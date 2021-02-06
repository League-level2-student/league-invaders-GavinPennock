import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LeaugeInvaders {
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	JFrame jFrame;
	GamePanel gamePanel;

	LeaugeInvaders() {
		gamePanel = new GamePanel();
		jFrame = new JFrame();

	}

	public static void main(String[] args) {
		LeaugeInvaders leaugeinvaders = new LeaugeInvaders();
		leaugeinvaders.setup();
	}

	void setup() {
		jFrame.setVisible(true);
		jFrame.add(gamePanel);
		jFrame.addKeyListener(gamePanel);
		// new LeaugeInvaders();
		jFrame.setSize(WIDTH, HEIGHT);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
