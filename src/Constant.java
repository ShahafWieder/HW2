public class Constant extends Polynomial{
private  double [] cFunction;
public  Constant(double c){

   this.cFunction= new double[]{c};
}
    @Override
    public double valueAt (double x){
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
