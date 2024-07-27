package automobile;

public interface Currency {
    double getPrice();
    void setPrice(double price);

    double change(String from, String to);
}
