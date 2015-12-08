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
public class CONST extends EXPR {
    protected double value;
    
    /**
     *
     * @param value : La valeur chiffrée de la "constante"
     */
    public CONST(double value) {
        this.value = value;
    }
    
    @Override
    public double eval() {
        return value;
    }
    
    @Override
    public double eval(double x) {
        return value;
    }
}
