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
import javafx.scene.shape.Polygon;
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
	public Ranged(double posx, double posy, Player p) {
		
		super(posx, posy, 100,p);
		
		Polygon triangle = new Polygon(); 
		triangle.getPoints().setAll(
				posx-20, posy+20,
				posx, posy-20,
				posx+20, posy+20);
		                          
		hitBox = triangle;
		hitBox.setFill(Color.AQUA);
		hitBox.setRotate(0);
		ProjectMain.mainlayout.getChildren().add(hitBox);
		EntityList.add(hitBox);
		
		
		
		// TODO Auto-generated constructor stub
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
		System.out.println("BANG");
	}
	

	


}
