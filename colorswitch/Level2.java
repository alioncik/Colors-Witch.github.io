package colorswitch;

/**
 *Colors Witch
 * @auteure: Cupcea Aliona 
 * @date: 2018/04/27
 * @NomDuFichier: Level2.java
 **/
public class Level2 extends Level {

	public Level2(double screenWidth, double screenHeight) {
		super(screenWidth, screenHeight);

		double x = screenWidth / 2;
		double w = screenWidth;
		double h = screenHeight;

		// Création des obstacles
		GrowingCircle obstacle1 = new GrowingCircle(x, 0.75 * h, 20, w);
		Square obstacle2 = new Square(x, 1.6 * h, 180);
		HorizontalBars obstacle3 = new HorizontalBars(x, 2.6 * h, 70, 20, w);
		HorizontalBars obstacle4 = new HorizontalBars(x, 3.2 * h, 70, 20, w);

		obstacles.add(obstacle1);
		obstacles.add(obstacle2);
		obstacles.add(obstacle3);
		obstacles.add(obstacle4);

		// Creation des items
		Potion potion1 = new Potion(x, 1.25 * h);
		Moon moon1 = new Moon(x, 2.2 * h);

		items.add(potion1);
		items.add(moon1);

		victoryMushroom = new Mushroom(screenWidth / 2, 3.5 * h);
	}
}
