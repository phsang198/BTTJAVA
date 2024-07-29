package task.javafx;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class messagebox {

    public static void show(String msg) {
        new Alert(AlertType.ERROR,msg).showAndWait();
    }
}
