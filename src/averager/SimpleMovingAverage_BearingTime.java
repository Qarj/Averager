package averager;

import java.util.ArrayDeque;

/**
 *
 * @author Tim
 */
public class SimpleMovingAverage_BearingTime extends SimpleMovingAverage_Bearing {

    protected ArrayDeque<TimeItem> items = new ArrayDeque<TimeItem>();

    public SimpleMovingAverage_BearingTime(long length) {
        super(length);
    }
    
    public double addItem(double value, long time) {

        while (items.size() > 0 && (time - items.getFirst().getTime() > length) ) {
            if (items.size() == 1) { //Removing a single value leaves us with null, but we put back to 0
                average = 0;
            } else {
                average = (360 + average + removeWeighting( diff(average, items.getFirst().getValue()), length) ) % 360;
            }
            items.removeFirst();
        }

        average = ( 360 + value + addWeighting( diff(average, value) , items.size() ) ) % 360;

        items.addLast(new TimeItem(value, time));

        return average;
    }

}
