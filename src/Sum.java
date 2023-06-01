public class Sum extends Polynomial {
    private Function f1;
    private Function  f2;

    public Sum(Function f1, Function f2) {
        this.f1 = f1;
        this.f2 = f2;
    }


    @Override
    public double valueAt(double x){
        return (this.f1.valueAt(x)+this.f2.valueAt(x));
    }
    @Override
    public String toString(){
        return "("+this.f1+" + "+this.f2+")";
    }
    @Override
    public Function derivative(){
       return new Sum(this.f1.derivative(),this.f2.derivative());
    }
}
