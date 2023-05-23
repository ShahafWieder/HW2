public class DateTime extends Date{
   protected int hour, minute;
    public DateTime(int day, int month, int year, int hour, int minute) {
        super(day, month, year);
        hour = this.hour;
        if(hour<0 || day>23) {
            hour = 0;
        }
        minute = this.minute;
        if(minute<0 || month>59) {
            minute = 0;
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
        return super.hashCode();
    }
}
