public class Product extends MultiProduct{
    private double [] values1;
    private double [] values2;
    private double[] productValue;
    public Product(double[] p1, double[] p2) {
        this.values1 = p1;
        this.values2 = p2;
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
