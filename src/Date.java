public class Date {
    protected int day, month, year;
    public Date(int year, int month, int day) {
        this.day = day;
        if(day>31 || day<1){
            day=1;
        }
        month = this.month;
        if(month>12 || month<1){
            month=1;
        }
        year = this.year;
        if(year<-9999 || year>9999){
            year=0;
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
        return (this.day+"/"+this.month+"/"+this.year);
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Date)){
            return false;
        }
        Date d2=(Date)obj;
        return(this.day==d2.day && this.month==d2.month && this.year==d2.year);

    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}