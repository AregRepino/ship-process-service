package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//      Создаются динамический массив(list-список)
//      Заполняем список массивом из двух чисел
//      Первое число - время разгрузки трюма
//      Второе число – время очистки

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

//      Вызов метода solution
        List<Double[]> result = solution(list);

//      Выполняем вывод полученного результата
        for (Double[] e : result) {
            System.out.println(e[0] + " " + e[1]);
        }

    }

    //  Метод solution который выполняет условие задачи
    public static List<Double[]> solution(List<Double[]> list) {
//      Здесь мы создаём копию листа
        List<Double[]> copyList = new ArrayList<>(list);

//      Здесь мы создаём массив списка, который будет хранить в себе время
//      работы, отсортированное по возрастанию времени разгрузки трюма
        List<Double[]> unloadingList = new ArrayList<>();

//      Здесь мы создаём массив списка, который будет хранить в себе время
//      работы, отсортированное по  возрастанию времени чистки трюма
        List<Double[]> cleaningList = new ArrayList<>();

//      N хранит размер copyList
        int N = copyList.size();
//      Цикл от 0 до N
        for (int i = 0; i < N; i++) {
//          получение индекса трюма с минимальным временем разгрузки
            int unloadingIndex = minUnloading(copyList);
//          получение минимального  времени разгрузки
            Double minUnloadingTime = copyList.get(unloadingIndex)[0];
//          получение индекса трюма с минимальным временем отчистки
            int cleaningIndex = minCleaning(copyList);
//          получение минимального времени отчистки
            Double minCleaningTime = copyList.get(cleaningIndex)[1];

//          Если время разгрузки меньше или равно времени очистки,
//          то мы добавляем element в список unloadingList и удаляем его из
//          copyList
            if (minUnloadingTime <= minCleaningTime) {
                Double[] element = copyList.get(unloadingIndex);
                unloadingList.add(element);
                copyList.remove(unloadingIndex);

//          Else в противным случаи добавляем element в cleaningList и
//          удаляем из copyList
            } else {
                Double[] element = copyList.get(cleaningIndex);
                cleaningList.add(element);
                copyList.remove(cleaningIndex);

            }


        }
//      Создаем новый список который будет хранить в себе результат
//      выполнения программы
        List<Double[]> result = new ArrayList<>();

//      Добавляем в список unloadingList
        result.addAll(unloadingList);
//      reverse переворачиваем список, чтобы он был по убыванию времени очистки
        Collections.reverse(cleaningList);
//      Добавляем в общий список
        result.addAll(cleaningList);

//      Возвращаем результат
        return result;

    }

    //  Здесь мы находим номер трюма с минимальным временем  разгрузки
    public static int minUnloading(List<Double[]> list) {

//      min хранит минимальное время разгрузки
        Double min = list.get(0)[0];

//      Index хранит номер трюма
        int index = 0;

//      Цикл от 0 до размера list
        for (int i = 0; i < list.size(); i++) {

//          time хранит время разгрузки
            Double time = list.get(i)[0];

//          Проверяем условие
            if (time < min) {
                min = time;
                index = i;

            }
        }

//      Возвращаем index
        return index;

    }

    //  Здесь мы находим номер трюма с минимальным временем очистки
    public static int minCleaning(List<Double[]> list) {


//      min хранит минимальное время очистки
        Double min = list.get(0)[1];

//      Index хранит номер трюма
        int index = 0;

//      Цикл от 0 до размера list
        for (int i = 0; i < list.size(); i++) {

//          time хранит время чистки
            Double time = list.get(i)[1];

//          Проверяем условие
            if (time < min) {
                min = time;
                index = i;

            }
        }

//      Возвращаем index
        return index;

    }

}


//ВЫВОД
//
//        0.0153 0.5028
//        0.0196 0.3784
//        0.2026 0.5417
//        0.3795 0.8537
//        0.6813 0.86
//        0.8381 0.6979
//        0.8462 0.6822
//        0.8318 0.5936
//        0.4451 0.4289
//        0.9318 0.3046
//        0.5252 0.3028
//        0.4186 0.1934
//        0.466 0.1897
//        0.6721 0.1509

