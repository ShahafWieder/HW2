public class Negation extends Polynomial{
    private double [] values;
    public Negation(Function f1) {
        this.values = ((Polynomial)f1).getValues();
        for(int i = 0; i < values.length; i++){
            this.values[i] = -values[i];
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
