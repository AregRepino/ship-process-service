package ru.gumrf.ship.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HoldProcessTimeDto {

    private double unloadingTime;
    private double cleaningTime;
}
