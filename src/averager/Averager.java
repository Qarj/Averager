package averager;

import java.util.ArrayDeque;

/**
 *
 * @author Tim
 */
public abstract class Averager {

    class item {
        private double value;
        
        public item (double value) {
            this.value = value;
        }
        
        public double getValue () {
            return this.value;
        }
       
    }   
    
    protected long length;
    protected double average = 0;
    protected double total = 0;
    protected ArrayDeque<item> items = new ArrayDeque<item>();
    
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

    public abstract double addItem(double value);
    
}

