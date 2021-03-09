import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
	Rectangle collisionBox;
	int x;
	int y;
	int width;
	int height;
	int speed = 0;
	boolean isActive = true;

	public void update() {
		collisionBox.setBounds(x,y,width,height);
	}

	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.drawRect(collisionBox.x,collisionBox.y,collisionBox.width, collisionBox.height);
	}

	GameObject(int x1, int y1, int width1, int height1) {
		x = x1;
		y = y1;
		width = width1;
		height = height1;
		collisionBox = new Rectangle(x, y, width, height);
	}
}
