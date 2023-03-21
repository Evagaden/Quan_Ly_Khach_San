module com.example.managing_hotel {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.managing_hotel to javafx.fxml;
    exports com.example.managing_hotel;
}