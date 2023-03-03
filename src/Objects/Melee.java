/**
 * 
 */
package Objects;

import GamePackage.GameProgram;
import GamePackage.ProjectMain;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;

/**
 * 
 *
 */
public class Melee extends Enemy {

	/**
	 * @param posx
	 * @param posy
	 * @param health
	 * @param p
	 */
	
	private Rectangle healthBar; 
	private Rectangle missingHealthBar; 
	private double healthScale;
	private double maxHealth;
	
	public Melee(double posx, double posy, Player p) {
		super(posx, posy, 200, p);
		hitBox = new Rectangle(posx,posy,25,25);
		hitBox.setFill(Color.MAGENTA);
		hitBox.setRotate(0);
		addEntity();
		
		
		healthBar = new Rectangle(posx, posy, 30 , 5);
		healthBar.setFill(null);
		ProjectMain.mainlayout.getChildren().add(healthBar);

		missingHealthBar = new Rectangle(posx, posy,0,5);
		missingHealthBar.getTransforms().add(new Rotate(180,missingHealthBar.getX(),missingHealthBar.getY()));
		ProjectMain.mainlayout.getChildren().add(missingHealthBar);
		
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub

	}

	@Override
	public void move() {
		boolean hitsAWallX = false;
		boolean hitsAWallY = false;
		double moveSpeed = 2;
		
		
	}

	@Override
	protected void setShape() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveMe() {
		rotateTo(target);
		move();
		
	}
	
	public void damage(double d) {
		System.out.println("M GOT DMGED");
		health -= d; 
		healthScale = health/maxHealth;
		healthBar.setLayoutX(getLayoutX()-2);
		healthBar.setLayoutY(getLayoutY()-15);
		healthBar.setFill(Color.GREEN);		

		
		missingHealthBar.setLayoutX(missingHealthBar.getLayoutX()+10);
		missingHealthBar.setLayoutY(missingHealthBar.getLayoutY()-15);
		missingHealthBar.setWidth(30*(1-healthScale));
		missingHealthBar.setFill(Color.RED);
		if (health <1) {
			this.removeEntity(); 
			ProjectMain.mainlayout.getChildren().remove(healthBar); 
			ProjectMain.mainlayout.getChildren().remove(missingHealthBar); 
		}
			
	}
	

}
