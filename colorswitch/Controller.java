/**
 * - Colors Witch
 * @auteure: Cupcea Aliona 
 * @date: 2018/04/27
 * @NomDuFichier: Controller.java
 */
package colorswitch;

import java.util.List;

/**
 * Contrôleur pour le jeu : fait le pont entre la vue et les modèles.
 */
public class Controller {

	private Game game;
	private int level;

	public Controller() {
		// La partie n'est pas creee initialement,
		// car un niveau doit etre selectionne avant dans le menu.
	}

	/**
	 * Fonction appelee apres qu'un niveau est ete selectione dans le menu
	 */
	public void start() {
		this.game = new Game(ColorsWitch.WIDTH, ColorsWitch.HEIGHT, level);
	}

	public List<Entity> getEntities() {
		return this.game.getEntities();
	}

	/**
	 * Fonction appelée à chaque frame du jeu.
	 * 
	 * @param dt
	 *            Delta-temps exprimé en secondes
	 */
	public void tick(double dt) {
		this.game.tick(dt);
	}

	public Level getCurrentLevel() {
		return this.game.getLevel();
	}

	public boolean getWon() {
		return this.game.hasWon();
	}

	public boolean getOver() {
		return this.game.isGameOver();
	}

	/**
	 * Fonction appelée lorsque la barre espace est enfoncée.
	 */
	public void spaceTyped() {
		if (this.game.isGameOver()) {
			if (this.game.hasWon()) {
				level++;
			}

			this.game = new Game(ColorsWitch.WIDTH, ColorsWitch.HEIGHT, level);
		} else {
			this.game.jump();
		}
	}

	/**
	 * Fonction appelee lorsque la touche Tab est enfoncee.
	 */
	public void tabTyped() {
		this.game.tabTyped();
	}

	public void setLevel(int level) {
		this.level = level;
	}
}
