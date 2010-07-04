package downloader;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Anurag Sharma, the user
 */
public class DownloaderTask {

    private int count = 0;
    private ArrayList<DownloadListener> listenerList;
    private String identifier;
    private URL urlName;
    private static final int MAX_THREAD_COUNT = 16;
    private int startedThreadCount = 0, finishedThreadCount = 0;
//    private boolean threadsStarted[] = new boolean[16];
//    private boolean threadsFinished[] = new boolean[16];
    public int fileSize = 0, downloadedAmount = 0;
    private Status downloadStatus=Status.SUCCESS;

    public DownloaderTask(URL url, String id, int size) {
        listenerList = new ArrayList<DownloadListener>();
        identifier = id;
        urlName = url;
        fileSize = size;
    }

    public URL getURL() {
        return urlName;
    }

    public String getID() {
        return identifier;
    }

    public int getActiveThreadCount() {
        return count;
    }

    public void notifyStarted(int partNumber) {
        startedThreadCount++;
    }

    public void notifyFinished(int partNumber, Status status) {
        finishedThreadCount++;
        if(status==Status.FAILED)
            downloadStatus=status;
        //check if all Threads have been started and all finished then only notifyListeners
        if (startedThreadCount==MAX_THREAD_COUNT && finishedThreadCount==MAX_THREAD_COUNT) {
            notifyListeners();
        }
    }

    public void addDownloadListener(DownloadListener listener) {
        listenerList.add(listener);
    }

    private void notifyListeners() {
        DownloadEvent event = new DownloadEvent();
        event.ID = identifier;
        event.url = urlName;
        event.status=downloadStatus;
        if(downloadStatus==Status.FAILED)
            System.out.println("Failed to download File. notifying the listeners now...");
        for (DownloadListener listener : listenerList) {
            listener.onDownloadFinish(event);
        }
    }

    public void addToProgress(int count) {
        downloadedAmount += count;
//        System.out.println("+"+downloadedAmount+"="+(int)(100*((float)downloadedAmount)/fileSize));
//        System.out.println("now progress="+getProgress()+"%");
    }

    public int getProgress() {
        return (int) (100 * ((float) downloadedAmount) / fileSize);
    }

    public void removeFromProgress(int counter) {
        downloadedAmount -= counter;
    }
}
