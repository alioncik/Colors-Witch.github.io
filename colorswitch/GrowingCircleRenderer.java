package colorswitch;

import javafx.scene.canvas.GraphicsContext;

/**
 *  - Colors Witch
 * @auteure: Cupcea Aliona 
 * @date: 2018/04/27
 * @NomDuFichier: GrowingCircleRenderer.java
 *
 *                Fait le rendu d'un GrowingCircle en dessinant un cercle colore
 *                sur l'ecran.
 */
public class GrowingCircleRenderer extends Renderer {

	private GrowingCircle cercle;

	public GrowingCircleRenderer(GrowingCircle c) {
		this.cercle = c;
	}

	@Override
	public void draw(Level level, GraphicsContext context) {

		double canvasY = Renderer.computeScreenY(level, cercle.getY());

		context.setFill(Renderer.convertColor(cercle.getColor()));

		context.fillOval(cercle.getX() - cercle.getRadius(), canvasY - cercle.getRadius(), 2 * cercle.getRadius(),
				2 * cercle.getRadius());
	}
}
