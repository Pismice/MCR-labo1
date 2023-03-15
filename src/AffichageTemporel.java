import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Class qui implemente l'affichage d'une holroge a travers un JPanel
 * @author Jeremie Santoro & Théo Coutaudier
 */
public class AffichageTemporel extends JPanel implements Observer {
    static private final int height = 200; // Hauteur de la fenetre
    static private final int width = 200; // Largeur de la fenetre
    final Chrono chrono; //Chronometre à rattacher
    long sec, min, hour; //Secondes, Minutes, Heures

    /**
     * Constructeur pour attacher l'objet au chrono et preparer le panel
     *
     * @param c le chrono à rataccher
     */
    AffichageTemporel(Chrono c) {
        chrono = c;
        this.chrono.attach(this); /* Attachement de l'objet au chrono */
        this.setPreferredSize(new Dimension(width, height));
        this.setLayout(new GridBagLayout());
        this.setSize(width, height);
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (c.getRunning()) {
                    c.arreter();
                } else {
                    c.demarrer();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    @Override
    public void update() {
        long l = chrono.getTime();
        hour = l / 3600; /* Calcule et split du temps actuelle */
        min = l / 60;
        sec = l % 60;
    }

    /**
     * detache l'objet du chrono
     */
    void detach() {
        this.chrono.detach(this);
    }


}
