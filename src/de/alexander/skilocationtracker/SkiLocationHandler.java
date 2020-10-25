package de.alexander.skilocationtracker;

import de.alexander.skilocationtracker.locations.Feldberg;
import de.alexander.skilocationtracker.locations.Schnalstal;
import de.alexander.skilocationtracker.locations.Wieden;
import de.alexander.skilocationtracker.locations.Wildhaus;
import de.alexander.skilocationtracker.util.FetchThread;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * SkiLocationHandler
 *
 * @author Alexander Niedermayer
 * @version 1.0
 */
public class SkiLocationHandler {

    private ArrayList<SkiLocation> skiLocations = new ArrayList<>();

    public SkiLocationHandler() {

        skiLocations.add(new Feldberg());
        skiLocations.add(new Schnalstal());
        skiLocations.add(new Wieden());
        skiLocations.add(new Wildhaus());

        ThreadPoolExecutor es = (ThreadPoolExecutor) Executors.newFixedThreadPool(skiLocations.size());

        for (SkiLocation location : skiLocations) {
            es.execute(new FetchThread(location));
        }

        es.shutdown();

        try {
            es.awaitTermination(15, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("Couldn't gather all data!");
        }

    }

    public void printData() {

        for (int i = 0; i < 4; i++)
            System.out.println();

        System.out.println("### Skigebiete ########################################");

        for (SkiLocation location : this.skiLocations) {

            if (location.finishedFetching()) {

                if (location.isOpen()) {
                    System.out.print("✔\t");
                } else {
                    System.out.print("❌\t");
                }

                System.out.printf("%-40s %d / %d \n", location.getName() + ":", location.getAmountOfOpenSkiLifts(), location.getMaxAmountOfOpenSkiLifts());
            }

        }

        System.out.println("#######################################################");

    }

}
