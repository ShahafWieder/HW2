public class Power extends Polynomial{
    private Function f;
    private int power;
    private Function tempPower;
    //private Function powerFunction;
    public Power(Function f1, int power) {
        this.f = f1;
        this.power=power;
      //  if(power == 1){
        //  powerFunction=this.f;
        }
        //else{
    //  this.tempPower =new Product(this.f,this.f);
      //      for(int i = 1; i< this.power-1; i++) {
        //        this.powerFunction = new Product(this.f, this.f);
          //      this.tempPower = this.powerFunction;
           // }
        //}
//    }
    @Override
    public double valueAt(double x){
        return Math.pow(f.valueAt(x),this.power);
    }
    @Override
    public String toString() {
        if(this.power >1) {
            return "(" + this.f.toString() + ")^" + this.power;
        }
        else{
            return "(" + this.f.toString() + ")";
        }
    }
    @Override
    public Function derivative() {
        // Using the power rule (f^n)' = n * f^(n-1) * f'
        if (power != 0) {
            return new Product(new Constant(this.power), new Product(new Power(this.f, this.power - 1), this.f.derivative()));
        } else {
            return new Constant(0);
        }
    }
}
