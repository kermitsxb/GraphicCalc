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
public class VAR extends CONST{
    protected char var;
    
    public VAR(char var, int value) {
        super(value);
        this.var = var;
    }
}
