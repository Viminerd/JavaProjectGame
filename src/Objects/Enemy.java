/**
 * 
 */
package Objects;

/**
 *
 */
public abstract class Enemy extends Character {

	/**
	 * @param posx
	 * @param posy
	 * @param health
	 */
	public Player target; 
	public Enemy(double posx, double posy, int health, Player p) {
		super(posx, posy, health);
		target = p; 
		// TODO Auto-generated constructor stub
	}
	
	public abstract void doAction(); 
	public abstract move(); 

}
