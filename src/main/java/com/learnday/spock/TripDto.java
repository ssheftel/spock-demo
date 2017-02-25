package com.learnday.spock;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TripDto {
    private Integer tripId;
    private String model;
    private Double averageMph;
}
