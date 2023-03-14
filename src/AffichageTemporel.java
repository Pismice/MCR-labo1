import javax.swing.*;
import java.awt.*;

public class AffichageTemporel extends JPanel implements Observer {
    static JFrame f;
    static final int height = 200;
    static final int width = 200;

    final Chrono chrono;
    long sec, min, hour;

    AffichageTemporel(Chrono c){
        this.chrono = c;
        this.chrono.attach(this);
        f = new JFrame();

    }

    public void update() {
        long l = chrono.getTime();
        hour = l / 3600;
        min = l / 60;
        sec = l % 60;
    }


}
