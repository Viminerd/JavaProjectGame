/**
 * 
 */
package Objects;

import GamePackage.GameProgram;
import GamePackage.ProjectMain;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Sphere;

/**
 * @author Viktor
 *
 */
public class LavaPool extends Entity {

	/**
	 * @param posx
	 * @param posy
	 */
	private double radie; 
	public LavaPool(double posx, double posy, double radie) {
		super(posx, posy);
		this.radie = radie; 		
		
		hitBox = new Rectangle(posx, posx+30, posy, posy+30);
		hitBox.setFill(Color.ORANGE);
		hitBox.setStroke(Color.RED);
		addEntity();
	}


	@Override
	public void moveMe() {
		hitBox.setLayoutX(posx);
		hitBox.setLayoutY(posy);
		onCollision(); 

		
		
	}

	private void onCollision() {
		for (Entity entity : GameProgram.entityList) {
			if (entity instanceof Player || entity instanceof Enemy) {
				if (hitBox.getBoundsInParent().intersects(entity.getHitBox().getBoundsInParent())) {
					entity.damage(10000);
					break;
				}
			}
				
		}
		// TODO Auto-generated method stub
		
	}

}
