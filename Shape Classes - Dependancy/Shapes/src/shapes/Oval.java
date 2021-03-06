package Shapes;

import java.awt.Graphics;

public class Oval extends BBox {

    public Oval(Point p1, Point p2) {
        super(p1, p2);
    }

    public Oval(int x1, int y1, int x2, int y2) {
        super(new Point(x1, y1), new Point(x2, y2));
    }

    @Override
    public void draw(Graphics g) {
        if (isFilled()) {
            g.setColor(getFillColor());
            g.fillOval(getULX(), getULY(), getWidth(), getHeight());
        }
        g.setColor(getColor());
        g.drawOval(getULX(), getULY(), getWidth(), getHeight());
    }
    
}