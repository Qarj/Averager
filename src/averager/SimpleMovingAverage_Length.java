package averager;

/**
 *
 * @author Tim
 */
public class SimpleMovingAverage_Length extends Averager {

    public SimpleMovingAverage_Length(long length) {
        super(length);
    }

    @Override
    public double addItem(double value) {
        if ( (items.size() == length) && length > 0) {
            total = total - items.getFirst().getValue();
            items.removeFirst();
        }
        
        total = total + value;
        items.addLast(new item(value));
        average = total / items.size();
        return average;
    }
    
}
