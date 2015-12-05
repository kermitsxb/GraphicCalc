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
public class PI extends CONST {
    
    public PI() {
        super(0);
    }
    
    @Override
    public double eval() {
        return Math.PI;
    }
    
}
