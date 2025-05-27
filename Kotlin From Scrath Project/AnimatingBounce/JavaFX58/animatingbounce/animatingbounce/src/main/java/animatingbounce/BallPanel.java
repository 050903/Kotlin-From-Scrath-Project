package animatingbounce;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BallPanel extends JPanel implements ActionListener {
    private final Ball ball;
    private final Timer timer;

    public BallPanel() {
        setPreferredSize(new Dimension(600, 400));
        setBackground(Color.WHITE);

        // Khởi tạo một quả bóng đỏ
        ball = new Ball(0, 0, 2, 3, 30, Color.RED);

        // Thiết lập timer cập nhật mỗi 10ms
        timer = new Timer(10, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ball.draw(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ball.move(getWidth(), getHeight());
        repaint();
    }
}
