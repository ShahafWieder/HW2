public class Negation extends Product {
    private Function f;

    public Negation(Function f) {
        super(f, new Constant(-1));
        this.f = f;
    }

    @Override
    public double valueAt(double x) {
        return super.valueAt(x);  // This will compute f(x) * -1
    }

    @Override
    public  String  toString(){
        return "(-"+this.f.toString()+")";
    }
    @Override
    public Function derivative() {
        return new Negation(this.f.derivative());
    }
}
