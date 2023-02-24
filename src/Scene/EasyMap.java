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
		
		double x = 200; 
		double y = 30; 
		double r = 20;
		//new Pillar(x,y,r,gc); 
		//objectList.add(new Pillar(x, y, r, gc)); 
		gc.fillOval(10,10,30,50);
	}

}
