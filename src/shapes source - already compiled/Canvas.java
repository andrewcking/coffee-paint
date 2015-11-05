package Shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Canvas extends JPanel implements MouseListener, MouseMotionListener {

    private ArrayList<Shape> shapes;
    private JLabel statusLabel;
    private ShapeType currentShapeType;
    private Shape currentShape;
    private Color shapeColor;
    private Color fillColor;
    private boolean filledShape;

    public Canvas() {
        shapes = new ArrayList<>();
        setBackground(Color.white);
        currentShapeType = ShapeType.Line;
        this.shapeColor = Color.black;
        this.fillColor = Color.black;
        this.filledShape = false;
        this.currentShape = null;
    }

    public void setStatusLabel(JLabel label) {
        statusLabel = label;
    }

    public void add(Shape shape) {
        shapes.add(shape);
    }

    public void setCurrentShapeype(ShapeType currentShapetype) {
        this.currentShapeType = currentShapetype;
    }

    public void setCurrentShape(Shape currentShape) {
        this.currentShape = currentShape;
    }

    public void setShapeColor(Color shapeColor) {
        this.shapeColor = shapeColor;
    }

    public Color getShapeColor() {
        return shapeColor;
    }

    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    public void undo() {
        if (!shapes.isEmpty()) {
            shapes.remove(shapes.size() - 1);
            this.repaint();
        }
    }

    public void clear() {
        shapes.clear();
        this.repaint();
    }

    public void setFilledShape(boolean filledShape) {
        this.filledShape = filledShape;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Shape shape : shapes) {
            shape.draw(g);
            }
        if (currentShape != null) {
            currentShape.draw(g);
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
        if (currentShape == null) {
            currentShape = ShapeType.makeShape(currentShapeType, trX(me.getX()), trY(me.getY()), trX(me.getX()), trY(me.getY()));
            currentShape.setColor(shapeColor);
            if (currentShape instanceof BBox) {
                ((BBox) currentShape).setFilled(filledShape);
                ((BBox) currentShape).setFillColor(fillColor);
            }
            this.repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        if (currentShape != null) {
            shapes.add(currentShape);
            currentShape = null;
            this.repaint();
        }
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        if (currentShape != null) {
            currentShape.setP2(new Point(trX(me.getX()), trY(me.getY())));
            this.repaint();
        }
        updateStatus(me);
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        updateStatus(me);
    }

    private void updateStatus(MouseEvent me) {
        if (statusLabel != null) {
            statusLabel.setText(String.format("(%03d,%03d)", me.getX() - 8, me.getY() - 66));
        }
    }

    private int trX(int x) {
        return x - 8;
    }

    private int trY(int y) {
        return y - 66;
    }
}