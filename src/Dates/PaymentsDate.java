package Dates;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PaymentsDate {

    //The concept of paying something over multiple months/years is not common in other countries like USA. It is most commonly found here on Brazil. But anyways.

    static public void generateBills(){
        try {

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Calendar calendar = Calendar.getInstance();

            for (int i = 1; i <= 12; i++) {
                calendar.add(Calendar.MONTH, 1);
                System.out.println("Bill fraction nº " + i + " - " + simpleDateFormat.format(calendar.getTime()));
            }

        }
//        catch (ParseException e) {
//            e.printStackTrace();
//        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
