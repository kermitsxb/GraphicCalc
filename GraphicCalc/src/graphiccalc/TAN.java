/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphiccalc;

/**
 *
 * @author Anthony Den Drijver - Thomas Stocker
 */
public class TAN extends OPUNARY{
    public TAN (EXPR right) {
        this.right = right;
    }
    
    @Override
    public double eval() {
        return Math.tan(right.eval());
    }
    
    @Override
    public double eval(double x) {
        return Math.tan(right.eval(x));
    }
}
