package ru.gumrf.ship.model;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class HoldProcessTime {

    private double unloadingTime;
    private double cleaningTime;
}
