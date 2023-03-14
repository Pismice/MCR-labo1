import javax.swing.*;
import java.awt.*;

public class AffichageTemporel extends JPanel implements Observer {
    JFrame f;
    static final int height = 200;
    static final int width = 200;

    final Chrono chrono;
    long sec, min, hour;

    AffichageTemporel(Chrono c, JFrame tf) {
        chrono = c;
        f = tf;
        this.setPreferredSize(new Dimension(width, height));
        this.setSize(width, height);
        f.add(this, BorderLayout.SOUTH);
    }


    public void update() {
        long l = chrono.getTime();
        hour = l / 3600;
        min = l / 60;
        sec = l % 60;
    }


}
