public class Negation extends Polynomial{
    private double [] values;
    public Negation(double...p) {
        this.values = p;
        for(int i = 0; i < values.length; i++){
            values[i] = -values[i];
        }
    }
    @Override
    public double valueAt(double x) {
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
