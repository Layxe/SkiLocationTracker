package de.alexander.skilocationtracker.locations;

import de.alexander.skilocationtracker.SkiLocation;
import de.alexander.skilocationtracker.Skilift;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Wildhaus
 *
 * @author Alexander Niedermayer
 * @version 1.0
 */
@SuppressWarnings("SpellCheckingInspection")
public class Wildhaus extends SkiLocation {

    private final String closedSource = "https://www.wildhaus.ch/typo3conf/ext/template_bergbahn/images/apg/states/7.gif";

    public Wildhaus() {
        super("Wildhaus", "https://www.wildhaus.ch/winter/aktuell/schnee-pistenbericht.html");
    }

    @Override
    public void processHTML(Document doc) {

        Element wrapperElement = doc.select(".resort-groups").get(2);
        Elements entries = wrapperElement.select("div.apg");

        for (Element entry : entries) {

            String name = entry.select("span").text();
            String type = "-";
            String imageSource = entry.select("img").attr("src");

            boolean open = true;

            if (imageSource.equals(closedSource)) {
                open = false;
            }

            skilifts.add(new Skilift(name, type, open));

        }

    }
}
