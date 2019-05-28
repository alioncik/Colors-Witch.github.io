package colorswitch;

/**
 * * Colors Witch
 * @auteure: Cupcea Aliona 
 * @date: 2018/04/27
 * @NomDuFichier: Player.java
 *
 *                Classe représentant l'entité de la personne qui joue (aka, la
 *                sorcière).
 *
 *                La sorcière est représentée par un cercle.
 */
public class Player extends Entity {

	private double radius;
	private double vy;
	private double ay;
	private int color = 1;

	private boolean shield = false;
	private boolean moon = false;
	private boolean apple = false;

	private double timeSinceShieldUsed = 0;
	private double timeSinceMoonUsed = 0;
	private double timeSinceAppleUsed = 0;
	private double timeSinceColorChange = 0;

	private boolean tab = false;

	public Player(double x, double y, double r) {
		super(x, y);

		this.radius = r;

		this.vy = 0;
		this.ay = -400;

		this.renderer = new PlayerRenderer(this);
	}

	public double getRadius() {
		if (this.apple == false) {
			return radius;
		} else {
			return (radius + 10);
		}
	}

	/**
	 * Fonction appelée à chaque frame pour mettre à jour les attributs de l'entité
	 *
	 * @param dt
	 *            Delta-Temps en secondes
	 */
	@Override
	public void tick(double dt) {
		// Mise à jour de la vitesse
		if (this.moon == false) {
			vy += dt * ay;
		}

		if (this.moon == true) {
			vy += dt * (ay + 300);
		}

		// Mise à jour de la position
		y += dt * vy;

		// Clip la vitesse pour rester entre -300 et 300
		vy = Math.min(vy, 300);
		vy = Math.max(vy, -300);

		// Mode test
		if (this.tab == true) {
			testMode(dt);
		}

		// Bouclier possede
		if (this.tab == false) {
			if (this.shield == true) {
				shieldMode(dt);
			}
		}

		// Lune possedee
		if (this.moon == true) {
			moonMode(dt);
		}

		// Pomme possedee
		if (this.apple == true) {
			appleMode(dt);
		}
	}

	public int getColor() {
		return color;
	}

	public boolean getTab() {
		return tab;
	}

	public void setTab(boolean tab) {
		this.tab = tab;
	}

	public boolean getShield() {
		return shield;
	}

	public void setShield(boolean shield) {
		this.shield = shield;
	}

	public boolean getMoon() {
		return moon;
	}

	public void setMoon(boolean moon) {
		this.moon = moon;
	}

	public boolean getApple() {
		return apple;
	}

	public void setApple(boolean apple) {
		this.apple = apple;
	}

	/**
	 * Remplace la couleur actuelle par une nouvelle couleur aléatoire
	 */
	public void randomizeColor() {
		int newColor;

		do {
			newColor = (int) (Math.random() * 4);
		} while (newColor == this.color);

		this.color = newColor;
	}

	/**
	 * Fait sauter la sorcière
	 */
	public void jump() {
		vy = Math.max(vy, 0);

		if (this.apple == false) {
			vy += 200;
		}

		if (this.apple == true) {
			vy += 120;
		}
	}

	public void setY(double y) {
		this.y = y;
	}

	@Override
	public double getWidth() {
		return this.getRadius() * 2;
	}

	@Override
	public double getHeight() {
		return this.getRadius() * 2;
	}

	public void testMode(double dt) {
		timeSinceColorChange += dt;

		if (timeSinceColorChange > 0.07) {
			color = (color + 1) % 4;
			timeSinceColorChange = 0;
		}
	}

	public void shieldMode(double dt) {
		timeSinceShieldUsed += dt;
		timeSinceColorChange += dt;

		if (timeSinceColorChange > 0.07) {
			color = (color + 1) % 4;
			timeSinceColorChange = 0;
		}

		if (timeSinceShieldUsed > 3) {
			this.shield = false;
			timeSinceShieldUsed = 0;
		}
	}

	public void moonMode(double dt) {
		timeSinceMoonUsed += dt;

		if (timeSinceMoonUsed > 6) {
			this.moon = false;
			timeSinceMoonUsed = 0;
		}
	}

	public void appleMode(double dt) {
		timeSinceAppleUsed += dt;

		if (timeSinceAppleUsed > 6) {
			this.apple = false;
			timeSinceAppleUsed = 0;
		}
	}
}
