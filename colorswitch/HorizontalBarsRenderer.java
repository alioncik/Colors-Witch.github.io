package colorswitch;

import javafx.scene.canvas.GraphicsContext;

/**
 * - Colors Witch
 * @auteure: Cupcea Aliona 
 * @date: 2018/04/27
 * @NomDuFichier: HorizontalBarsRenderer.java
 * 
 * 
 *                Fait le rendu des HorizontalBars en dessinant deux barres
 *                colorees sur l'ecran.
 */
public class HorizontalBarsRenderer extends Renderer {

	private HorizontalBars barres;

	public HorizontalBarsRenderer(HorizontalBars h) {
		this.barres = h;
	}

	@Override
	public void draw(Level level, GraphicsContext context) {

		double canvasYUp = Renderer.computeScreenY(level, barres.getYUp());
		double canvasYDown = Renderer.computeScreenY(level, barres.getYDown());

		context.setFill(Renderer.convertColor(barres.getColor()));

		context.fillRect(barres.getXUp() - barres.getWidth() / 2, canvasYUp - barres.getHeight() / 2, barres.getWidth(),
				barres.getHeight());
		context.fillRect(barres.getXDown() - barres.getWidth() / 2, canvasYDown - barres.getHeight() / 2,
				barres.getWidth(), barres.getHeight());
	}
}
