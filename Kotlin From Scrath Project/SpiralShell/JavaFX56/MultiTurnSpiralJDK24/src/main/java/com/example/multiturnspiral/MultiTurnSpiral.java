package com.example.multiturnspiral; // Đảm bảo package này KHỚP với cấu trúc thư mục của bạn

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font; // Import Font cho văn bản
import javafx.stage.Stage;

// Import các hàm toán học tĩnh từ lớp Math của Java để sử dụng trực tiếp
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.toRadians; // Hàm chuyển đổi độ sang radian
import static java.lang.Math.min; // Hàm tìm giá trị nhỏ nhất

public class MultiTurnSpiral extends Application {

    // Các hằng số cho kích thước cửa sổ và tiêu đề
    private static final double WINDOW_WIDTH = 600.0;
    private static final double WINDOW_HEIGHT = 600.0; // Chiều cao bằng chiều rộng để hình xoắn ốc đối xứng
    private static final String WINDOW_TITLE = "Xoắn ốc nhiều vòng";

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(WINDOW_TITLE); // Đặt tiêu đề cho cửa sổ chính

        // Tạo một đối tượng Canvas, nơi chúng ta sẽ vẽ hình
        Canvas canvas = new Canvas(WINDOW_WIDTH, WINDOW_HEIGHT);

        // Lấy ngữ cảnh đồ họa 2D từ Canvas để thực hiện các thao tác vẽ
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Gọi phương thức chính để vẽ hình xoắn ốc lên Canvas
        drawMultiTurnSpiral(gc, canvas.getWidth(), canvas.getHeight());

        // Tạo một Pane (khung bố cục cơ bản) để chứa Canvas
        Pane root = new Pane(canvas);

