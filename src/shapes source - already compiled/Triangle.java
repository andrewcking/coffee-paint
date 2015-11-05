package Shapes;

public class Triangle extends Poly {

    public Triangle(Point p1, Point p2) {
        super(p1, p2);
    }

    @Override
    protected final void calcVertices() {
        xs = new int[3];
        ys = new int[3];
        xs[0] = getULX() + getWidth() / 2;
        ys[0] = getULY();
        xs[1] = getULX();
        ys[1] = getULY() + getHeight();
        xs[2] = getULX() + getWidth();
        ys[2] = getULY() + getHeight();

    }

}
