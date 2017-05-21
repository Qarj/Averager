/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package averager;

import java.util.ArrayDeque;

/**
 *
 * @author Tim
 */
public class SimpleMovingAverage_Time extends Averager {

    protected ArrayDeque<TimeItem> items = new ArrayDeque<TimeItem>();

    public SimpleMovingAverage_Time(long length) {
        super(length);
    }
    
    
    public double addItem(double value, long time) {
        //First we need to examine our existing items and remove any that are too old
        //Time of new values cannot be older than existing values else calculation will be erroneous
        while (items.size() > 0 && (time - items.getFirst().getTime() > length) ) {
            total = total - items.getFirst().getValue();
            items.removeFirst();
        }
        
        //Then add in this value and time
        total = total + value;
        items.addLast(new TimeItem(value, time));
        average = total / items.size();
        return average;
    }
    
}
