package Objects;

import GamePackage.ProjectMain;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Player extends Character{ 
	private double moveSpeed;
	private double newY;
	private double newX;
	private Timeline timeline; 
	public Player(double posx, double posy, int health) {
		super(posx, posy, health);
		System.out.println("CREATED PLAYER");
		gc.setFill(Color.RED);
		gc.setStroke(Color.GREEN);
		gc.setLineWidth(2);
		gc.fillOval(posx, posy, 30, 30);
		gc.strokeOval(posx, posy, 30, 30);
		moveSpeed = 5; 
		
		
//		newX = 0; 
//		newY = 0; 
		
		timeline = new Timeline(new KeyFrame(Duration.millis(16), event -> {
			move(newX,newY); 
			
		}));
		
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
		
		ProjectMain.mainScene.setOnKeyPressed(e -> {
			switch(e.getCode()) {
			case W: 
				newY = -1*moveSpeed;  
				break;
			case S: 
				newY = 1*moveSpeed; 
				break;
			case A:
				newX = -1*moveSpeed; 
				break;
			case D: 
				newX = 1*moveSpeed;
				break;
			default:
				break;
			}
			//move(newX, newY); 		
			
		});	
		
		ProjectMain.mainScene.setOnKeyReleased(e -> {
			switch(e.getCode()) {
			case W:
				newY += 1*moveSpeed;
				break;
			case S: 
				newY -= 1*moveSpeed;
				break; 
			case A:
				newX += 1*moveSpeed;
				break; 
			case D: 
				newX -= 1*moveSpeed;
				break; 
			default:
				break;
			}
			
			
		});	
		
	}

	public void move(double newX, double newY) {
		//Clear old image
		gc.setFill(Color.LIGHTGREEN);
		gc.setStroke(Color.LIGHTGREEN);
		gc.setLineWidth(gc.getLineWidth()+2);
		gc.fillOval(getPosx(), getPosy(), 30, 30);
		gc.strokeOval(getPosx(), getPosy(), 30, 30);
		 
		//Paint new image
		gc.setFill(Color.RED);
		gc.setStroke(Color.GREEN);
		gc.setLineWidth(2);
		gc.fillOval(getPosx()+newX, getPosy()+newY, 30, 30);
		gc.strokeOval(getPosx()+newX, getPosy()+newY, 30, 30);
		posx = getPosx()+newX;
		posy = getPosy()+newY; 
		
	}

	public void shoot() {
		
		
	}

	@Override
	protected void setShape() {
		// TODO Auto-generated method stub
		
	}
	
}
