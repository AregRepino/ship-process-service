package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.model.HoldProcessTime;

import java.util.List;


@Data
@AllArgsConstructor
public class OptimizationResponseDto {

    private List<HoldProcessTimeDto> holdProcessTimeList;
}
