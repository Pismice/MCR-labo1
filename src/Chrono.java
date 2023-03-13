import java.util.Timer;
import java.util.TimerTask;

public class Chrono extends Subject {
    Chrono() {
        name = "Chrono #"+count++;
        timer = new Timer();
        time = 0;
        timerTask = new TimerTask() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    time++;
                    notify();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }
    static private short count = 0;
    private String name;
    private Timer timer;
    private long time;
    private TimerTask timerTask;
    public void demarrer() { timer.schedule(timerTask, 0); }
    public void arreter(){ timer.cancel(); }
    public void reinitialiser(){
        arreter();
        setTime(0);
    }
    public long getTime(){ return time; }
    public void setTime(long t){ time = t; }
}
