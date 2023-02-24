/**
 * 
 */
package Objects;

/**
 * @author osclo923
 *
 */
public abstract class Bullet extends Entity{
	
	private int damage;
	
	
	public Bullet(double posx, double posy, int damage) {
		super(posx, posy);
		this.damage=damage;
	}
	
	public abstract void onCollision(Entity entity);


	protected abstract void setShape();

}
