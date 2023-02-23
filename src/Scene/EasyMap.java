/**
 * 
 */
package Scene;

/**
 * Map without lavapools and lots of protection against bullets and restrictions for bot movement
 * @author Viktor
 *
 */
public class EasyMap extends GameScene {

	/**
	 * 
	 */
	public EasyMap() {
		sizeX = 1200; 
		sizeY = 600; 
		
		double x = 0; 
		double y = 0; 
		double r = 20;
		objectList.Add(new Pillar(x, y, r)); 
		// TODO Auto-generated constructor stub
	}

}
