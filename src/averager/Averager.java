package averager;

import java.util.ArrayDeque;

/**
 *
 * @author Tim
 */
public abstract class Averager {

    protected long length;
    protected double average = 0;
    protected double total = 0;
    
    public Averager (long length)
    {
        if (length < 1) {
            throw new IllegalArgumentException("Length of Averager must be greater than zero");
        }
        this.length = length;

    }

    public double getAverage() {
        return average;
    }
    
}

