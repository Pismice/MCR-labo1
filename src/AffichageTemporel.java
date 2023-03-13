import javax.swing.*;

public class AffichageTemporel implements Observer {
    static JFrame f;
    static final int height = 200;
    static final int width = 200;

    private final Chrono chrono;
    long sec, min, hour;

    AffichageTemporel(Chrono c){
        this.chrono = c;
        f = new JFrame();
        f.setSize(width,height);
        f.setVisible(true);
        System.out.println("Test");
    }

    public void update() {
        long l = chrono.getTime();
        hour = l / 3600;
        min = l / 60;
        sec = l % 60;
    }

}
