/**
 * 
 */
package Objects;

import GamePackage.GameProgram;
import GamePackage.ProjectMain;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Shape;

/**
 * @author osclo923
 * Class defining behavior for a bullet not fired by player.
 */
public class EnemyBullet extends Bullet{

	Player p; 
	public EnemyBullet(double posx, double posy,double rotation, Player p, int damage) {
		super(posx, posy, rotation, damage);
		this.p = p;
	}

	@Override
	public void onCollision() {
		for (Entity entity : GameProgram.entityList) {
			if (entity instanceof Pillar && hitBox.getBoundsInParent().intersects(entity.getHitBox().getBoundsInParent())) {
				
				removeEntity(); 
				break;
			}
			else if (entity instanceof Player) {
				if (hitBox.getBoundsInParent().intersects(entity.getHitBox().getBoundsInParent())) {
					entity.damage(damage);
					this.removeEntity(); 
					break;
				}
			}
				
		}
			
	}
		// TODO Auto-generated method stub
		
	

	@Override
	protected void setShape() {
		// TODO Auto-generated method stub
		
	}



}
