public class Sum extends Polynomial {
    private Function f1;
    private Function  f2;

    public Sum(Function f1, Function f2) {
        this.f1 = f1;
        this.f2 = f2;
        /**this.values1 = ((Polynomial)f1).getValues();
        this.values2 = ((Polynomial)f2).getValues();
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
        }*/
    }


    @Override
    public double valueAt(double x){
        return (this.f1.valueAt(x)+this.f2.valueAt(x));
    }
    @Override
    public String toString(){
        return "(("+this.f1+")+"+"("+this.f2+"))";
    }
    @Override
    public Function derivative(){
       return new Sum(this.f1.derivative(),this.f2.derivative());
    }
}
