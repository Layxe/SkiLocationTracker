package de.alexander.skilocationtracker;

import de.alexander.skilocationtracker.util.GetRequest;

import java.util.ArrayList;

/**
 * SkiLocation
 *
 * @author Alexander Niedermayer
 * @version 1.0
 */
public abstract class SkiLocation implements SkiLocationInterface {

    // Variables
    // #################################################################################################

    /**
     * Web address for the data scraping
     */

    private final String webAddress;

    /**
     * Name of ski location
     */

    private final String name;

    /**
     * List of ski lifts available in the location
     */

    private ArrayList<Skilift> skilifts = new ArrayList<>();

    private int currentlyOpen = -1;

    // Constructor
    // #################################################################################################

    public SkiLocation(String name, String webAddress) {

        this.name = name;
        this.webAddress = webAddress;
        this.processHTML(getSiteBody());

    }

    // Getter
    // #################################################################################################

    @Override
    public int getAmountOfOpenSkiLifts() {

        // If the amount of open skilifts has not been counted,
        // count them and store the value
        if (currentlyOpen == -1) {

            currentlyOpen = 0;

            for(Skilift skilift : skilifts) {

                if (skilift.isOpen()) {

                    currentlyOpen += 1;

                }

            }

        }

        return currentlyOpen;

    }

    @Override
    public int getMaxAmountOfOpenSkiLifts() {
        return skilifts.size();
    }

    @Override
    public boolean isOpen() {
        return false;
    }

    /**
     * Get the body of the requested site
     * @return body of the page
     */

    private String getSiteBody() {

        return new GetRequest(this.webAddress).getBody();

    }

    public String getName() {
        return this.name;
    }

}
