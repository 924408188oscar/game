package cn.oscar.jdk8;

import com.alibaba.fastjson.JSON;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class Stest {
    private List<String> beforeJava7(List<Dish> dishList) {
        List<Dish> lowCaloricDishes = new ArrayList<>();

        //1.筛选出卡路里小于400的菜肴
        for (Dish dish : dishList) {
            if (dish.getCalories() < 400) {
                lowCaloricDishes.add(dish);
            }
        }

        //2.对筛选出的菜肴进行排序
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(), o2.getCalories());
            }
        });

        //3.获取排序后菜肴的名字
        List<String> lowCaloricDishesName = new ArrayList<>();
        for (Dish d : lowCaloricDishes) {
            lowCaloricDishesName.add(d.getName());
        }
        return lowCaloricDishesName;
    }

    private static Map<String, List<Dish>> afterJdk81(List<Dish> dishList) {
        return  dishList.stream().collect(groupingBy(Dish::getType));

    }



    static public List<String> afterJava8(List<Dish> dishList) {
        return dishList.stream()
                .filter(d -> d.getCalories() < 800)  //筛选出卡路里小于400的菜肴
                .sorted(comparing(Dish::getCalories))  //根据卡路里进行排序
                .map(Dish::getName)  //提取菜肴名称
                .collect(toList()); //转换为List
    }

    public static void main(String[] args) {
        Dish dish = new Dish("冬瓜",true,100,"季节菜");
        Dish dish1 = new Dish("南瓜",true,500,"特色菜");
        Dish dish2 = new Dish("西瓜",false,1500,"冷菜");
        Dish dish3 = new Dish("苦瓜",false,600,"季节菜");

        List<Dish> dishList= new ArrayList<>();
        dishList.add(dish);
        dishList.add(dish1);
        dishList.add(dish2);
        dishList.add(dish3);

        List<String> list=afterJava8(dishList);

        System.out.println(String.join(", ", list));

        list.forEach(System.out::println);
        System.out.println(dishList.stream().map(x -> x.getName()).collect(Collectors.joining(", ", "{", "}")));


        List<String> strings = dishList.stream().map(Dish::getName).collect(toList());

        Set<String> sets = dishList.stream().map(Dish::getName).collect(toSet());
        System.out.println("=================");

        strings.forEach(System.out::println);
        System.out.println("=================");

        sets.forEach(System.out::println);

        Map map=afterJdk81(dishList);
        System.out.println(JSON.toJSONString(map));


    }


}
