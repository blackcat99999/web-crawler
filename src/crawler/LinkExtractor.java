package crawler;

import java.util.HashSet;
import java.util.Set;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LinkExtractor {

    public static Set<String> extractLinks(Document document) {

        Set<String> linksSet = new HashSet<>();

        Elements links = document.select("a[href]");

        for (Element link : links) {

            String absUrl = link.attr("abs:href");

            if (!absUrl.isEmpty()) {

                linksSet.add(absUrl);
            }
        }

        return linksSet;
    }
}
