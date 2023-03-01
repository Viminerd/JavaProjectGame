/**
 * 
 */
package Objects;

import GamePackage.GameProgram;
import GamePackage.ProjectMain;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

/**
 * @author osclo923
 *
 */
public class EnemyBullet extends Bullet{

	double rotation; 
	public EnemyBullet(double posx, double posy,double rotation, int damage) {
		super(posx, posy, damage);
		this.rotation = rotation; 
		hitBox = new Ellipse(posx,posy,3,6); 
		hitBox.setFill(Color.BLACK);
		hitBox.setRotate(rotation-90);
		ProjectMain.mainlayout.getChildren().add(hitBox);
		EntityList.add(hitBox);
		GameProgram.entityList.add(this); 
		setPosx(0);
		setPosy(0); 
	}

	@Override
	public void onCollision(Entity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setShape() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveMe() {
		double rotRad = rotation*Math.PI/180;
		double xDir = Math.cos(rotRad);
		double yDir = Math.sin(rotRad);
		System.out.println(xDir);
		hitBox.setTranslateX(posx+xDir*10);
		hitBox.setTranslateY(posy+yDir*10);
		
		posx = posx+xDir*10;
		posy = posy+yDir*10; 


		
	}



}
