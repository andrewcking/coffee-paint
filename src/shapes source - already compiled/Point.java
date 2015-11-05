package Shapes;

public class Point {
    private int x;
    private int y;
    
    public Point() {
        this(0,0);
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int hDiff(Point p2) {
        return Math.abs(this.x - p2.x);

    }

    public int vDiff(Point p2) {
        return Math.abs(this.y - p2.y);

    }

    public double Distance(Point p2) {
        return Math.sqrt(Math.pow(hDiff(p2), 2) + Math.pow(vDiff(p2), 2));
    }
    
    public int minX(Point p2){
        return Math.min(this.x,p2.x);
        
    }
    
    public int minY(Point p2){
        return Math.min(this.y,p2.y);
    }
    
}
