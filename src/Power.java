public class Power extends Function{
    private final Function f;
    private final int power;
    private Function tempPower;
    public Power(Function f1, int power) {
        this.f = f1;
        this.power=power;
        }
    @Override
    public double valueAt(double x){
        return Math.pow(f.valueAt(x),this.power);
    }
    @Override
    public String toString() {
        if(this.power >=1) {
            return "(" + this.f.toString() + "^" + this.power+")";
        }
        else{
            return "(" + this.f.toString() + ")";
        }
    }
    @Override
    public Function derivative() {
        // Using the power rule (f^n)' = n * f^(n-1) * f'
        if (power != 0) {
            return new MultiProduct(new Constant(this.power),new Power(this.f, this.power - 1), this.f.derivative());
        } else {
            return new Constant(0);
        }
    }
}
