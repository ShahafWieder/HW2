public class Negation extends Polynomial {
    //private double [] values;
    private Function f;

    public Negation(Function f) {
        this.f = f;
        /**for(int i = 0; i < values.length; i++){
         this.values[i] = -values[i];
         }   */
    }
    @Override
    public double valueAt(double x) {
        return -1 * (this.f.valueAt(x));
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
