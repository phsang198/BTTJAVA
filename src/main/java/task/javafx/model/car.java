package task.javafx.model;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class car extends vehicle implements currency {
    private LocalDate dateOfEntry;
    private char type;
    private double price;
    private String unit;

    public car() {
    }
    public car(String id, String name, int number, LocalDate dateOfEntry, char type, double price,String unit) {
        super(id, name, number);
        this.dateOfEntry = dateOfEntry;
        this.type = type;
        this.price = price;
        this.unit = unit; 
    }
    @Override
    public String getId() {
        return id;
    }
    @Override
    public void setId(String id) {
        this.id = id;
    }
    public LocalDate getDateOfEntry() {
        return dateOfEntry;
    }

    public void setDateOfEntry(LocalDate dateOfEntry) {
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
    public double change(String from, String to, Double val)  // 1
    {
        if (from.equals("USD") && to.equals("JPY")) {
            return price * 139.12;
        }
        return 0.0; // Placeholder
    }
    public long toEpoch()  // 2
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Instant instant = dateOfEntry.atStartOfDay(ZoneId.systemDefault()).toInstant();

        return instant.toEpochMilli();

    }
    public boolean checkExist(String name) {  // 3 function
        return this.name.contains(name);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", dateOfEntry=" + dateOfEntry +
                ", type=" + type +
                ", price=" + price +
                ", unit=" + unit +
                '}';
    }
}
