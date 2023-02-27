package Objects;

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
		hitBox = new Circle(posx+15,posy+15,15);
		hitBox.setFill(null);
		hitBox.setStroke(Color.GREEN);
		ProjectMain.mainlayout.getChildren().add(hitBox);
		EntityList.add(hitBox);
		EntityList.add(this);
		
		
		
		
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
		boolean hitsAWall = false; 
		double moveSpeed = 3;
		if (newX != 0 || newY != 0) {
			if(newX != 0 && newY !=0) { 
				moveSpeed= Math.sqrt(moveSpeed*2);
			}
			hitBox.setLayoutX(getPosx()+newX*moveSpeed-10);
			hitBox.setLayoutY(getPosy()+newY*moveSpeed-10);
			for (Shape s : EntityList) {
				if (hitBox.getBoundsInParent().intersects(s.getBoundsInParent()) && s !=hitBox) {
					hitsAWall = true; 
					break;
				}
			}
			hitBox.setLayoutX(getPosx()-newX*moveSpeed-10);
			hitBox.setLayoutY(getPosy()-newY*moveSpeed-10);
			 
			//Clear old image
			if(hitsAWall == false) {
				gc.setFill(Color.LIGHTGREEN);
				gc.setStroke(Color.LIGHTGREEN);
				gc.setLineWidth(gc.getLineWidth()+0.5);
				gc.fillOval(getPosx(), getPosy(), 30, 30);
				gc.strokeOval(getPosx(), getPosy(), 30, 30);
				 
				//Paint new image
				posx = getPosx()+newX*moveSpeed;
				posy = getPosy()+newY*moveSpeed; 
				paintMe(); 
				hitBox.setLayoutX(getPosx()-10);
				hitBox.setLayoutY(getPosy()-10);
			}

			
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
