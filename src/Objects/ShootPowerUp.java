/**
 * Sublclass to Powerup that implements the shoot powerup. input posx posy Player
 */
package Objects;

/**
 * @author osclo923
 *
 */
public class ShootPowerUp extends Powerup {

	/**
	 * @param posx
	 * @param posy
	 */
	public ShootPowerUp(double posx, double posy, Player p) {
		super(posx, posy, p);

		addEntity();
	}

	@Override
	public void moveMe() {
		// TODO Auto-generated method stub
		
	}

}
