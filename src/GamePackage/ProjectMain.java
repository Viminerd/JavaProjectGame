/**
 * The game is created and initialised
 */

package GamePackage;

import Objects.Player;
import Scene.EasyMap;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ProjectMain extends Application {
	public static Canvas gameCanvas = new Canvas(1200, 600);
	private GraphicsContext g = gameCanvas.getGraphicsContext2D();

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Oscar och Viktors Canvas!");

		BorderPane mainlayout = new BorderPane();
		g.setFill(Color.LIGHTGREEN);
		g.fillRect(0, 0, gameCanvas.getWidth(), gameCanvas.getHeight());

		mainlayout.setCenter(gameCanvas);
		Scene mainScene = new Scene(mainlayout);
		primaryStage.setScene(mainScene);
		primaryStage.show();

		runGame("hard"); // test

	}

	public void runGame(String difficulty) {
		GameProgram newGame = new GameProgram(difficulty);
		Player player = new Player(10, 10, 10);

	}

}
