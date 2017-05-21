package averager;

import java.util.ArrayDeque;

/**
 *
 * @author Tim
 */
public class SimpleMovingAverage_Length extends Averager {

    protected ArrayDeque<Item> items = new ArrayDeque<Item>();

    public SimpleMovingAverage_Length(long length) {
        super(length);
    }
    
    public double addItem(double value) {
        if ( (items.size() == length) && length > 0) {
            total = total - items.getFirst().getValue();
            items.removeFirst();
        }
        
        total = total + value;
        items.addLast(new Item(value));
        average = total / items.size();
        return average;
    }
   
}
