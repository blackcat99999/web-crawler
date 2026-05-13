package crawler;

import org.jsoup.nodes.Document;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WebWorker implements Runnable {
    private String url;
    private CrawlManager manager;
    private List<String> keywords;
    private Map<String, Integer> finalResults;

    public WebWorker(String url, CrawlManager manager, List<String> keywords, Map<String, Integer> finalResults) {
        this.url = url;
        this.manager = manager;
        this.keywords = keywords;
        this.finalResults = finalResults;
    }

    @Override
    public void run() {
        Document doc = PageFetcher.fetchPage(url);
        if (doc != null) {
            System.out.println(Thread.currentThread().getName() + " processing: " + doc.title());

            // 1. Keyword Analysis
            Map<String, Integer> pageStats = WordAnalyzer.analyze(doc.text(), keywords);
            for (String key : keywords) {
                // Synchronize the update to the shared map
                synchronized (finalResults) {
                    finalResults.put(key, finalResults.get(key) + pageStats.get(key));
                }
            }

            // 2. Link Extraction
            Set<String> links = LinkExtractor.extractLinks(doc);
            for (String link : links) {
                manager.addUrl(link);
            }
        }
    }
}