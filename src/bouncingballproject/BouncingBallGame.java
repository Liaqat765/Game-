package bouncingballproject;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class BouncingBallGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(() -> {
            JFrame.setDefaultLookAndFeelDecorated(true);
            new GameMainFrame();
        });
	}

}
