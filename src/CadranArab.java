import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class CadranArab extends Analogique{
    CadranArab(Chrono c) throws IOException {
        super(c);
        new JFrame();
        new JFrame();
        System.out.println("Test2");
        BufferedImage image = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("cadran_chiffres_arabes.jpg")));
        image.getGraphics().drawImage(image, 200, 200, null);
    }
}
