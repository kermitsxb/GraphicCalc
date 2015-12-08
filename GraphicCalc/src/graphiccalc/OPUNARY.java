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
public class OPUNARY extends EXPR{
    protected EXPR right;
    
    @Override
    public double eval() {
        return 0;
    }
    
    @Override
    public double eval(double x) {
        return 0;
    }
}
