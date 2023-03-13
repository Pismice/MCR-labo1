import javax.swing.*;
import java.io.IOException;

public class Numerique extends AffichageTemporel{
    Numerique(Chrono c){
        super(c);
        JLabel infos = new JLabel("Chrono #" + c.getId() + ": " + hour + "h " + min + "m " + sec + "s");
        f.add(infos);
    }
    public void update(){
        super.update();
    }
}
