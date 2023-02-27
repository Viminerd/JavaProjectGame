/**
 * 
 */
package Objects;

import GamePackage.ProjectMain;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
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
		// TODO Auto-generated constructor stub
		paintMe(); 
		entityList.add(this); 
		
		
		hitBox = new Ellipse(posx, posy, radie, radie*3);
		hitBox.setFill(null);
		hitBox.setStroke(Color.GREEN);
		EntityList.add(hitBox); 
		ProjectMain.mainlayout.getChildren().add(hitBox);
	}

	@Override
	protected void setShape() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void paintMe() {
		gc.setFill(Color.ORANGE);
		gc.setStroke(Color.RED);
		gc.setLineWidth(2);
		gc.fillOval(posx - radie/2, posy - radie/2, radie, radie*3);
		gc.strokeOval(posx - radie/2, posy - radie/2, radie, radie*3);
		
		
	}

}
