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
        return super.toString();
    }

    @Override
    public Function derivative() {
        return super.derivative();
    }
}
