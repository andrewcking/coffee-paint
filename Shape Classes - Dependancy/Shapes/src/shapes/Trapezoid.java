package Shapes;

public class Trapezoid extends Poly {

    public Trapezoid(Point p1, Point p2) {
        super(p1, p2);
    }
    
    @Override
    protected void calcVertices() {
        xs = new int[4];
        ys = new int[4];
        xs[0] = getULX() + getWidth() / 3;
        ys[0] = getULY();
        xs[1] = getULX() + getWidth() * 2 / 3;
        ys[1] = getULY();
        xs[2] = getULX() + getWidth();
        ys[2] = getULY() + getHeight();
        xs[3] = getULX();
        ys[3] = getULY()+ getHeight();
    }
    
}
