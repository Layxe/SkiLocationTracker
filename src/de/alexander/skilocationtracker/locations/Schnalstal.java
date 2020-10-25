package de.alexander.skilocationtracker.locations;

import de.alexander.skilocationtracker.SkiLocation;
import de.alexander.skilocationtracker.Skilift;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Schnalstal
 *
 * @author Alexander Niedermayer
 * @version 1.0
 */
public class Schnalstal extends SkiLocation {

    // Need fixed max data because the website only shows the lifts that are currently open
    private static final int MAX_AMOUNT_SKILIFTS = 11;

    public Schnalstal() {
        super("Schnalstal", "https://www.schnalstal.com/de/gletscher/pisteninfo-schneebericht.html");
    }

    @Override
    public int getMaxAmountOfOpenSkiLifts() {
        return MAX_AMOUNT_SKILIFTS;
    }

    @Override
    public void processHTML(Document doc) {

        Elements entries = doc.select("#snowreportlifts > div > div");

        for (Element entry : entries) {

            String statusString = entry.select("div > div > div > div > span").attr("title");
            String name         = entry.select("div > div > div > div").get(0).text();

            boolean open = true;

            if (statusString.equals("geschlossen")) {
                open = false;
            }

            skilifts.add(new Skilift(name, "-", open));

        }

    }

}
