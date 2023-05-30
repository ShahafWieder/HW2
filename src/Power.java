public class Power extends MultiProduct{
    private Function values;
    private int power;
    private Function tempPower;
    private Function powerFunction;
    public Power(Function f1, int power) {
        this.values = f1;
        this.power=power;
        if(power == 1){
          powerFunction=this.values;
        }
        else{
            this.tempPower =new Product(this.values,this.values);
            for(int i = 1; i< this.power-1; i++) {
                this.powerFunction = new Product(this.values, this.values);
                this.tempPower = this.powerFunction;
            }
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
