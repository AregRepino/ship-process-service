package ru.gumrf.ship.dto;

import lombok.Data;

import java.util.List;

@Data
public class OptimizationRequestDto {

    private List<HoldProcessTimeDto> holdProcessTimeList;



}
