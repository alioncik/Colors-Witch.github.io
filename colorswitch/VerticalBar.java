package colorswitch;

/**
 * Colors Witch
 * @auteure: Cupcea Aliona 
 * @date: 2018/04/27
 * @NomDuFichier: VerticalBar.java
 *
 *                Obstacle : une barre verticale dont la couleur ne change pas
 *                et qui se deplace de gauche a droite en rebondissant sur les
 *                murs du niveau.
 */
public class VerticalBar extends Obstacle {

	private double width;
	private double height;
	private double vx = 200;
	private double screenWidth;

	public VerticalBar(double x, double y, double longueur, double hauteur, double largeurEcran) {
		super(x, y);

		this.width = longueur;
		this.height = hauteur;

		this.renderer = new VerticalBarRenderer(this);

		this.screenWidth = largeurEcran;

		this.color = (int) (Math.random() * 4);
	}

	@Override
	public double getWidth() {
		return width;
	}

	@Override
	public double getHeight() {
		return height;
	}

	/**
	 * Fonction appelee a chaque frame pour mettre a jour les attributs de l'entite
	 *
	 * @param dt
	 *            Delta-Temps en secondes
	 */
	@Override
	public void tick(double dt) {
		// Mise a jour de la position
		double newX = x + dt * vx;

		// Collision avec les murs
		if (newX + width / 2 > screenWidth || newX - width / 2 < 0) {
			vx *= -1;
		} else {
			x = newX;
		}
	}

	public int getColor() {
		return color;
	}

	@Override
	public boolean intersects(Player player) {
		if (player.getShield() == true) {
			return false;
		} else {
			return this.color != player.getColor()
					&& player.getX() - player.getRadius() < this.getX() + this.getWidth() / 2
					&& player.getX() + player.getRadius() > this.getX() - this.getWidth() / 2
					&& player.getY() - player.getRadius() < this.getY() + this.getHeight() / 2
					&& player.getY() + player.getRadius() > this.getY() - this.getHeight() / 2;
		}
	}
}
