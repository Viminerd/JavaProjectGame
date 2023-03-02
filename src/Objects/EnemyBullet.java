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
 *
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
			if (entity instanceof Player) {
				if (hitBox.getBoundsInParent().intersects(entity.getHitBox().getBoundsInParent())) {
					p.damage(damage);
					this.delete(); 
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
