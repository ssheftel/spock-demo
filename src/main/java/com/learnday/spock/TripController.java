package com.learnday.spock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class TripController {
    private TripService tripService;

    @Autowired
    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @RequestMapping(path = "/trip/{tripId}", method = RequestMethod.GET)
    public TripDto getTrip(@PathVariable Integer tripId) {
        TripDto tripDto = tripService.findTrip(tripId);
        return tripDto;
    }

    @RequestMapping(path = "/trip", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public TripDto addTrip(@RequestBody TripDto tripDto) {
        TripDto savedTrip = tripService.save(tripDto);
        return savedTrip;
    }
}
