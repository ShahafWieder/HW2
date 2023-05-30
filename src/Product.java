public class Product extends MultiProduct{
    private double [] values1;
    private double [] values2;
    private double[] productValue;
    public Product(Function f1, Function f2) {
        this.values1 = ((Polynomial)f1).getValues();
        this.values2 = ((Polynomial)f2).getValues();
        for(int i = 0; i<this.values1.length; i++){
            for(int j = 0; j<this.values2.length; j++){
                this.productValue[i+j] += this.values1[i]*this.values2[j];
            }
        }
    }
    @Override
    public double valueAt(double x){
        return super.valueAt(x);
    }
    @Override
    public String toString(){
        return super.toString();
    }
    @Override
    public Function derivative(){
        return super.derivative();
    }
    public double [] getProductValues(){
        return this.productValue;
    }
}
