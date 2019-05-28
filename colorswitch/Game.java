package colorswitch;

import java.util.ArrayList;
import java.util.List;
/** Colors Witch
 * @auteure: Cupcea Aliona 
 * @date: 2018/04/27
 * @NomDuFichier: Game.java
 **/
public class Game {

    private Level level;
    private Player player;

    /**
     * Dimensions de l'écran
     */
    private double screenWidth, screenHeight;
    private ExplosionBall[] balls;
    private boolean collision = false;
    private double timeSinceCollision = 0;

    /**
     * Indique si la partie est terminée/gagnée
     */
    private boolean gameOver = false;
    private boolean hasWon = false;

    /**
     * Crée une partie dans le niveau levelNumber.
     *
     * @param screenWidth largeur de l'écran
     * @param screenHeight hauteur de l'écran
     * @param levelNumber numéro du niveau
     */
    public Game(double screenWidth, double screenHeight, int levelNumber) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;

        player = new Player(screenWidth / 2, 200, 15);

        switch (levelNumber) {
            case 1:
                level = new Level1(screenWidth, screenHeight);
                break;
            case 2:
                level = new Level2(screenWidth, screenHeight);
                break;
	    case 3:
                level = new Level3(screenWidth, screenHeight);
                break;
	    case 4:
                level = new Level4(screenWidth, screenHeight);
                break;
	    case 5:
                level = new Level5(screenWidth, screenHeight);
                break;
	    case 6:
                level = new Level6(screenWidth, screenHeight);
                break;
	    case 7:
                level = new Level7(screenWidth, screenHeight);
                break;
	    case 8:
                level = new Level8(screenWidth, screenHeight);
                break;
	    case 9:
                level = new Level9(screenWidth, screenHeight);
                break;
	    case 10:
                level = new Level10(screenWidth, screenHeight);
                break;
            default:
                throw new IllegalArgumentException("Niveau inconnu");
        }
    }

    /**
     * Fonction appelée à chaque frame
     *
     * @param dt Delta-Temps (en secondes)
     */
    public void tick(double dt) {
        level.tick(dt);

	// Si la sorciere n'est pas encore entree en collision avec un obstacle
	if (collision == false) {
	    player.tick(dt);
	    if (player.getY() - player.getRadius() < level.getScroll()) {
		// Empêche la balle de sortir de l'écran
		player.setY(level.getScroll() + player.getRadius());
	    } else if (player.getY() - level.getScroll() > screenHeight / 2) {
		// Scroll le level verticalement si nécessaire
		level.incrementScroll(player.getY() - level.getScroll() - screenHeight / 2);
	    }

	    // Gestion des collisions avec les éléments (items/obstacles/...) du niveau
	    for (LevelElement element : level.getEntities()) {
		if (element.intersects(player)) {
		    element.handleCollision(player, this);
		}
	    }
	}

	// Si la sorciere est entree en collision avec un obstacle
	if (collision == true) {
	    timeSinceCollision += dt;
	    explosionUpdate(dt);
	    endExplosion(dt);
	}
    }

    /**
     * @return les entités à afficher à l'écran
     */
    public List<Entity> getEntities() {
        List<Entity> entities = new ArrayList<>();

        entities.addAll(level.getEntities());

	if (collision == false) {
	    entities.add(player);
	}

	if (collision == true) {
	    for (int i = 0; i < balls.length; i++) {
		entities.add(balls[i]);
	    }
	}

        return entities;
    }

    public Level getLevel() {
        return level;
    }

    public void jump() {
        player.jump();
    }

    public void explosion() {
	this.collision = true;
	
	balls = new ExplosionBall[20];
	
	for (int i = 0; i < balls.length; i++) {
	    balls[i] = new ExplosionBall(player.getX(), player.getY(), 6, screenWidth, screenHeight);
	}
    }

    public void lose() {
        this.gameOver = true;
    }

    public void win() {
        this.hasWon = true;
        this.gameOver = true;
    }

    /**
     * Indique si la partie est gagnée
     *
     * @return
     */
    public boolean hasWon() {
        return hasWon;
    }

    /**
     * Indique si la partie est terminée
     *
     * @return
     */
    public boolean isGameOver() {
        return gameOver;
    }

    /**
     * Lorsqu'il y a collision entre la sorciere et un obstacle,
     * elle explose et cette fonction gere les balles de l'explosion.
     *
     * @param dt Delta-Temps (en secondes)
     */
    public void explosionUpdate(double dt) {
	for (int i = 0; i < balls.length; i++) {
	    ExplosionBall e = balls[i];
	    e.tick(dt);

	    // Collision de la balle avec toutes les balles suivantes
	    for (int j = i + 1; j < balls.length; j++) {
		e.testCollision(balls[j]);
	    }
	}
    }

    /**
     * Fonction qui determine si le message de fin de partie
     * doit etre affiche
     *
     * @param dt Delta-Temps (en secondes)
     */
    public void endExplosion(double dt) {
	if (timeSinceCollision > 3) {
	    timeSinceCollision = 0;
	    lose();
	}
    }

    /**
     * Fonction appelee lorsque la touche Tab est enfoncee
     * pour mettre la sorciere en mode test
     */
    public void tabTyped() {
	if (player.getTab() == false) {
	    player.setTab(true);
	    player.setShield(true);
	} else {
	    player.setTab(false);
	    player.setShield(false);
	}
    }
}
