package de.alexander.skilocationtracker;

import org.jsoup.nodes.Document;

/**
 * Interface for every ski location that will be implemented
 *
 * @author Alexander Niedermayer
 * @version 1.0
 */
public interface SkiLocationInterface {

    /**
     * Get the amount of ski lifts that are currently open
     * @return Ski lifts that are currently open
     */

    int getAmountOfOpenSkiLifts();

    /**
     * Get the total amount of ski lifts in this location
     * @return Total amount of ski lifts
     */

    int getMaxAmountOfOpenSkiLifts();

    /**
     * Get if a ski location is currently opened
     * @return returns true if it is open
     */

    boolean isOpen();

    /**
     * Get the name of the ski location
     * @return Name of ski location
     */

    String getName();

    /**
     * Process the HTML of the page, add the resulting skilifts in the skilifts array
     * @param body HTML Body
     */

    void processHTML(Document doc);

}
