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
        String original = super.toString();

        if (original.charAt(1) != '-') {
            String negate = original.substring(1);
            negate = "+" + negate;

            negate.replace("+", "t");
            negate.replace("-", "+");
            negate.replace("t", "-");
            return "(" + negate;
        }
        else {
            original.replace("+", "t");
            original.replace("-", "+");
            original.replace("t", "-");
        return original;
        }


}
    @Override
    public Function derivative() {
        return new Negation(this.f.derivative());
    }
}
