public class Sum extends Function {
    private double [] values1;
    private double [] values2;
    private double[] sumValue;
    public Sum(double[] p1, double[] p2) {
        this.values1 = p1;
        this.values2 = p2;
        sumValue=new double[Math.max(this.values1.length,this.values2.length)];
        int counter = 0;
        for(int i=0;i<Math.min(this.values1.length,this.values2.length);i++){
            sumValue[i]=values1[i]+values2[i];
            counter ++;
        }
        for(int j = counter; j<Math.max(this.values1.length,this.values2.length);j++){
           if(this.values1.length >= this.values2.length){
               sumValue[j]=values1[j];
           }
           else{
               sumValue[j]=values2[j];
           }
        }
    }
    @Override
    public double valueAt(double x){
        double value = 0;
        for(int i = 0; i<this.sumValue.length; i++){
            value += this.sumValue[i] * Math.pow(x, i);
        }
        return value;
    }
    @Override
    public String toString(){
        String polyString = "";
        for(int i = 0; i<this.sumValue.length; i++) {
            if (i == 0) {
                if (checkInt(this.sumValue[i])){
                    polyString+=(int)this.sumValue[i];
                }
                else{
                    polyString+=this.sumValue[i];
                }
            }
            else {
                if (this.sumValue[i] > 0) {
                    polyString += " + ";
                } else {
                    polyString += " - ";
                }
                if (this.sumValue[i] != 1 || this.sumValue[i] != -1) {
                    if (i == 1) {
                        if (checkInt(this.sumValue[i])){
                            polyString += (int) this.sumValue[i] + "x";
                        }
                        else {
                            polyString+=this.sumValue[i]+ "x";
                        }
                    }
                    else {
                        if (checkInt(this.sumValue[i])){
                            polyString += (int) this.sumValue[i] + "x^" + i;
                        }
                        else {
                            polyString+=this.sumValue[i]+"x^" + i;
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
        if(sumValue.length > 1) {
            double[] derivativeCoefficients = new double[sumValue.length - 1];
            for (int i = 1; i < sumValue.length; i++) {
                derivativeCoefficients[i - 1] = sumValue[i] * i;
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
}
