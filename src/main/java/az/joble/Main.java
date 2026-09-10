package az.joble;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Main {
    static void main(String[] args) throws Exception {
        String url = "https://az.jooble.org/";

        Document document = Jsoup.connect(url)
                .userAgent("Mozilla/5.0")
                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
                .header("Accept-Language", "az,en;q=0.9")
                .referrer("https://www.google.com/")
                .get();

        System.out.println(document.title());

    }
}
