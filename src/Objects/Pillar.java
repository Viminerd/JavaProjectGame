/**
 * 
 */
package Objects;



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
	public Pillar(double x, double y, double radie) {
		super(x,y);
		gc.setFill(Color.WHITE);
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(2);
		gc.fillOval(x - radie/2, y - radie/2, radie, radie);
		gc.strokeOval(x - radie/2, y - radie/2, radie, radie);
		
		hitBox = new Circle();
		hitBox.setStrokeWidth(radie); 
		hitBox.setFill(Color.RED);
//		hitBox.setCenterX(x-radie); 
//		hitBox.setCenterY(y-radie); 
//	    hitBox.setRadius(radie); 
	}

	@Override
	protected void setShape() {
		// TODO Auto-generated method stub
		
	}

}
