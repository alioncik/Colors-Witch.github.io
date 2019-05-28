/**
 *  Colors Witch
 * @auteure: Cupcea Aliona 
 * @date: 2018/04/27
 * @NomDuFichier: BouncingSquares.java
 */
package colorswitch;

/**
 * Obstacle : deux carres qui se deplacent du centre vers les cotes de l'ecran
 * et dont la couleur change lorsqu'ils rebondissent sur les murs du niveau.
 */
public class BouncingSquares extends Obstacle {

	private double width;
	private double xLeft;
	private double xRight;
	private double vxLeft = -250;
	private double vxRight = 250;
	private double screenWidth;

	public BouncingSquares(double x, double y, double longueur, double largeurEcran) {
		super(x, y);
		this.xLeft = x - (longueur / 2);
		this.xRight = x + (longueur / 2);

		this.width = longueur;

		this.renderer = new BouncingSquaresRenderer(this);

		this.screenWidth = largeurEcran;

		this.color = (int) (Math.random() * 4);
	}

	@Override
	public double getWidth() {
		return width;
	}

	@Override
	public double getHeight() {
		return width;
	}

	public double getXLeft() {
		return this.xLeft;
	}

	public double getXRight() {
		return this.xRight;
	}

	/**
	 * Fonction appelee a chaque frame pour mettre a jour les attributs de l'entite
	 * 
	 * @param dt
	 *            Delta-Temps en secondes
	 */
	@Override
	public void tick(double dt) {
		// Mise a jour des positions
		double newXLeft = xLeft + dt * vxLeft;
		double newXRight = xRight + dt * vxRight;

		// Collisions avec les murs et au centre
		if (newXLeft - width / 2 < 0) {
			vxLeft *= -1;
			color = (color + 1) % 4;
		} else if (newXLeft + width / 2 > x) {
			vxLeft *= -1;
		} else {
			xLeft = newXLeft;
		}

		if (newXRight + width / 2 > screenWidth || newXRight - width / 2 < x) {
			vxRight *= -1;
		} else {
			xRight = newXRight;
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
					&& ((player.getX() - player.getRadius() < this.getXLeft() + this.getWidth() / 2
							&& player.getX() + player.getRadius() > this.getXLeft() - this.getWidth() / 2
							&& player.getY() - player.getRadius() < this.getY() + this.getHeight() / 2
							&& player.getY() + player.getRadius() > this.getY() - this.getHeight() / 2)
							|| (player.getX() - player.getRadius() < this.getXRight() + this.getWidth() / 2
									&& player.getX() + player.getRadius() > this.getXRight() - this.getWidth() / 2
									&& player.getY() - player.getRadius() < this.getY() + this.getHeight() / 2
									&& player.getY() + player.getRadius() > this.getY() - this.getHeight() / 2));
		}
	}
}
