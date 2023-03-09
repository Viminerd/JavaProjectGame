/**
 * 
 */
package Objects;

/**
 * @author osclo923
 *	Basic powerup class, consist of a nonmoving object on screen with a hitbox.
 */
public abstract class Powerup extends Entity {

	/**
	 * @param posx
	 * @param posy
	 */
	protected Player target; 
	public Powerup(double posx, double posy, Player p) {
		super(posx, posy);
		target=p;
	}


	@Override
	public abstract void moveMe();

}
