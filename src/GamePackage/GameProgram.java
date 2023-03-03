package GamePackage;

import java.util.ArrayList;

import Objects.Entity;
import Objects.Melee;
import Objects.Player;
import Objects.Ranged;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class GameProgram {
	private String difficulty;
	private Timeline timeline;
	public static ArrayList<Entity> entityList = new ArrayList<>();
	public static ArrayList<Entity> tempList = new ArrayList<>(); 
	private Player player; 
	public static boolean gameRunning = true; 

	public GameProgram(String difficulty) {
		
		tempList.addAll(entityList); 
		this.difficulty = difficulty;
		Map();
		
//		Button pause = new Button("II"); 
		Rectangle pause = new Rectangle(0,0,20,20);
		pause.setFill(Color.GREY);
		pause.setStroke(Color.BLACK);
		pause.setStrokeWidth(3);
		
		Text p = new Text("II");
		p.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		p.setFill(Color.BLACK);
		p.setX(pause.getX()+2);
		p.setY(pause.getY()+15);
		ProjectMain.mainlayout.getChildren().add(pause); 
		ProjectMain.mainlayout.getChildren().add(p); 
		p.setOnMouseClicked(event->{
			gameRunning = false;
			pauseMenu(); 
		});
		pause.setOnMouseClicked(event->{
			gameRunning = false; 
			pauseMenu(); 

		});
		
		timeline = new Timeline(new KeyFrame(Duration.millis(16), event -> {
			if (gameRunning) {
				ProjectMain.CanvasPaintMe();
				tempList.clear(); 
				tempList.addAll(entityList); 
				for (Entity entity : tempList) {					
					entity.moveMe();
				}
			}
			else {
				timeline.stop();
			}

			
		}));
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
		new Ranged(500, 300, player);
		new Melee(600, 200, player);

	}

	public void Map() {
		if (difficulty.equals("easy")) {
			easyMap();
		} else if (difficulty.equals("hard")) {
			hardMap();
		}
		player = new Player(10, 10, 100);
	}

	public void easyMap() {
		Scene.EasyMap map = new Scene.EasyMap();
	}

	public void hardMap() {
		Scene.HardMap map = new Scene.HardMap();
	}
	
	private void pauseMenu() {
		Rectangle r = new Rectangle(500,100,120,30);
		ProjectMain.mainlayout.getChildren().add(r);
		r.setOnMouseClicked(event->{
			gameRunning = true; 
			timeline.play(); 
			ProjectMain.mainlayout.getChildren().remove(r); 
			
		});

		System.out.println("Game Paused");
	}
}
