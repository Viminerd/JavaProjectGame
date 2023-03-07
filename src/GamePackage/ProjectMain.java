/**
 * The game is created and initialised
 */

package GamePackage;

import Objects.Player;
import Scene.EasyMap;
import Scene.MainMenu;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ProjectMain extends Application {
	public static Canvas gameCanvas = new Canvas(1200, 600);
	public static Scene mainScene; 
	public static BorderPane mainlayout; 
	private GraphicsContext gc = gameCanvas.getGraphicsContext2D();

	public static void main(String[] args) {
		launch(args);
	}
	/*
	 * TODO LIST 
	 * Player kan gå in i lava
	 * Enemies kan inte spawna på eller i närheten av spelare
	 * Enemies kan inte gå in i spelare, det får spelaren att sitta fast. 
	 * enemies kan inte gå in i pelare eller hinder 
	 * Läs in highscore från filen och spara om filen med nya värden. /// LÄS IN KLAR, structurera upp sparandet av filen rätt. 
	 * Enter name vid game over
	 * Gör spelet skalbart, kanske göra om alla positioner för menu och hinder osv som ett bråktal av ProjectMain.mainlayout.getWidth()
	 * Powerups... 
	 * ev massa visuellt fix, menyn och spelet kan ju bli lite roligare
	 * Fixa melee fiende DONE
	 * Implemetera powerups
	 * Spawna powerups
	 * Skala om så EasyMap har rätt skala
	 */

	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Projekt TDDE10");

		mainlayout = new BorderPane();

		new MainMenu();

		mainScene = new Scene(mainlayout);
		primaryStage.setScene(mainScene);
		primaryStage.show();
		primaryStage.setMinHeight(600);
		primaryStage.setMinWidth(1200);
		primaryStage.setMaxHeight(600);
		primaryStage.setMaxWidth(1200);

	}
	public static void CanvasPaintMe() {
		
		gameCanvas.getGraphicsContext2D().setFill(Color.LIGHTGREEN);
		gameCanvas.getGraphicsContext2D().fillRect(0, 0, gameCanvas.getWidth(), gameCanvas.getHeight());		
		
	}

	public void runGame(String difficulty) {
		GameProgram newGame = new GameProgram(difficulty);

	}

}
