package Shapes;

import java.awt.Graphics;

public class Line extends Shape {

    public Line(Point p1, Point p2) {
        super(p1, p2);
    }

    public Line(int x1, int y1, int x2, int y2) {
        super(new Point(x1, y1), new Point(x2, y2));

    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }
    
}
