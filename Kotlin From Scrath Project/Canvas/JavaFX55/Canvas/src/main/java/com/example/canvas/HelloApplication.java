package com.example.canvas; // Đảm bảo package này khớp

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view.fxml")); // Thay "hello-view.fxml" bằng tên file FXML của bạn
        Scene scene = new Scene(fxmlLoader.load(), 600, 400); // Điều chỉnh kích thước cửa sổ
        stage.setTitle("Vẽ Hình Chữ Nhật");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}