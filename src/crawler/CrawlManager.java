package crawler;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class CrawlManager {
    // Thread-safe Queue
    private LinkedBlockingQueue<String> urlQueue = new LinkedBlockingQueue<>();
    // Thread-safe Set (created from a ConcurrentHashMap)
    private Set<String> visitedUrls = ConcurrentHashMap.newKeySet();

    public void addUrl(String url) {
        if (url != null && !url.isEmpty() && !visitedUrls.contains(url)) {
            visitedUrls.add(url);
            urlQueue.add(url);
        }
    }

    public String getNextUrl() {
        // poll() returns null if queue is empty; it doesn't block forever
        return urlQueue.poll();
    }

    public int getVisitedCount() {
        return visitedUrls.size();
    }
    
    public boolean hasWork() {
        return !urlQueue.isEmpty();
    }
}