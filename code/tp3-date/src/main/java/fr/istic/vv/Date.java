package fr.istic.vv;


class Date implements Comparable<Date> {
    int day;
    int month;
    int year;

    public Date(int day, int month, int year) { 
        /*
        assert (month > 0 && month <= 12 );
        assert (day > 0 );
        assert (day <= 31 );
        assert (!(month ==4 ||month ==6 ||month ==9||month ==11 ) || day<=30);
        assert (month !=2 || (year % 4 ==0 && day<=29) ||day <=28  ) ;
        */
        assert(Date.isValidDate(day,month,year));
        this.day=day;
        this.month=month;
        this.year=year;
    }

    public static boolean isValidDate(int day, int month, int year) { 
        if(month <=0 ){
            return false;
            } 
        if( month >=13 ){
            return false;
            } 
        if(day <= 0 ){
            return false;
            } 
        if(day >= 32 ){
            return false;
        }
        if((month ==4 ||month ==6 ||month ==9||month ==11 ) && day>=31){
            return false;
            } 
        if(month ==2 &&( day >=30  || (year % 4 !=0 && day>=29)) ) {
            return false;
            } 
        else{
            return true;
        }
    }

    public static boolean isLeapYear(int year) { return year % 4 ==0; }

    public Date nextDate() {
        if(isValidDate(day+1,month,year)){
            return new Date(day+1,month,year);
        }
        if(isValidDate(1,month+1,year)){
            return new Date(1,month+1,year);
        }
        else{
            return new Date(1,1,year+1);
        }
     }

    public Date previousDate() { 
        if(isValidDate(day-1,month,year)){
        return new Date(day-1,month,year);
        }
        if(isValidDate(31,month-1,year)){
            return new Date(31,month-1,year);
        }
        if(isValidDate(30,month-1,year)){
            return new Date(30,month-1,year);
        }
        if(isValidDate(29,month-1,year)){
            return new Date(29,month-1,year);
        }
        if(isValidDate(28,month-1,year)){
            return new Date(28,month-1,year);
        }
        else{
            return new Date(31,12,year-1);
        } }

    public int compareTo(Date other) { 
        if(this.year>other.year){
            return 1;
        }
        if(this.year<other.year){
            return -1;
        }
        else{
            if(this.month>other.month){
            return 1;
            }
            if(this.month<other.month){
                return -1;
            }
            else{
                if(this.day>other.day){
                return 1;
                }
                if(this.day<other.day){
                    return -1;
                }
                else{
                    return 0;
                }
            }
        }
     }

}