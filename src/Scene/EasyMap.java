/**
 * 
 */
package Scene;

import GamePackage.ProjectMain;
import Objects.LavaPool;
import Objects.Pillar;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

/**
 * Map without lavapools and lots of protection against bullets and restrictions for bot movement
 * 
 *
 */
public class EasyMap extends GameScene {

	public EasyMap() {
		sizeX = ProjectMain.mainlayout.getWidth();
		sizeY = ProjectMain.mainlayout.getHeight(); 
		
		double x = 100; 
		double y = 70; 
		double r = 30;
		for (int i = 0; i<3;i++) {
			objectList.add(new Pillar(x+200*i, y, r)); 
			objectList.add(new Pillar(x+200*i, y+130, r)); 
		}
		for (int i = 0; i<4; i++) {
			objectList.add(new Pillar(x+200, y+32*i, r));			
		}
		
		
	
	}

}
