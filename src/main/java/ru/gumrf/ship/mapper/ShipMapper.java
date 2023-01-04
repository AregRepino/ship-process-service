package ru.gumrf.ship.mapper;

import ru.gumrf.ship.dto.HoldProcessTimeDto;
import ru.gumrf.ship.model.HoldProcessTime;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShipMapper {


    public List<HoldProcessTime> toHoldProcessTimeList(List<HoldProcessTimeDto> list) {
        List<HoldProcessTime> result = new ArrayList<>();

        for (HoldProcessTimeDto h : list) {
            result.add(new HoldProcessTime(h.getUnloadingTime(), h.getCleaningTime()));
        }

        return result;
    }

    public List<HoldProcessTimeDto> toHoldProcessTimeDtoList(List<HoldProcessTime> list) {
        List<HoldProcessTimeDto> result = new ArrayList<>();

        for (HoldProcessTime h : list) {
            result.add(new HoldProcessTimeDto(h.getUnloadingTime(), h.getCleaningTime()));
        }
        return result;
    }


}
