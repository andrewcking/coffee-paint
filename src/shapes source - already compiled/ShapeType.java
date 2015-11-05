package Shapes;


public enum ShapeType {

    Line, Rect, Oval, Triangle, Trapezoid;

    public static Shape makeShape(ShapeType type, int x1, int y1, int x2, int y2) {
        switch (type) {
            case Line:
                return new Line(new Point(x1, y1), new Point(x2, y2));
            case Rect:
                return new Rect(new Point(x1, y1), new Point(x2, y2));
            case Oval:
                return new Oval(new Point(x1, y1), new Point(x2, y2));
            case Triangle:
                return new Triangle(new Point(x1, y1), new Point(x2, y2));
            case Trapezoid:
                return new Trapezoid(new Point(x1, y1), new Point(x2, y2));
            default:
                return new Line(new Point(x1, y1), new Point(x2, y2));
        }
    }
}
