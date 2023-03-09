/**
 * Sublclass to Powerup that implements the invincible powerup. input posx posy Player
 */
package Objects;

import GamePackage.GameProgram;
import GamePackage.ProjectMain;
import javafx.scene.paint.Color;

import javafx.scene.shape.Polygon;

import javafx.scene.shape.Shape;

/**
 * @author osclo923
 * 
 */
public class InvinciblePowerUp extends Powerup {

	/**
	 * @param posx
	 * @param posy
	 */

	public InvinciblePowerUp(double posx, double posy, Player p) {
		super(posx, posy, p);

		Polygon triangle = new Polygon();
		triangle.getPoints().setAll(posx - 30, posy + 10, posx, posy - 20, posx + 30, posy + 10);

		Polygon triangle2 = new Polygon();
		triangle2.getPoints().setAll(posx - 30, posy - 10, posx, posy + 20, posx + 30, posy - 10);

		Shape hitBoxTemp = Shape.union(triangle, triangle2);

		hitBox = hitBoxTemp;
		hitBox.setFill(Color.YELLOW);
		addEntity();

	}

	@Override
	public void moveMe() {// kommer inte röra sig men används för att uppdatera

//		for (Entity entity : GameProgram.entityList) {
//			if (hitBox.getBoundsInParent().intersects(entity.getHitBox().getBoundsInParent()) && entity == target) {
//				doCommand();
//				break;
//			}//TODO;den intersectar alltid en hitbox som inte är player, hur????
//		}

	}
	@Override
	public void doCommand() {
		GameProgram.invincibleTime = 7*1000/16;
		removeEntity();
	}

}
