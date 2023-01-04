package ru.gumrf.ship.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
public class OptimizationResponseDto {

    private List<HoldProcessTimeDto> holdProcessTimeList;
}
