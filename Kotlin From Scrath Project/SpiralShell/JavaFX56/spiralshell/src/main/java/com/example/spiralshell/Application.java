package com.example.spiralshell; // Gói của bạn

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

// Import các hàm toán học tĩnh để sử dụng ngắn gọn hơn
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.toRadians;
import static java.lang.Math.min;

// Đổi tên class nếu cần, nhưng nếu file là Application.java thì class nên là Application
public class Application extends javafx.application.Application {

    @Override
    public void start(Stage primaryStage) { // primaryStage thay vì stage
        primaryStage.setTitle("Xoắn ốc nhiều vòng - JavaFX");

        // Tạo một canvas và lấy GraphicsContext của nó.
        Canvas canvas = new Canvas(600.0, 600.0); // Kích thước canvas
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Tạo một Pane đơn giản để chứa canvas
        Pane root = new Pane();
        root.getChildren().add(canvas);

        // Tạo Scene với root Pane
        Scene scene = new Scene(root, 600.0, 600.0); // Kích thước cửa sổ
        primaryStage.setScene(scene);
        primaryStage.show();

        // Gọi hàm trợ giúp để vẽ xoắn ốc.
        drawMultiTurnSpiral(gc, canvas.getWidth(), canvas.getHeight());
    }

    private void drawMultiTurnSpiral(
            GraphicsContext gc,
            double width, double height) {

        // Đặt các tham số chính cho xoắn ốc.
        final int numCircles = 70;    // số lượng vòng tròn
        final double turns = 2.0;     // 360 độ mỗi vòng
        final double maxAngle = 360.0 * turns;

        // Góc xoay (độ) cho mỗi bước.
        final double rotationStep = maxAngle / numCircles;

        // Đảm bảo các vòng tròn nằm trong giới hạn của canvas.
        final double maxRadiusBase = min(width, height) / 10.0;
        final double spacingFactor = 2.0;
        final double radiusStep = (maxRadiusBase / numCircles) * spacingFactor;

        printParams(gc, radiusStep, numCircles, width, height);

        gc.setStroke(Color.GRAY);
        gc.setFill(Color.BLACK);

        for (int i = 0; i < numCircles; i++) {
            double angle = i * rotationStep;
            double currentDrawingRadius = i * radiusStep;

            double x = (width / 2.0) + currentDrawingRadius * cos(toRadians(angle));
            double y = (height / 2.0) + currentDrawingRadius * sin(toRadians(angle));

            if (i > 0) {
                drawCircle(gc, x, y, currentDrawingRadius);
            } else {
                drawCircle(gc, x, y, 2.0); // Chấm nhỏ ở tâm
            }
        }
    }

    private void printParams(GraphicsContext gc, double radiusStep, int numCircles, double canvasWidth, double canvasHeight) {
        gc.setFill(Color.BLACK);
        gc.fillText(String.format("Bán kính cơ sở: %.4f pixel", radiusStep), 10, canvasHeight - 30);
        gc.fillText(String.format("Số lượng hình dạng (hình tròn): %d", numCircles), 10, canvasHeight - 10);
    }

    private void drawCircle(
            GraphicsContext gc,
            double x, double y, double radius) {
        gc.setStroke(Color.LIGHTGRAY);
        gc.strokeOval(x - radius, y - radius, radius * 2, radius * 2);

        gc.setFill(Color.BLACK);
        gc.fillOval(x - 2, y - 2, 4.0, 4.0);
    }

    public static void main(String[] args) {
        launch(args);
    }
}