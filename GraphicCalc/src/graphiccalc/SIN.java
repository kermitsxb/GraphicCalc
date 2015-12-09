package graphiccalc;

/**
 *
 * @author Anthony Den Drijver - Thomas Stocker
 */
public class SIN extends OPUNARY{
    public SIN (EXPR right) {
        this.right = right;
    }
    
    @Override
    public double eval() {
        return Math.sin(right.eval());
    }
    
    @Override
    public double eval(double x) {
        return Math.sin(right.eval(x));
    }
}
