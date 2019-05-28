package colorswitch;

/**
 * - Colors Witch
 * @auteure: Cupcea Aliona 
 * @date: 2018/04/27
 * @NomDuFichier: Level8.java
 **/
public class Level8 extends Level {

	public Level8(double screenWidth, double screenHeight) {
		super(screenWidth, screenHeight);

		double x = screenWidth / 2;
		double h = screenHeight;
		double w = screenWidth;

		// Création des obstacles
		VerticalBar obstacle1 = new VerticalBar(x, 0.75 * h, 30, 85, w);
		VerticalBar obstacle2 = new VerticalBar(x, 1.1 * h, 85, 30, w);
		VerticalBar obstacle3 = new VerticalBar(x, 1.45 * h, 30, 85, w);
		VerticalBar obstacle4 = new VerticalBar(x, 1.8 * h, 95, 30, w);
		VerticalBar obstacle5 = new VerticalBar(x, 2.15 * h, 30, 95, w);
		VerticalBar obstacle6 = new VerticalBar(x, 2.5 * h, 95, 30, w);
		VerticalBar obstacle7 = new VerticalBar(x, 2.85 * h, 30, 105, w);
		VerticalBar obstacle8 = new VerticalBar(x, 3.2 * h, 105, 30, w);
		VerticalBar obstacle9 = new VerticalBar(x, 3.55 * h, 30, 105, w);

		obstacles.add(obstacle1);
		obstacles.add(obstacle2);
		obstacles.add(obstacle3);
		obstacles.add(obstacle4);
		obstacles.add(obstacle5);
		obstacles.add(obstacle6);
		obstacles.add(obstacle7);
		obstacles.add(obstacle8);
		obstacles.add(obstacle9);

		// Création des items
		Potion potion1 = new Potion(x, 1.25 * h);
		Potion potion2 = new Potion(x, 1.95 * h);
		Potion potion3 = new Potion(x, 2.65 * h);
		Potion potion4 = new Potion(x, 3.35 * h);

		items.add(potion1);
		items.add(potion2);
		items.add(potion3);
		items.add(potion4);

		victoryMushroom = new Mushroom(x, 4 * h);
	}
}
