module com.example.javafxs {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxs to javafx.fxml;
    exports com.example.javafxs;
    opens com to javafx.fxml;
}