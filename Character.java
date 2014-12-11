package MainFile;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URL;

public class Character {

	int x = 0;
	int y = 600;
	Image activeImage = null;
	public static void mainCharacter(Graphics g)
	{


	}

	public static Image loadpicture(String s){
		Image temp = null;
		URL imageURL = Character.class.getResource(s);
		temp = Toolkit.getDefaultToolkit().getImage(imageURL);
		return temp;
	}

	
	


}
