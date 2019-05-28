package colorswitch;

/**
 * Colors Witch
 * @auteure: Cupcea Aliona 
 * @date: 2018/04/27
 * @NomDuFichier: RotatigCircle.java
 *
 *                Obstacle : un cercle qui tourne autour d'un point central et
 *                dont la couleur change a toutes les 2 secondes.
 */
public class RotatingCircle extends Obstacle {

	private double radius;
	private double x0 = 60;
	private double y0 = 0;
	private double xInitial;
	private double yInitial;
	private double v = 5;
	private double timeSinceColorChange = 0;

	public RotatingCircle(double x, double y, double rayon) {
		super(x, y);

		this.radius = rayon;
		this.xInitial = x;
		this.yInitial = y;

		this.renderer = new RotatingCircleRenderer(this);

		this.color = (int) (Math.random() * 4);
	}

	public double getRadius() {
		return radius;
	}

	@Override
	public double getHeight() {
		return radius * 2;
	}

	@Override
	public double getWidth() {
		return radius * 2;
	}

	/**
	 * Fonction appelee a chaque frame pour mettre a jour les attributs l'obstacle
	 *
	 * @param dt
	 *            Delta-Temps en secondes
	 */
	@Override
	public void tick(double dt) {
		// Mise a jour de la position
		double newX = x0 * Math.cos(dt * v) - y0 * Math.sin(dt * v);
		double newY = y0 * Math.cos(dt * v) + x0 * Math.sin(dt * v);

		x0 = newX;
		y0 = newY;

		x = xInitial + x0;
		y = yInitial + y0;

		// Changement de couleur
		timeSinceColorChange += dt;

		if (timeSinceColorChange > 2) {
			color = (color + 1) % 4;
			timeSinceColorChange = 0;
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
					&& player.getX() - player.getRadius() < this.getX() + this.getRadius()
					&& player.getX() + player.getRadius() > this.getX() - this.getRadius()
					&& player.getY() - player.getRadius() < this.getY() + this.getRadius()
					&& player.getY() + player.getRadius() > this.getY() - this.getRadius();
		}
	}
}
