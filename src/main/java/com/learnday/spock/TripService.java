package com.learnday.spock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TripService {
    private TripRepository tripRepository;

    @Autowired
    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public List<TripDto> findAllTrips() {
        List<TripEntity> tripEntities = tripRepository.findAll();
        List<TripDto> tripDtos = tripEntities.stream()
                .map(TripDto::fromTripEntity)
                .collect(Collectors.toList());
        return tripDtos;
    }

    public TripDto findTrip(Integer tripId) {
        TripEntity tripEntity = tripRepository.findOne(tripId);
        TripDto tripDto = TripDto.fromTripEntity(tripEntity);
        return tripDto;
    }

    public TripDto save(TripDto tripDto) {
        TripEntity tripEntity = TripEntity.fromTripDto(tripDto);
        TripEntity savedEntity = tripRepository.save(tripEntity);
        TripDto newTripDto = TripDto.fromTripEntity(savedEntity);
        return newTripDto;
    }

}
