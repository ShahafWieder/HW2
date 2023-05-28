public class Date {
    protected int day, month, year;
    public Date(int year, int month, int day) {
        this.day = day;
        if(day>31 || day<1){
            this.day=1;
        }
        this.month=month;
        if(month>12 || month<1){
            this.month=1;
        }
         this.year=year;
        if(year<-3999 || year>3999){
            this.year=0;
        }
    }
    public void setMonth(int month2) {

        if(month2>12 || month2<1){
          this.month= 1;
        }
        else {this.month=month2;}
    }

    @Override
    public String toString() {

        String da = null;
        String mo = null;
        String ye = null;

        if(this.day<10){
            da="0"+this.day;
        }
        else {
            da=String.valueOf(this.day);
        }
        if(this.month<10){
            mo="0"+this.month;
        }
        else {
            mo=String.valueOf(this.month);
        }
        if(this.year<1000 && this.year > 99 || this.year < -99 && this.year > -1000){
            ye="0"+this.year;
        }
        else if(this.year<100 && this.year > 9 || this.year < -9 && this.year > -100){
            ye="00"+this.year;
        }
        else if(this.year<10 && this.year >=0 || this.year <= 0 && this.year > -10){
            ye="000"+this.year;
        }
        else {
            ye=String.valueOf(this.year);
        }
        return (da+"/"+mo+"/"+ye);
    }

    @Override
    public boolean equals(Object obj){
    if(obj==null){
        return false;
    }
        if(!(this.hashCode()==obj.hashCode())||!(obj instanceof Date)) {
            return false;
        }
        Date d2=(Date)obj;
        return(this.day==d2.day && this.month==d2.month && this.year==d2.year);

    }

    @Override
    public int hashCode() {
        return this.day*1440+this.month*44640+this.year*535680;
    }
}