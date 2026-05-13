package crawler;

import java.util.*;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CrawlManager manager = new CrawlManager();
        List<String> keywords = Arrays.asList("News", "Sport", "Weather", "Climate");
        Map<String, Integer> finalResults = new ConcurrentHashMap<>();
        for (String key : keywords) finalResults.put(key, 0);

        // 1. Create a Thread Pool
        ExecutorService executor = Executors.newFixedThreadPool(10);
        manager.addUrl("https://bbc.co.uk");

        int maxPages = 50;

        // 2. Distribution Loop
        while (manager.getVisitedCount() < maxPages) {
            String url = manager.getNextUrl();
            if (url != null) {
                executor.execute(new WebWorker(url, manager, keywords, finalResults));
            } else {
                // If queue is temporarily empty, wait for workers to find more links
                Thread.sleep(100); 
            }
        }

        // 3. Shutdown
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("\n--- Final Multi-Threaded Results ---");
        finalResults.forEach((word, count) -> System.out.println(word + ": " + count));
    }
}