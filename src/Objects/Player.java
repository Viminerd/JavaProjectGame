package Objects;

import java.awt.geom.RectangularShape;

import GamePackage.GameProgram;
import GamePackage.ProjectMain;
import Scene.GameScene;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class Player extends Character {
	private double moveSpeed;
	private double newY;
	private double newX;
	private boolean primaryMousePressed = false;
	private boolean secondaryMousePressed = false;
	private Shape aimRay;
	private double aimx;
	private double aimy;

	public Player(double posx, double posy, int health) {
		super(posx, posy, health);
		moveSpeed = 3;
		hitBox = new Circle(posx, posy, 15);
		hitBox.setLayoutX(posx);
		hitBox.setLayoutY(posy);
		hitBox.setFill(Color.RED);
		hitBox.setStroke(Color.GREEN);
		ProjectMain.mainlayout.getChildren().add(hitBox);
		EntityList.add(hitBox);
		GameProgram.entityList.add(this);

		ProjectMain.mainScene.setOnKeyPressed(e -> {
			switch (e.getCode()) {
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

		
		
		
		//Dessa måste ligga i en move-funktion för att inte kunna användas när spelet är pausat.
		ProjectMain.mainScene.setOnKeyReleased(e -> {
			switch (e.getCode()) {
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
				if (newX == -1) {
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

		ProjectMain.mainScene.setOnMouseDragged(e -> {

			if (e.isSecondaryButtonDown()) {
				aim(e.getX(), e.getY());
				secondaryMousePressed = true;
			}
			if (e.isPrimaryButtonDown()) {
				primaryMousePressed = true;
			}
	
		});
		
		ProjectMain.mainScene.setOnMousePressed(e -> {

			if (e.isSecondaryButtonDown()) {
				aim(e.getX(), e.getY());
				secondaryMousePressed = true;
			}
				
			if (e.isPrimaryButtonDown()) {
				primaryMousePressed = true;
				shoot(e.getX(),e.getY());
			}
		});

		ProjectMain.mainScene.setOnMouseReleased(e -> {

			if (e.isSecondaryButtonDown() == false) {
				secondaryMousePressed = false;
				ProjectMain.mainlayout.getChildren().remove(aimRay);
			}
			if (e.isPrimaryButtonDown() == false) {
				primaryMousePressed = false;
			}
		});

	}

	public void move(double newX, double newY) {
		boolean hitsAWallX = false;
		boolean hitsAWallY = false;
		double moveSpeed = 3;
		isAiming();
		if (newX != 0 || newY != 0) {
			if (newX != 0 && newY != 0) {
				moveSpeed = Math.sqrt(moveSpeed * 2);
			}
			hitBox.setLayoutX(getPosx() + newX * moveSpeed);
			for (Shape s : EntityList) {
				if (hitBox.getBoundsInParent().intersects(s.getBoundsInParent()) && s != hitBox) {
					hitsAWallX = true;
					break;
				}
			}
			hitBox.setLayoutX(posx);

			hitBox.setLayoutY(getPosy() + newY * moveSpeed);
			for (Shape s : EntityList) {
				if (hitBox.getBoundsInParent().intersects(s.getBoundsInParent()) && s != hitBox) {
					hitsAWallY = true;
					break;
				}
			}
			hitBox.setLayoutY(posy);

			if (hitsAWallX == false) {
				posx = getPosx() + newX * moveSpeed;
			}
			if (hitsAWallY == false) {
				posy = getPosy() + newY * moveSpeed;
			}
		}
	}

	private void shoot(double x, double y) {
		System.out.println("Pew Pew");
		
		Point2D point1 = new Point2D(getPosx()+15, getPosy());
		Point2D point2 = new Point2D(x,y);
		Point2D vector = point2.subtract(point1);
		double angleRad = Math.atan2(vector.getY(), vector.getX());
		double angle = Math.toDegrees(angleRad);
		new FriendlyBullet(posx,posy,angle,10);   //ändra rotation här "0", till vinkeln baserad på eventX och eventY. Ex i ranged.

	}

	private void aim(double x, double y) {
		aimx = x;
		aimy = y;
		ProjectMain.mainlayout.getChildren().remove(aimRay);
		aimRay = new Line(getPosx()+10, getPosy()+10, x, y);
		aimRay.setStroke(Color.RED);
		ProjectMain.mainlayout.getChildren().add(aimRay);
	}

	private void isAiming() {
		if (secondaryMousePressed) {
			aim(aimx, aimy);
		}
	}

	@Override
	protected void setShape() {
	}

	@Override
	public void moveMe() {
		move(newX, newY);
	}

	public void damage(int damage) {
		health -=damage;
		if (health <1) {
			System.out.println("Player dead");
			GameProgram.gameRunning = false; 
		}
		
	}

}
