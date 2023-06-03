public class Quotient extends Function{
    private final Function f1;
    private final Function f2;

    public Quotient(Function f1, Function f2) {
        this.f1 = f1;
        this.f2 = f2;
    }

    @Override
    public double valueAt(double x) {
        return (f1.valueAt(x) /f2.valueAt(x));
    }

    @Override
    public Function derivative() {
        // Using the quotient rule
        // (g(x) * f'(x) - f(x) * g'(x)) / (g(x))^2
        return new Quotient(new Difference(new Product(this.f1.derivative(),f2), new Product(this.f2.derivative(),this.f1 )),
                new Power(this.f2, 2));
    }

    @Override
    public String toString() {
        return "(" +this.f1.toString() + " / " +this.f2.toString() + ")";

    }
}
