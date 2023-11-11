
package bouncingballproject;


import java.awt.*;
import javax.swing.*;
 
public class CircleClass extends Shape {
 
 
  // Box height and width
  int width;
  int height;
 
  // Size
  float radius = 40; 

  // Center of Call
  float center_X = 85;
  float center_Y = 85;
 
  // Direction
  float dx = 1;
  float dy = -3;
//  int userColor = 0;
//  int speed = 30;
  
//  int userNum = 3;
  
  Color[] colors = {Color.RED, Color.CYAN, Color.PINK, Color.YELLOW, Color.MAGENTA};
  
  //int movementSpeed = 3; 
   
 
  public CircleClass() {
 
    Thread thread = new Thread() {
      public void run() {
        while (true) {
 
          width = getWidth();
          height = getHeight();
 
          center_X = center_X + dx ;
          center_Y = center_Y + dy;
 
          if (center_X - radius < 0) {  //Left side
            dx = -dx; 
            center_X = radius;
//            switch (userNum){
//                    case 1 -> userColor=1;
//                    case 2 -> radius= 40;
//                    case 3 -> speed= 25;
//            }
                         
          } 
          if (center_X > width){ //right side
            dx = -dx;
//            switch (userNum){
//                case 1 -> userColor = 2;
//                case 2 -> radius= 60;
//                case 3 -> speed=40;
//            } 
          }
 
          if (center_Y - radius< 0){ //top side
            dy = -dy;
            center_Y = radius;
//            switch (userNum){
//                case 1 -> userColor = 3;
//                case 2 -> radius= 80;
//                case 3 -> speed=65;
//            }
          }
            if (center_Y > height) {  //bottom side
                dy = -dy;
//                switch (userNum){
//                   case 1 -> userColor = 4;
//                   case 2 -> radius= 100;
//                   case 3 -> speed=15;
//                }
          }
        repaint();

          try {
            Thread.sleep(speed);
          } catch (InterruptedException ex) {
          }
 
        }
      }
    };
    thread.start();
  }
 
 
  public void paintComponent(Graphics g){
        //System.out.println(user.getvariableName());
        super.paintComponent(g);
        g.setColor(color);
        g.fillOval((int)(center_X-radius), (int)(center_Y-radius), (int)radius, (int)radius);
    }
  
 
  public static void main(String[] args) {
    JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame frame = new JFrame("Bouncing Ball Project");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 500);
    frame.setContentPane(new CircleClass());
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
  }
}