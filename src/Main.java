import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        f.setLayout(new FlowLayout(FlowLayout.CENTER));
        f.setSize(800,250);
        Chrono[] chronos = new Chrono[nbChronos];

        // 3. Affichage des options pour CHAQUE chrono
        for(int i = 1; i <= nbChronos; i++) {
            final int id = i;
            chronos[id-1] = new Chrono(); // FIXME: moyen de faire sur meme ligne que tableau ?
            JPanel pnl = new JPanel();
            JLabel name = new JLabel(chronos[id-1].getName());
            JButton start = new JButton("Démarrer");
            start.addActionListener(e -> chronos[id-1].demarrer());
            JButton stop = new JButton("Arrêter");
            stop.addActionListener(e -> chronos[id-1].arreter());
            JButton reset = new JButton("Réinitialiser");
            reset.addActionListener(e -> chronos[id-1].reinitialiser());
            JButton roman = new JButton("Cadran romain");
            roman.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame f = new JFrame();
                    f.add(new CadranRomain(chronos[id-1]));
                    f.pack();
                    f.setVisible(true);
                }
            });
            JButton arab = new JButton("Cadran arabe");
            arab.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame f = new JFrame();
                    f.add(new CadranArabe(chronos[id-1]));
                    f.pack();
                    f.setVisible(true);
                }
            });
            JButton numeric = new JButton("Numérique");
            numeric.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
     JPanel allCtrl = new JPanel();
        JLabel title = new JLabel("Tous les chronos");
        JButton allRoman = new JButton("Cadran romain");
        allRoman.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame allInfos = new JFrame("Tous les chronos romains");
                allInfos.setLayout(new FlowLayout());
                allInfos.setSize(900,500);
                for(int i = 1; i <= nbChronos; i++) {
                    allInfos.add(new CadranRomain(chronos[i-1]));
                }
                allInfos.pack();
                allInfos.revalidate();
                allInfos.setVisible(true);
            }
        });
        JButton allArab = new JButton("Cadran arabe");
        allArab.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame allInfos = new JFrame("Tous les chronos arabes");
                allInfos.setLayout(new FlowLayout());
                allInfos.setSize(900,500);
                for(int i = 1; i <= nbChronos; i++) {
                    allInfos.add(new CadranArabe(chronos[i-1]));
                }
                allInfos.pack();
                allInfos.revalidate();
                allInfos.setVisible(true);
            }
        });
        JButton allNumerique = new JButton("Numérique");
        allNumerique.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame allInfos = new JFrame("Tous les chronos numériques");
                allInfos.setLayout(new FlowLayout());
                allInfos.setSize(900,500);
                for(int i = 1; i <= nbChronos; i++) {
                    allInfos.add(new Numerique(chronos[i-1]));
                }
                allInfos.pack();
                allInfos.revalidate();
                allInfos.setVisible(true);
            }
        });               JFrame f = new JFrame();
                    f.add(new Numerique(chronos[id-1]));
                    f.pack();
                    f.setVisible(true);
                }
            });
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
        JButton allRoman = new JButton("Cadran romain");
        allRoman.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame allInfos = new JFrame("Tous les chronos romains");
                allInfos.setLayout(new FlowLayout());
                for(int i = 1; i <= nbChronos; i++) {
                    allInfos.add(new CadranRomain(chronos[i-1]));
                }
                allInfos.pack();
                allInfos.revalidate();
                allInfos.setVisible(true);
            }
        });
        JButton allArab = new JButton("Cadran arabe");
        allArab.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame allInfos = new JFrame("Tous les chronos arabes");
                allInfos.setLayout(new FlowLayout());
                for(int i = 1; i <= nbChronos; i++) {
                    allInfos.add(new CadranArabe(chronos[i-1]));
                }
                allInfos.pack();
                allInfos.revalidate();
                allInfos.setVisible(true);
            }
        });
        JButton allNumerique = new JButton("Numérique");
        allNumerique.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame allInfos = new JFrame("Tous les chronos numériques");
                allInfos.setLayout(new FlowLayout());
                for(int i = 1; i <= nbChronos; i++) {
                    allInfos.add(new Numerique(chronos[i-1]));
                }
                allInfos.pack();
                allInfos.revalidate();
                allInfos.setVisible(true);
            }
        });
        allCtrl.add(title);
        allCtrl.add(allRoman);
        allCtrl.add(allArab);
        allCtrl.add(allNumerique);

        // 5. Ajout du tout à la JFrame principale
        f.add(allCtrl);
        f.setVisible(true);
    }
}