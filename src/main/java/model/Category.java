package model;

public class Category {
    private int id;
    private String name;
    private String des;

    public Category(int id, String name, String des) {
        this.id = id;
        this.name = name;
        this.des = des;
    }

    public Category(String name, String des) {
        this.name = name;
        this.des = des;
    }

    public Category(int id) {
        this.id = id;
    }

    public Category() {
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
