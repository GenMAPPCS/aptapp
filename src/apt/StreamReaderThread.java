/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apt;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.JEditorPane;
import javax.swing.JProgressBar;

/**
 *
 * @author user
 */
public class StreamReaderThread implements Runnable {

    private Thread thread;
    private InputStream stream;
    private JEditorPane commandPane;
    private JProgressBar pbar;
    private UniformIncrementerThread incrementerThread = null;
    private String commandPaneText = null;
    private String outputDirectory;

    public StreamReaderThread(JEditorPane pane, JProgressBar bar, InputStream is, String outputDirectory) {
        stream = is;
        commandPane = pane;
        pbar = bar;
        thread = new Thread(this);
        commandPaneText = "";//pane.getText(); //uncomment this for not clearing up the output screen
        this.outputDirectory = outputDirectory;
    }

    public void start() {
        thread.start();
    }

    public void run() {
//        Scanner sc = new Scanner(stream);
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

        int ch = 0;

        //character by character output code
        try {
            String str = "";
            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
                commandPaneText += (char) ch;
                commandPane.setText(commandPaneText);

                if (str.startsWith("Processing Probesets..") && ch == '.') {
                    pbar.setValue(pbar.getValue() + 2);
                }

                if (ch == '\n') {
                    setProgressFor(str);
                    str = "";
                } else {
                    str += (char) ch;
                }
            }

            commandPaneText += "Results saved to " + outputDirectory;
            commandPane.setText(commandPaneText);

        } catch (Exception e) {
            System.out.println("Error while reading output from APT");
            e.printStackTrace();
        }

        //line by line output code.
        //        while (sc.hasNextLine()) {
//            String line = sc.nextLine();
//            System.out.println(line);
//
//            if (commandPane.getText().equals("")) {
//                commandPane.setText(line);
//            } else {
//                commandPane.setText(commandPane.getText() + "\n" + line);
//            }
//        }
    }

    //sets the 'approximate' progress level as indicated in "ProgressBar-equation.xls" from Nathan
    private void setProgressFor(String str) {
        if (str.contains("Opening pgf file")) {
            pbar.setValue(10);
            incrementerThread = new UniformIncrementerThread(pbar, 1000, 15);
            incrementerThread.start();
        } else if (str.contains("Reading") && str.contains("cel files")) {

            if (incrementerThread != null) {
                incrementerThread.stop();
            }

            if (str.contains("Done.")) {
                pbar.setValue(50);
            } else {
                pbar.setValue(30);
                incrementerThread.set(1000, 15);
                incrementerThread.start();
            }
        } else if (str.equals("Processing Probesets")) {
            pbar.setValue(55);
        } else if (str.contains("Run took approximately")) {
            pbar.setValue(100);
        } //now for cdf processing
        else if (str.contains("celfiles.txt")) {
            pbar.setValue(2);
        } else if (str.contains("Reading") && str.contains("Done")) {
            if (str.contains("probesets")) {
                pbar.setValue(10);
            } else if (str.contains("and pre-processing")) {
                pbar.setValue(30);
            }
        } else if (str.contains("Computing sketch normalization")) {
            pbar.setValue(50);
        } else if (str.contains("Applying sketch normalization to")) {
            pbar.setValue(70);
        }

    }
}
