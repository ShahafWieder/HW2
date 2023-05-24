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

    @Override
    public String toString() {
        return (super.day+"/"+super.month+"/"+super.year+" "+this.hour+":"+this.minute);
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof DateTime)){
            return false;
        }
        DateTime dt2=(DateTime) obj;
        return (this.day == dt2.day && this.month == dt2.month && this.year == dt2.year && this.hour == dt2.hour && this.minute == dt2.minute);
    }

    @Override
    public int hashCode() {
        return super.hashCode()+(hour+1)*24+(minute+1)*60;
    }
}
