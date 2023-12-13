package com.googlecode.aviator.runtime.type;

/**
 * Collector to collect elements.
 *
 * @param <T>
 * @author dennis(killme2008 @ gmail.com)
 */
public interface Collector {
    void add(Object e);

    Object getRawContainer();
}
