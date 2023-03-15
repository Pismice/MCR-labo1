import java.awt.*;

public class Analogique extends AffichageTemporel{
    /**
     * Constructeur qui ajoute l'initialisation de l'image
     * @param c
     * @param filename
     */
    Analogique(Chrono c,String filename){
        super(c);
        image = Toolkit.getDefaultToolkit().getImage(filename).getScaledInstance(200, 200, Image.SCALE_AREA_AVERAGING);
        update();
    }
    private final Image image; //Image de l'horloge
    @Override
    public void update(){
        super.update();
        repaint();
    }
    @Override
    public void paintComponent(Graphics g){
        g.drawImage(image, 0, 0, this); /* Dessin de l'image */
        g.drawString(chrono.getName(), 75,100); /* Dessin du texte */
        drawAiguille(g, Color.red, sec * 6, 70, 2); /* Dessin des aguilles */
        drawAiguille(g, Color.blue, min * 6, 50, 4);
        drawAiguille(g, Color.black, hour * 30, 30, 6);
    }

    /**
     * Dessine les aiguille de l'horloge et calcule oû les placer
     * @param g le graphics sur le quel dessiner
     * @param c la couleur de l'aiguille
     * @param a l'angle de l'aiguille (en degrés)
     * @param lo la longeur de l'aiguille
     * @param la la largeur de l'aiguille
     */
    private void drawAiguille(Graphics g, Color c, double a, int lo, int la){
        int coord = 105; /* se place au centre */
        a %= 360;
        a *= Math.PI / 180; /* Conversion radiant */
        double  x = Math.sin(a)*lo, /* Ajustement avec la longueur */
                y = -Math.cos(a)*lo;
        g.setColor(c);
        ((Graphics2D)g).setStroke(new BasicStroke(la));
        g.drawLine(coord, coord,(int) x+coord,(int) y+coord); /* Dessin de la ligne en fonction des coordonnes */
    }
}
