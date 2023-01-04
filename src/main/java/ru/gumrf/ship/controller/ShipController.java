package ru.gumrf.ship.controller;



import lombok.RequiredArgsConstructor;
import ru.gumrf.ship.dto.HoldProcessTimeDto;
import ru.gumrf.ship.model.HoldProcessTime;
import ru.gumrf.ship.dto.OptimizationRequestDto;
import ru.gumrf.ship.dto.OptimizationResponseDto;
import ru.gumrf.ship.mapper.ShipMapper;
import ru.gumrf.ship.service.ShipService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ShipController {

    private final ShipService shipService;
    private final ShipMapper shipMapper;

    @PostMapping ("/optimize-load")
    public OptimizationResponseDto optimizeLoad(@RequestBody OptimizationRequestDto optimizationRequestDto) {

        List<HoldProcessTime> holdProcessTimeList = shipMapper.toHoldProcessTimeList(optimizationRequestDto.getHoldProcessTimeList());

        List<HoldProcessTime> result = shipService.optimizeLoad(holdProcessTimeList);

        List<HoldProcessTimeDto> resultDto = shipMapper.toHoldProcessTimeDtoList(result);

        return new OptimizationResponseDto(resultDto);
    }

}
