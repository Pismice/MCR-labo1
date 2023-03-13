import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImagingOpException;
import java.io.IOException;

public class AffichageTemporel extends JFrame implements Observer {
    static JFrame f;
    AffichageTemporel(Chrono c) throws IOException {
        this.chrono = c;
        f = new JFrame();
        f.setSize(200, 200);
        f.setVisible(true);
        System.out.println("Test");


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
