package Objects;

import GamePackage.GameProgram;
import GamePackage.ProjectMain;
import Scene.GameScene;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
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
		moveSpeed = 3; 	
		hitBox = new Circle(posx,posy,15);
		hitBox.setLayoutX(posx);
		hitBox.setLayoutY(posy);
		hitBox.setFill(Color.RED);
		hitBox.setStroke(Color.GREEN);
		ProjectMain.mainlayout.getChildren().add(hitBox);
		EntityList.add(hitBox);
		GameProgram.entityList.add(this);
		
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
		boolean hitsAWallX = false; 
		boolean hitsAWallY = false; 
		double moveSpeed = 3;
		if (newX != 0 || newY != 0) {
			if(newX != 0 && newY !=0) { 
				moveSpeed= Math.sqrt(moveSpeed*2);
			}
			hitBox.setLayoutX(getPosx()+newX*moveSpeed);
			for (Shape s : EntityList) {
				if (hitBox.getBoundsInParent().intersects(s.getBoundsInParent()) && s !=hitBox) {
					hitsAWallX = true; 
					break;
				}
			}
			hitBox.setLayoutX(posx);
			
			hitBox.setLayoutY(getPosy()+newY*moveSpeed);
			for (Shape s : EntityList) {
				if (hitBox.getBoundsInParent().intersects(s.getBoundsInParent()) && s !=hitBox) {
					hitsAWallY = true; 
					break;
				}
			}
			hitBox.setLayoutY(posy);
			 
			if(hitsAWallX == false) {				 
				posx = getPosx()+newX*moveSpeed;
			}
			if (hitsAWallY == false) {
				posy = getPosy()+newY*moveSpeed; 	
			}			
		}		
	}

	public void shoot() {
		
		
	}

	@Override
	protected void setShape() {		
	}
	
	@Override
	public void moveMe() {
		move(newX,newY);

	}
	
}
