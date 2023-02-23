/**
 * The game is created and initialised
 */

package GamePackage;

import Scene.EasyMap;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ProjectMain extends Application{
	private Canvas gameCanvas = new Canvas(1200,600); 
	private GraphicsContext g = gameCanvas.getGraphicsContext2D();
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Oscar och Viktors Canvas!");
//		primaryStage.setWidth(1200);
//		primaryStage.setHeight(600); 

		BorderPane mainlayout = new BorderPane();

		mainlayout.setCenter(gameCanvas);
		Scene mainScene = new Scene(mainlayout);
		primaryStage.setScene(mainScene);
		primaryStage.show();
		easyMap();
	}
	
	public void easyMap() {
		new EasyMap(g);
	}
	

}
