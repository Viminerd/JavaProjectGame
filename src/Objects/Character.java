
package Objects;

/**
 * @author osclo923
 * set position and health for characters
 */
public abstract class Character extends Entity {
	protected int health;

	public Character(double posx, double posy, int health) {
		super(posx, posy);
		this.setHealth(health);
		
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}


	protected abstract void setShape();



}
