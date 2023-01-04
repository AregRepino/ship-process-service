package org.example.controller;

import org.example.dto.HoldProcessTimeDto;
import org.example.dto.OptimizationRequestDto;
import org.example.dto.OptimizationResponseDto;
import org.example.mapper.ShipMapper;
import org.example.model.HoldProcessTime;
import org.example.service.ShipService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class ShipControllerTest {

    @Configuration
    @Import(ShipController.class)
    static class Config {
    }


    @MockBean
    private ShipService shipService;

    @MockBean
    private ShipMapper shipMapper;

    @Autowired
    private ShipController shipController;

    @Test
    public  void  optimizeLoad () {
        // given

        OptimizationRequestDto optimizationRequestDto = new OptimizationRequestDto();
        List<HoldProcessTimeDto> holdProcessTimeDtoList = new ArrayList<>();
        holdProcessTimeDtoList.add(new HoldProcessTimeDto(0.0153, 0.5028));
        optimizationRequestDto.setHoldProcessTimeList(holdProcessTimeDtoList);

        List<HoldProcessTime> holdProcessTimeList = new ArrayList<>();
        holdProcessTimeList.add(new HoldProcessTime(0.0153, 0.5028));

        given(shipMapper.toHoldProcessTimeList(holdProcessTimeDtoList)).willReturn(holdProcessTimeList);

        given(shipService.optimizeLoad(holdProcessTimeList)).willReturn(holdProcessTimeList);

        given(shipMapper.toHoldProcessTimeDtoList(holdProcessTimeList)).willReturn(holdProcessTimeDtoList);

        OptimizationResponseDto expected = new OptimizationResponseDto(holdProcessTimeDtoList);

        //        when

        OptimizationResponseDto actual = shipController.optimizeLoad(optimizationRequestDto);


        //        then

        assertNotNull(actual);
        assertNotNull(actual.getHoldProcessTimeList());
        assertArrayEquals(expected.getHoldProcessTimeList().toArray(), actual.getHoldProcessTimeList().toArray());

        verify(shipMapper).toHoldProcessTimeList(holdProcessTimeDtoList);
        verify(shipService).optimizeLoad(holdProcessTimeList);
        verify(shipMapper).toHoldProcessTimeDtoList(holdProcessTimeList);
    }
}
