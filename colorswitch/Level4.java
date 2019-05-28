package colorswitch;

/**
 * - Colors Witch
 * @auteure: Cupcea Aliona
 * @date: 2018/04/27
 * @NomDuFichier: Level4.java
 **/
public class Level4 extends Level {

	public Level4(double screenWidth, double screenHeight) {
		super(screenWidth, screenHeight);

		double x = screenWidth / 2;
		double h = screenHeight;
		double w = screenWidth;

		// Création des obstacles
		BouncingSquares obstacle1 = new BouncingSquares(x, 0.75 * h, 40, w);
		BouncingSquares obstacle2 = new BouncingSquares(x, 1.1 * h, 60, w);
		BouncingSquares obstacle3 = new BouncingSquares(x, 1.5 * h, 70, w);
		RotatingCircle obstacle4 = new RotatingCircle(x, 2.5 * h, 25);
		Square obstacle5 = new Square(x, 3.1 * h, 120);

		obstacles.add(obstacle1);
		obstacles.add(obstacle2);
		obstacles.add(obstacle3);
		obstacles.add(obstacle4);
		obstacles.add(obstacle5);

		// Création des items
		Shield shield1 = new Shield(x, 2 * h);

		items.add(shield1);

		victoryMushroom = new Mushroom(x, 3.5 * h);
	}
}
