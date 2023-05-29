public class MultiSum extends Polynomial{
    private Polynomial[] values;
    private  double [] multiSumFunction;
    public MultiSum(Polynomial...p) {
            this.values = p;
            for(int i = 0; i< this.values.length-1; i++){
                this.multiSumFunction=new Sum(this.values[i].getValues(),this.values[i+1].getValues()).getSumValues();
            }
    }


}
