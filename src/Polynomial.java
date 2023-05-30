public class Polynomial extends Function {
    private double [] values;
    public Polynomial(double...p) {
            this.values = p;
    }
    @Override
    public double valueAt(double x){
        double value = 0;
        for(int i = 0; i<this.values.length; i++){
            value += this.values[i] * Math.pow(x, i);
        }
        return value;
    }
    @Override
    public String toString() {
        String polyString = "";
        for(int i = 0; i<this.values.length; i++) {
            if (i == 0) {
                if (checkInt(this.values[i])){
                    polyString+=(int)this.values[i];
                }
                else{
                polyString+=this.values[i];
                }
            }
             else {
                if (this.values[i] > 0) {
                    polyString += " + ";
                } else {
                    polyString += " - ";
                }
                if (this.values[i] != 1 || this.values[i] != -1) {
                    if (i == 1) {
                        if (checkInt(this.values[i])){
                        polyString += (int) this.values[i] + "x";
                        }
                        else {
                            polyString+=this.values[i]+ "x";
                        }
                    }
                    else {
                        if (checkInt(this.values[i])){
                        polyString += (int) this.values[i] + "x^" + i;
                        }
                        else {
                            polyString+=this.values[i]+"x^" + i;
                        }
                    }
                }
                else {
                    if (i == 1) {
                        polyString += "x";
                    } else {
                        polyString += "x^" + i;
                    }
                }
            }
        }
        return polyString;
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

    @Override
    public Function derivative() {
        double[] derivativeCoefficients = new double[values.length - 1];
        if(values.length > 1) {
            for (int i = 1; i < values.length; i++) {
                derivativeCoefficients[i - 1] = values[i] * i;
            }
            return new Polynomial(derivativeCoefficients);
        }
        else{
            return new Polynomial(0);
        }

    }
    public double [] getValues(){
        return this.values;
    }
}