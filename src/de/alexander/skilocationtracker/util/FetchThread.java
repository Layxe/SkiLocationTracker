package de.alexander.skilocationtracker.util;

import de.alexander.skilocationtracker.SkiLocation;

/**
 * FetchThread
 *
 * @author Alexander Niedermayer
 * @version 1.0
 */
public class FetchThread implements Runnable {

    private SkiLocation skiLocation;

    public FetchThread(SkiLocation skiLocation) {
        this.skiLocation = skiLocation;
    }

    @Override
    public void run() {
        System.out.println("Start fetching data for " + skiLocation.getName() + "...");
        this.skiLocation.fetchData();
        System.out.println("Finished fetching data for " + skiLocation.getName() + "!");
    }

}
