package graphiccalc;

/**
 *
 * @author Anthony Den Drijver - Thomas Stocker
 */
public class VAR extends CONST{
    public VAR() {
        super(0);
    }
    
    public void setValue(double d) {
        this.value = d;
    }
    
    @Override
    public double eval() {
        return this.value;
    }
    
}
