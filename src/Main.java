import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.security.InvalidParameterException;

public class Main {
    static JFrame f; // frame principale du programme

    public static void main(String[] args) {
        // 1. Récupération du nombre de chronos à lancer
        final int chronosMax = 9;
        final int chronosMin = 1;
        int nbChronos = Integer.parseInt(args[0]);
        if (nbChronos > chronosMax || nbChronos < chronosMin) {
            throw new InvalidParameterException("Le nombre de chronos (passé en paramètre) doit être supérieur à " + chronosMin + " et inférieur à " + chronosMax + "!");
        }

        // 2. Création de la fenêtre de base
        f = new JFrame("Panneau de contrôle");
        f.setLayout(new FlowLayout(FlowLayout.RIGHT));
        f.setResizable(false);
        f.setSize(700, 60 * (nbChronos + 1));
        Chrono[] chronos = new Chrono[nbChronos];

        // 3. Affichage des options pour CHAQUE chrono
        for (int i = 0; i < nbChronos; i++) {
            final int id = i;
            chronos[id] = new Chrono();
            JPanel pnl = new JPanel();
            JLabel name = new JLabel(chronos[id].getName());
            JButton start = new JButton("Démarrer");
            start.addActionListener(e -> chronos[id].demarrer());
            JButton stop = new JButton("Arrêter");
            stop.addActionListener(e -> chronos[id].arreter());
            JButton reset = new JButton("Réinitialiser");
            reset.addActionListener(e -> chronos[id].reinitialiser());
            JButton roman = new JButton("Cadran romain");
            roman.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame f = new JFrame();
                    CadranRomain cr = new CadranRomain(chronos[id]);
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
                    CadranArabe ca = new CadranArabe(chronos[id]);
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
                    Numerique nu = new Numerique(chronos[id]);
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
                allInfos.setSize(900, 500);
                CadranRomain[] crtab = new CadranRomain[nbChronos];
                for (int i = 0; i < nbChronos; i++) {
                    crtab[i] = new CadranRomain(chronos[i]);
                    allInfos.add(crtab[i]);
                }
                allInfos.pack();
                allInfos.revalidate();
                allInfos.setVisible(true);
                allInfos.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        super.windowClosing(e);
                        for (int i = 0; i < nbChronos; i++) {
                            crtab[i].detach();
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
                allInfos.setSize(900, 500);
                CadranArabe[] catab = new CadranArabe[nbChronos];
                for (int i = 0; i < nbChronos; i++) {
                    catab[i] = new CadranArabe(chronos[i]);
                    allInfos.add(catab[i]);
                }
                allInfos.pack();
                allInfos.revalidate();
                allInfos.setVisible(true);
                allInfos.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        super.windowClosing(e);
                        for (int i = 0; i < nbChronos; i++) {
                            catab[i].detach();
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
                allInfos.setSize(900, 500);
                Numerique[] nutab = new Numerique[nbChronos];
                for (int i = 0; i < nbChronos; i++) {
                    nutab[i] = new Numerique(chronos[i]);
                    allInfos.add(nutab[i]);
                }
                allInfos.pack();
                allInfos.revalidate();
                allInfos.setVisible(true);
                allInfos.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        super.windowClosing(e);
                        for (int i = 0; i < nbChronos; i++) {
                            nutab[i].detach();
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