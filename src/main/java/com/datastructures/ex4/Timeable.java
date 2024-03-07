package com.datastructures.ex4;


/**
 * Timeable defines the methods an object must provide to work with Profiler
 *
 */
public interface Timeable {
    /*
     * setup is invoked before the clock starts.
     */
    public void setup(int n);

    /*
     * timeMe does whatever operation we are timing.
     */
    public void timeMe(int n);
}
