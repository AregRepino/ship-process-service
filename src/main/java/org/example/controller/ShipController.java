package org.example.controller;



import lombok.RequiredArgsConstructor;
import org.example.dto.HoldProcessTimeDto;
import org.example.model.HoldProcessTime;
import org.example.dto.OptimizationRequestDto;
import org.example.dto.OptimizationResponseDto;
import org.example.mapper.ShipMapper;
import org.example.service.ShipService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ShipController {

    private final ShipService  shipService;
    private final ShipMapper shipMapper;

    @PostMapping ("/optimize-load")
    public OptimizationResponseDto optimizeLoad(@RequestBody OptimizationRequestDto optimizationRequestDto) {

        List<HoldProcessTime> holdProcessTimeList = shipMapper.toHoldProcessTimeList(optimizationRequestDto.getHoldProcessTimeList());

        List<HoldProcessTime> result = shipService.optimizeLoad(holdProcessTimeList);

        List<HoldProcessTimeDto> resultDto = shipMapper.toHoldProcessTimeDtoList(result);

        return new OptimizationResponseDto(resultDto);
    }

}
