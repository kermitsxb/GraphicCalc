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
public class LN extends OPUNARY {
    public LN(EXPR right) {
        this.right = right;
    }
    
    @Override
    public double eval() {
        return Math.round(Math.log(right.eval()));
    }
    
    @Override
    public double eval(double x) {
        return Math.round(Math.log(right.eval()));
    }
    
}
