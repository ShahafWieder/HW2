public class Constant extends Function{
private  double cFunction;
public  Constant(double c){

   this.cFunction=c;
}
    @Override
    public  double valueAt (double x){
        return this.cFunction;
}
    @Override
    public String toString() {
        return (""+this.cFunction);
    }

    @Override
    public Function derivative() {
    Constant c=new Constant('0') ;
        return(c);
    }
    /**
    @Override
    public double bisectionMethod(double a, double b, double epsilon){
        double left = a;
        double right = b;
        double mid = (left + right) / 2;
        while (Math.abs(this.valueAt(mid)) > epsilon) {
            if (this.valueAt(mid) * this.valueAt(left) > 0) {
                left = mid;
            } else {
                right = mid;
            }
            mid = (left + right) / 2;
        }
        return mid;
    }
    @Override
    public double bisectionMethod(double a, double b){
        return 0;
    }
    @Override
    public double newtonRaphsonMethod(double a, double epsilon){
        return 0;
    }
    @Override
    public double newtonRaphsonMethod(double a){
        return 0;
    }
    @Override
    public String taylorPolynomial(int n){
        return (""+this.cFunction);
    }
    */
}
