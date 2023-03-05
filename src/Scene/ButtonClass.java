/**
 * 
 */
package Scene;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

/**
 * Button with a custom class 
 *
 */
public class ButtonClass extends Button {

	/**
	 * 
	 */
	public ButtonClass(String text, double x, double y, GraphicsContext gc) {
		gc.setFill(Color.ORANGE);
		gc.fillRect(x, y, 100, 20);
		gc.setFill(Color.BLACK);
		gc.fillText(text, x+20, y+13);
		
		
		// TODO Auto-generated constructor stub
	}


}
