public class Difference extends Polynomial {
    private double [] values1;
    private double [] values2;
    private double[] diffValues;
    public Difference(Function p1, Function p2) {
        this.d1=p1;
        this.d2=p2;
    }
        /**this.values1 = ((Polynomial)p1).getValues();
        this.values2 = ((Polynomial)p2).getValues();
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
         }*/
    //}
    public double valueAt(double x){
       return super.valueAt(x);
    }
    @Override
    public String toString(){
        return "(("+this.d1.toString()+")-"+"("+this.d2.toString()+"))";
    }
    @Override
    public Function derivative(){
       return super.derivative();
    }

    public double [] getDiffValues(){
        return this.diffValues;
    }
}

