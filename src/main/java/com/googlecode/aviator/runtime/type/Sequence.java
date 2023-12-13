package com.googlecode.aviator.runtime.type;

/**
 * Sequence mark interface.
 *
 * @param <T>
 * @author dennis(killme2008 @ gmail.com)
 */
public interface Sequence<T> extends Iterable<T> {
    Collector newCollector(int size);

    int hintSize();
}
