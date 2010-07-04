/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apt;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;

/**
 *
 * @author Anurag Sharma, the user
 */
public class UniformIncrementerThread implements Runnable {

    private JProgressBar pbar;
    private int interval;
    private int count;
    private boolean running=false;

    public UniformIncrementerThread(JProgressBar bar, int interval, int count) {
        pbar = bar;
        this.interval = interval;
        this.count = count;
    }

    public void set(int interval,int count)
    {
        this.interval=interval;
        this.count=count;
    }

    public void start() {
        if (running) {
            return;
        }

        Thread t = new Thread(this);
        running = true;
        t.start();
    }

    public void stop() {
        running = false;
    }

    public void run() {
        for (int i = 0; running && i < count; i++) {
            pbar.setValue(pbar.getValue() + 1);
            try {
                Thread.sleep(interval);
            } catch (InterruptedException ex) {
            }
        }
    }
}
