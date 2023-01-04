package org.example.service;


import org.example.model.HoldProcessTime;
import org.springframework.stereotype.Service;

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


//    public List<Double[]> optimizeLoad(List<Double[]> list) {
//        List<Double[]> copyList = new ArrayList<>(list);
//        List<Double[]> unloadingList = new ArrayList<>();
//        List<Double[]> cleaningList = new ArrayList<>();
//
//
//        int N = copyList.size();
//
//        for (int i = 0; i < N; i++) {
//
//            int unloadingIndex = minUnloading(copyList);
//
//            Double minUnloadingTime = copyList.get(unloadingIndex)[0];
//
//            int cleaningIndex = minCleaning(copyList);
//            Double minCleaningTime = copyList.get(cleaningIndex)[1];
//
//            if (minUnloadingTime <= minCleaningTime) {
//                Double[] element = copyList.get(unloadingIndex);
//                unloadingList.add(element);
//                copyList.remove(unloadingIndex);
//
//            } else {
//                Double[] element = copyList.get(cleaningIndex);
//                cleaningList.add(element);
//                copyList.remove(cleaningIndex);
//
//            }
//
//
//        }
//
//        List<Double[]> result = new ArrayList<>();
//
//
//        result.addAll(unloadingList);
//        Collections.reverse(cleaningList);
//        result.addAll(cleaningList);
//
//        return result;
//
//    }

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

//    public int minUnloading(List<Double[]> list) {
//
//        Double min = list.get(0)[0];
//
//        int index = 0;
//
//        for (int i = 0; i < list.size(); i++) {
//
//            Double time = list.get(i)[0];
//
//            if (time < min) {
//                min = time;
//                index = i;
//
//            }
//        }
//
//        return index;
//
//    }
//
//    public int minCleaning(List<Double[]> list) {
//
//
//        Double min = list.get(0)[1];
//
//        int index = 0;
//
//        for (int i = 0; i < list.size(); i++) {
//
//            Double time = list.get(i)[1];
//
//            if (time < min) {
//                min = time;
//                index = i;
//
//            }
//        }
//
//
//        return index;
//
//    }
}
