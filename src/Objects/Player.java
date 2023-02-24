package Objects;

import javafx.scene.paint.Color;

public class Player extends Character {
	public Player(double posx, double posy, int health) {
		super(posx, posy, health);
		gc.setFill(Color.RED);
		gc.setStroke(Color.GREEN);
		gc.setLineWidth(2);
		gc.fillOval(posx, posy, 30, 30);
		gc.strokeOval(posx, posy, 30, 30);
		
		
		
		
	}

	public void shoot() {
		
		
	}

	@Override
	protected void setShape() {
		// TODO Auto-generated method stub
		
	}
	
}
