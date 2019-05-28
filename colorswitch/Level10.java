package colorswitch;

/**
 * - Colors Witch
 * @auteure: Cupcea Aliona 
 * @date: 2018/04/27
 * @NomDuFichier: Level10.java
 **/
public class Level10 extends Level {

	public Level10(double screenWidth, double screenHeight) {
		super(screenWidth, screenHeight);

		double x = screenWidth / 2;
		double h = screenHeight;
		double w = screenWidth;

		// Création des obstacles
		BouncingSquares obstacle1 = new BouncingSquares(x, 0.75 * h, 25, w);
		BouncingSquares obstacle2 = new BouncingSquares(x, 0.95 * h, 25, w);
		Square obstacle3 = new Square(x, 1.15 * h, 90);
		Square obstacle4 = new Square(x, 1.55 * h, 40);
		Square obstacle5 = new Square(x, 1.85 * h, 40);
		GrowingCircle obstacle6 = new GrowingCircle(x, 2.65 * h, 40, w);
		BouncingSquares obstacle7 = new BouncingSquares(x, 3.1 * h, 25, w);
		BouncingSquares obstacle8 = new BouncingSquares(x, 3.3 * h, 25, w);
		VerticalBar obstacle9 = new VerticalBar(x, 3.45 * h, 20, 95, w);
		HorizontalBars obstacle10 = new HorizontalBars(x, 3.85 * h, 60, 15, w);
		HorizontalBars obstacle11 = new HorizontalBars(x, 4.15 * h, 60, 15, w);

		obstacles.add(obstacle1);
		obstacles.add(obstacle2);
		obstacles.add(obstacle3);
		obstacles.add(obstacle4);
		obstacles.add(obstacle5);
		obstacles.add(obstacle6);
		obstacles.add(obstacle7);
		obstacles.add(obstacle8);
		obstacles.add(obstacle9);
		obstacles.add(obstacle10);
		obstacles.add(obstacle11);

		// Création des items
		PoisonedApple apple1 = new PoisonedApple(x, 0.85 * h);
		Potion potion1 = new Potion(x, 1.45 * h);
		Potion potion2 = new Potion(x, 1.75 * h);
		Moon moon1 = new Moon(x, 2 * h);
		PoisonedApple apple2 = new PoisonedApple(x, 3.2 * h);
		Moon moon2 = new Moon(x, 4 * h);

		items.add(apple1);
		items.add(potion1);
		items.add(potion2);
		items.add(moon1);
		items.add(apple2);
		items.add(moon2);

		victoryMushroom = new Mushroom(x, 4.5 * h);
	}
}
