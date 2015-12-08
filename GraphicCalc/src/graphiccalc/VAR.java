package graphiccalc;

/**
 *
 * @author Anthony Den Drijver - Thomas Stocker
 */
public class VAR extends CONST{
    public VAR() {
        super(0);
    }
    
    
    @Override
    public double eval() {
        return this.value;
    }
    
    @Override
    public double eval(double x) {
        return x;
    }
}
