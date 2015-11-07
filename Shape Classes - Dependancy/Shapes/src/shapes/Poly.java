package Shapes;

import java.awt.Graphics;

public abstract class Poly extends BBox {

    protected abstract void calcVertices();
    protected int[] xs;
    protected int[] ys;

    public Poly(Point p1, Point p2) {
        super(p1, p2);
        calcVertices();
    }

    @Override
    public void setP2(Point p2) {
        super.setP2(p2);
        calcVertices();

    }

    @Override
    public void draw(Graphics g) {
        if (isFilled()) {
            g.setColor(getFillColor());
            g.fillPolygon(xs, ys, xs.length);

        }
        g.setColor(getColor());
        g.drawPolygon(xs, ys, xs.length);
    }

}
