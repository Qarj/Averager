package averager;

import static java.lang.Math.*;
import java.util.ArrayDeque;

/**
 *
 * @author Tim
 */
public class SimpleMovingAverage_Bearing extends Averager {

    protected ArrayDeque<BearingItem> items = new ArrayDeque<BearingItem>();

    public SimpleMovingAverage_Bearing(long length) {
        super(length);
    }
    
    public double addItem(double value) {

        if ( (items.size() == length) && length > 0) {
            double removeValue = items.getFirst().getValue();
            //int removeWeight = items.getFirst().getInvertedWeight()+1;
            if (length == 1) { //Removing a single value leaves us with null, but we put back to 0
                average = 0;
            } else {
                average = (360 + average + removeWeighting(weightedDifference(average, removeValue),length)) % 360;
            }
            items.removeFirst();
            System.out.println("Removed " + removeValue);
            System.out.println("Average after removal " + average + "\n");
        }
        
        int invertedWeight = items.size();
        items.addLast(new BearingItem(value,invertedWeight));

        //double weightedDifference = (((value - average) * invertedWeight)/(invertedWeight+1)+180+360) % 360 - 180;
        average = ( 360 + value + addWeighting( weightedDifference(average, value) , invertedWeight ) ) % 360;
        return average;
    }
   
    private double weightedDifference(double previousAverage, double newValue) {
        //double diff = ((((average - value) * invertedWeight)/(invertedWeight + 1) + 180 + 360) % 360 ) - 180;
        System.out.println(" -> previousAverage["+previousAverage+"] newValue["+newValue+"]");
        double unweightedDiff = (( (previousAverage - newValue + 180 + 360) % 360 ) - 180);
        System.out.println("  unweighted diff: " + unweightedDiff);
        //double diff = unweightedDiff * ( weight / ( weight + 1 ) );
        
        //System.out.println("  diff: " + diff);
        return unweightedDiff;
    }
    
    private double addWeighting(double value, double weight) {
        return value * ( weight / ( weight + 1 ) );
    }

    private double removeWeighting(double value, double weight) {
        return value * ( 1 / ( weight - 1 ) );
    }
}
