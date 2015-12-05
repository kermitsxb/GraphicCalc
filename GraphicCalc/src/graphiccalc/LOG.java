package graphiccalc;

/**
 *
 * @author Anthony Den Drijver - Thomas Stocker
 */
public class LOG extends OPUNARY {
    public LOG(EXPR right) {
        this.right = right;
    }
    
    @Override
    public double eval() {
        return Math.log(right.eval()) / Math.log(10);
    }
}
