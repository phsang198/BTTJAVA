package task.javafx;

import java.net.URL;
import java.util.Currency;
import java.util.ResourceBundle;
import java.util.Set;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import task.javafx.model.controller;

public class managerView implements Initializable{
    private controller _controler = new controller() ; 
    @FXML
    private ComboBox<String> currency;

    @FXML
    private DatePicker edate;

    @FXML
    private TableView<?> id;

    @FXML
    private Pane managepage;

    @FXML
    private TextField name;

    @FXML
    private TextField number;

    @FXML
    private TextField price;

    @FXML
    private TableColumn<?, ?> tcurency;

    @FXML
    private TableColumn<?, ?> tdate;

    @FXML
    private TableColumn<?, ?> tid;

    @FXML
    private TableColumn<?, ?> tname;

    @FXML
    private TableColumn<?, ?> tnumber;

    @FXML
    private TableColumn<?, ?> tprice;

    @FXML
    private TableColumn<?, ?> ttype;

    @FXML
    private ComboBox<String> type;
    @FXML
    void Select(ActionEvent event) {
        String s = type.getSelectionModel().getSelectedItem().toString();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> list = FXCollections.observableArrayList("S", "C", "E", "M");
        type.setItems(list);
        type.setValue("S");

        Set<Currency> currencies = Currency.getAvailableCurrencies();
        ObservableList<String> listC = FXCollections.observableArrayList();
        // Duyệt qua và in tên của mỗi loại tiền tệ
        for (Currency currency : currencies) {
            String currencyCode = currency.getCurrencyCode();
            listC.add(currencyCode);
        }
        currency.setItems(listC);
        currency.setValue("USD");
    }

    @FXML
    void mescpressed(KeyEvent event) {
        switch (event.getCode()) {
            case ESCAPE:
                closeWindow();
                break;
            default:
                break;
        }
    }
   
    private void closeWindow() {
        // Assuming this controller has access to a Stage object to close.
        // If this method should close the primary stage, you need to pass the stage reference
        Stage stage = (Stage) managepage.getScene().getWindow();
        stage.close();
    }

}
