package automobile;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class View extends Application {

    @Override
    public void start(Stage stage) {
        TableView<Car> table = new TableView<>();

        TableColumn<Car, String> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Car, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Car, Integer> numberColumn = new TableColumn<>("Number");
        numberColumn.setCellValueFactory(new PropertyValueFactory<>("number"));

        TableColumn<Car, Date> dateColumn = new TableColumn<>("Date Of Entry");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("dateOfEntry"));

        TableColumn<Car, Character> typeColumn = new TableColumn<>("Type");
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));

        TableColumn<Car, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        table.getColumns().addAll(idColumn, nameColumn, numberColumn, dateColumn, typeColumn, priceColumn);

        Scene scene = new Scene(table);
        stage.setScene(scene);
        stage.setTitle("Car Inventory");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
