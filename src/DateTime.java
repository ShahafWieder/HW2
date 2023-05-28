public class DateTime extends Date{
   protected int hour, minute;
    public DateTime(int year, int month, int day, int hour, int minute) {
        super(year, month, day);
        this.hour=hour;
        if(hour<0 || hour>23) {
            this.hour = 0;
        }
        this.minute=minute;
        if(minute<0 || minute>59) {
            this.minute = 0;
        }
    }
    public void setHour (int hour2){

        if(hour2<0 || hour2>23) {
            this.hour = 0;
        }
        else { this.hour=hour2;}
    }
  //  public  void setMonth(int month2){
    //    super.setMonth(month2);
    //}
    public void setMinute(int minute2) {

        if(minute2<0 || minute2>59) {
            this.minute=0;
        }
        else {this.minute=minute2;}
    }

    @Override
    public String toString() {
        String ho=null;
        String mi=null;
        if(this.hour<10){
            ho="0"+this.hour;
        }
        else {
            ho=String.valueOf(this.hour);
        }
        if(this.minute<10){
            mi="0"+this.minute;
        }
        else {
            mi=String.valueOf(this.minute);
        }
        return (super.toString()+" "+ho+":"+mi);
    }

    @Override
    public boolean equals(Object obj){
        if(obj==null) {
            return false;
        }
        if(!(this.hashCode()==obj.hashCode())||!(obj instanceof DateTime)){
            return false;
        }
        DateTime dt2=(DateTime) obj;
        return (this.day == dt2.day && this.month == dt2.month && this.year == dt2.year && this.hour == dt2.hour && this.minute == dt2.minute);
    }

    @Override
    public int hashCode() {
        return super.hashCode()+(hour+1)*60+(minute+1);
    }
}
