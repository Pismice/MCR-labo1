import java.util.LinkedList;

/**
 * Classe qui contient les informations qui seront écoutées
 * @author Jérémie Santoro & Théo Coutaudier
 */
public class Subject {
    /**
     * Constructeur, création de la liste d'observeur
     */
    Subject() {
        observerList = new LinkedList<>();
    }

    private final LinkedList<Observer> observerList; //Liste content tout les observeurs ratacher au Sujet

    /**
     * Ajoute l'observer à la liste d'observeur
     *
     * @param o l'observeur à attacher
     */
    void attach(Observer o) {
        if (o == null)
            throw new RuntimeException("Invalid parameter transmitted");
        observerList.add(o);
    }

    /**
     * Supprimer l'observeur de la liste d'observeur
     *
     * @param o l'observeur à attacher
     */
    void detach(Observer o) {
        if (o == null)
            throw new RuntimeException("Invalid parameter transmitted");
        observerList.remove(o);
    }

    /**
     * Averti tout les observeur du changement
     */
    void notifyObservers() {
        for (Observer ob : observerList) {
            ob.update();
        }
    }
}
