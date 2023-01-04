package org.example.dto;

import lombok.Data;
import org.example.model.HoldProcessTime;

import java.util.List;

@Data
public class OptimizationRequestDto {

    private List<HoldProcessTimeDto> holdProcessTimeList;



}
