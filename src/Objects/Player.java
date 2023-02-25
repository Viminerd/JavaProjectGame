package Objects;

import GamePackage.ProjectMain;
import Scene.GameScene;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class Player extends Character{ 
	private double moveSpeed;
	private double newY;
	private double newX;
	private Timeline timeline; 
	public Player(double posx, double posy, int health) {
		super(posx, posy, health);
		moveSpeed = 5; 	
		
		paintMe();
		
		timeline = new Timeline(new KeyFrame(Duration.millis(16), event -> {
			move(newX,newY); 
			
		}));
		
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
		
		ProjectMain.mainScene.setOnKeyPressed(e -> {
			switch(e.getCode()) {
			case W: 
				newY = -1;  
				break;
			case S: 
				newY = 1; 
				break;
			case A:
				newX = -1; 
				break;
			case D: 
				newX = 1;
				break;
			default:
				break;
			}		
			
		});	
		
		ProjectMain.mainScene.setOnKeyReleased(e -> {
			switch(e.getCode()) {
			case W:
				if (newY == -1) {
					newY += 1;
				}
				break;
			case S: 
				if (newY == 1) {
					newY -= 1;
				}
				break; 
			case A:
				if(newX == -1) {
					newX += 1;
				}
				break; 
			case D: 
				if (newX == 1) {
					newX -= 1;
				}
				break; 
			default:
				break;
			}
			
			
		});	
		
	}

	public void move(double newX, double newY) {
		if (newX != 0 || newY != 0) {
			//Clear old image
			gc.setFill(Color.LIGHTGREEN);
			gc.setStroke(Color.LIGHTGREEN);
			gc.setLineWidth(gc.getLineWidth()+0.5);
			gc.fillOval(getPosx(), getPosy(), 30, 30);
			gc.strokeOval(getPosx(), getPosy(), 30, 30);
			 
			//Paint new image
			posx = getPosx()+newX*moveSpeed;
			posy = getPosy()+newY*moveSpeed; 
			paintMe(); 

			
		}
		
	}

	public void shoot() {
		
		
	}

	@Override
	protected void setShape() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void paintMe() {
		gc.setFill(Color.RED);
		gc.setStroke(Color.GREEN);
		gc.setLineWidth(2);
		gc.fillOval(getPosx(), getPosy(), 30, 30);
		gc.strokeOval(getPosx(), getPosy(), 30, 30);
		
	}
	
}
