package com.example.canvas; // Đảm bảo package này khớp với cấu trúc thư mục của bạn

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Controller {

    @FXML
    private Canvas drawingCanvas; // Kết nối với fx:id="drawingCanvas" trong FXML

    // Phương thức này sẽ được gọi khi ứng dụng khởi tạo, sau khi FXML đã được tải
    @FXML
    public void initialize() {
        // Có thể vẽ ngay khi khởi tạo hoặc chờ hành động của người dùng
        // drawRectangle(); // Nếu bạn muốn vẽ ngay khi ứng dụng chạy
    }

    // Phương thức này được gọi khi nút "Vẽ Hình Chữ Nhật" được nhấn (onAction="#drawRectangleOnCanvas")
    @FXML
    protected void drawRectangleOnCanvas() {
        // Lấy GraphicsContext từ Canvas để thực hiện các thao tác vẽ
        GraphicsContext gc = drawingCanvas.getGraphicsContext2D();

        // Xóa Canvas trước khi vẽ để đảm bảo không có hình vẽ cũ
        gc.clearRect(0, 0, drawingCanvas.getWidth(), drawingCanvas.getHeight());

        // Đặt màu fill cho hình chữ nhật
        gc.setFill(Color.RED); // Màu đỏ

        // Vẽ hình chữ nhật được tô đầy: fillRect(x, y, width, height)
        // (x, y) là tọa độ góc trên bên trái của hình chữ nhật
        // (width, height) là chiều rộng và chiều cao
        gc.fillRect(50, 50, 200, 150); // Vẽ hình chữ nhật ở (50,50) với rộng 200, cao 150

        // Đặt màu stroke (viền) cho hình chữ nhật
        gc.setStroke(Color.BLUE); // Màu xanh dương
        gc.setLineWidth(4); // Độ dày của viền

        // Vẽ viền hình chữ nhật: strokeRect(x, y, width, height)
        gc.strokeRect(250, 100, 180, 100); // Vẽ viền hình chữ nhật khác

        // Vẽ một hình chữ nhật với góc bo tròn
        gc.setFill(Color.GREEN); // Màu xanh lá cây
        gc.setStroke(Color.DARKGREEN); // Màu viền xanh đậm
        gc.setLineWidth(2);
        // fillRoundRect(x, y, width, height, arcWidth, arcHeight)
        // arcWidth và arcHeight định nghĩa độ cong của góc
        gc.fillRoundRect(100, 200, 150, 80, 20, 20);
        gc.strokeRoundRect(100, 200, 150, 80, 20, 20);
    }
}
