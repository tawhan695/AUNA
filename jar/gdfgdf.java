
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Date;


public class gdfgdf {

    public static void main(String[] args) {
        String sDate = "2013-08-03";

         String date="28 มb.ย. 1997";
         System.out.println(date.length());
        System.out.println(date);
       
         String Year = date.substring(8, date.length());

        int Y = Integer.valueOf(Year.trim());

        int Y2 = 2018 - Y;

        String Year2 = Integer.toString(Y2);
        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
/*
        try {

            Date date = df.parse(sDate);

            System.out.println("Full Date : " + date);
  
        } catch (ParseException e) {

            e.printStackTrace();

        }*/
    }
}
