import java.awt.Color;
import java.awt.Graphics;

public class alien extends GameObject{
	alien(int x1, int y1, int width1, int height1) {
		super(x1, y1, width1, height1);
		speed=1;
	}
	 public void update() {
		 y+=speed;
	}
	 public void draw(Graphics g) {
		  g.setColor(Color.YELLOW);
	        g.fillRect(x, y, width, height);
	 }
}
