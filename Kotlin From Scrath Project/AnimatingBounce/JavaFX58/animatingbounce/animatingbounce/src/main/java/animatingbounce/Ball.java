package animatingbounce;

import java.awt.*;

public class Ball {
    private int x, y;
    private int dx, dy;
    private final int diameter;
    private final Color color;

    public Ball(int x, int y, int dx, int dy, int diameter, Color color) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.diameter = diameter;
        this.color = color;
    }

    public void move(int panelWidth, int panelHeight) {
        x += dx;
        y += dy;

        if (x < 0 || x + diameter > panelWidth) dx = -dx;
        if (y < 0 || y + diameter > panelHeight) dy = -dy;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, diameter, diameter);
    }

    // Getters (optional)
    public int getX() { return x; }
    public int getY() { return y; }
    public int getDiameter() { return diameter; }
}
