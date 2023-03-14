import javax.swing.*;
import java.io.IOException;

public class CadranRomain extends Analogique {
    CadranRomain(Chrono c){
        super(c, "cadran_chiffres_romains.jpg");
    }

    CadranRomain(Chrono c, JFrame f){
        super(c, f, "cadran_chiffres_romains.jpg");
        //this.f = f;
    }
}
