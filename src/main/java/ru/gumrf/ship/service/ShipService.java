package ru.gumrf.ship.service;


import org.springframework.stereotype.Service;
import ru.gumrf.ship.model.HoldProcessTime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ShipService {


    public List<HoldProcessTime> optimizeLoad(List<HoldProcessTime> holdProcessTimeList) {

        List<HoldProcessTime> copyList = new ArrayList<>(holdProcessTimeList);
        List<HoldProcessTime> unloadingList = new ArrayList<>();
        List<HoldProcessTime> cleaningList = new ArrayList<>();


        int N = copyList.size();

        for (int i = 0; i < N; i++) {

            int unloadingIndex = minUnloading(copyList);

            double minUnloadingTime = copyList.get(unloadingIndex).getUnloadingTime();

            int cleaningIndex = minCleaning(copyList);
            double minCleaningTime = copyList.get(cleaningIndex).getCleaningTime();

            if (minUnloadingTime <= minCleaningTime) {
                HoldProcessTime element = copyList.get(unloadingIndex);
                unloadingList.add(element);
                copyList.remove(unloadingIndex);

            } else {
                HoldProcessTime element = copyList.get(cleaningIndex);
                cleaningList.add(element);
                copyList.remove(cleaningIndex);

            }


        }

        List<HoldProcessTime> result = new ArrayList<>();


        result.addAll(unloadingList);
        Collections.reverse(cleaningList);
        result.addAll(cleaningList);

        return result;
    }


    public int minUnloading(List<HoldProcessTime> list) {

        double min = list.get(0).getUnloadingTime();

        int index = 0;

        for (int i = 0; i < list.size(); i++) {

            double time = list.get(i).getUnloadingTime();

            if (time < min) {
                min = time;
                index = i;

            }
        }

        return index;

    }

    public int minCleaning(List<HoldProcessTime> list) {


        double min = list.get(0).getCleaningTime();

        int index = 0;

        for (int i = 0; i < list.size(); i++) {

            double time = list.get(i).getCleaningTime();

            if (time < min) {
                min = time;
                index = i;

            }
        }


        return index;

    }

}
