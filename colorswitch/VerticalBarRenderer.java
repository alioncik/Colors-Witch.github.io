package colorswitch;

import javafx.scene.canvas.GraphicsContext;

/**
  * Colors Witch
 * @auteure: Cupcea Aliona 
 * @date: 2018/04/27
 * @NomDuFichier: VerticalBarRenderer.java
 *
 *                Fait le rendu d'une VerticalBar en dessinant un rectangle
 *                colore sur l'ecran.
 */
public class VerticalBarRenderer extends Renderer {

	private VerticalBar barreVerticale;

	public VerticalBarRenderer(VerticalBar b) {
		this.barreVerticale = b;
	}

	@Override
	public void draw(Level level, GraphicsContext context) {

		double canvasY = Renderer.computeScreenY(level, barreVerticale.getY());

		context.setFill(Renderer.convertColor(barreVerticale.getColor()));

		context.fillRect(barreVerticale.getX() - barreVerticale.getWidth() / 2,
				canvasY - barreVerticale.getHeight() / 2, barreVerticale.getWidth(), barreVerticale.getHeight());
	}
}
