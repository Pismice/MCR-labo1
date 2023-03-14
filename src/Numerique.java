import javax.swing.*;
import java.io.IOException;

public class Numerique extends AffichageTemporel{
    Numerique(Chrono c){
        super(c);
        JLabel infos = new JLabel(chrono.getName() + ": " + hour + "h " + min + "m " + sec + "s");
        f.add(infos);
    }

    Numerique(Chrono c, JFrame f){
        super(c);
        this.f = f;
        JLabel infos = new JLabel(chrono.getName() + ": " + hour + "h " + min + "m " + sec + "s");
        this.f.add(infos);
    }
    public void update(){
        super.update();
    }
}
