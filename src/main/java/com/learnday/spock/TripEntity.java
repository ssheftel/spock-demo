package com.learnday.spock;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "TRIP")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TripEntity {

    @Id
    @Column(name="tripId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tripId;

    @Column(name="model")
    private String model;

    @Column(name = "averageMph")
    private Double averageMph;
}
