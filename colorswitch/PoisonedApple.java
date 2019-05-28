package colorswitch;

/**
* Colors Witch
 * @auteure: Cupcea Aliona 
 * @date: 2018/04/27
 * @NomDuFichier: PoisonedApple.java
 *
 *                Item : Pomme empoisonnee
 *
 *                Rend la sorciere plus grosse et fait en sorte qu'elle saute
 *                moins haut pendant 6 secondes
 */
public class PoisonedApple extends Item {

	private boolean used = false;

	public PoisonedApple(double x, double y) {
		super(x, y);

		this.renderer = new ImageRenderer("poisoned-apple", this);
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
		player.setApple(true);
	}

	@Override
	public boolean intersects(Player player) {
		return !used && player.getX() - player.getRadius() < this.getX() + this.getWidth() / 2
				&& player.getX() + player.getRadius() > this.getX() - this.getWidth() / 2
				&& player.getY() - player.getRadius() < this.getY() + this.getHeight() / 2
				&& player.getY() + player.getRadius() > this.getY() - this.getHeight() / 2;
	}
}
