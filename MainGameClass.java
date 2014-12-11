package MainFile;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MainGameClass {

	public static void main(String args[]){
		JFrame screen = new JFrame();
		screen.setVisible(true);
		screen.setSize(1280,720);
		screen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		screen.setLayout(new BorderLayout());
		Screen window = new Screen();
		screen.add(window);
	}

}
