/**
 * 
 */
package Objects;

import GamePackage.GameProgram;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

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
	public Melee(double posx, double posy, int health, Player p) {
		super(posx, posy, 200, p);
		hitBox = new Rectangle(posx,posy,Color.AQUA);
		hitBox.setFill(Color.MAGENTA);
		hitBox.setStroke(Color.BLACK);
		GameProgram.entityList.add(this); 
		
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub

	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setShape() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveMe() {
		// TODO Auto-generated method stub
		
	}
}
