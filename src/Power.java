public class Power extends MultiProduct{
    private Polynomial[] values;
    private int power;
    private  double [] tempPower;
    private double [] powerFunction;
    public Power(Polynomial...p) {
        this.values = p;
        this.tempPower =new Product(this.values[0].getValues(),this.values[1].getValues()).getProductValues();
        for(int i = 1; i< this.values.length-1; i++){
            this.powerFunction = new Product(tempPower,this.values[i+1].getValues()).getProductValues();
            this.tempPower =this.powerFunction;
        }
    }
}
