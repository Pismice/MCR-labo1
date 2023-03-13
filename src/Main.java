import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.InvalidParameterException;

public class Main{
    static JFrame f;
    public static void main(String[] args) {
        // 1. Récupération du nombre de chronos à lancer
        final int chronosMax = 9;
        final int chronosMin = 1;
        int nbChronos = Integer.parseInt(args[0]);
        if(nbChronos > chronosMax || nbChronos < chronosMin) {
            throw new InvalidParameterException("Le nombre de chronos (passé en paramètre) doit être supérieur à " + chronosMin + " et inférieur à " + chronosMax + "!");
        }

        // 2. Création de la fenêtre de base
        f = new JFrame("Panneau de contrôle");
        f.setLayout(new FlowLayout());
        f.setSize(900,500);
        Chrono[] chronos = new Chrono[nbChronos];

        // 3. Affichage des options pour CHAQUE chrono
        for(int i = 1; i <= nbChronos; i++) {
            final int id = i;
            JPanel pnl = new JPanel();
            JLabel name = new JLabel("Chrono #" + i);
            JButton start = new JButton("Démarrer");
            start.addActionListener(e -> chronos[id-1].demarrer());
            JButton stop = new JButton("Arrêter");
            stop.addActionListener(e -> chronos[id-1].arreter());
            JButton reset = new JButton("Réinitialiser");
            stop.addActionListener(e -> chronos[id-1].reinitialiser());
            JButton roman = new JButton("Cadran romain");
            JButton arab = new JButton("Cadran arabe");
            JButton numeric = new JButton("Numérique");
            pnl.add(name);
            pnl.add(start);
            pnl.add(stop);
            pnl.add(reset);
            pnl.add(roman);
            pnl.add(arab);
            pnl.add(numeric);
            f.add(pnl);
        }


        // 4. Affichage des options pour intéragir avec TOUS les chronos
        JPanel allCtrl = new JPanel();
        JLabel title = new JLabel("Tous les chronos");
        JButton allRoman = new JButton("Cadre romain");
        JButton allArab = new JButton("Cadre arabe");
        JButton allNumerique = new JButton("Numérique");
        allCtrl.add(title);
        allCtrl.add(allRoman);
        allCtrl.add(allArab);
        allCtrl.add(allNumerique);

        // 5. Ajout du tout à la JFrame principale
        f.add(allCtrl);
        f.setBackground(Color.blue);
        f.setVisible(true);
    }
}