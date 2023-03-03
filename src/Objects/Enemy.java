/**
 * 
 */
package Objects;

import javafx.geometry.Point2D;

/**
 *
 */
public abstract class Enemy extends Character {

	/**
	 * @param posx
	 * @param posy
	 * @param health
	 */
	protected Player target; 
	public Enemy(double posx, double posy, int health, Player p) {
		super(posx, posy, health);
		target = p; 
		// TODO Auto-generated constructor stub
	}
	
	public abstract void doAction(); 
	public abstract void move(); 
	
	protected void rotateTo(Player p) {
		Point2D point1 = new Point2D(posx, posy);
		Point2D point2 = new Point2D(p.getPosx()+15, p.getPosy()+15);
		Point2D vector = point2.subtract(point1);
		double angleRad = Math.atan2(vector.getY(), vector.getX());
		double angle = Math.toDegrees(angleRad)+90;
		
		hitBox.setRotate(angle);
	};

}
