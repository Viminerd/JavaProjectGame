/**
 * Entity graphics and movement defined. 
 */

package Objects;

import java.util.ArrayList;

import GamePackage.ProjectMain;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Shape;

/**
 * @author osclo923
 *
 */
public abstract class Entity extends Canvas {
	
	public static ArrayList<Shape> EntityList = new ArrayList<>();  
	protected Canvas objectCanvas = new Canvas(1000,1000); 
	//protected GraphicsContext gc = ProjectMain.gameCanvas.getGraphicsContext2D();
	
	protected Shape hitBox;
	protected double posx;
	protected double posy;
	
	protected abstract void setShape();

	public Entity(double posx, double posy) {
		this.posx = posx;
		this.posy = posy;
	}

	public void move() {

	}

	public double getPosx() {
		return posx;
	}

	public void setPosx(double posx) {
		this.posx = posx;
	}

	public double getPosy() {
		return posy;
	}

	public void setPosy(double posy) {
		this.posy = posy;
	}

	public void removeEntity() {
		//gc = getGraphicsContext2D(); // creates empty gc
	}
	
	public abstract void moveMe();
	

}
