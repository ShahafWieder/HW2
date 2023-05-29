public class Difference extends Function {
    private double [] values1;
    private double [] values2;
    private double[] diffValues;
    public Difference(double[] p1, double[] p2) {
        this.values1 = p1;
        this.values2 = p2;
        diffValues =new double[Math.max(this.values1.length,this.values2.length)];
        int counter = 0;
        for(int i=0;i<Math.min(this.values1.length,this.values2.length);i++){
            diffValues[i]=values1[i]-values2[i];
            counter ++;
        }
        for(int j = counter; j<Math.max(this.values1.length,this.values2.length);j++){
            if(this.values1.length >= this.values2.length){
                diffValues[j]=values1[j];
            }
            else{
                diffValues[j]=values2[j];
            }
        }
    }
    public double valueAt(double x){
        double value = 0;
        for(int i = 0; i<this.diffValues.length; i++){
            value += this.diffValues[i] * Math.pow(x, i);
        }
        return value;
    }
    @Override
    public String toString(){
        String polyString = "";
        for(int i = 0; i<this.diffValues.length; i++) {
            if (i == 0) {
                if (checkInt(this.diffValues[i])){
                    polyString+=(int)this.diffValues[i];
                }
                else{
                    polyString+=this.diffValues[i];
                }
            }
            else {
                if (this.diffValues[i] > 0) {
                    polyString += " + ";
                } else {
                    polyString += " - ";
                }
                if (this.diffValues[i] != 1 || this.diffValues[i] != -1) {
                    if (i == 1) {
                        if (checkInt(this.diffValues[i])){
                            polyString += (int) this.diffValues[i] + "x";
                        }
                        else {
                            polyString+=this.diffValues[i]+ "x";
                        }
                    }
                    else {
                        if (checkInt(this.diffValues[i])){
                            polyString += (int) this.diffValues[i] + "x^" + i;
                        }
                        else {
                            polyString+=this.diffValues[i]+"x^" + i;
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
    @Override
    public Function derivative(){
        if(diffValues.length > 1) {
            double[] derivativeCoefficients = new double[diffValues.length - 1];
            for (int i = 1; i < diffValues.length; i++) {
                derivativeCoefficients[i - 1] = diffValues[i] * i;
            }
            return new Polynomial(derivativeCoefficients);
        }
        else{
            return new Polynomial(0);
        }
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
    public double [] getDiffValues(){
        return this.diffValues;
    }
}

