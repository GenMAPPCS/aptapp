/*******************************************************************************
 * Copyright 2010 Alexander Pico
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package apt;

import javax.swing.JProgressBar;

/**
 * Uniformly increments the Progress Bar. It is required in some steps.
 * @author Anurag Sharma
 */
public class UniformIncrementerThread implements Runnable {

    private JProgressBar pbar;
    private int interval;
    private int count;
    private boolean running=false;

    /**
     * creates new object
     * @param bar the Progress bar where the progress is to be displayed
     * @param interval the interval at which the bar is to be updated
     * @param count the number of times the progress is to be increased by 1
     */
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
