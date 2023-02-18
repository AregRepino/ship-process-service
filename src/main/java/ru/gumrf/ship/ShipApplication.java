package ru.gumrf.ship;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ShipApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShipApplication.class, args);

//        OptimizationRequestDto optimizationRequestDto = new OptimizationRequestDto();
//        List<HoldProcessTime> holdProcessTimeList = new ArrayList<>();
//
//        HoldProcessTime holdProcessTime = new HoldProcessTime();
//        holdProcessTime.setHoldUnloadingTime(0.0153);
//        holdProcessTime.setCleaningTime(0.5028);
//        holdProcessTimeList.add(holdProcessTime);
//
//        holdProcessTime = new HoldProcessTime();
//        holdProcessTime.setHoldUnloadingTime(0.4451);
//        holdProcessTime.setCleaningTime(0.4289);
//        holdProcessTimeList.add(holdProcessTime);
//
//        holdProcessTime = new HoldProcessTime();
//        holdProcessTime.setHoldUnloadingTime(0.4660);
//        holdProcessTime.setCleaningTime(0.1897);
//        holdProcessTimeList.add(holdProcessTime);
//
//        holdProcessTimeList.add(new HoldProcessTime(0.4186, 0.1934));
//
//        holdProcessTime = new HoldProcessTime();
//        holdProcessTime.setHoldUnloadingTime(0.8462);
//        holdProcessTime.setCleaningTime(0.6822);
//        holdProcessTimeList.add(holdProcessTime);
//
//
//        holdProcessTimeList.add(new HoldProcessTime(0.5252, 0.3028));
//
//        holdProcessTime = new HoldProcessTime();
//        holdProcessTime.setHoldUnloadingTime(0.2026);
//        holdProcessTime.setCleaningTime(0.5417);
//        holdProcessTimeList.add(holdProcessTime);
//
//
//        holdProcessTimeList.add(new HoldProcessTime(0.6721, 0.1509));
//
//        holdProcessTime = new HoldProcessTime();
//        holdProcessTime.setHoldUnloadingTime(0.8381);
//        holdProcessTime.setCleaningTime(0.6979);
//        holdProcessTimeList.add(holdProcessTime);
//
//        holdProcessTime = new HoldProcessTime();
//        holdProcessTime.setHoldUnloadingTime(0.0196);
//        holdProcessTime.setCleaningTime(0.3784);
//        holdProcessTimeList.add(holdProcessTime);
//
//        holdProcessTime = new HoldProcessTime();
//        holdProcessTime.setHoldUnloadingTime(0.6813);
//        holdProcessTime.setCleaningTime(0.8600);
//        holdProcessTimeList.add(holdProcessTime);
//
//        holdProcessTime = new HoldProcessTime();
//        holdProcessTime.setHoldUnloadingTime(0.3795);
//        holdProcessTime.setCleaningTime(0.8537);
//        holdProcessTimeList.add(holdProcessTime);
//
//        holdProcessTime = new HoldProcessTime();
//        holdProcessTime.setHoldUnloadingTime(0.8318);
//        holdProcessTime.setCleaningTime(0.5936);
//        holdProcessTimeList.add(holdProcessTime);
//
//        holdProcessTime = new HoldProcessTime();
//        holdProcessTime.setHoldUnloadingTime(0.9318);
//        holdProcessTime.setCleaningTime(0.3046);
//        holdProcessTimeList.add(holdProcessTime);
//
//        optimizationRequestDto.setHoldProcessTimeList(holdProcessTimeList);


//      Создаются динамический массив(list-список)
//      Заполняем список массивом из двух чисел
//      Первое число - время разгрузки трюма
//      Второе число – время очистки

//        List<Double[]> list = new ArrayList<>();
//        list.add(new Double[]{0.0153, 0.5028});
//        list.add(new Double[]{0.4451, 0.4289});
//        list.add(new Double[]{0.4660, 0.1897});
//        list.add(new Double[]{0.4186, 0.1934});
//        list.add(new Double[]{0.8462, 0.6822});
//        list.add(new Double[]{0.5252, 0.3028});
//        list.add(new Double[]{0.2026, 0.5417});
//        list.add(new Double[]{0.6721, 0.1509});
//        list.add(new Double[]{0.8381, 0.6979});
//        list.add(new Double[]{0.0196, 0.3784});
//        list.add(new Double[]{0.6813, 0.8600});
//        list.add(new Double[]{0.3795, 0.8537});
//        list.add(new Double[]{0.8318, 0.5936});
//        list.add(new Double[]{0.9318, 0.3046});
//
////      Вызов метода solution
//        List<Double[]> result = solution(list);
//
////      Выполняем вывод полученного результата
//        for (Double[] e : result) {
//            System.out.println(e[0] + " " + e[1]);
//        }

    }

}


