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
