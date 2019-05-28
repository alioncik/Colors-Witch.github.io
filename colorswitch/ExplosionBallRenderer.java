package colorswitch;

import javafx.scene.canvas.GraphicsContext;

/**
 * IFT 1025 - H2018 - TP2 - Colors Witch
 * 
 * @auteure: Bouvier Demmie - 20062942
 * @auteure: Cupcea Aliona - 20057887
 * @date: 2018/04/27
 * @NomDuFichier: ExplosionBallRenderer.java
 *
 *                Fait le rendu d'une ExplosionBall sur l'ecran en dessinant un
 *                cercle colore
 */
public class ExplosionBallRenderer extends Renderer {

	private ExplosionBall ball;

	public ExplosionBallRenderer(ExplosionBall ball) {
		this.ball = ball;
	}

	@Override
	public void draw(Level level, GraphicsContext context) {

		double canvasY = Renderer.computeScreenY(level, ball.getY());

		context.setFill(Renderer.convertColor(ball.getColor()));

		context.fillOval(ball.getX() - ball.getRadius(), canvasY - ball.getRadius(), 2 * ball.getRadius(),
				2 * ball.getRadius());
	}
}
