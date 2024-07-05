module com.example.hrmanagementmilan {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;
    requires java.sql;

    opens com.example.hrmanagementmilan to javafx.fxml;
    exports com.example.hrmanagementmilan;
}