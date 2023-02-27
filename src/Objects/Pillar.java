/**
 * 
 */
package Objects;



import GamePackage.GameProgram;
import GamePackage.ProjectMain;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
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
	private double radie; 
	public Pillar(double x, double y, double radie) {
		super(x,y);
		this.radie = radie; 
		
		hitBox = new Circle(x,y,radie);
		hitBox.setFill(Color.WHITE);
		hitBox.setStroke(Color.BLACK); 
		ProjectMain.mainlayout.getChildren().add(hitBox);
		EntityList.add(hitBox);
		
		GameProgram.entityList.add(this); 
	}

	@Override
	protected void setShape() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void paintMe() {
		hitBox.setLayoutX(posx);
		hitBox.setLayoutY(posy);
		
	}

}
