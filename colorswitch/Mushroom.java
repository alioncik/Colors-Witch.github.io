package colorswitch;

/**
 *  Colors Witch
 * @auteure: Cupcea Aliona - 20057887
 * @date: 2018/04/27
 * @NomDuFichier: Mushroom.java
 *
 *                Item : champignon.
 * 
 *                Ramasser un champignon permet de gagner le niveau actuel
 */
public class Mushroom extends Item {

	private double timeSinceFrameChange = 0;

	public Mushroom(double x, double y) {
		super(x, y);

		this.renderer = new AnimationRenderer("mushroom", 26, 16 * 1e-9, this);
		super.frame = 0;
	}

	@Override
	public void tick(double dt) {
		timeSinceFrameChange += dt;

		if (timeSinceFrameChange > renderer.getFrameRate()) {
			super.frame = (int) ((super.frame + 1) % renderer.getNumber());
		}
	}

	@Override
	public double getWidth() {
		return 64;
	}

	@Override
	public double getHeight() {
		return 64;
	}

	@Override
	public void handleCollision(Player player, Game game) {
		game.win();
	}

	@Override
	public boolean intersects(Player player) {
		return player.getX() - player.getRadius() < this.getX() + this.getWidth() / 2
				&& player.getX() + player.getRadius() > this.getX() - this.getWidth() / 2
				&& player.getY() - player.getRadius() < this.getY() + this.getHeight() / 2
				&& player.getY() + player.getRadius() > this.getY() - this.getHeight() / 2;
	}
}
