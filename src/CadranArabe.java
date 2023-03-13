import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class CadranArabe extends Analogique{
    CadranArabe(Chrono c) {
        super(c);
        new JFrame();
        new JFrame();
        System.out.println("Test2");
        try {
            BufferedImage image = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("cadran_chiffres_arabes.jpg")));
            image.getGraphics().drawImage(image, 200, 200, null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
