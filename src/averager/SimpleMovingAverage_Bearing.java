package averager;

import java.util.ArrayDeque;

/**
 *
 * @author Tim
 */
public class SimpleMovingAverage_Bearing extends Averager {

    protected ArrayDeque<Item> items = new ArrayDeque<Item>();

    public SimpleMovingAverage_Bearing(long length) {
        super(length);
    }
    
    public double addItem(double value) {

        if ( (items.size() == length) && length > 0) {
            if (length == 1) { //Removing a single value leaves us with null, but we put back to 0
                average = 0;
            } else {
                average = (360 + average + removeWeighting( diff(average, items.getFirst().getValue()), length) ) % 360;
            }
            items.removeFirst();
        }

        average = ( 360 + value + addWeighting( diff(average, value) , items.size() ) ) % 360;

        items.addLast(new Item(value));

        return average;
    }

    protected double diff(double average, double value) {
        return (( (average - value + 180 + 360) % 360 ) - 180);
    }
    
    protected double addWeighting(double value, double weight) {
        return value * ( weight / ( weight + 1 ) );
    }

    protected double removeWeighting(double value, double weight) {
        return value * ( 1 / ( weight - 1 ) );
    }
}
