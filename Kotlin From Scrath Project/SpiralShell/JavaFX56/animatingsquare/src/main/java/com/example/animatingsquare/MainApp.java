import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.animation.Transition; // Cho Transition.INDEFINITE
import javafx.animation.TranslateTransition;
import javafx.util.Duration;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Transition Example - Java");

        // 1. Tạo một hình chữ nhật (square)
        Rectangle square = new Rectangle(50.0, 50.0, Color.RED);
        // Đặt vị trí Y ban đầu cho hình chữ nhật.
        // Trong JavaFX, tọa độ (0,0) là góc trên bên trái.
        // Rectangle(width, height, fill) sẽ có x=0, y=0 ban đầu.
        square.setY(100.0);
        // Vị trí X ban đầu sẽ là 0.0 (mặc định của Rectangle và TranslateTransition.fromX)

        // Tạo một Pane để chứa hình chữ nhật
        Pane pane = new Pane();
        pane.getChildren().add(square);

        // 2. Tạo Scene và hiển thị Stage
        Scene scene = new Scene(pane, 300.0, 300.0); // Kích thước cửa sổ 300x300
        primaryStage.setScene(scene);
        primaryStage.show();

        // 3. Tạo một đối tượng TranslateTransition và thiết lập các thuộc tính của nó
        TranslateTransition transition = new TranslateTransition(Duration.seconds(2.0), square);

        // Thiết lập các thuộc tính cho transition
        transition.setFromX(0.0); // Vị trí X bắt đầu của animation (so với vị trí ban đầu của node)
        // Vì square.getX() là 0, fromX=0.0 nghĩa là bắt đầu từ cạnh trái.

        // Tính toán toX: di chuyển đến cạnh phải của pane trừ đi chiều rộng của square
        // Vì pane là root của scene và scene có width là 300, pane.getWidth() sẽ là 300.
        transition.setToX(scene.getWidth() - square.getWidth());

        transition.setCycleCount(Transition.INDEFINITE); // Lặp lại vô hạn
        transition.setAutoReverse(true);                // Tự động đảo ngược khi kết thúc mỗi chu kỳ

        // 4. Chạy animation
        transition.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}