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
public class SUB extends OPBINARY {
    
    public SUB(EXPR left, EXPR right) {
        this.left = left;
        this.right = right;
    }
    
    @Override
    public int eval() {
        return left.eval() - right.eval();
    }
}
