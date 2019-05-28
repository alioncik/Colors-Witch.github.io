/**
 *  Colors Witch
 * @auteure: Cupcea Aliona 
 * @date: 2018/04/27
 * @NomDuFichier: CBouncingSquaresRenderer.java
 */
package colorswitch;

import javafx.scene.canvas.GraphicsContext;

/**
 * Fait le rendu des BouncingSquares en dessinant deux carres colores sur
 * l'ecran.
 */
public class BouncingSquaresRenderer extends Renderer {

	private BouncingSquares carres;

	public BouncingSquaresRenderer(BouncingSquares c) {
		this.carres = c;
	}

	@Override
	public void draw(Level level, GraphicsContext context) {

		double canvasY = Renderer.computeScreenY(level, carres.getY());

		context.setFill(Renderer.convertColor(carres.getColor()));

		context.fillRect(carres.getXLeft() - carres.getWidth() / 2, canvasY - carres.getWidth() / 2, carres.getWidth(),
				carres.getWidth());
		context.fillRect(carres.getXRight() - carres.getWidth() / 2, canvasY - carres.getWidth() / 2, carres.getWidth(),
				carres.getWidth());
	}
}
