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
    void notify(Observer o){
        if (o == null)
            throw new RuntimeException("Invalid parameter transmitted");
        setChanged();
        notifyObservers(o);
    }
    private void setChanged(){
        changed = true;
    }
    private boolean hasChanged(){
        return changed;
    }
    private void clearChanged(){
        changed = false;
    }
    private void notifyObservers(Observer o){
        if (o == null)
            throw new RuntimeException("Invalid parameter transmitted");
        if(hasChanged()){
            for(Observer ob : observerList){
                ob.update();
            }
            clearChanged();
        }
    }
}
