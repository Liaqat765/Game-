
package bouncingballproject;

import javax.swing.*;
import java.awt.*;

public class GameMainFrame extends JFrame {
    
    private Shape shape, circle, triangle, square;
    private CardLayout cardLayout;
    private JPanel cardPanel;
    

    public GameMainFrame() {
        setTitle("Bouncing Ball Project");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        

         cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        circle = new CircleClass();
        triangle = new TriangleClass();
        square= new SquareClass();

        cardPanel.add(circle, "Circle");
        cardPanel.add(triangle, "Triangle");
        cardPanel.add(square, "Square");
        
        shape = circle;

        add(cardPanel, BorderLayout.CENTER);

        JPanel controlPanel = createControlPanel();
        add(controlPanel, BorderLayout.NORTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createControlPanel() {
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        // Shape selection
        String[] shapes = {"Circle", "Triangle", "Square"};
        JComboBox<String> shapeComboBox = new JComboBox<>(shapes);
        shapeComboBox.addActionListener(e -> {
            String selectedShape = (String) shapeComboBox.getSelectedItem();
            cardLayout.show(cardPanel, selectedShape);
            switch (selectedShape) {
                case "Circle":
                    shape = (CircleClass) cardPanel.getComponent(0);
                    break;
                case "Triangle":
                    shape = (TriangleClass) cardPanel.getComponent(1);
                    break;
                case "Square":
                    shape = (SquareClass) cardPanel.getComponent(2);
                    break;
            }
        });
        controlPanel.add(new JLabel("Select Shape:"));
        controlPanel.add(shapeComboBox);

//         Color selection
        JButton colorButton = new JButton("Choose Color");
         colorButton.addActionListener(e -> {
            Color selectedColor = JColorChooser.showDialog(null, "Choose Color", shape.getColor());
            if (selectedColor != null) {
                shape.setColor(selectedColor);
                shape.repaint();
            }
        });
        controlPanel.add(colorButton);

        // Speed control
        JSlider speedSlider = new JSlider(1, 100, shape.getSpeed() );
       speedSlider.addChangeListener(e -> {
            shape.setSpeed(speedSlider.getValue());
        });
        controlPanel.add(new JLabel("Set Speed:"));
        controlPanel.add(speedSlider);

        return controlPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame.setDefaultLookAndFeelDecorated(true);
            new GameMainFrame();
        });
    }
}

