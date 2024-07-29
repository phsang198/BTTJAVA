package task.javafx.model;

public abstract class Vehicle {
    protected String id;
    protected String name;
    protected int number;
    protected char filter;

    public Vehicle(String id, String name, int number, char filter) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.filter = filter;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public char getFilter() {
        return filter;
    }

    public void setFilter(char filter) {
        this.filter = filter;
    }

    public abstract String toString();
}
