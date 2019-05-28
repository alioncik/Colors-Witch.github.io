package colorswitch;

/**
 *  Colors Witch
 * @auteure: Cupcea Aliona 
 * @date: 2018/04/27
 * @NomDuFichier: Level5.java
 **/
public class Level5 extends Level {

	public Level5(double screenWidth, double screenHeight) {
		super(screenWidth, screenHeight);

		double x = screenWidth / 2;
		double h = screenHeight;

		// Création des obstacles
		RotatingCircle obstacle1 = new RotatingCircle(x, 0.75 * h, 30);
		Square obstacle2 = new Square(x, 1.3 * h, 40);
		Square obstacle3 = new Square(x, 1.6 * h, 40);
		Square obstacle4 = new Square(x, 1.9 * h, 40);
		Square obstacle5 = new Square(x, 3 * h, 220);

		obstacles.add(obstacle1);
		obstacles.add(obstacle2);
		obstacles.add(obstacle3);
		obstacles.add(obstacle4);
		obstacles.add(obstacle5);

		// Création des items
		Potion potion1 = new Potion(x, 1.2 * h);
		Potion potion2 = new Potion(x, 1.5 * h);
		Potion potion3 = new Potion(x, 1.8 * h);
		Moon moon1 = new Moon(x, 2.2 * h);

		items.add(potion1);
		items.add(potion2);
		items.add(potion3);
		items.add(moon1);

		victoryMushroom = new Mushroom(x, 3.5 * h);
	}
}
