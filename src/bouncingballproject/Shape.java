

package bouncingballproject;

import java.awt.Color;
import javax.swing.JPanel;


public abstract class Shape extends JPanel {
    protected Color[] colors = {Color.blue, Color.red, Color.pink, Color.orange, Color.green,};
    protected int speed = 30;
    protected Color color = Color.RED;

    public Color[] getColors() {
        return colors;
    }

    public void setColors(Color[] colors) {
        this.colors = colors;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    
}
