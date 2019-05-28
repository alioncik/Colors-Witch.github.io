package colorswitch;

/**
 *  - Colors Witch
 * @auteure: Cupcea Aliona 
 * @date: 2018/04/27
 * @NomDuFichier: Level7.java
 **/
public class Level7 extends Level {

	public Level7(double screenWidth, double screenHeight) {
		super(screenWidth, screenHeight);

		double x = screenWidth / 2;
		double h = screenHeight;
		double w = screenWidth;

		// Création des obstacles
		RotatingCircle obstacle1 = new RotatingCircle(x, 0.75 * h, 15);
		HorizontalBars obstacle2 = new HorizontalBars(x, 1.15 * h, 50, 20, w);
		HorizontalBars obstacle3 = new HorizontalBars(x, 1.45 * h, 70, 20, w);
		HorizontalBars obstacle4 = new HorizontalBars(x, 1.75 * h, 90, 20, w);
		RotatingCircle obstacle5 = new RotatingCircle(x, 2.4 * h, 15);
		VerticalBar obstacle6 = new VerticalBar(x, 3.3 * h, 30, 180, w);

		obstacles.add(obstacle1);
		obstacles.add(obstacle2);
		obstacles.add(obstacle3);
		obstacles.add(obstacle4);
		obstacles.add(obstacle5);
		obstacles.add(obstacle6);

		// Création des items
		PoisonedApple apple1 = new PoisonedApple(x, 0.75 * h);
		Moon moon1 = new Moon(x, 2.4 * h);

		items.add(apple1);
		items.add(moon1);

		victoryMushroom = new Mushroom(x, 4 * h);
	}
}
