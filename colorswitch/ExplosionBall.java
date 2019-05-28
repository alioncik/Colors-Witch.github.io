
package colorswitch;

/**
 - Colors Witch
 * @auteure: Cupcea Aliona
 * @date: 2018/04/27
 * @NomDuFichier: ExplosionBall.java
 *
 *                Classe representant l'entite de la personne qui joue
 *                lorsqu'elle rencontre un obstacle qui lui fait perdre la
 *                partie.
 *
 *                La sorciere qui perd est representee par une explosion de
 *                cercles.
 */
public class ExplosionBall extends Entity {

	private double radius;
	private double vx, vy;
	private int color;
	private double screenWidth;
	private double screenHeight;
	private double ay = -600;

	public ExplosionBall(double x, double y, double r, double largeurEcran, double hauteurEcran) {
		super(x, y);

		this.radius = r;

		this.screenWidth = largeurEcran;
		this.screenHeight = hauteurEcran;

		this.vx = directionVx() * (Math.random() * 600);
		this.vy = 1 * (Math.random() * 600);

		this.color = (int) (Math.random() * 4);

		this.renderer = new ExplosionBallRenderer(this);
	}

	public double getRadius() {
		return radius;
	}

	@Override
	public double getWidth() {
		return this.getRadius() * 2;
	}

	@Override
	public double getHeight() {
		return this.getRadius() * 2;
	}

	/**
	 * Genere une direction vx aleatoire
	 *
	 * @return 1 pour une vx vers la droite ou -1 pour une vx vers la gauche
	 */
	public int directionVx() {
		double direction = Math.random();
		if (direction < 0.5) {
			return 1;
		} else {
			return -1;
		}
	}

	/**
	 * Indique s'il y a intersection entre les deux balles
	 *
	 * @param other
	 * @return true s'il y a intersection
	 */
	public boolean intersects(ExplosionBall other) {
		double dx = this.x - other.x;
		double dy = this.y - other.y;
		double d2 = dx * dx + dy * dy;

		return d2 < (this.radius + other.radius) * (this.radius + other.radius);
	}

	/**
	 * Déplace les deux balles en intersection pour retrouver un déplacement minimal
	 *
	 * @param other
	 */
	public void pushOut(ExplosionBall other) {
		// Calculer la quantité qui overlap en X, same en Y
		// Déplacer les deux de ces quantités/2
		double dx = other.x - this.x;
		double dy = other.y - this.y;
		double d2 = dx * dx + dy * dy;
		double d = Math.sqrt(d2);

		// Overlap en pixels
		double overlap = d - (this.radius + other.radius);

		// Direction dans laquelle se déplacer (normalisée)
		double directionX = dx / d;
		double directionY = dy / d;

		double deplacementX = directionX * overlap / 2;
		double deplacementY = directionY * overlap / 2;

		this.x += deplacementX;
		this.y += deplacementY;
		other.x -= deplacementX;
		other.y -= deplacementY;
	}

	public void testCollision(ExplosionBall other) {
		if (this.intersects(other)) {
			double vx = this.vx;
			double vy = this.vy;

			this.vx = other.vx;
			this.vy = other.vy;

			other.vx = vx;
			other.vy = vy;

			pushOut(other);
		}
	}

	/**
	 * Fonction appelee a chaque frame pour mettre a jour les attributs de l'entite
	 *
	 * @param dt
	 *            Delta-Temps en secondes
	 */
	@Override
	public void tick(double dt) {
		// Mise a jour de la vitesse
		vy += dt * ay;

		// Mise a jour de la position
		x += dt * vx;
		y += dt * vy;

		// Si la balle touche un mur
		if (x + getRadius() > screenWidth || x - getRadius() < 0) {
			vx *= -1;
		}
	}

	public int getColor() {
		return color;
	}
}
