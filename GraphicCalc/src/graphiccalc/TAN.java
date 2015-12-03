/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphiccalc;

/**
 *
 * @author kermit
 */
public class TAN extends OPUNARY{
    public TAN (EXPR right) {
        this.right = right;
    }
    
    @Override
    public double eval() {
        return Math.tan(right.eval());
    }
}
