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
public class CoordItem extends Item {
    
    private double y;
    
    public CoordItem(double x, double y) {
        super(x);
        this.y = y;
    }

    public double getY () {
        return this.y;
    }

    public double getX () {
        return getValue();
    }
    
}
