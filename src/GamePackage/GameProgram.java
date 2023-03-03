package GamePackage;

import java.util.ArrayList;
import java.util.Random;

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
	private Timeline timeline = null;
	public static ArrayList<Entity> entityList = new ArrayList<>();
	public static ArrayList<Entity> tempList = new ArrayList<>(); 
	private Player player; 
	public static boolean gameRunning = true; 
	private static int score = 0; 
	private int secondCounter = 0; 
	private int botSpawnCounter = 0; 
	
	Text currentScore = new Text(score+"");

	public GameProgram(String difficulty) {
		botSpawnCounter = 5; 
		score = 0; 
		ProjectMain.mainlayout.getChildren().add(ProjectMain.gameCanvas); 
		tempList.addAll(entityList); 
		this.difficulty = difficulty;
		Map();
		 
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
		pause.setOnMouseClicked(p.getOnMouseClicked());
		
		timeline = new Timeline(new KeyFrame(Duration.millis(16), event -> {
			if (gameRunning) {
				ProjectMain.CanvasPaintMe();
				tempList.clear(); 
				tempList.addAll(entityList); 
				for (Entity entity : tempList) {	
					entity.moveMe();
				}
				if (secondCounter >1000 ) {
					score++; 
					secondCounter = 0; 
					botSpawnCounter += 1; 
				}
					
				secondCounter += 16; 
			}
			else {
				timeline.stop();
			}
			currentScore.setText(score+"");
			spawnRanged();

			
		}));
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
//		new Ranged(500, 300, player);
//		new Melee(600, 200, player);
		
		
		//SCORE
		Rectangle scoreHolder = new Rectangle(40,0,50,20);
		scoreHolder.setFill(Color.GREY);
		scoreHolder.setStroke(Color.BLACK);
		scoreHolder.setStrokeWidth(3);
	
		currentScore.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		currentScore.setFill(Color.BLACK);
		currentScore.setX(scoreHolder.getX()+2);
		currentScore.setY(scoreHolder.getY()+15);
		ProjectMain.mainlayout.getChildren().add(scoreHolder); 
		ProjectMain.mainlayout.getChildren().add(currentScore); 

	}

	private void spawnMelee() {
		Random random = new Random(); 
		int sizeX = random.nextInt((int)ProjectMain.mainlayout.getWidth()); 
		int sizeY = random.nextInt((int)ProjectMain.mainlayout.getHeight()); 
		new Melee(sizeX, sizeY, player); 
		botSpawnCounter = 0; 
		
	}

	private void spawnRanged() {
		if(botSpawnCounter >9) {
			Random random = new Random(); 
			int sizeX = random.nextInt((int)ProjectMain.mainlayout.getWidth()); 
			int sizeY = random.nextInt((int)ProjectMain.mainlayout.getHeight()); 
			new Ranged(sizeX, sizeY, player); 
			botSpawnCounter = 0; 
			spawnMelee(); 
		}
		
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
		r.setFill(Color.GREY);
		r.setStroke(Color.BLACK);
		
		Text p = new Text("Resume");
		p.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		p.setFill(Color.BLACK);
		p.setX(r.getX()+2);
		p.setY(r.getY()+15);
		ProjectMain.mainlayout.getChildren().add(r);
		ProjectMain.mainlayout.getChildren().add(p); 
		
		
		Rectangle restart = new Rectangle(500,200,120,30);
		restart.setFill(Color.GREY);
		restart.setStroke(Color.BLACK);
		Text restartText = new Text("Restart");
		restartText.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		restartText.setFill(Color.BLACK);
		restartText.setX(restart.getX()+2);
		restartText.setY(restart.getY()+15);
		ProjectMain.mainlayout.getChildren().add(restart);
		ProjectMain.mainlayout.getChildren().add(restartText); 
		
		r.setOnMouseClicked(event->{
			gameRunning = true; 
			timeline.play(); 
			ProjectMain.mainlayout.getChildren().remove(r); 
			ProjectMain.mainlayout.getChildren().remove(restart); 
			ProjectMain.mainlayout.getChildren().remove(p); 
			ProjectMain.mainlayout.getChildren().remove(restartText); 
			
		});
		p.setOnMouseClicked(r.getOnMouseClicked());
		

		restart.setOnMouseClicked(event->{		
			entityList.clear(); 
			ProjectMain.mainlayout.getChildren().clear(); 
			timeline = null;
    		GameProgram gameProgram = new GameProgram(difficulty); 
			
			
			ProjectMain.mainlayout.getChildren().remove(r); 
			ProjectMain.mainlayout.getChildren().remove(restart);
			ProjectMain.mainlayout.getChildren().remove(p); 
			ProjectMain.mainlayout.getChildren().remove(restartText); 			
			
			gameProgram.timeline.play(); 
			gameRunning = true; 
			
		});
		restartText.setOnMouseClicked(restart.getOnMouseClicked());
		

		System.out.println("Game Paused");
	}
	
	public static void addScore(int a) {
		score += a; 
	}
	
	public static int getScore() {
		return score; 
	}
}
