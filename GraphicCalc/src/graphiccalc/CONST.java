/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3;

/**
 *
 * @author Thomas STOCKER
 */
public class CONST extends EXPR {
    protected int value;
    
    public CONST(int value) {
        this.value = value;
    }
    
    @Override
    public int eval() {
        return value;
    }
}
