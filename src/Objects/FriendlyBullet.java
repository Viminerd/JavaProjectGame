/**
 * 
 */
package Objects;

import GamePackage.GameProgram;

/**
 * @author osclo923
 *
 */
public class FriendlyBullet extends Bullet{

	public FriendlyBullet(double posx, double posy, double rotation, int damage) {
		super(posx, posy, rotation, damage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCollision() {
		for (Entity entity : GameProgram.entityList) {
			if (entity instanceof Pillar && hitBox.getBoundsInParent().intersects(entity.getHitBox().getBoundsInParent())) {
				removeEntity(); 
				System.out.println("HIT PILLAR");
				break;
			}
			else if (entity instanceof Enemy) {
				if (hitBox.getBoundsInParent().intersects(entity.getHitBox().getBoundsInParent())) {
					entity.damage(damage); 
					removeEntity();
					break;
				}
			}
		}
		
	}

	@Override
	protected void setShape() {
		// TODO Auto-generated method stub
		
	}


}
