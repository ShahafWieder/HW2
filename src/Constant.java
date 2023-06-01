public class Constant extends Polynomial{
private  double cFunction;
public  Constant(double c){

   this.cFunction= c;
}
    @Override
    public double valueAt (double x){
    return this.cFunction;
    }
    @Override
    public String toString() {
        if (checkInt(this.cFunction)){
            return "("+(int)this.cFunction+")";
        }
        else{
            return "("+this.cFunction+")";
        }
    }

    @Override
    public Function derivative() {
    return new Constant(0);
    }
    public boolean checkInt (double current_value){
        double absValue = Math.abs(current_value);
        int intValue = (int) absValue;
        if (absValue == intValue) {
            return true;
        }
        else {
            return false;
        }
    }
}
