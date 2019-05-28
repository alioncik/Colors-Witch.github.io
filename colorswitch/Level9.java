package colorswitch;

/**
 *  Colors Witch
 * @auteure: Cupcea Aliona
 * @date: 2018/04/27
 * @NomDuFichier: Level9.java
 **/
public class Level9 extends Level {

	public Level9(double screenWidth, double screenHeight) {
		super(screenWidth, screenHeight);

		double x = screenWidth / 2;
		double h = screenHeight;
		double w = screenWidth;

		// Création des obstacles
		Square obstacle1 = new Square(x, 0.75 * h, 170);
		RotatingCircle obstacle2 = new RotatingCircle(x, 0.75 * h, 25);
		RotatingCircle obstacle3 = new RotatingCircle(x, 1.3 * h, 15);
		Square obstacle4 = new Square(x, 1.3 * h, 40);
		RotatingCircle obstacle5 = new RotatingCircle(x, 1.9 * h, 70);
		Square obstacle6 = new Square(x, 3.75 * h, 290);
		GrowingCircle obstacle7 = new GrowingCircle(x, 3.75 * h, 20, w);

		obstacles.add(obstacle1);
		obstacles.add(obstacle2);
		obstacles.add(obstacle3);
		obstacles.add(obstacle4);
		obstacles.add(obstacle5);
		obstacles.add(obstacle6);
		obstacles.add(obstacle7);

		// Création des items
		Shield shield1 = new Shield(x, 2.6 * h);

		items.add(shield1);

		victoryMushroom = new Mushroom(x, 4.5 * h);
	}
}
