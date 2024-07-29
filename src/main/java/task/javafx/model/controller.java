package task.javafx.model;

import java.util.List;
import java.util.stream.Collectors;

public class controller {
    private List<Car> carList;
    private Model model;

    public Controller() {
        this.model = new Model();
        this.carList = model.getAllCars();
    }

    public List<Car> getWithFilter(char _filter) {
        return carList.stream()
                      .filter(car -> car.getFilter() == _filter)
                      .collect(Collectors.toList());
    }

    public void addCar(Car car) {
        model.addCar(car);
        carList = model.getAllCars();
    }

    public void deleteCar(String carId) {
        model.deleteCar(carId);
        carList = model.getAllCars();
    }
}
