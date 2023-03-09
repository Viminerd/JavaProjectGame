/**
 * 
 */
package Objects;

import GamePackage.GameProgram;
import GamePackage.ProjectMain;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;

/**
 * 
 *
 */
public class Melee extends Enemy {

	/**
	 * @param posx
	 * @param posy
	 * @param health
	 * @param p
	 */

	private double maxHealth;
	private Rectangle healthBar;
	private Rectangle missingHealthBar;
	private double centerX;
	private double centerY;
	private double newX;
	private double newY;
	private double posxTemp;
	private double posyTemp;
	public Melee(double posx, double posy, Player p) {
		super(posx, posy, 200, p);

		maxHealth = health;
		centerX = posx;
		centerY = posy;

		hitBox = new Rectangle(posx, posy, 25, 25);
		hitBox.setFill(Color.MAGENTA);
		hitBox.setRotate(0);
		addEntity();

		healthBar = new Rectangle(posx - 15, posy - 30, 30, 5);
		healthBar.setFill(null);

		missingHealthBar = new Rectangle(posx + 15, posy - 30, 0, 5);
		missingHealthBar.setFill(Color.RED);

		ProjectMain.mainlayout.getChildren().add(healthBar);
		ProjectMain.mainlayout.getChildren().add(missingHealthBar);

	}

	@Override
	public void move() {
		double moveSpeed = 1;
		boolean hitsAWallX = false;
		boolean hitsAWallY = false;
		newX = target.getPosx() - posx;
		newY = target.getPosy() - posy;

		if (newX < -10) { // 10 då det blir om en tolerans för hur nogrann den behöver vara
			posxTemp = posx - moveSpeed;
		} else if (newX > 10) {
			posxTemp = posx + moveSpeed;
		} 
		if (newY < -10) {
			posyTemp = posy - moveSpeed;
		} else if (newY > 10) {
			posyTemp = posy + moveSpeed;
		}
		
		hitBox.setLayoutX(posxTemp - centerX);		
		for (Entity entity : GameProgram.entityList) {
			if (hitBox.getBoundsInParent().intersects(entity.getHitBox().getBoundsInParent())
					&& entity.getHitBox() != hitBox && entity instanceof Powerup == false) {
				hitsAWallX = true;
				break;
			}
		}

		hitBox.setLayoutY(posyTemp-centerY);
		for (Entity entity : GameProgram.entityList) {
			if (hitBox.getBoundsInParent().intersects(entity.getHitBox().getBoundsInParent())
					&& entity.getHitBox() != hitBox && entity instanceof Powerup == false) {
				hitsAWallY = true;
				break;
			}
		}

		if (hitsAWallX == false) {
			posx = posxTemp;
			hitBox.setLayoutX(posx - centerX);
		}
		if (hitsAWallY == false) {
			posy = posyTemp;
			hitBox.setLayoutY(posy - centerY);
		}
		
		for (Entity entity : GameProgram.entityList) {
			if (hitBox.getBoundsInParent().intersects(entity.getHitBox().getBoundsInParent())
					&& entity instanceof Player) {
				target.damage(1);
				break;
			}
		}
		

		healthBar.setLayoutX(posx - centerX);
		healthBar.setLayoutY(posy - centerY);
		missingHealthBar.setLayoutX(getLayoutX() + (posx - centerX) - missingHealthBar.getWidth());
		missingHealthBar.setLayoutY(posy - centerY);

	}



	@Override
	public void moveMe() {
		rotateTo(target);
		move();

	}

	public void damage(double d) {
		health -= d;
		healthBar.setFill(Color.GREEN);

		missingHealthBar.setWidth(missingHealthBar.getWidth() + (30 / maxHealth) * d);

		if (health < 1) {
			this.removeEntity();
			ProjectMain.mainlayout.getChildren().remove(healthBar);
			ProjectMain.mainlayout.getChildren().remove(missingHealthBar);
			GameProgram.addScore(15);
		}

	}

}
