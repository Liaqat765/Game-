

package bouncingballproject;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JOptionPane;

public class BouncingBallProject {

    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
       // userInterface Interface = new userInterface();//window??
        //display Display = new display();//not needed???
         public void run() {
            JFrame frame = new JFrame("Bouncing Ball Project");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
            frame.pack();
             JFrame.setDefaultLookAndFeelDecorated(true);
            frame.setSize(640, 480);
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
            String[] shapes= {"Circle", "Square", "Triangle"};
            
            
            
            int shapeUser = JOptionPane.showOptionDialog(null, "Select a shape!"
                    , "Bouncing Shape Project", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, 
                    shapes, 0);
            switch (shapeUser){
                    case 0 -> frame.setContentPane(new CircleClass());
                    case 1 -> frame.setContentPane(new SquareClass());
                    case 2 -> frame.setContentPane(new TriangleClass());
            }                  
           frame.setVisible(true);
           
   
            
         }
      });
   
    }
    
}
