import java.util.Timer;
import java.util.TimerTask;

public class Chrono extends Subject {
    Chrono() {
        id = ++count;
        timer = new Timer();
        time = 0;
        alreadyRunning = false;
        stop = false;
        timerTask = new TimerTask() {
            @Override
            public void run() {
                try {
                    while(!stop) {
                        Thread.sleep(1000);
                        time++;
                        System.out.println("Time : " + time);
                        notifyChrono();
                    }
                } catch (InterruptedException e){
                        throw new RuntimeException(e);
                    }
            }
        };
    }
    static private short count = 0;
    private final int id;
    private Timer timer;
    private long time;
    private Boolean stop;
    private TimerTask timerTask;
    private Boolean alreadyRunning;
    public void demarrer() {
        if(!alreadyRunning){
            alreadyRunning = true;
            timer.schedule(timerTask, 0);
        }
    }
    public void arreter(){
        stop = true;
        timer.cancel();
    }
    public void reinitialiser(){
        arreter();
        setTime(0);
    }
    public long getTime(){ return time; }
    public void setTime(long t){ this.time = t; }
    public int getId() { return id;}
    public String getName(){
        return "Chrono #"+getId();
    }
}
