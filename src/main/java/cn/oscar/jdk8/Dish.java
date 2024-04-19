package cn.oscar.jdk8;

public class Dish {
    private String name;
    private boolean vegetarian;
    private int calories;
    private String type;

    public int getCalories() {
        return this.calories;
    }

    public String getName() {
        return this.name;
    }

    Dish(String name,
         boolean vegetarian,
         int calories,
         String type){
        this.name=name;
        this.calories=calories;
        this.vegetarian=vegetarian;
        this.type=type;
    }

    public  String  getType() { return  this.type;}




    // getter and setter
}