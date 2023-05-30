public class Constant extends Polynomial{
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
}
