public class MultiProduct extends Polynomial {
    private Function[] functions;
    //private Function f1;
    private Function f2;

    public MultiProduct(Function f1, Function f2, Function... p) {
        this.functions=new Function[p.length+2];
        this.functions[0]=f1;
        this.functions[1]=f2;
        for (int i=2;i<p.length+2;i++){
            this.functions[i]=p[i-2];
        }

        //this.functions = p;
        //this.functions[0] = f1;
        //this.functions[1] = f2;
        //for (int i = 2; i < p.length + 2; i++) {
          //  this.functions[i] = p[i - 2];
      //  }
    }

    @Override
    public double valueAt(double x) {
        double value = 0;
        for (int i = 0; i < this.functions.length; i++) {
            value *= this.functions[i].valueAt(x);
        }
        return value;
    }

    @Override
    public String toString() {
        String multiPstring = "(";
        for (int i = 0; i < this.functions.length - 1; i++) {
            multiPstring += "(" + this.functions[i].toString() + ")*";
        }
        multiPstring = multiPstring + "(" + this.functions[functions.length - 1].toString() + "))";
        return multiPstring;
    }

    @Override
    public Function derivative() {
        Function[] result = new Function[functions.length];

        for (int i = 0; i < functions.length; i++) {
            // Get a derivative of the i-th function
            Function derivative = functions[i].derivative();

            // Calculate the product of all other functions
            Function[] otherFunctions = new Function[functions.length - 1];
            int index = 0;
            for (int j = 0; j < functions.length; j++) {
                if (j != i) {
                    otherFunctions[index++] = functions[j];
                }
            }

            Function productOfOthers;
            if (otherFunctions.length > 1) {
                Function f1 = otherFunctions[0];
                Function f2 = otherFunctions[1];
                Function[] p = new Function[otherFunctions.length - 2];
                for (int j = 2; j < otherFunctions.length; j++) {
                    p[j - 2] = otherFunctions[j];
                }
                productOfOthers = new MultiProduct(f1, f2, p);
            } else {
                productOfOthers = otherFunctions[0];
            }

            result[i] = new MultiProduct(derivative, productOfOthers);
        }

        // The derivative is the sum of all functions in the result
        Function sum;
        if (result.length > 1) {
            Function f1 = result[0];
            Function f2 = result[1];
            Function[] p = new Function[result.length - 2];
            for (int i = 2; i < result.length; i++) {
                p[i - 2] = result[i];
            }
            sum = new MultiSum(f1, f2, p);
        } else {
            sum = result[0];
        }

        return sum;
    }
}
