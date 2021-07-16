package Dates;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class NewDateAPI {

    public void newDateApi(){
//        LocalDateTime localDateTime = LocalDateTime.now();
//        LocalDate localDate = LocalDate.now();
//        LocalTime localTime = LocalTime.now();
//
//        System.out.println(localDateTime.getMonth());
//        System.out.println(localDateTime.getDayOfWeek());
//        System.out.println(localDateTime.getDayOfMonth());
//        System.out.println(localDateTime.getYear());
//        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
//
//        Instant start = Instant.now();
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Instant end = Instant.now();
//        Duration duration = Duration.between(start, end);
//        System.out.println(duration.getSeconds());
//        System.out.println(duration.toMinutes());


        // -------------


//        LocalDate previousDate = LocalDate.of(2020,02,5);
//        LocalDate currentDate = LocalDate.of(2021,07,5);
//
//        if(previousDate.isAfter(currentDate)){
//            System.out.println("Your bill has expired.");
//        }
//
//        if(previousDate.isEqual(currentDate)){
//            System.out.println("Your bill expires today, boi.");
//        }
//
//        if(previousDate.isBefore(currentDate)){
//            System.out.println("Your bill is still up to date");
//        }
//
//        Period period = Period.between(previousDate, currentDate);
//        System.out.println(period.getMonths());

        // -------------

        LocalDate currentDate = LocalDate.now();
        for (int i = 0; i < 13; i++) {

            currentDate = currentDate.plusDays(1);
            currentDate = currentDate.plusMonths(1);
            System.out.println(currentDate);

        }
    }
}
