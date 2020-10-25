package de.alexander.skilocationtracker.locations;

import de.alexander.skilocationtracker.SkiLocation;
import de.alexander.skilocationtracker.Skilift;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Wieden
 *
 * @author Alexander Niedermayer
 * @version 1.0
 */
@SuppressWarnings("SpellCheckingInspection")
public class Wieden extends SkiLocation {

    private final String openSource = "https://www.skilifte-muenstertal-wieden.de/oeffnungszeiten/betriebein.gif";

    public Wieden() {
        super("Wieden", "https://www.skilifte-muenstertal-wieden.de/preise-oeffungszeiten.php");
    }

    @Override
    public void processHTML(Document doc) {

        Elements tableEntries = doc.select(".table").get(0).select("tbody > tr");

        for (Element tableEntry : tableEntries) {

            Elements tableData = tableEntry.select("td");

            String name      = tableData.get(0).text();
            String type      = "2er Schlepplift";
            String openImage = tableData.get(2).child(0).attr("src");

            boolean open = false;

            if (openImage.equals(openSource)) {
                open = true;
            }

            skilifts.add(new Skilift(name, type, open));


        }

    }

}
