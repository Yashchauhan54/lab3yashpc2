module org.example.hrmanagementyash {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;
    requires java.sql;

    opens org.example.hrmanagementyash to javafx.fxml;
    exports org.example.hrmanagementyash;
}