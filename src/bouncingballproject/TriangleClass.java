
package bouncingballproject;


import java.awt.*;
import javax.swing.*;
 
public class TriangleClass extends Shape {
 
  // Box height and width
  int width;
  int height;
  
  int x1 = 290;
  int x2 = 320; 
  int x3 = 350;
  int y1 = 280;
  int y2 = 220;
  int y3 = 280;
  
    
//  int x1 = 290;
//  int x2 = 320; 
//  int x3 = 350;
//  int y1 = 250;
//  int y2 = 100;
//  int y3 = 250;

  
  int[] xPoints = {x1, x2, x3};
  int[] yPoints = {y1, y2, y3};
  Polygon triangle = new Polygon(xPoints, yPoints, 3);
  
  // Ball Size


 
  // Center of Call
  float X = (x1+x2+x3)/3;
  float Y = (y1+y2+y3)/3;
 
  // Direction
  float dx = -2;
  float dy = 5;
  

//  int intialColor = 0;
//  int userNum = 3;
//  int speed = 55;
  
  
 
  public TriangleClass() {
 
    Thread thread = new Thread() {
      public void run() {
        while (true) {
 
           width = getWidth();
           height = getHeight();
 
            X = X + dx ;
            Y = Y + dy;
       
           triangle.translate((int)dx, (int)dy);
          
            if (X + triangle.getBounds().width-30 > width){     //Check is the triangle is at the right boundary                    
                dx = - dx;
//                switch (userNum){
//                    case 1 -> intialColor = 1;
//                    //case 2 ->  radius = 40;
//                    case 3 -> speed = 22;
//                }
            } 
            
            else if( X < 30){  //Check is the triangle is at the left boundary 
                 dx = - dx;
//                switch (userNum){
//                   case 1 -> intialColor = 2;
//                   //case 2 -> radius= 60;
//                   case 3 -> speed=30;
//            } 
            } //Move back            

            else if (Y + triangle.getBounds().height-40 > height){    //triangle is at the bottom boundary
                dy = - dy;
//                switch (userNum){
//                    case 1 -> intialColor = 3;
//                    //case 2 -> radius= 80;
//                    case 3 -> speed=55;
//            }
            } //move up
            
            if( Y < 40){
                dy = - dy;//move down
//                switch (userNum){
//                       case 1 -> intialColor = 4;
//                       //case 2 -> radius= 100;
//                       case 3 -> speed=15;
//                    }
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
        super.paintComponent(g);
       // int userColor = user.getChosenColor();
        g.setColor(color);
        
        g.fillPolygon(triangle);
        
    } 
 
  public static void main(String[] args) {
    JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame frame = new JFrame("Bouncing Ball Project");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 500);
    frame.setContentPane(new TriangleClass());
    frame.setVisible(true);
   
  }
}
