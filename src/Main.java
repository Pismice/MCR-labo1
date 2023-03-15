import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
        f.setLayout(new FlowLayout(FlowLayout.RIGHT));
        f.setResizable(false);
        f.setSize(700,60 * (nbChronos+1));
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
                    CadranRomain cr = new CadranRomain(chronos[id-1]);
                    f.add(cr);
                    f.pack();
                    f.setVisible(true);
                    f.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent e) {
                            super.windowClosing(e);
                            cr.detach();
                        }
                    });
                }
            });
            JButton arab = new JButton("Cadran arabe");
            arab.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame f = new JFrame();
                    CadranArabe ca = new CadranArabe(chronos[id - 1]);
                    f.add(ca);
                    f.pack();
                    f.setVisible(true);
                    f.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent e) {
                            super.windowClosing(e);
                            ca.detach();
                            }
                        }
                    );
                }
            });
            JButton numeric = new JButton("Numérique");
            numeric.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame f = new JFrame();
                    Numerique nu = new Numerique(chronos[id-1]);
                    f.add(nu);
                    f.pack();
                    f.setVisible(true);
                    f.addWindowListener(new WindowAdapter() {
                         @Override
                         public void windowClosing(WindowEvent e) {
                             super.windowClosing(e);
                             nu.detach();
                             }
                        }
                    );
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
                    allInfos.setSize(900,500);
                    CadranRomain[] crtab = new CadranRomain[nbChronos];
                    for(int i = 1; i <= nbChronos; i++) {
                        crtab[i-1] = new CadranRomain(chronos[i-1]);
                        allInfos.add(crtab[i-1]);
                    }
                    allInfos.pack();
                    allInfos.revalidate();
                    allInfos.setVisible(true);
                    allInfos.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent e) {
                            super.windowClosing(e);
                            for (int i = 1; i <= nbChronos; i++){
                                crtab[i-1].detach();
                            }
                        }
                    });
                }
            });
            JButton allArab = new JButton("Cadran arabe");
            allArab.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame allInfos = new JFrame("Tous les chronos arabes");
                    allInfos.setLayout(new FlowLayout());
                    allInfos.setSize(900,500);
                    CadranArabe[] catab = new CadranArabe[nbChronos];
                    for(int i = 1; i <= nbChronos; i++) {
                        catab[i-1] = new CadranArabe(chronos[i-1]);
                        allInfos.add(catab[i-1]);
                    }
                    allInfos.pack();
                    allInfos.revalidate();
                    allInfos.setVisible(true);
                    allInfos.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent e) {
                            super.windowClosing(e);
                            for (int i = 1; i <= nbChronos; i++){
                                catab[i-1].detach();
                            }
                        }
                    });
                }
            });
            JButton allNumerique = new JButton("Numérique");
            allNumerique.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame allInfos = new JFrame("Tous les chronos numériques");
                    allInfos.setLayout(new FlowLayout());
                    allInfos.setSize(900,500);
                    Numerique[] nutab = new Numerique[nbChronos];
                    for(int i = 1; i <= nbChronos; i++) {
                        nutab[i-1] = new Numerique(chronos[i-1]);
                        allInfos.add(nutab[i-1]);
                    }
                    allInfos.pack();
                    allInfos.revalidate();
                    allInfos.setVisible(true);
                    allInfos.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent e) {
                            super.windowClosing(e);
                            for (int i = 1; i <= nbChronos; i++){
                                nutab[i-1].detach();
                            }
                        }
                    });
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