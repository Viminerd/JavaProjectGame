package Objects;

import java.awt.geom.RectangularShape;

import GamePackage.GameProgram;
import GamePackage.ProjectMain;
import Scene.GameScene;
import Scene.MainMenu;
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
import javafx.scene.transform.Rotate;
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
	private Rectangle healthBar; 
	private Rectangle missingHealthBar; 
	private double healthScale;
	private double maxHealth;

	public Player(double posx, double posy, int health) {
		super(posx, posy, health);
		maxHealth=health;
		moveSpeed = 3;
		hitBox = new Circle(posx, posy, 15);
		hitBox.setLayoutX(posx);
		hitBox.setLayoutY(posy);
		hitBox.setFill(Color.RED);
		hitBox.setStroke(Color.GREEN);
		ProjectMain.mainlayout.getChildren().add(hitBox);
		GameProgram.entityList.add(this);
		
		
		healthBar = new Rectangle(posx -10, posy-17, 70 , 10);
		healthBar.setFill(Color.GREEN);
		ProjectMain.mainlayout.getChildren().add(this.healthBar);
		


		missingHealthBar = new Rectangle(posx, posy-7,0,10);
		missingHealthBar.setFill(Color.RED);
		missingHealthBar.getTransforms().add(new Rotate(180,missingHealthBar.getX(),missingHealthBar.getY()));
		ProjectMain.mainlayout.getChildren().add(missingHealthBar);

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

		// Dessa måste ligga i en move-funktion för att inte kunna användas när spelet
		// är pausat.
		
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
			if (e.isSecondaryButtonDown() && GameProgram.gameRunning) {
				aim(e.getX(), e.getY());
				secondaryMousePressed = true;
			}
			if (e.isPrimaryButtonDown()&& GameProgram.gameRunning) {
				primaryMousePressed = true;
			}
		});
		ProjectMain.mainScene.setOnMousePressed(e -> {
			if (e.isSecondaryButtonDown()&& GameProgram.gameRunning) {
				aim(e.getX(), e.getY());
				secondaryMousePressed = true;
			}
			if (e.isPrimaryButtonDown()&& GameProgram.gameRunning) {
				primaryMousePressed = true;
				shoot(e.getX(), e.getY());
			}
		});
		ProjectMain.mainScene.setOnMouseReleased(e -> {
			if (e.isSecondaryButtonDown() == false && GameProgram.gameRunning) {
				secondaryMousePressed = false;
				ProjectMain.mainlayout.getChildren().remove(aimRay);
			}
			if (e.isPrimaryButtonDown() == false&& GameProgram.gameRunning ) {
				primaryMousePressed = false;
			}
		});
	}

	public void move(double newX, double newY) {
		boolean hitsAWallX = false;
		boolean hitsAWallY = false;
		double moveSpeed = 3;
		isAiming();
		updateHealthBar();
		if (newX != 0 || newY != 0) {
			if (newX != 0 && newY != 0) {
				moveSpeed = Math.sqrt(moveSpeed * 2);
			}
			hitBox.setLayoutX(getPosx() + newX * moveSpeed);
			for (Entity entity : GameProgram.entityList) {
				if (hitBox.getBoundsInParent().intersects(entity.getHitBox().getBoundsInParent())
						&& entity.getHitBox() != hitBox) {
					hitsAWallX = true;
					break;
				}
			}
			hitBox.setLayoutX(posx);

			hitBox.setLayoutY(getPosy() + newY * moveSpeed);
			for (Entity entity : GameProgram.entityList) {
				if (hitBox.getBoundsInParent().intersects(entity.getHitBox().getBoundsInParent())
						&& entity.getHitBox() != hitBox) {
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

		Point2D point1 = new Point2D(getPosx() + 15, getPosy());
		Point2D point2 = new Point2D(x, y);
		Point2D vector = point2.subtract(point1);
		double angleRad = Math.atan2(vector.getY(), vector.getX());
		double angle = Math.toDegrees(angleRad);
		new FriendlyBullet(posx, posy, angle, 10); // ändra rotation här "0", till vinkeln baserad på eventX och eventY.
													// Ex i ranged.

	}

	private void aim(double x, double y) {
		aimx = x;
		aimy = y;
		ProjectMain.mainlayout.getChildren().remove(aimRay);
		aimRay = new Line(getPosx() + 10, getPosy() + 10, x, y);
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
	
	private void updateHealthBar() {
		healthScale = health/maxHealth;
		healthBar.setLayoutX(posx+8-35);
		healthBar.setLayoutY(posy-17);

		healthBar.setFill(Color.GREEN);

		missingHealthBar.setWidth(70*(1-healthScale));
		missingHealthBar.setLayoutX(posx+35);
		missingHealthBar.setLayoutY(posy-17);
		missingHealthBar.setFill(Color.RED);
	}

	@Override
	public void damage(double damage) {
		health -= damage;
		if (health < 1) {
			System.out.println("Player dead");
			missingHealthBar.setWidth(72);
			GameProgram.gameRunning = false;
			MainMenu.gameOver(); 
		}

	}

}
