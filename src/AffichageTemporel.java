import javax.swing.*;
import java.awt.*;

public class AffichageTemporel extends JPanel implements Observer {
    static final int height = 200;
    static final int width = 200;

    final Chrono chrono;
    long sec, min, hour;

    AffichageTemporel(Chrono c) {
        chrono = c;
        this.chrono.attach(this);
        this.setPreferredSize(new Dimension(width, height));
        this.setLayout(new GridBagLayout());
        this.setSize(width, height);
    }


    public void update() {
        long l = chrono.getTime();
        hour = l / 3600;
        min = l / 60;
        sec = l % 60;
    }


}
