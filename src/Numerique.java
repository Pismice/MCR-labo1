import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Numerique extends AffichageTemporel{

    Numerique(Chrono c){
        super(c);
        infos = new JLabel();
        infos.setText(chrono.getName() + ": " + hour + "h " + min + "m " + sec + "s");
        this.add(infos);
    }
    JLabel infos;
    public void update(){
        super.update();
        infos.setText(chrono.getName() + ": " + hour + "h " + min + "m " + sec + "s");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
