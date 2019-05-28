package colorswitch;

/**
 *  - Colors Witch
 * @auteure: Cupcea Aliona 
 * @date: 2018/04/27
 * @NomDuFichier: Level3.java
 **/
public class Level3 extends Level {

	public Level3(double screenWidth, double screenHeight) {
		super(screenWidth, screenHeight);

		double x = screenWidth / 2;
		double h = screenHeight;
		double w = screenWidth;

		// Création des obstacles
		HorizontalBars obstacle1 = new HorizontalBars(x, 0.75 * h, 70, 20, w);
		RotatingCircle obstacle2 = new RotatingCircle(x, 1.1 * h, 15);
		HorizontalBars obstacle3 = new HorizontalBars(x, 1.45 * h, 70, 20, w);
		BouncingSquares obstacle4 = new BouncingSquares(x, 2.5 * h, 85, w);
		BouncingSquares obstacle5 = new BouncingSquares(x, 3 * h, 30, w);
		HorizontalBars obstacle6 = new HorizontalBars(x, 3.15 * h, 70, 20, w);

		obstacles.add(obstacle1);
		obstacles.add(obstacle2);
		obstacles.add(obstacle3);
		obstacles.add(obstacle4);
		obstacles.add(obstacle5);
		obstacles.add(obstacle6);

		// Creation des items
		Shield shield1 = new Shield(x, 1.75 * h);

		items.add(shield1);

		victoryMushroom = new Mushroom(x, 3.5 * h);
	}
}
