package ru.gumrf.ship.mapper;

import ru.gumrf.ship.dto.HoldProcessTimeDto;
import ru.gumrf.ship.model.HoldProcessTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
public class ShipMapperTest {

    @Configuration
    @Import(ShipMapper.class)
    static class Config {
    }

    @Autowired
    private ShipMapper shipMapper;


    @Test
    public void toHoldProcessTimeList() {
//      given
        List<HoldProcessTimeDto> holdProcessTimeDtoList = new ArrayList<>();

        holdProcessTimeDtoList.add(new HoldProcessTimeDto(0.0153, 0.5028));
        holdProcessTimeDtoList.add(new HoldProcessTimeDto(0.4451, 0.4289));

        List<HoldProcessTime> expected = new ArrayList<>();

        expected.add(new HoldProcessTime(0.0153, 0.5028));
        expected.add(new HoldProcessTime(0.4451, 0.4289));

//        holdProcessTimeListDto.add(new HoldProcessTimeDto(0.4186, 0.1934));
//
//        holdProcessTimeDto = new HoldProcessTimeDto();
//        holdProcessTimeDto.setUnloadingTime(0.8462);
//        holdProcessTimeDto.setCleaningTime(0.6822);
//        holdProcessTimeListDto.add(holdProcessTimeDto);
//
//
//        holdProcessTimeListDto.add(new HoldProcessTimeDto(0.5252, 0.3028));
//
//        holdProcessTimeDto = new HoldProcessTimeDto();
//        holdProcessTimeDto.setUnloadingTime(0.2026);
//        holdProcessTimeDto.setCleaningTime(0.5417);
//        holdProcessTimeListDto.add(holdProcessTimeDto);
//
//
//        holdProcessTimeListDto.add(new HoldProcessTimeDto(0.6721, 0.1509));
//
//        holdProcessTimeDto = new HoldProcessTimeDto();
//        holdProcessTimeDto.setUnloadingTime(0.8381);
//        holdProcessTimeDto.setCleaningTime(0.6979);
//        holdProcessTimeListDto.add(holdProcessTimeDto);
//
//        holdProcessTimeDto = new HoldProcessTimeDto();
//        holdProcessTimeDto.setUnloadingTime(0.0196);
//        holdProcessTimeDto.setCleaningTime(0.3784);
//        holdProcessTimeListDto.add(holdProcessTimeDto);
//
//        holdProcessTimeDto = new HoldProcessTimeDto();
//        holdProcessTimeDto.setUnloadingTime(0.6813);
//        holdProcessTimeDto.setCleaningTime(0.8600);
//        holdProcessTimeListDto.add(holdProcessTimeDto);
//
//        holdProcessTimeDto = new HoldProcessTimeDto();
//        holdProcessTimeDto.setUnloadingTime(0.3795);
//        holdProcessTimeDto.setCleaningTime(0.8537);
//        holdProcessTimeListDto.add(holdProcessTimeDto);
//
//        holdProcessTimeDto = new HoldProcessTimeDto();
//        holdProcessTimeDto.setUnloadingTime(0.8318);
//        holdProcessTimeDto.setCleaningTime(0.5936);
//        holdProcessTimeListDto.add(holdProcessTimeDto);
//
//        holdProcessTimeDto = new HoldProcessTimeDto();
//        holdProcessTimeDto.setUnloadingTime(0.9318);
//        holdProcessTimeDto.setCleaningTime(0.3046);
//        holdProcessTimeListDto.add(holdProcessTimeDto
        // when
        List<HoldProcessTime> actual = shipMapper.toHoldProcessTimeList(holdProcessTimeDtoList);

        // then
        assertNotNull(actual);
        assertEquals(2, actual.size());

        for (int i = 0; i < expected.size(); i ++) {
            HoldProcessTime e = expected.get(i);
            HoldProcessTime a = actual.get(i);
            assertEquals(e, a);
        }

        assertArrayEquals(expected.toArray(), actual.toArray());


    }


}
