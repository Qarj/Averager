package averager;

/**
 *
 * @author Tim
 */
class BearingItem extends Item {

    private int invertedWeight;

    public BearingItem (double value, int invertedWeight) {
        super(value);
        this.invertedWeight = invertedWeight;
    }

    public int getInvertedWeight () {
        return this.invertedWeight;
    }

}
