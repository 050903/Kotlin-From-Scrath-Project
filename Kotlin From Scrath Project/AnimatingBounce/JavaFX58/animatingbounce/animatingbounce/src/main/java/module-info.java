module com.example.animatingbounce {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens animatingbounce to javafx.fxml;
    exports animatingbounce;
}