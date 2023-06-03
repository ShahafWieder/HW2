public class Difference extends Function {
    private final Function d1;
    private final Function d2;
    public Difference(Function p1, Function p2) {
        this.d1=p1;
        this.d2=p2;
    }
    @Override
    public double valueAt(double x){
       return (this.d1.valueAt(x)-this.d2.valueAt(x));
    }
    @Override
    public String toString(){
        return "("+this.d1.toString()+" - "+this.d2.toString()+")";
    }
    @Override
    public Function derivative(){
       return new Difference(this.d1.derivative(),this.d2.derivative());
    }
}

