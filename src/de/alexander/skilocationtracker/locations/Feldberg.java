package de.alexander.skilocationtracker.locations;

import de.alexander.skilocationtracker.SkiLocation;
import de.alexander.skilocationtracker.Skilift;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Feldberg
 *
 * @author Alexander Niedermayer
 * @version 1.0
 */
public class Feldberg extends SkiLocation {

    private String closedSource = "/extension/lissnowreport/design/standard/images/lissnowreport_icon-0.png";
    private String openSource = "/extension/lissnowreport/design/standard/images/lissnowreport_icon-1.png";

    public Feldberg() {
        super("Feldberg", "https://www.liftverbund-feldberg.de/Schneebericht/Schneebericht-Liftverbund-Feldberg");
    }

    @Override
    public void processHTML(Document doc) {

        Elements tableEntries = doc.select("#lifte > table > tbody > tr");

        for (Element tableEntry : tableEntries) {

            Elements tableData = tableEntry.select("td");

            String openImage = tableData.get(0).child(0).attr("src");
            String name      = tableData.get(1).text();
            String type      = tableData.get(2).text();

            boolean open = false;

            if (openImage.equals(openSource)) {
                open = true;
            }

            skilifts.add(new Skilift(name, type, open));

        }

    }
}
