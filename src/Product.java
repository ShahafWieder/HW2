public class Product extends Function{
    private final Function f1;
    private final Function f2;
    public Product(Function p1, Function p2)
    {
    this.f1=p1;
    this.f2=p2;
    }
    @Override
    public double valueAt(double x){
        return this.f1.valueAt(x)*this.f2.valueAt(x);
    }
    @Override
    public String toString(){
        return "("+this.f1+" * "+this.f2+")";
    }
    @Override
    public Function derivative() {
        // Using the product rule (f*g)' = f'*g + f*g'
        return new Sum(new Product(this.f1.derivative(), f2), new Product(this.f2.derivative(),this.f1));
    }

}
