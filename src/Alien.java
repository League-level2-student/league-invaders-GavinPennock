import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Alien extends GameObject {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;

	Alien(int x1, int y1, int width1, int height1) {
		super(x1, y1, width1, height1);
		speed = 1;
		if (needImage) {
			loadImage("alien.png");
		}
	}

	void loadImage(String imageFile) {
		if (needImage) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				gotImage = true;
			} catch (Exception e) {

			}
			needImage = false;
		}
	}

	public void update() {
		y += speed;
		if (y > LeaugeInvaders.HEIGHT) {
			isActive = false;
		}
		super.update();
	}

	public void draw(Graphics g) {
		//super.draw(g);
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
	}
}
