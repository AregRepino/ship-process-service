package ru.gumrf.ship.service;


import ru.gumrf.ship.model.HoldProcessTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@RunWith(SpringRunner.class)
public class ShipServiceTest {

    @Configuration
    @Import(ShipService.class)
    static class Config {

    }

    @Autowired
    private ShipService shipService;

    @Test
    public void optimizeLoad() {
        // given
        List<HoldProcessTime> holdProcessTimeList = new ArrayList<>();
        holdProcessTimeList.add(new HoldProcessTime(0.0153, 0.5028));
        holdProcessTimeList.add(new HoldProcessTime(0.4451, 0.4289));
        holdProcessTimeList.add(new HoldProcessTime(0.4660, 0.1897));
        holdProcessTimeList.add(new HoldProcessTime(0.4186, 0.1934));
        holdProcessTimeList.add(new HoldProcessTime(0.8462, 0.6822));

        List<HoldProcessTime> expected = new ArrayList<>();
        expected.add(new HoldProcessTime(0.0153, 0.5028));
        expected.add(new HoldProcessTime(0.8462, 0.6822));
        expected.add(new HoldProcessTime(0.4451, 0.4289));
        expected.add(new HoldProcessTime(0.4186, 0.1934));
        expected.add(new HoldProcessTime(0.4660, 0.1897));

        List<HoldProcessTime> actual = shipService.optimizeLoad(holdProcessTimeList);

        // them
        assertNotNull(actual);
        assertEquals(expected.size(), actual.size());
        assertArrayEquals(expected.toArray(), actual.toArray());

    }

}
