# Spock Demo Notes

## Demo 1. Adding Spock to a Spring Boot Project

branch name: `demo-1-adding-spock`

1. In build.gradle add the groovy plugin `apply plugin: 'groovy'` and the following test dependencies

```groovy
	testCompile 'org.spockframework:spock-spring:1.0-groovy-2.4'
	testCompile 'cglib:cglib-nodep:3.2.2'
	testCompile 'com.blogspot.toomuchcoding:spock-subjects-collaborators-extension:1.2.1'
```
2. Create a new directory named "groovy" in src/test
3. Create the packages matching your projects package name e.g. `com.learnday.spock`
4. Create new test specifications files. These files should have Spec as a suffix and have the .groovy extension.

```groovy
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
```
