
package Objects;

import GamePackage.GameProgram;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

/**
 * @author osclo923
 * Sublclass to Powerup that implements the shoot powerup. input posx posy Player
 */
public class ShootPowerUp extends Powerup {

	/**
	 * @param posx
	 * @param posy
	 */
	public ShootPowerUp(double posx, double posy, Player p) {
		super(posx, posy, p);
		hitBox = new Ellipse(posx,posy,10,10);
		hitBox.setFill(Color.BROWN);
		addEntity();
	}

	@Override
	public void moveMe() {
		
		
	}

	@Override
	public void doCommand() {
		GameProgram.shootPowerUp = 5*1000/16; 
		removeEntity();
		
	}

}
