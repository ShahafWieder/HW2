public class MultiProduct extends Polynomial{
    private Polynomial[] values;
    private  double [] tempProduct;
    private double [] multiprodductFunction;
    public MultiProduct(Polynomial...p) {
        this.values = p;
        this.tempProduct =new Product(this.values[0].getValues(),this.values[1].getValues()).getProductValues();
        for(int i = 1; i< this.values.length-1; i++){
            this.multiprodductFunction = new Product(tempProduct,this.values[i+1].getValues()).getProductValues();
            this.tempProduct =this.multiprodductFunction;
        }
    }
    @Override
    public double valueAt(double x){
        return super.valueAt(x);
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
