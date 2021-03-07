import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	GamePanel gamePanel;
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	Font titleFont;
	Font startFont;
	Font instructionFont;
	Font gameOverFont;
	Font enimiesKilledFont;
	Font restartFont;
	int currentState = MENU;
	Timer frameDraw;
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	Rocketship rocketship=new Rocketship(250,600,50,50);
	ObjectManager objectmanager=new ObjectManager(rocketship);

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
	
	public GamePanel() {
		// main menu page text
		titleFont = new Font("Arial", Font.PLAIN, 48);
		startFont = new Font("Arial", Font.PLAIN, 24);
		instructionFont = new Font("Arial", Font.PLAIN, 24);
		// game over page text
		gameOverFont = new Font("Ariel", Font.PLAIN, 48);
		enimiesKilledFont = new Font("Ariel", Font.PLAIN, 24);
		restartFont = new Font("Ariel", Font.PLAIN, 24);
		// game timer
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
		if (needImage) {
		    loadImage ("space.png");
		}
	}

	void updateMenuState() {
	}

	void updateGameState() {
		objectmanager.update();
	}

	void updateEndState() {
	}

	void drawMenuState(Graphics g) {
		// background
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeaugeInvaders.WIDTH, LeaugeInvaders.HEIGHT);
		// title font
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", 25, 110);
		// start font
		g.setFont(startFont);
		g.setColor(Color.YELLOW);
		g.drawString("press ENTER to start", 130, 325);
		// instructions
		g.setFont(instructionFont);
		g.setColor(Color.YELLOW);
		g.drawString("press SPACE for instructions", 90, 550);

	}

	void drawGameState(Graphics g) {
		if (gotImage) {
			g.drawImage(image, 0, 0, LeaugeInvaders.WIDTH, LeaugeInvaders.HEIGHT-125, null);
		} else {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, LeaugeInvaders.WIDTH, LeaugeInvaders.HEIGHT);
		}
		objectmanager.draw(g);
	}

	void drawEndState(Graphics g) {
		// background when you die
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeaugeInvaders.WIDTH, LeaugeInvaders.HEIGHT);
		// game over text
		g.setFont(gameOverFont);
		g.setColor(Color.BLACK);
		g.drawString("GAME OVER", 115, 110);
		// enemies killed text
		g.setFont(enimiesKilledFont);
		g.setColor(Color.BLACK);
		g.drawString("you killed ___ enemies", 120, 325);
		// restart text
		g.setFont(restartFont);
		g.setColor(Color.BLACK);
		g.drawString("press ENTER to restart you failure", 60, 550);

	}

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == END) {
			drawEndState(g);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (currentState == MENU) {
			updateMenuState();
		} else if (currentState == GAME) {
			updateGameState();
		} else if (currentState == END) {
			updateEndState();
		}
		// System.out.println("action");
		repaint();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {

			if (currentState == END) {
				currentState = MENU;
			} else {
				currentState++;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_UP && currentState == GAME) {
			System.out.println("UP");
			if(rocketship.y>10) {
				rocketship.up();
			}
			
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT && currentState == GAME) {
			System.out.println("LEFT");
			if(rocketship.x>10) {
				rocketship.left();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT && currentState == GAME) {
			System.out.println("RIGHT");
			if(rocketship.x<440) {
				rocketship.right();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN && currentState == GAME) {
			System.out.println("DOWN");
			if(rocketship.y<610) {
				rocketship.down();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
