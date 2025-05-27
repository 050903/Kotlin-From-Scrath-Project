module com.example.multiturnspiral {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.multiturnspiral to javafx.fxml;
    exports com.example.multiturnspiral;
}