public class Quotient extends Function {
    private Function f1;
    private Function f2;

    public Quotient(Function f1, Function f2) {
        this.f1 = f1;
        this.f2 = f2;
    }

    @Override
    public double valueAt(double x) {
        return ((Polynomial)f1).valueAt(x) / ((Polynomial)f2).valueAt(x);
    }

    @Override
    public Function derivative() {
        // Using the quotient rule
        // (g(x) * f'(x) - f(x) * g'(x)) / (g(x))^2
        return new Quotient(new Difference(new Product(f2, ((Polynomial)f1).derivative()), new Product(f1, ((Polynomial)f2).derivative())),
                new Power(f2, 2));
    }

    @Override
    public String toString() {
        return "(" +((Polynomial)f1).toString() + ") / (" + ((Polynomial)f2).toString() + ")";

    }
}
