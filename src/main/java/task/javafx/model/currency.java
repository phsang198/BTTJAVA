package task.javafx.model;

public interface currency {
    double getPrice();
    void setPrice(double price);

    double change(String from, String to);
}
