package GamePackage;

import java.util.ArrayList;

import Objects.Entity;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class GameProgram {
	private String difficulty;
	private Timeline timeline;
	public static ArrayList<Entity> entityList = new ArrayList<>();

	public GameProgram(String difficulty) {
		this.difficulty = difficulty;
		// Scene.EasyMap map = new Scene.EasyMap();
		Map();
		timeline = new Timeline(new KeyFrame(Duration.millis(16), event -> {
			ProjectMain.CanvasPaintMe();
			for (Entity entity : entityList) {
				entity.moveMe();
			}

		}));
		//timeline.setCycleCount(Timeline.INDEFINITE);
		//timeline.play();

	}

	public void Map() {

		if (difficulty.equals("easy")) {
			easyMap();
		} else if (difficulty.equals("hard")) {
			hardMap();
		}

	}

	public void easyMap() {
		Scene.EasyMap map = new Scene.EasyMap();
	}

	public void hardMap() {
		Scene.HardMap map = new Scene.HardMap();
	}
}
