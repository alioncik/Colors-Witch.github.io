/**
 *  - Colors Witch

 * @auteure: Cupcea Aliona 
 * @date: 2018/04/27
 * @NomDuFichier: AnimationRenderer.java
 */
package colorswitch;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * Fait le rendu d'une Entity sur l'ecran en affichant une animation
 */
public class AnimationRenderer extends Renderer {

	private Image[] frames;
	private Entity entity;

	public AnimationRenderer(String name, int number, double f, Entity e) {

		super.framerate = f;
		super.number = number;

		frames = new Image[number];
		for (int i = 0; i < number; i++) {
			frames[i] = new Image("/" + name + "_animation" + (i + 1) + ".png");
		}

		this.entity = e;

	}

	@Override
	public void draw(Level level, GraphicsContext context) {

		double x = entity.getX();
		double y = Renderer.computeScreenY(level, entity.getY());

		Image img = frames[entity.getFrame()];
		context.drawImage(img, x - entity.getWidth() / 2, y - entity.getHeight() / 2, entity.getWidth(),
				entity.getHeight());
	}
}
