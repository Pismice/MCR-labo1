import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Chrono extends Subject {
    Chrono() {
        id = ++count;
        ActionListener taskPerformer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ++time;
                notifyChrono();
            }
        };
        timer = new Timer(delay,taskPerformer);
    }
    static private short count = 0;
    static private int delay = 1000;
    private final int id;
    private Timer timer;
    private long time = 0;
    public void demarrer() {
        timer.start();
    }
    public void arreter(){
        timer.stop();
    }
    public void reinitialiser(){
        time = 0;
        notifyChrono();
    }
    public long getTime(){ return time; }
    public int getId() { return id;}
    public String getName(){
        return "Chrono #"+getId();
    }
}
