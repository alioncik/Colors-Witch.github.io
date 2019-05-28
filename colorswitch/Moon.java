package colorswitch;

/**
 *  Colors Witch
 * @auteure: Cupcea Aliona 
 * @date: 2018/04/27
 * @NomDuFichier: Moon.java
 *
 * Item : Lune
 *
 * La gravite qui affecte la sorciere est diminuee pendant 6 secondes
 */
public class Moon extends Item {

    private boolean used = false;
    
    public Moon(double x, double y) {
        super(x, y);
        
        this.renderer = new ImageRenderer("moon", this);
    }
    
    @Override
    public void tick(double dt) {
        // Rien a faire
    }
    
    @Override
    public double getWidth() {
        return 64;
    }
    
    @Override
    public double getHeight() {
        return 64;
    }
    
    @Override
    public void handleCollision(Player player, Game game) {
        used = true;
        this.renderer = new ImageRenderer("moon-used", this);
        player.setMoon(true);
    }
    
    @Override
    public boolean intersects(Player player) {
        return !used
        && player.getX() - player.getRadius() < this.getX() + this.getWidth() / 2
        && player.getX() + player.getRadius() > this.getX() - this.getWidth() / 2
        && player.getY() - player.getRadius() < this.getY() + this.getHeight() / 2
        && player.getY() + player.getRadius() > this.getY() - this.getHeight() / 2;
    }
}
