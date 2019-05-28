package colorswitch;
/**
 *Colors Witch
 * @auteure: Cupcea Aliona 
 * @date: 2018/04/27
 * @NomDuFichier: Entity.java
 *
 * Classe abstraite pour représenter une entité sur le jeu.
 *
 * Une entité possède minimalement un Renderer et une position (x, y) définie
 * par rapport au niveau (où y=0 est tout en bas).
 */
public abstract class Entity {

	protected double x, y;
	protected Renderer renderer;
	protected int frame;

	public Entity(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public int getFrame() {
		return frame;
	}

	/**
	 * @return la largeur totale de l'entité
	 */
	public abstract double getWidth();

	/**
	 * @return la hauteur totale de l'entité
	 */
	public abstract double getHeight();

	public Renderer getRepresentation() {
		return renderer;
	}

	/**
	 * Fonction appelée à chaque frame pour mettre à jour les attributs de l'entité.
	 *
	 * @param dt
	 *            Delta-Temps en secondes
	 */
	public abstract void tick(double dt);
}
