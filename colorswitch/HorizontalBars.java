package colorswitch;

/**
 *  - Colors Witch
 * @auteure: Cupcea Aliona
 * @date: 2018/04/27
 * @NomDuFichier: HorizontalBars.java
 *
 *                Obstacle : deux barres horizontales placees l'une au-dessus de
 *                l'autre qui bougent de droite a gauche et changent de couleur
 *                lorsqu'elles touchent les murs du niveau.
 */
public class HorizontalBars extends Obstacle {

	private double width;
	private double height;
	private double xUp;
	private double xDown;
	private double yUp;
	private double yDown;
	private double vxUp = -200;
	private double vxDown = 200;
	private double screenWidth;

	public HorizontalBars(double x, double y, double longueur, double hauteur, double largeurEcran) {
		super(x, y);
		this.xUp = x;
		this.xDown = x;
		this.yUp = y + (hauteur / 2);
		this.yDown = y - (hauteur / 2);

		this.width = longueur;
		this.height = hauteur;

		this.renderer = new HorizontalBarsRenderer(this);

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

	public double getXUp() {
		return xUp;
	}

	public double getXDown() {
		return xDown;
	}

	public double getYUp() {
		return yUp;
	}

	public double getYDown() {
		return yDown;
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
		double newXUp = xUp + dt * vxUp;
		double newXDown = xDown + dt * vxDown;

		// Collision avec les murs
		if (newXUp - width / 2 < 0 || newXUp + width / 2 > screenWidth) {
			vxUp *= -1;
			color = (color + 1) % 4;
		} else {
			xUp = newXUp;
		}

		if (newXDown - width / 2 < 0 || newXDown + width / 2 > screenWidth) {
			vxDown *= -1;
		} else {
			xDown = newXDown;
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
					&& ((player.getX() - player.getRadius() < this.getXUp() + this.getWidth() / 2
							&& player.getX() + player.getRadius() > this.getXUp() - this.getWidth() / 2
							&& player.getY() - player.getRadius() < this.getYUp() + this.getHeight() / 2
							&& player.getY() + player.getRadius() > this.getYUp() - this.getHeight() / 2)
							|| (player.getX() - player.getRadius() < this.getXDown() + this.getWidth() / 2
									&& player.getX() + player.getRadius() > this.getXDown() - this.getWidth() / 2
									&& player.getY() - player.getRadius() < this.getYDown() + this.getHeight() / 2
									&& player.getY() + player.getRadius() > this.getYDown() - this.getHeight() / 2));
		}
	}
}
