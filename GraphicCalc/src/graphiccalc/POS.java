/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphiccalc;

/**
 *
 * @author Thomas STOCKER
 */
public class POS extends OPUNARY {
    public POS (EXPR right) {
        this.right = right;
    }
    
    @Override
    public double eval() {
        return right.eval();
    }
    
    @Override
    public double eval(double x) {
        return right.eval(x);
    }
}
