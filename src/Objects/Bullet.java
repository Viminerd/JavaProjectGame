/**
 * 
 */
package Objects;

import GamePackage.GameProgram;
import GamePackage.ProjectMain;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

/**
 * @author osclo923
 *
 */
public abstract class Bullet extends Entity{
	
	protected int damage;
	private double rotation;    //NOTE: rotation is calculated clockwise with start on +X axis
	
	public Bullet(double posx, double posy,double rotation, int damage) {
		super(posx, posy);
		this.rotation = rotation;
		this.damage=damage;
		hitBox = new Ellipse(posx,posy,3,6); 
		hitBox.setFill(Color.BLACK);
		hitBox.setRotate(rotation-90);
		ProjectMain.mainlayout.getChildren().add(hitBox);
		GameProgram.entityList.add(this); 
		setPosx(0);
		setPosy(0); 
	}
	
	public abstract void onCollision();
	
	@Override
	final public void moveMe() {
		double rotRad = rotation*Math.PI/180;
		double xDir = Math.cos(rotRad);
		double yDir = Math.sin(rotRad);
		hitBox.setTranslateX(posx+xDir*10);
		hitBox.setTranslateY(posy+yDir*10);
		
		posx = posx+xDir*10;
		posy = posy+yDir*10; 
		onCollision();
	}


	protected abstract void setShape();

}
