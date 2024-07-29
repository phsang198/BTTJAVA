package task.javafx.model;

import java.util.List;
import java.util.stream.Collectors;

public class controller {
    public List<car> carList;
    
    private model _model;

    public controller() {
        this._model = new model();
        this.carList = _model.getAllCars();
    }

    public List<car> getWithFilter(char _filter) {
        
        return carList;
        
    }

    public void addCar(car car) {
        _model.addCar(car);
        carList = _model.getAllCars();
    }

    public void deleteCar(String carId) {
        _model.deleteCar(carId);
        carList = _model.getAllCars();
    }
}
