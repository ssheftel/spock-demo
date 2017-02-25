package com.learnday.spock;


import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<TripEntity, Integer> {

}
