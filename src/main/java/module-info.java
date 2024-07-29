module task.javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens task.javafx.model to javafx.base;
    opens task.javafx to javafx.fxml;
    exports task.javafx;
}
