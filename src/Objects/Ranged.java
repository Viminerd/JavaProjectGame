/**
 * 
 */
package Objects;

import java.util.List;
import java.util.Vector;

import GamePackage.GameProgram;
import GamePackage.ProjectMain;
import javafx.beans.property.ObjectProperty;
import javafx.geometry.Point2D;
import javafx.geometry.Point3D;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;

/**
 * 
 *
 */
public class Ranged extends Enemy {

	/**
	 * @param posx
	 * @param posy
	 * @param health
	 * @param p
	 */
	private int shootDelay = 0; 
	private Rectangle healthBar;
	private Rectangle missingHealth; 
	
	private double centerX; 
	private double centerY; 
	private double dir = 0;
	private int changeDir = 1; 
	public Ranged(double posx, double posy, Player p) {
		
		super(posx, posy, 100,p);
		centerX = posx;
		centerY = posy; 
		Polygon triangle = new Polygon(); 
		triangle.getPoints().setAll(
				posx-20, posy+20,
				posx, posy-20,
				posx+20, posy+20);
		                          
		hitBox = triangle;
		hitBox.setFill(Color.AQUA);
		hitBox.setRotate(0);
		addEntity(); 
		
		healthBar = new Rectangle(posx-15,posy-30,30,5); 
		healthBar.setFill(null);
		
		missingHealth = new Rectangle(posx+15, posy-30,0,5); 
		missingHealth.setFill(Color.RED);

		
		ProjectMain.mainlayout.getChildren().add(healthBar); 
		ProjectMain.mainlayout.getChildren().add(missingHealth); 
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
		rotateTo(target);
		if (shootDelay == 30) {
			shoot(); 
			shootDelay = 0; 
		}
		shootDelay++; 
		 
		if (Math.abs(posx -centerX) <2 && Math.abs(posy -centerY) <2) {
			dir = hitBox.getRotate()-90; 
		}
		double x = Math.cos(dir); 
		double y = -Math.sin(dir); 

		if (Math.abs(posx-centerX)>50 || Math.abs(posy-centerY)>50) {
			changeDir *= -1;

		}
		posx = posx + x*changeDir; 
		posy = posy + y*changeDir; 
		hitBox.setLayoutX(posx-centerX);
		hitBox.setLayoutY(posy-centerY);
		healthBar.setLayoutX(posx-centerX);
		healthBar.setLayoutY(posy-centerY); 
		missingHealth.setLayoutX(getLayoutX()+(posx-centerX)-missingHealth.getWidth());
		missingHealth.setLayoutY(posy-centerY); 		
	}
	
		
	private void rotateTo(Player p) {
		
		Point2D point1 = new Point2D(posx, posy);
		Point2D point2 = new Point2D(p.getPosx()+15, p.getPosy()+15);
		Point2D vector = point2.subtract(point1);
		double angleRad = Math.atan2(vector.getY(), vector.getX());
		double angle = Math.toDegrees(angleRad)+90;
		
		hitBox.setRotate(angle);

	}
	
	private void shoot() {
		new EnemyBullet(posx,posy,hitBox.getRotate()-90, target, 10);
	}
	
	@Override
	public void damage(double d) {
		health -= d; 
		healthBar.setFill(Color.GREEN);
		missingHealth.setWidth(missingHealth.getWidth()+30/d);
//	    missingHealth.setLayoutX(posx-centerX-missingHealth.getWidth());		
		
		if (health <1) {
			this.removeEntity(); 
			ProjectMain.mainlayout.getChildren().remove(healthBar); 
			ProjectMain.mainlayout.getChildren().remove(missingHealth); 
		}
			
	}
	

	


}
