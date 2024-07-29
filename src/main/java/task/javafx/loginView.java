package task.javafx;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class loginView {

    @FXML
    private AnchorPane loginpage;

    @FXML
    private ImageView ic;

    @FXML
    private TextField password;

    @FXML
    private TextField username;

    @FXML
    void login(MouseEvent event) throws IOException {
        if (username.getText().isEmpty() || username.getText().isEmpty())
        {
            messagebox.show("empty input");
            return;
        }
        if (!username.getText().equals("admin") || !password.getText().equals("admin")) {
            messagebox.show("Invalid account");
            return;
        }
        Stage managerStage = new Stage();
        managerStage.initStyle(StageStyle.UNDECORATED);
        closeWindow(); 
        App.scene = new Scene(App.loadFXML("manager"));
  
        managerStage.setScene(App.scene);
        managerStage.show();
    }
    
    @FXML
    void escpressed(KeyEvent event) {
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
        Stage stage = (Stage) loginpage.getScene().getWindow();
        stage.close();
    }
    @FXML
    void onPassChanged(InputMethodEvent event) {

    }

    @FXML
    void onUserChanged(InputMethodEvent event) {

    }

}
