package de.alexander.skilocationtracker;

/**
 * Skilift
 *
 * @author Alexander Niedermayer
 * @version 1.0
 */
public interface SkiliftInterface {

    /**
     * Get the name of the ski lift
     * @return Name of the ski lift
     */

    String getName();

    /**
     * Get the type of the ski lift
     * @return Type of the ski lift
     */

    String getType();

    /**
     * Get if the ski lift is currently open
     * @return true if open
     */

    boolean isOpen();

}
