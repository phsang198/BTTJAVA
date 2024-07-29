module task.javafx {
    requires javafx.controls;
    requires javafx.fxml;

    opens task.javafx to javafx.fxml;
    exports task.javafx;
}
