package com.learnday.spock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripService {
    private TripRepository tripRepository;

    @Autowired
    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public TripDto findTrip(Integer tripId) {
        TripEntity tripEntity = tripRepository.findOne(tripId);
        TripDto tripDto = TripDto.builder()
                .tripId(tripEntity.getTripId())
                .model(tripEntity.getModel())
                .averageMph(tripEntity.getAverageMph())
                .build();
        return tripDto;
    }

    public TripDto save(TripDto tripDto) {
        TripEntity tripEntity = TripEntity.builder()
                .model(tripDto.getModel())
                .averageMph(tripDto.getAverageMph())
                .build();
        tripRepository.save(tripEntity);
        tripDto.setTripId(tripEntity.getTripId());
        return tripDto;
    }

}
