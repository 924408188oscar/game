
package cn.oscar.game;



public class Animal_list {

    private int id;
    private int num;
    private int type;



    public Animal_list(int id, int num) {
        this.id = id;
        this.num = num;
        this.type = 1;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setType(int type) {
        this.type = 1;
    }

    public int getType() {
        return type;
    }

    @Override
    public String toString() {
        return "{\"id\":" + id + ",\"num\":" + num + ",\"type\":" + type + "}";

    }
}