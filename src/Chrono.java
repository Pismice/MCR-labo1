import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Chrono extends Subject {
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
        timer = new Timer(delay,taskPerformer);
    }
    static private short count = 0;
    private final int id;
    private final Timer timer;
    private long time = 0;

    /**
     * Demarre le timer
     */
    void demarrer() {
        timer.start();
    }

    /**
     * Stop le timer
     */
    void arreter(){
        timer.stop();
    }

    /**
     * Reinitialise le timer
     */
    void reinitialiser(){
        time = 0;
        notifyObservers();
    }

    /**
     *
     * @return le temps actuelle
     */
    long getTime(){ return time; }

    /**
     *
     * @return l'id de l'objet
     */
    private int getId() { return id;}

    /**
     *
     * @return le nom de l'objet (Chrono #1)
     */
    String getName(){
        return "Chrono #"+getId();
    }
}
