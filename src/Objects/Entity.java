/**
 * Entity graphics and movement defined. 
 */

package Objects;

import java.util.ArrayList;

import GamePackage.GameProgram;
import GamePackage.ProjectMain;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Shape;

/**
 * @author osclo923
 *
 */
public abstract class Entity extends Canvas {
	
	protected Canvas objectCanvas = new Canvas(1000,1000); 
	protected GraphicsContext gc = ProjectMain.gameCanvas.getGraphicsContext2D();
	
	protected Shape hitBox;
	protected double posx;
	protected double posy;
	

	public Entity(double posx, double posy) {
		this.posx = posx;
		this.posy = posy;
	}

	public Shape getHitBox() {
		return hitBox;
	}

	public void move() {

	}

	public double getPosx() {
		return posx;
	}

	public void setPosx(double posx) {
		this.posx = posx;
	}
	
	public void removeEntity() {
		ProjectMain.mainlayout.getChildren().remove(this.hitBox); 
		GameProgram.entityList.remove(this);
	}
	
	public void addEntity() {
		ProjectMain.mainlayout.getChildren().add(this.hitBox);
		GameProgram.entityList.add(this); 
	}

	public double getPosy() {
		return posy;
	}

	public void setPosy(double posy) {
		this.posy = posy;
	}


	public abstract void moveMe();
	
	public void damage(double d) {
		//not abstract because i did not want to need to implement it for all classes
	}
	

}
