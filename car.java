package automobile;

import java.util.Date;

import automobile.Vehicle;

public class Car extends Vehicle implements Currency {
    private Date dateOfEntry;
    private char type;
    private double price;

    public Car(String id, String name, int number, char filter, Date dateOfEntry, char type, double price) {
        super(id, name, number, filter);
        this.dateOfEntry = dateOfEntry;
        this.type = type;
        this.price = price;
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
