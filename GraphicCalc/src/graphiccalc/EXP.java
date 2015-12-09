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
public class EXP extends OPBINARY {
    
    public EXP(EXPR left, EXPR right) {
        this.left = left;
        this.right = right;
    }
    
    @Override
    public double eval() {
        return Math.pow(left.eval(), right.eval());
    }
    
    @Override
    public double eval(double x) {
        return Math.pow(left.eval(x), right.eval(x));
    }
    
}
