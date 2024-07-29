package task.javafx.model;

import java.util.Date;

public class car extends vehicle implements currency {
    private Date dateOfEntry;
    private char type;
    private double price;
    private String unit;

    public car() {
    }
    public car(String id, String name, int number, char filter, Date dateOfEntry, char type, double price,String unit) {
        super(id, name, number, filter);
        this.dateOfEntry = dateOfEntry;
        this.type = type;
        this.price = price;
        this.unit = unit; 
    }

    public Date getDateOfEntry() {
        return dateOfEntry;
    }

    public void setDateOfEntry(Date dateOfEntry) {
        this.dateOfEntry = dateOfEntry;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public String getUnit()
    {
        return unit; 
    }
    @Override
    public void setUnit(String unit)
    {
        this.unit = unit; 
    }
    @Override
    public double change(String from, String to) {
        // Implement currency conversion logic here
        return 0.0; // Placeholder
    }

    public boolean checkExist(String name) {
        return this.name.equalsIgnoreCase(name);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", filter=" + filter +
                ", dateOfEntry=" + dateOfEntry +
                ", type=" + type +
                ", price=" + price +
                '}';
    }
}
