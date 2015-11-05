package Shapes;

import java.awt.Color;
import java.awt.Graphics;

public class BBox extends Shape {
    
    protected Color fillColor;
    protected boolean filled;
    
    public BBox(Point p1, Point p2) {
        super(p1, p2);
    }

    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    public int getULX() {
        return p1.minX(p2);
    }

    public int getULY() {
        return p1.minY(p2);
    }

    public int getWidth() {
        return p1.hDiff(p2);
    }

    public int getHeight() {
        return p1.vDiff(p2);
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public void draw(Graphics g) {
    }

}
