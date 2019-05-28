package colorswitch;

/**
 * Colors Witch
 * @auteure: Cupcea Aliona 
 * @date: 2018/04/27
 * @NomDuFichier: GrowingCircle.java
 *
 *                Obstacle : un cercle qui grossit et retrecit avec le temps et
 *                dont la couleur change a toutes les 2 secondes.
 */
public class GrowingCircle extends Obstacle {

    private double radius;
    private double vr = 50;
    private double timeSinceColorChange = 0;
    private double maxRadius;
    private double minRadius;
    
    public GrowingCircle(double x, double y, double rayon, double largeurEcran) {
        super(x, y);
        
        this.radius = rayon;
        
        this.renderer = new GrowingCircleRenderer(this);
        this.maxRadius = largeurEcran/4;
        this.minRadius = 20;
        
        this.color = (int) (Math.random() * 4);
    }
    
    public double getRadius() {
        return radius;
    }
    
    @Override
    public double getHeight() {
        return radius * 2;
    }
    
    @Override
    public double getWidth() {
        return radius * 2;
    }
    
    /**
     * Fonction appelee a chaque frame pour mettre a jour les attributs de
     * l'obstacle
     *
     * @param dt Delta-Temps en secondes
     */
    @Override
    public void tick(double dt) {
        // Mise a jour du rayon
        double newRadius = radius + dt * vr;
        
        // Atteint une grosseur maximale ou minimale
        if (newRadius > maxRadius || newRadius < minRadius) {
            vr *= -1;
        } else {
            radius = newRadius;
        }
        
        // Changement de couleur
        timeSinceColorChange += dt;
        
        if (timeSinceColorChange > 2) {
            color = (color + 1) % 4;
            timeSinceColorChange = 0;
        }
    }
    
    public int getColor() {
        return color;
    }
    
    @Override
    public boolean intersects(Player player) {
        if (player.getShield() == true) {
            return false;
        } else {
            return this.color != player.getColor()
                && player.getX() - player.getRadius() < this.getX() + this.getRadius()
                && player.getX() + player.getRadius() > this.getX() - this.getRadius()
                && player.getY() - player.getRadius() < this.getY() + this.getRadius()
                && player.getY() + player.getRadius() > this.getY() - this.getRadius();
        }
    }
}
