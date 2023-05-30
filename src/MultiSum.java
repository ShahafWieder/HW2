public class MultiSum extends Polynomial{
    private Function[] values;
    private Function tempSum;
    private Function multisumFunction;
    public MultiSum(Function...p) {
            this.values = p;
            this.tempSum = new Sum(this.values[0],this.values[1]);
            for(int i = 1; i< this.values.length-1; i++){
                this.multisumFunction = new Sum(tempSum,this.values[i+1]);
                this.tempSum =this.multisumFunction;
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
