/**
 * 
 */
package Objects;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
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
	public Pillar(double x, double y, double radie, GraphicsContext g) {
		super(x,y);
		g.setFill(Color.WHITE);
		g.setStroke(Color.BLACK);
		g.fillOval(x - radie/2, y - radie/2, radie, radie);
		
		hitBox = new Circle();
//		hitBox.setCenterX(x-radie); 
//		hitBox.setCenterY(y-radie); 
//	    hitBox.setRadius(radie); 
	}

}