/**
 * 
 */
package Scene;

import Objects.Pillar;
import javafx.scene.canvas.Canvas;
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
	public EasyMap(Canvas canvas) {
		sizeX = 1200; 
		sizeY = 600; 
		
		double x = 200; 
		double y = 100; 
		double r = 40;
		for (int i = 0; i<3;i++) {
			objectList.add(new Pillar(x+400*i, y, r)); 
			objectList.add(new Pillar(x+400*i, y+300, r)); 
		}
		
	
	}

}
