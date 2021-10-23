package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//        Double[] array = new Double[2];
//        array[0] = 0.0153;
//        array[1] = 0.5028;
//
//        System.out.println(array[0]);
//
//
//        Double[] array1 = new Double[]{0.0153, 0.5028};


        List<Double[]> list = new ArrayList<>();
        list.add(new Double[]{0.0153, 0.5028});
        list.add(new Double[]{0.4451, 0.4289});
        list.add(new Double[]{0.4660, 0.1897});
        list.add(new Double[]{0.4186, 0.1934});
        list.add(new Double[]{0.8462, 0.6822});
        list.add(new Double[]{0.5252, 0.3028});
        list.add(new Double[]{0.2026, 0.5417});
        list.add(new Double[]{0.6721, 0.1509});
        list.add(new Double[]{0.8381, 0.6979});
        list.add(new Double[]{0.0196, 0.3784});
        list.add(new Double[]{0.6813, 0.8600});
        list.add(new Double[]{0.3795, 0.8537});
        list.add(new Double[]{0.8318, 0.5936});
        list.add(new Double[]{0.9318, 0.3046});



        List<Double[]> result = solution(list);


        for (Double[] e : result) {
            System.out.println(e[0] + " " + e[1]);
        }





    }


    public static List<Double[]> solution(List<Double[]> list) {
        List<Double[]> copyList = new ArrayList<>(list);
        //copyList.addAll(list);

        List<Double[]> unloadingList = new ArrayList<>();
        List<Double[]> cleaningList = new ArrayList<>();


        int N = copyList.size();
        for (int i = 0; i < N; i++) {
            int unloadingIndex = minUnloading(copyList);
//           Double[] array = list.get(unloadingIndex);
//           Double aDouble = array[0];
            Double minUnloadingTime = copyList.get(unloadingIndex)[0];
            int cleaningIndex = minCleaning(copyList);
            Double minCleaningTime = copyList.get(cleaningIndex)[1];

            if (minUnloadingTime <= minCleaningTime) {
                Double[] element = copyList.get(unloadingIndex);
                unloadingList.add(element);
                copyList.remove(unloadingIndex);

            } else {
                Double[] element = copyList.get(cleaningIndex);
                cleaningList.add(element);
                copyList.remove(cleaningIndex);

            }


        }

        List<Double[]> result = new ArrayList<>();
        result.addAll(unloadingList);

        Collections.reverse(cleaningList);

        result.addAll(cleaningList);


        return result;


    }


    public static int minUnloading(List<Double[]> list) {

        Double min = list.get(0)[0];
        int index = 0;


        for (int i = 0; i < list.size(); i++) {
            Double element = list.get(i)[0];
            if (element < min) {
                min = element;
                index = i;

            }
        }
        return index;

    }

    public static int minCleaning(List<Double[]> list) {

        Double min = list.get(0)[1];
        int index = 0;


        for (int i = 0; i < list.size(); i++) {
            Double element = list.get(i)[1];
            if (element < min) {
                min = element;
                index = i;

            }
        }
        return index;

    }

}
