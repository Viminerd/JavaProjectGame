package Objects;

import javafx.scene.paint.Color;

public class Player extends Character {
	private double newx; 
	private double newy; 
	public Player(double posx, double posy, int health) {
		super(posx, posy, health);
		System.out.println("CREATED PLAYER");
		gc.setFill(Color.RED);
		gc.setStroke(Color.GREEN);
		gc.setLineWidth(2);
		gc.fillOval(posx, posy, 30, 30);
		gc.strokeOval(posx, posy, 30, 30);
		
		setOnMouseClicked(event -> {
			System.out.println("MOUSE CLIKC");

		});
		setOnKeyPressed(e -> {
			System.out.println("CLICK BUTTON");
			switch(e.getCode()) {
			case W: 
				newy = posy + 10; 
				break;
			case S: 
				newy = posy-10; 
				break;
			case A: 
				newx = posx-10; 
				break;
			case D: 
				newx = posx+10; 
				break;
			}
			//move(newx, newy); 
			gc.setFill(Color.LIGHTGREEN);
			gc.clearRect(posx, posy, 30, 30);
			
			//Paint new image
			gc.setFill(Color.RED);
			gc.setStroke(Color.GREEN);
			gc.setLineWidth(2);
			gc.fillOval(newx, newy, 30, 30);
			
			
		});
        setFocusTraversable(true);
        requestFocus();
		
		
		
		
		
	}
	public void move(double newY, double newX) {
		//Clear old image
		gc.setFill(Color.LIGHTGREEN);
		gc.clearRect(posx, posy, 30, 30);
		
		//Paint new image
		gc.setFill(Color.RED);
		gc.setStroke(Color.GREEN);
		gc.setLineWidth(2);
		gc.fillOval(newX, newX, 30, 30);
		
	}

	public void shoot() {
		
		
	}

	@Override
	protected void setShape() {
		// TODO Auto-generated method stub
		
	}
	
}
