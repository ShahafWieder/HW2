public class MultiSum extends Polynomial {
    private Function[] functions;
    public MultiSum(Function f1, Function f2, Function... p) {
        this.functions = new Function[p.length + 2];
        this.functions[0] = f1;
        this.functions[1] = f2;
        for (int i = 2; i < p.length + 2; i++) {
            this.functions[i] = p[i - 2];
        }
    }

    @Override
    public double valueAt(double x) {
        double value = 0;
        for (int i = 0; i < this.functions.length; i++) {
            value += this.functions[i].valueAt(x);
        }
        return value;
    }

    @Override
    public String toString() {
        String sumString = "(";
        for (int i = 0; i < this.functions.length - 1; i++) {
            sumString += this.functions[i].toString() + " + ";
        }
        sumString = sumString + "(" + this.functions[functions.length - 1].toString() + "))";
        return sumString;
    }

    @Override
    public Function derivative() {
        Function[] derivativeFunctions = new Function[functions.length-2];
        Function f1=functions[0].derivative();
        Function f2=functions[1].derivative();
        for (int i = 0; i < functions.length-2; i++) {
            derivativeFunctions[i] = functions[i+2].derivative();
        }
        return new MultiSum(f1,f2,derivativeFunctions);
    }

}