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
		double x = 100; 
		double y = 50; 
		double r = 20;
		for (int i = 0; i<3;i++) {
			objectList.add(new Pillar(x+200*i, y, r)); 
			objectList.add(new Pillar(x+200*i, y+200, r)); 
		}

		objectList.add(new LavaPool(x+200,150,r*2)); 

	}
	

}
