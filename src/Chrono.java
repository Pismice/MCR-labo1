import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe qui implémente un chrono
 * @author Jérémie Santoro & Théo Coutaudier
 */
public class Chrono extends Subject {
    /**
     * Constructeur du chrono initialise l'id, le timer et la taskPerformer
     */
    Chrono() {
        id = ++count;
        ActionListener taskPerformer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ++time; /* Incrementation du temps puis notif des observateurs */
                notifyObservers();
            }
        };
        int delay = 1000;
        timer = new Timer(delay, taskPerformer);
    }

    static private short count = 0; //nombre de chrono utile pour l'id
    private final int id; //id du chrono
    private final Timer timer; //timer du chrono
    private long time = 0; //temps actuel
    private boolean running = false;

    /**
     * Demarre le timer
     */
    void demarrer() {
        timer.start();
        running = true;
    }

    /**
     * Stop le timer
     */
    void arreter() {
        timer.stop();
        running = false;
    }

    /**
     * Reinitialise le timer
     */
    void reinitialiser() {
        time = 0;
        notifyObservers();
    }

    /**
     * @return le temps actuelle
     */
    long getTime() {
        return time;
    }

    /**
     * @return le nom de l'objet (Chrono #1)
     */
    String getName() {
        return "Chrono #" + id;
    }

    boolean getRunning() {
        return running;
    }
}
