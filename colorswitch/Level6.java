package colorswitch;

/**
 *  Colors Witch
 * @auteure: Cupcea Aliona 
 * @date: 2018/04/27
 * @NomDuFichier: Level6.java
 **/
public class Level6 extends Level {

	public Level6(double screenWidth, double screenHeight) {
		super(screenWidth, screenHeight);

		double x = screenWidth / 2;
		double h = screenHeight;
		double w = screenWidth;

		// Création des obstacles
		VerticalBar obstacle1 = new VerticalBar(x, 0.75 * h, 15, 80, w);
		RotatingCircle obstacle2 = new RotatingCircle(x, 1.1 * h, 30);
		VerticalBar obstacle3 = new VerticalBar(x, 1.45 * h, 15, 80, w);
		RotatingCircle obstacle4 = new RotatingCircle(x, 2.25 * h, 15);
		Square obstacle5 = new Square(x, 2.25 * h, 40);
		RotatingCircle obstacle6 = new RotatingCircle(x, 2.8 * h, 15);
		Square obstacle7 = new Square(x, 2.8 * h, 40);
		Square obstacle8 = new Square(x, 3.4 * h, 200);

		obstacles.add(obstacle1);
		obstacles.add(obstacle2);
		obstacles.add(obstacle3);
		obstacles.add(obstacle4);
		obstacles.add(obstacle5);
		obstacles.add(obstacle6);
		obstacles.add(obstacle7);
		obstacles.add(obstacle8);

		// Création des items
		Shield shield1 = new Shield(x, 1.9 * h);

		items.add(shield1);

		victoryMushroom = new Mushroom(x, 4 * h);
	}
}
