package crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class PageFetcher {

    public static Document fetchPage(String url) {

        try {
            return Jsoup.connect(url).get();

        } catch (Exception e) {

            System.out.println("Failed to fetch: " + url);

            return null;
        }
    }
}
