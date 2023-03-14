import java.util.LinkedList;

public class Subject {

    Subject(){
        observerList = new LinkedList<Observer>();
        changed = false;
    }
    LinkedList<Observer> observerList;
    boolean changed;
    void attach(Observer o){
        if (o == null)
            throw new RuntimeException("Invalid parameter transmitted");
        observerList.add(o);
    }
    void detach(Observer o){
        if (o == null)
            throw new RuntimeException("Invalid parameter transmitted");
        observerList.remove(o);
    }
   void notifyChrono(){
        setChanged();
        notifyObservers();
    }
    private void setChanged(){
        changed = true;
    }
    boolean hasChanged(){
        return changed;
    }
    private void clearChanged(){
        changed = false;
    }
    private void notifyObservers(){
        if(hasChanged()){
            for(Observer ob : observerList){
                ob.update();
            }
            clearChanged();
        }
    }
}
