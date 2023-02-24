/**
 * 
 */
package Scene;

import Objects.LavaPool;
import Objects.Pillar;

/**
 *
 */
public class HardMap extends GameScene{

	/**
	 * 
	 */
	public HardMap() {
		sizeX = 1200; 
		sizeY = 600; 
		double x = 200; 
		double y = 100; 
		double r = 40;
		for (int i = 0; i<3;i++) {
			objectList.add(new Pillar(x+400*i, y, r)); 
			objectList.add(new Pillar(x+400*i, y+300, r)); 
		}

		objectList.add(new LavaPool(x+400,170,r*2)); 

	}
	

}
