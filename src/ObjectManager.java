import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	Rocketship rocket;
	Random random = new Random();
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	int score=0;
	

	ObjectManager(Rocketship rocket1) {
		rocket = rocket1;
	}
	public int getscore(){
		return score;
	}
	public void addProjectile(Projectile e) {
		projectiles.add(e);
	}

	public void checkCollision() {
		for (Alien alien : aliens) {
			if (alien.collisionBox.intersects(rocket.collisionBox)) {
				rocket.isActive = false;
				return;
			}
			for (Projectile projectile : projectiles) {
				if (alien.collisionBox.intersects(projectile.collisionBox)) {
					alien.isActive = false;
					projectile.isActive = false;
					score=score+1;
				}
			}
		}
	}

	public void addAlien() {
		aliens.add(new Alien(random.nextInt(LeaugeInvaders.WIDTH), 0, 50, 50));
	}

	public void update() {
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
		}
		rocket.update();
		checkCollision();
		purgeObjects();
	}

	public void draw(Graphics g) {
		rocket.draw(g);
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}

	}

	public void purgeObjects() {
		for (int i = 0; i < aliens.size(); i++) {
			if (!aliens.get(i).isActive ) {
				aliens.remove(i);
			}
		}
		for (int i = 0; i < projectiles.size(); i++) {
			if (!projectiles.get(i).isActive) {
				projectiles.remove(i);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		addAlien();

	}
}
