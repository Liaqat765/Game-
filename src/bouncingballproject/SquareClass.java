

package bouncingballproject;

import java.awt.*;
import javax.swing.*;

public class SquareClass extends Shape{

 
  // Box height and width
  int width;
  int height;
 
  // Square Size
  float side = 40; 

  // Center of Call
  float center_X = 85;
  float center_Y = 85;
 
  // Direction
  float dx = 3;
  float dy = -1;
  
  int userNum = 3;
   
  
  //int movementSpeed = 3; 
   
  public SquareClass() {
 
    Thread thread = new Thread() {
      public void run() {
        while (true) {
 
          width = getWidth();
          height = getHeight();
 
          center_X = center_X + dx ;
          center_Y = center_Y + dy;
 
          if (center_X - side < 0) {  //Left side
            dx = -dx; 
            center_X = side;
//            switch (userNum){
//                    case 1 -> userColor=1;
//                    case 2 -> side= 40;
//                    case 3 -> speed= 30;
//            }
                         
          } 
          if (center_X > width){ //right side
            dx = -dx;
//            switch (userNum){
//                case 1 -> userColor = 2;
//                case 2 -> side= 60;
//                case 3 -> speed=50;
//            } 
          }
 
          if (center_Y - side< 0){ //top side
            dy = -dy;
            center_Y = side;
//            switch (userNum){
//                case 1 -> userColor = 3;
//                case 2 -> side= 120;
//                case 3 -> speed=150;
//            }
          }
            if (center_Y > height) {  //bottom side
                dy = -dy;
//                switch (userNum){
//                   case 1 -> userColor = 4;
//                   case 2 -> side= 100;
//                   case 3 -> speed=200;
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
 
            
 
  
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
     //user.getColor;
    g.setColor(color);
    g.fillRect((int)(center_X-side), (int)(center_Y-side), (int)side, (int)side);
  }
  
 
  public static void main(String[] args) {
    JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame frame = new JFrame("Bouncing Ball Project");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 500);
    frame.setContentPane(new SquareClass());
    frame.setVisible(true);
  }
    
}