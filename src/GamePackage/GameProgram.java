package GamePackage;

import java.util.ArrayList;

import Objects.Entity;
import Objects.Player;
import Objects.Ranged;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.shape.Shape;
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
		entityList.add(new Ranged(500, 300, player));

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
}
