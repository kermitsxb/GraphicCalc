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
public class VAR extends CONST{
    protected char var;
    
    public VAR(char var) {
        super(0);
        this.var = var;
    }
    
    @Override
    public double eval() {
        return 0;
    }
    
}
