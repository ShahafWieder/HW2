public class MultiProduct extends Polynomial{
    private Function[] values;
    private Function tempProduct;
    private Function multiprodductFunction;
    public MultiProduct(Function...p) {
        this.values = p;
        this.tempProduct =new Product(this.values[0],this.values[1]);
        for(int i = 1; i< this.values.length-1; i++){
            this.multiprodductFunction = new Product(tempProduct,this.values[i+1]);
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
