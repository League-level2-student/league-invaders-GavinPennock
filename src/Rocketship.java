import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
	

	Rocketship(int x1, int y1, int width1, int height1) {
		super(x1, y1, width1, height1);
		speed=10;
	}

	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
        
	}
	
	public void right() {
        x+=speed;
    }
	public void left() {
        x-=speed;
    }
	public void up() {
        y-=speed;
    }
	public void down() {
        y+=speed;
    }
}
