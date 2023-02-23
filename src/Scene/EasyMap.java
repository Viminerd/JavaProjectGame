/**
 * 
 */
package Scene;

import Objects.Pillar;
import javafx.scene.canvas.GraphicsContext;

/**
 * Map without lavapools and lots of protection against bullets and restrictions for bot movement
 * 
 *
 */
public class EasyMap extends GameScene {

	/**
	 * 
	 */
	public EasyMap(GraphicsContext gc) {
		sizeX = 1200; 
		sizeY = 600; 
		
		double x = 0; 
		double y = 0; 
		double r = 20;
		objectList.add(new Pillar(x, y, r)); 
		// TODO Auto-generated constructor stub
	}

}
