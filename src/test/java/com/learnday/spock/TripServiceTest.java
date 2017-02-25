package com.learnday.spock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.any;

@RunWith(MockitoJUnitRunner.class)
public class TripServiceTest {

    @InjectMocks
    private TripService tripService;

    @Mock
    private TripRepository tripRepository;

    @Test
    public void givenANewTrip_whenTripIsSaved_returnAPersistedWithAId() {
        TripEntity newTripEntity = new TripEntity(123, "car model", 29.7);
        when(tripRepository.save(any(TripEntity.class))).thenReturn(newTripEntity);

        TripDto savedTripDto = tripService.save(new TripDto(null, "car model", 29.7));

        assertEquals(savedTripDto.getTripId(), newTripEntity.getTripId());
    }
}
