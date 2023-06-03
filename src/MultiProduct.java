public class MultiProduct extends Function {
    private final Function[] functions;
    private Function f2;

    public MultiProduct(Function f1, Function f2, Function... p) {
        this.functions=new Function[p.length+2];
        this.functions[0]=f1;
        this.functions[1]=f2;
        for (int i=2;i<p.length+2;i++){
            this.functions[i]=p[i-2];
        }
    }

    private MultiProduct(Function derivative, Function[] otherFunctions) {
        Function[] factors = new Function[otherFunctions.length + 1];
        factors[0] = derivative;
        for(int i = 1; i < otherFunctions.length + 1; i++) {
            factors[i] = otherFunctions[i-1];
        }
        this.functions = factors;
    }
    @Override
    public double valueAt(double x) {
        double value = 1; // Initialize to 1 instead of 0
        for (int i = 0; i < this.functions.length; i++) {
            value *= this.functions[i].valueAt(x);
        }
        return value;
    }

    @Override
    public String toString() {
        String multiPstring = "(";
        for (int i = 0; i < this.functions.length - 1; i++) {
            multiPstring +=  this.functions[i].toString() + " * ";
        }
        multiPstring = multiPstring  + this.functions[functions.length - 1].toString() + ")";
        return multiPstring;
    }

    @Override
    public Function derivative() {
        int numOfFunctions = functions.length;
        Function[] derivatives = new Function[numOfFunctions];
        for (int i = 0; i < numOfFunctions; i++) {
            int k = 0;
            Function[] otherFunctions = new Function[numOfFunctions - 1];
            for(int j = 0; j < numOfFunctions; j++) {
                if (i != j) {
                    otherFunctions[k++] = functions[j];
                }
            }
            derivatives[i] = new MultiProduct(functions[i].derivative(),otherFunctions);
        }

        return splitDerivative(derivatives);
    }

    public MultiSum splitDerivative(Function[] derivatives) {
        return MultiSum.getMultiSum(derivatives, functions);
    }
}
