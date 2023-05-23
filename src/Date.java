public class Date {
    protected int day, month, year;
    public Date(int day, int month, int year) {
        day = this.day;
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