        // Tạo một Scene (khung cảnh) từ root Pane và đặt nó vào Stage (cửa sổ ứng dụng)
        // Kích thước của Scene sẽ tự động điều chỉnh theo kích thước của root Pane
        primaryStage.setScene(new Scene(root));
        primaryStage.show(); // Hiển thị cửa sổ ứng dụng
    }

    /**
     * Phương thức chính để vẽ hình xoắn ốc nhiều vòng.
     * Nó tính toán vị trí và kích thước của từng vòng tròn trong xoắn ốc
     * dựa trên các tham số cấu hình.
     * @param gc Ngữ cảnh đồ họa của canvas.
     * @param width Chiều rộng của canvas.
     * @param height Chiều cao của canvas.
     */
    private void drawMultiTurnSpiral(GraphicsContext gc, double width, double height) {
        // Các tham số cấu hình cho hình xoắn ốc
        int numCircles = 70; // Tổng số lượng vòng tròn sẽ được vẽ
        double turns = 2.0; // Số vòng quay hoàn chỉnh của xoắn ốc (ví dụ: 2.0 = 2 vòng 360 độ)
        double maxAngle = 360.0 * turns; // Tổng góc quay tối đa tính bằng độ

        // rotationStep: Số độ xoay giữa mỗi vòng tròn
        double rotationStep = (maxAngle / numCircles);

        // maxRadius: Bán kính lớn nhất mà một vòng tròn có thể đạt được.
        // Được tính toán để đảm bảo hình xoắn ốc nằm gọn trong giới hạn của canvas.
        double maxRadius = min(width, height) / 10.0; // Lấy 1/10 của chiều nhỏ hơn của canvas

        double spacingFactor = 2.0; // Hệ số điều chỉnh khoảng cách giữa các vòng tròn
        // radiusStep: Lượng bán kính tăng lên giữa mỗi vòng tròn
        double radiusStep = (maxRadius / numCircles) * spacingFactor;

        // Gọi phương thức printParams() để hiển thị các thông số chính lên canvas
        printParams(gc, radiusStep, numCircles);

        // Vòng lặp để vẽ từng vòng tròn tạo nên hình xoắn ốc
        for (int i = 0; i < numCircles; i++) {
            double angle = i * rotationStep; // Góc quay hiện tại cho vòng tròn thứ i
            double radius = i * radiusStep; // Bán kính của vòng tròn thứ i

            // Tính toán tọa độ tâm của vòng tròn (x, y)
            // Tâm của canvas (width/2, height/2) được coi là điểm cố định của hình xoắn ốc
            double centerX = width / 2.0;
            double centerY = height / 2.0;

            // Sử dụng hàm cos() và sin() để tính toán vị trí x, y của tâm vòng tròn.
            // Lưu ý: Các hàm này yêu cầu góc phải ở đơn vị radian, nên chúng ta dùng toRadians().
            double x = centerX + radius * cos(toRadians(angle));
            double y = centerY + radius * sin(toRadians(angle));

            // Gọi phương thức trợ giúp để vẽ vòng tròn hiện tại
            drawCircle(gc, x, y, radius);
        }
    }

    /**
     * Phương thức trợ giúp để in các tham số chính của hình xoắn ốc lên canvas.
     * Giúp người dùng biết được các giá trị quan trọng của mô hình.
     * @param gc Ngữ cảnh đồ họa.
     * @param radiusStep Bước bán kính.
     * @param numCircles Số lượng vòng tròn.
     */
    private void printParams(GraphicsContext gc, double radiusStep, int numCircles) {
        // Đặt màu và font chữ cho văn bản
        gc.setFill(Color.BLACK); // Màu chữ là đen
        gc.setFont(Font.font("Arial", 14.0)); // Font Arial, cỡ 14 pixel

        // Tạo các chuỗi thông báo sử dụng String.format để định dạng số thập phân
        String msg1 = String.format("Bán kính cơ sở : %.4f pixel", radiusStep);
        String msg2 = String.format("Số lượng hình dạng (hình tròn) : %d", numCircles);

        // Hiển thị văn bản trên canvas (gần góc dưới cùng bên trái)
        // Tọa độ y được tính toán để văn bản nằm phía trên đáy cửa sổ, không bị che khuất
        gc.fillText(msg1, 25.0, WINDOW_HEIGHT - 45.0);
        gc.fillText(msg2, 25.0, WINDOW_HEIGHT - 25.0);
    }

    /**
     * Phương thức trợ giúp để vẽ một vòng tròn riêng lẻ.
     * Mỗi vòng tròn được vẽ với một đường viền và một chấm nhỏ ở tâm.
     * @param gc Ngữ cảnh đồ họa.
     * @param x Tọa độ x của tâm vòng tròn.
     * @param y Tọa độ y của tâm vòng tròn.
     * @param radius Bán kính của vòng tròn.
     */
    private void drawCircle(GraphicsContext gc, double x, double y, double radius) {
        // Tính toán tọa độ góc trên bên trái của hình chữ nhật bao quanh hình tròn.
        // Các phương thức fillOval() và strokeOval() của Canvas định vị hình tròn
        // dựa trên góc trên bên trái của hình chữ nhật bao quanh nó, không phải tâm.
        double topLeftX = x - radius;
        double topLeftY = y - radius;

        double pointSize = 8.0; // Kích thước (đường kính) của chấm nhỏ đánh dấu tâm

        // Đặt độ dày đường thẳng và màu nét cho đường viền vòng tròn
        gc.setLineWidth(1.0); // Độ dày nét vẽ là 1.0 pixel
        gc.setStroke(Color.LIGHTGRAY); // Màu đường viền là xám nhạt

        // Đặt màu tô cho chấm nhỏ ở tâm
        gc.setFill(Color.BLACK); // Màu chấm là đen

        // Vẽ chấm nhỏ ở tâm vòng tròn
        // Tọa độ của chấm cũng cần được điều chỉnh để nó nằm chính giữa điểm (x, y)
        gc.fillOval(x - pointSize / 2, y - pointSize / 2, pointSize, pointSize);

        // Vẽ đường viền của vòng tròn lớn hơn
        // Tham số: topLeftX, topLeftY, width, height (width và height đều là 2 * radius cho một hình tròn)
        gc.strokeOval(topLeftX, topLeftY, radius * 2, radius * 2);
    }

    /**
     * Hàm main là điểm khởi đầu của ứng dụng JavaFX.
     * Nó gọi phương thức launch() để khởi tạo và chạy ứng dụng JavaFX.
     * @param args Các đối số dòng lệnh truyền vào khi chạy ứng dụng.
     */
    public static void main(String[] args) {
        launch(MultiTurnSpiral.class);
    }
}