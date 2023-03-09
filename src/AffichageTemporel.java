import javax.swing.*;

public class AffichageTemporel extends JFrame implements Observer {
    static JFrame f;
    AffichageTemporel(Chrono c){
        this.chrono = c;
    }
    private final Chrono chrono;
    private long sec, min, hour;
    public void update() {
        long l = chrono.getTime();
        hour = l / 3600;
        min = l / 60;
        sec = l % 60;
    }

}
