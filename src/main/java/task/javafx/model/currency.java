package task.javafx.model;

public interface currency {
    double getPrice();

    void setPrice(double price);
    String getUnit();

    void setUnit(String unit);
    

    double change(String from, String to);
}
