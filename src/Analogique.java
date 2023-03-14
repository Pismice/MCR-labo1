import java.awt.*;

public class Analogique extends AffichageTemporel{

    Analogique(Chrono c, String filename){
        super(c);
        image = Toolkit.getDefaultToolkit().getImage(filename);
        image = image.getScaledInstance(200, 200, Image.SCALE_AREA_AVERAGING);
        f.setSize(220, 240);
        f.setLocationRelativeTo(null);
        f.add(this);
        f.revalidate();
        f.setVisible(true);
        System.out.println("TEST 2");
    }
    Image image;
    @Override
    public void update(){
        super.update();
        repaint();
    }

    @Override
   public void paintComponent(Graphics g){
        g.drawImage(image, 0, 0, this);
        g.drawString(chrono.getName(), 75,100);
    }
}
