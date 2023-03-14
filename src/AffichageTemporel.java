import javax.swing.*;
import java.awt.*;

public class AffichageTemporel extends JPanel implements Observer {
    JFrame f;
    static final int height = 200;
    static final int width = 200;

    final Chrono chrono;
    long sec, min, hour;

    AffichageTemporel(Chrono c){
        chrono = c;
        f = new JFrame();
        init();
    }

    AffichageTemporel(Chrono c, JFrame tf) {
        chrono = c;
        f = tf;
        init();
    }

    private void init() {
        this.chrono.attach(this);
        f.setSize(220, 240);
        f.setBackground(Color.BLUE); // FIXME : mettre gris
        f.setLocationRelativeTo(null);
        f.revalidate();
        f.setVisible(true);
    }

    public void update() {
        long l = chrono.getTime();
        hour = l / 3600;
        min = l / 60;
        sec = l % 60;
    }


}
