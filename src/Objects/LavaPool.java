/**
 * 
 */
package Objects;

import javafx.scene.paint.Color;

/**
 * @author Viktor
 *
 */
public class LavaPool extends Entity {

	/**
	 * @param posx
	 * @param posy
	 */
	public LavaPool(double posx, double posy, double radie) {
		super(posx, posy);
		// TODO Auto-generated constructor stub
		
		gc.setFill(Color.ORANGE);
		gc.setStroke(Color.RED);
		gc.setLineWidth(2);
		gc.fillOval(posx - radie/2, posy - radie/2, radie, radie*3);
		gc.strokeOval(posx - radie/2, posy - radie/2, radie, radie*3);
	}

}
