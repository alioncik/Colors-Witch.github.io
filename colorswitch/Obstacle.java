package colorswitch;

/**
 * Colors Witch
 * @auteure: Cupcea Aliona 
 * @date: 2018/04/27
 * @NomDuFichier: Level1.java
 *
 *                Obstacle dans un niveau.
 *
 *                Lorsque le joueur entre en collision avec un obstacle, la
 *                partie est terminée.
 */
public abstract class Obstacle extends LevelElement {

	protected int color;

	public Obstacle(double x, double y) {
		super(x, y);
	}

	/**
	 * Gestion de la collision entre le joueur et l'obstacle
	 *
	 * @param player
	 *            Le joueur
	 * @param game
	 *            La partie en cours
	 */
	@Override
	public void handleCollision(Player player, Game game) {
		game.explosion();
	}
}
