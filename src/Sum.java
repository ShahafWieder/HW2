public class Sum extends MultiSum {
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
        return super.valueAt(x);
    }
    @Override
    public String toString(){
        return super.toString();
    }
    @Override
    public Function derivative(){
       return super.derivative();
    }
    public double [] getSumValues(){
        return this.sumValue;
    }
}
