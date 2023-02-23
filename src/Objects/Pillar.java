/**
 * 
 */
package Objects;

import java.awt.Color;

import javafx.scene.shape.Shape;
import javafx.scene.shape.Sphere;

/**
 * Pillar is an circle that is simply blocking movement (of characters and bullets). 
 *
 *
 */
public class Pillar extends Entity {

	/**
	 * 
	 */
	public Pillar(double x, double y, double radie) {
		gc.setFill(Color.WHITE);
		gc.setStroke(Color.Black);
		gc.fillOval(x - radie/2, y - radie/2, radie, radie);
		
		shape = new Circle();
		shape.setCenterX(x-radie); 
		shape.setCenterY(y-radie); 
		shape.setRadius(radie); 
	}

}
