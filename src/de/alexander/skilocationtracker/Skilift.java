package de.alexander.skilocationtracker;

/**
 * Skilift
 *
 * @author Alexander Niedermayer
 * @version 1.0
 */
public class Skilift implements SkiliftInterface {

    // Variables
    // #################################################################################################

    private final String name;
    private final String type;
    private boolean open;

    // Constructor
    // #################################################################################################

    /**
     * Create a new skilift
     * @param name Name of the skilift
     * @param type Type of the skilift
     * @param open If the skilift is currently open
     */

    public Skilift(String name, String type, boolean open) {

        this.name = name;
        this.type = type;
        this.open = open;

    }

    // Getter
    // #################################################################################################

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public boolean isOpen() {
        return this.open;
    }

    @Override
    public String toString() {
        return "Skilift{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", open=" + open +
                '}';
    }
}
