package collage;

import Shapes.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Adrix (Andrew King)
 */
public class CoffeePaint extends JFrame {
    
    private Canvas canvas;
    private JComboBox shapeBox;
    private JButton colorButton;
    private JCheckBox filledCheckBox;
    private JButton fillButton;
    private JButton undoButton;
    private JButton clearButton;
    private JLabel statusLabel;
    
    public CoffeePaint() {
        super("Coffee Paint");
        setLayout(new BorderLayout());
        JPanel controlPanel = new JPanel();
        
        //Button Shape Selector
        shapeBox = new JComboBox(ShapeType.values());
        shapeBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                canvas.setCurrentShapeype((ShapeType) shapeBox.getSelectedItem());
            }
        });
        controlPanel.add(shapeBox);
        
        //Button Outline Color
        colorButton = new JButton("Line Color");
        colorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Color oldOutlineColor = canvas.getShapeColor();
                Color newOutlineColor = JColorChooser.showDialog(canvas, "Line Color", oldOutlineColor);
                if (newOutlineColor != null) {
                    canvas.setShapeColor(newOutlineColor);
                    colorButton.setForeground(newOutlineColor);
                }
            }
        });
        controlPanel.add(colorButton);
        
        //Button Fill Color
        fillButton = new JButton("Fill Color");
        fillButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Color oldFillColor = canvas.getFillColor();
                Color newFillColor = JColorChooser.showDialog(canvas, "Fill Color", oldFillColor);
                if (newFillColor != null) {
                    canvas.setFillColor(newFillColor);
                    fillButton.setForeground(newFillColor);
                }
            }
        });
        controlPanel.add(fillButton);
        
        //CheckBox Fill Shape?
        filledCheckBox = new JCheckBox("Filled");
        filledCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                canvas.setFilledShape(filledCheckBox.isSelected());
            }
        });
        controlPanel.add(filledCheckBox);
           
        //Button Undo
        undoButton = new JButton("Undo");
        undoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                canvas.undo();
            }
        });
        controlPanel.add(undoButton);
        
        //Button Clear
        clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                canvas.clear();
            }
        });
        controlPanel.add(clearButton);
        add(controlPanel, BorderLayout.NORTH);
        
        //Other Canvas Objects
        canvas = new Canvas();
        add(canvas, BorderLayout.CENTER);
        JPanel statusPanel = new JPanel();
        statusLabel = new JLabel("(000,000)");
        statusPanel.add(statusLabel);
        add(statusPanel, BorderLayout.SOUTH);
        canvas.setStatusLabel(statusLabel);
        addMouseListener(canvas);
        addMouseMotionListener(canvas);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CoffeePaint collage = new CoffeePaint();
        collage.setSize(1000, 800);
        collage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        collage.setVisible(true);

    }
}