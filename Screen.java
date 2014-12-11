package MainFile;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class Screen extends JPanel {
	Image Char = null;
	Character mainCharacter = new Character();
	Image Background = null;

	public Screen() {
		Background = Character.loadpicture("Sc2Terrain2.png");
		mainCharacter.activeImage = Character.loadpicture("ling.png");
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (Background != null) {
			g.drawImage(Background, 0, 0, 1280, 720, this);
		}
		if (mainCharacter != null) {
			g.drawImage(mainCharacter.activeImage, mainCharacter.x,
					mainCharacter.y, 100, 100, this);
		}
		Bindings();
		repaint();
	}

	public void adaptCoordinates(Character C, int x, int y) {
		C.x += x;
		C.y += y;
	}

	public void Bindings() {
		InputMap im = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap am = this.getActionMap();

		im.put(KeyStroke.getKeyStroke('d'), "RightAction");
		am.put("RightAction", new KeyActions(mainCharacter, 'd'));

		im.put(KeyStroke.getKeyStroke('a'), "LeftAction");
		am.put("LeftAction", new KeyActions(mainCharacter, 'a'));

		im.put(KeyStroke.getKeyStroke('w'), "UpAction");
		am.put("UpAction", new KeyActions(mainCharacter, 'w'));

		im.put(KeyStroke.getKeyStroke('s'), "DownAction");
		am.put("DownAction", new KeyActions(mainCharacter, 's'));
	}

	public class KeyActions extends AbstractAction {
		char key;
		Character CH;
		Graphics G;

		public KeyActions(Character C, char c) {
			CH = C;
			key = c;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (key == 'd') {
				adaptCoordinates(CH, 10, 0);
			}

			if (key == 'a') {
				adaptCoordinates(CH, -10, 0);
			}

			if (key == 'w') {
				adaptCoordinates(CH, 0, -10);
			}

			if (key == 's') {
				adaptCoordinates(CH, 0, 10);
			}

		}
	}

}
