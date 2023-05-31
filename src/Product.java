public class Product extends Polynomial{
    private Function f1;
    private Function f2;
    public Product(Function p1, Function p2)
    {
    this.f1=p1;
    this.f2=p2;
    }
        /**
        this.values1 = ((Polynomial)f1).getValues();
        this.values2 = ((Polynomial)f2).getValues();
        for(int i = 0; i<this.values1.length; i++){
            for(int j = 0; j<this.values2.length; j++){
                this.productValue[i+j] += this.values1[i]*this.values2[j];
            }
        }
    }*/
    @Override
    public double valueAt(double x){
        return this.f1.valueAt(x)*this.f2.valueAt(x);
    }
    @Override
    public String toString(){
        return "(("+this.f1+")*"+"("+this.f2+"))";
    }
    @Override
    public Function derivative() {
        // Using the product rule (f*g)' = f'*g + f*g'
        return new Sum(new Product(this.f1.derivative(), f2), new Product(f1, this.f2.derivative()));
    }

}
