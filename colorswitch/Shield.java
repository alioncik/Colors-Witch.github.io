package colorswitch;

/**
 * Colors Witch
 * @auteure: Cupcea Aliona 
 * @date: 2018/04/27
 * @NomDuFichier: Shield.java
 *
 *                Item : Bouclier.
 *
 *                Rend la sorciere invincible pendant 3 secondes
 */
public class Shield extends Item {

	private boolean used = false;

	public Shield(double x, double y) {
		super(x, y);

		this.renderer = new ImageRenderer("shield", this);
	}

	@Override
	public void tick(double dt) {
		// Rien a faire
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
		used = true;
		player.setShield(true);
	}

	@Override
	public boolean intersects(Player player) {
		return !used && player.getX() - player.getRadius() < this.getX() + this.getWidth() / 2
				&& player.getX() + player.getRadius() > this.getX() - this.getWidth() / 2
				&& player.getY() - player.getRadius() < this.getY() + this.getHeight() / 2
				&& player.getY() + player.getRadius() > this.getY() - this.getHeight() / 2;
	}
}
