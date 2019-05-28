/**
 * - Colors Witch
 * @auteure: Cupcea Aliona 
 * @date: 2018/04/27
 * @NomDuFichier: ColorsWitch.java
 */

package colorswitch;

import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Classe principale. Définit la vue.
 */
public class ColorsWitch extends Application {

	public static final double WIDTH = 320, HEIGHT = 480;

	private Controller controller;
	private GraphicsContext context;
	private Scene scene;

	private boolean displayMenu = true;
	private int levelChosen;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		controller = new Controller();

		Canvas canvas = new Canvas(WIDTH, HEIGHT);
		Pane root = new Pane(canvas);

		if (displayMenu == true) {
			menu(root, primaryStage);
		}

		else {
			controller.setLevel(this.levelChosen);
			controller.start();

			context = canvas.getGraphicsContext2D();

			AnimationTimer timer = new AnimationTimer() {
				private long lastTime = System.nanoTime();

				@Override
				public void handle(long now) {
					controller.tick((now - lastTime) * 1e-9);

					context.setFill(Color.BLACK);
					context.fillRect(0, 0, WIDTH, HEIGHT);

					if (controller.getOver()) {
						if (controller.getWon()) {
							gameWon();
						} else {
							gameLost();
						}
					}

					else {
						List<Entity> entities = controller.getEntities();

						for (Entity e : entities) {
							e.getRepresentation().draw(controller.getCurrentLevel(), context);
						}
					}

					lastTime = now;
				}
			};
			timer.start();

			scene = new Scene(root, WIDTH, HEIGHT);

			scene.setOnKeyPressed((event) -> {
				if (event.getCode() == KeyCode.SPACE) {
					controller.spaceTyped();
				}
				if (event.getCode() == KeyCode.TAB) {
					controller.tabTyped();
				}
				if (event.getCode() == KeyCode.ESCAPE) {
					timer.stop();
					returnToMenu(root, primaryStage);
				}
			});
		}

		primaryStage.setTitle("Colors Witch");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	// Affichage d'un menu
	public void menu(Pane root, Stage stage) {

		root.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
		BorderPane border = new BorderPane();
		border.setPadding(new Insets(30, 30, 30, 30));

		VBox buttons = new VBox();

		Button level1 = new Button("Level 1");

		level1.setOnAction((event) -> {
			this.levelChosen = 1;
			this.displayMenu = false;
			try {
				start(stage);
			} catch (Exception exception) {
			}
		});

		Button level2 = new Button("Level 2");

		level2.setOnAction((event) -> {
			this.levelChosen = 2;
			this.displayMenu = false;
			try {
				start(stage);
			} catch (Exception exception) {
			}
		});

		Button level3 = new Button("Level 3");

		level3.setOnAction((event) -> {
			this.levelChosen = 3;
			this.displayMenu = false;
			try {
				start(stage);
			} catch (Exception exception) {
			}
		});

		Button level4 = new Button("Level 4");

		level4.setOnAction((event) -> {
			this.levelChosen = 4;
			this.displayMenu = false;
			try {
				start(stage);
			} catch (Exception exception) {
			}
		});

		Button level5 = new Button("Level 5");

		level5.setOnAction((event) -> {
			this.levelChosen = 5;
			this.displayMenu = false;
			try {
				start(stage);
			} catch (Exception exception) {
			}
		});

		Button level6 = new Button("Level 6");

		level6.setOnAction((event) -> {
			this.levelChosen = 6;
			this.displayMenu = false;
			try {
				start(stage);
			} catch (Exception exception) {
			}
		});

		Button level7 = new Button("Level 7");

		level7.setOnAction((event) -> {
			this.levelChosen = 7;
			this.displayMenu = false;
			try {
				start(stage);
			} catch (Exception exception) {
			}
		});

		Button level8 = new Button("Level 8");

		level8.setOnAction((event) -> {
			this.levelChosen = 8;
			this.displayMenu = false;
			try {
				start(stage);
			} catch (Exception exception) {
			}
		});

		Button level9 = new Button("Level 9");

		level9.setOnAction((event) -> {
			this.levelChosen = 9;
			this.displayMenu = false;
			try {
				start(stage);
			} catch (Exception exception) {
			}
		});

		Button level10 = new Button("Level 10");

		level10.setOnAction((event) -> {
			this.levelChosen = 10;
			this.displayMenu = false;
			try {
				start(stage);
			} catch (Exception exception) {
			}
		});

		Label title = new Label("ColorsWitch");
		title.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
		title.setTextFill(Color.WHITE);
		Label choose = new Label("Choose the level you want to play");
		choose.setFont(Font.font("Verdana", FontWeight.NORMAL, 15));
		choose.setTextFill(Color.WHITE);

		buttons.setSpacing(10);
		buttons.getChildren().addAll(title, choose);
		buttons.getChildren().addAll(level1, level2, level3, level4, level5, level6, level7, level8, level9, level10);
		buttons.setAlignment(Pos.CENTER);

		border.setCenter(buttons);
		root.getChildren().add(border);

		scene = new Scene(root, WIDTH, HEIGHT);
	}

	// Affichage lorsqu'une partie est perdue
	public void gameLost() {
		context.clearRect(0, 0, WIDTH, HEIGHT);
		context.setFill(Color.BLACK);
		context.fillRect(0, 0, WIDTH, HEIGHT);
		context.setFont(Font.font("Verdana", 20));
		context.setFill(Color.WHITE);
		context.fillText("You lose... Too bad !", WIDTH / 5, HEIGHT / 2.2);
		context.setFont(Font.font("Verdana", 10));
		context.fillText("Press Space Key to try again", WIDTH / 3.8, HEIGHT / 1.8);
	}

	// Affichage lorsqu'une partie est gagnee
	public void gameWon() {
		context.clearRect(0, 0, WIDTH, HEIGHT);
		context.setFill(Color.BLACK);
		context.fillRect(0, 0, WIDTH, HEIGHT);
		context.setFont(Font.font("Verdana", 20));
		context.setFill(Color.WHITE);
		context.fillText("You win !", WIDTH / 2.8, HEIGHT / 2.2);
		context.setFont(Font.font("Verdana", 10));
		context.fillText("Press Space Key to continue", WIDTH / 3.8, HEIGHT / 1.8);
	}

	// Lorsque la touche Escape est enfoncee le menu est affiche
	public void returnToMenu(Pane root, Stage stage) {
		root.getChildren().clear();
		this.displayMenu = true;
		try {
			start(stage);
		} catch (Exception exception) {
		}
	}

}
