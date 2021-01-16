import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LeaugeInvadersRunner {
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	JFrame jframe;

	LeaugeInvadersRunner() {
		jframe = new JFrame();
	}

	public static void main(String[] args) {

	}
	public class gamePanel extends JPanel{
		@Override
		public void paintComponent(Graphics g){
			g.fillRect(10, 10, 100, 100);
		}
		
	}

	
	void setup() {
		new LeaugeInvadersRunner();
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
