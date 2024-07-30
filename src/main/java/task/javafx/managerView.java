package task.javafx;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import task.javafx.model.car;
import task.javafx.model.controller;

public class managerView  implements Initializable{

    private controller _controller; 
    @FXML
    private ComboBox<String> currency;
    private String unit = "USD";

    @FXML
    private DatePicker edate;

    @FXML
    private TableView<car> table;

    @FXML
    private Pane managepage;

    @FXML
    private TextField name;

    @FXML
    private TextField number;

    @FXML
    private TextField price;

    @FXML
    private TableColumn<car, String> tcurency;

    @FXML
    private TableColumn<car, LocalDate> tdate;

    @FXML
    private TableColumn<car, String> tid;

    @FXML
    private TableColumn<car, String> tname;

    @FXML
    private TableColumn<car, Integer> tnumber;

    @FXML
    private TableColumn<car, Double> tprice;

    @FXML
    private TableColumn<car, Character> ttype;

    @FXML
    private TextField search;

    @FXML
    private ComboBox<String> type;

    @FXML
    private Button toEpo;

    @FXML
    private TextField epoch;
    
    @FXML
    private Button del;

    @FXML
    private ImageView logout;

    @FXML
    void toEClick(MouseEvent event) {
        car _car = new  car();
        _car.setDateOfEntry(edate.getValue());
        epoch.setText(String.valueOf(_car.toEpoch()));

    }

    @FXML
    void Select(ActionEvent event) {
        if ( price.getText().isEmpty()) return ; 
        String s = currency.getSelectionModel().getSelectedItem().toString();
        Double tmp = Double.parseDouble(price.getText()) ;
        car _car = new car();
        tmp = _car.change(unit, s,tmp);
        price.setText(tmp.toString());
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

        _controller = new controller();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        tdate.setCellFactory(column -> {
            return new TableCell<car, LocalDate>() {
                
                @Override
                protected void updateItem(LocalDate item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setText(null);
                    } else {
                        setText(item.toString());
                    }
                }
            };
        });
        
        tid.setCellValueFactory(new PropertyValueFactory<car,String>("id"));
        tname.setCellValueFactory(new PropertyValueFactory<car,String>("name"));
        tnumber.setCellValueFactory(new PropertyValueFactory<car,Integer>("number"));
        tdate.setCellValueFactory(new PropertyValueFactory<car,LocalDate>("dateOfEntry"));
        tprice.setCellValueFactory(new PropertyValueFactory<car,Double>("price"));
        ttype.setCellValueFactory(new PropertyValueFactory<car,Character>("type"));
        tcurency.setCellValueFactory(new PropertyValueFactory<car,String>("unit"));
        show(_controller.carList); 
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
    @FXML
    void addclick(MouseEvent event) {
        if (name.getText().isEmpty() || number.getText().isEmpty() || price.getText().isEmpty() ) 
        {
            messagebox.show("empty input") ; 
            return ; 
        }
        car _car = new car();
        _car.setName(name.getText());
        _car.setNumber(Integer.parseInt(number.getText()));
        _car.setDateOfEntry(edate.getValue());
        _car.setPrice(Double.parseDouble(price.getText()));
        _car.setType(type.getValue().charAt(0));
        _car.setUnit(currency.getValue());
        _controller.addCar(_car);
        show(_controller.carList);
    }
    private void closeWindow() {
        // Assuming this controller has access to a Stage object to close.
        // If this method should close the primary stage, you need to pass the stage reference
        Stage stage = (Stage) managepage.getScene().getWindow();
        stage.close();
    }
    public void show(List<car> car)
    {
        try {
        table.getItems().setAll(car) ; 
            
        } catch (Exception e) {
            String tmp = e.getMessage();
        }
    }
    @FXML
    void searchChanged(KeyEvent event) {
        String s = search.getText();
        if (s.isEmpty()) {
            show(_controller.carList);
            return;
        }
        List<car> lst = new ArrayList<>();
        for (car car : _controller.carList) {
            if (car.checkExist(s))
                lst.add(car);
        }
        show(lst);
    }
    @FXML
    void delclick(MouseEvent event) {
        car car = table.getSelectionModel().getSelectedItem();
        _controller.deleteCar(car.getId());
        show(_controller.carList);
    }
    @FXML
    void logout(MouseEvent event) throws IOException {
        Stage Stage = new Stage();
        Stage.initStyle(StageStyle.UNDECORATED);
        closeWindow(); 
        App.scene = new Scene(App.loadFXML("login"));
  
        Stage.setScene(App.scene);
        Stage.show();
    }
}
