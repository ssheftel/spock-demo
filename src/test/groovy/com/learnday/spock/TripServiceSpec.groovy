package com.learnday.spock

import spock.lang.*
import com.blogspot.toomuchcoding.spock.subjcollabs.Subject
import com.blogspot.toomuchcoding.spock.subjcollabs.Collaborator


class TripServiceSpec extends Specification {

    @Subject
    TripService tripService

    @Collaborator
    TripRepository tripRepository = Mock(TripRepository)

    def "save() returns a trip with a tripId"() {
        given: "trip is saved to the db with tripId 123"
            tripRepository.save(_) >> new TripEntity(tripId: 123)

        when: "save() is called"
            def savedTripDto = tripService.save(new TripDto())

        then: "the saved trip is returned with its tripId"
            savedTripDto.tripId == 123
    }
}
