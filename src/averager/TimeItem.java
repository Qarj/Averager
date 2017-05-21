/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package averager;

/**
 *
 * @author Tim
 */
class TimeItem extends Item {

    private long time;

    public TimeItem (double value, long time) {
        super(value);
        this.time = time;
    }

    public long getTime () {
        return this.time;
    }

}
