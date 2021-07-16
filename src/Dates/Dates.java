package Dates;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Calendar;
import java.util.Date;

public class Dates {

    public static void main(String[] args) {
        new NewDateAPI().newDateApi();
    }

    static public void chronoUnit(){
        Calendar currentDate = Calendar.getInstance();
        Calendar expireDate = Calendar.getInstance();
        expireDate.set(2021, 6, 18);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        long daysBetweenTwoDates = ChronoUnit.DAYS.between(
                LocalDate.parse(
                        simpleDateFormat.format(currentDate.getTime())
                ), LocalDate.parse(
                        simpleDateFormat.format(expireDate.getTime())
                )
        );

        long hoursBetweenDays = ChronoUnit.HOURS.between(LocalDateTime.now(), LocalDateTime.of(2021, Month.JULY, 15,0,0));

        System.out.println(daysBetweenTwoDates);
        System.out.println(hoursBetweenDays);
    }

    static public void usingCalendar(){
        try{

            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

            //calendar.set(2021, 5, 5);
            calendar.add(Calendar.DAY_OF_MONTH, -5);

            System.out.println(simpleDateFormat.format(calendar.getTime()));

            calendar.add(Calendar.MONTH, 4);

            System.out.println(simpleDateFormat.format(calendar.getTime()));

            calendar.add(Calendar.YEAR, 1);

            System.out.println(simpleDateFormat.format(calendar.getTime()));
        }
//        catch(ParseException e){
//            e.printStackTrace();
//        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    static public void comparingDates(){

        try {

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date billExpireDate = simpleDateFormat.parse("14/07/2021");
            String currentDateString = simpleDateFormat.format(new Date());
            Date currentDate = simpleDateFormat.parse(currentDateString);

            if(billExpireDate.after(currentDate)){
                System.out.println("Bill has expired.");
            }

            if(billExpireDate.compareTo(currentDate) == 0){
                System.out.println("Today is the last day to pay your bill, boi.");
            }

            if(billExpireDate.before(currentDate)){
                System.out.println("Bill is still up to date.");
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    static public void x(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(new Date()));

        Calendar calendar = Calendar.getInstance();
        System.out.println(simpleDateFormat.format(calendar.getTime()));

        try {
            //it will parse the date according to the format used on the instance of the object
            Date parseddate = simpleDateFormat.parse("1967-12-09 02:34:00");
            System.out.println(parseddate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
