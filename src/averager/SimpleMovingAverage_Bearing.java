package averager;

import static java.lang.Math.*;
import java.util.ArrayDeque;

/**
 *
 * @author Tim
 */
public class SimpleMovingAverage_Bearing extends Averager {

    protected ArrayDeque<CoordItem> items = new ArrayDeque<CoordItem>();
    
    private double xTotal;
    private double yTotal;

    public SimpleMovingAverage_Bearing(long length) {
        super(length);
    }
    
    public double addItem(double value) {
        // value is bearing in degrees
        final double radians = Math.toRadians(value);

        if ( (items.size() == length) && length > 0) {
            xTotal = xTotal - items.getFirst().getX();
            yTotal = yTotal - items.getFirst().getY();
            items.removeFirst();
        }
        
        final double x = cos(radians);
        final double y = sin(radians);
        xTotal = xTotal + x;
        yTotal = yTotal + y;
        items.addLast(new CoordItem(x,y));
        average = Math.toDegrees(atan2(yTotal, xTotal));
        //average = Math.toDegrees(atan2(yTotal/items.size(), xTotal/items.size()));
        return average;
    }
   
}
