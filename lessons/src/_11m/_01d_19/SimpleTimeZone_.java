package _11m._01d_19;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;
//Třída, která umožňuje definovat vlastní pravidla lokálního času
//posuv oproti UTC + pravidla pro DST (Daylight Saving Time)
//Domácí úkol: upravte pro rok 2021, nejlépe dle pravidla, že změna je
// ve 2 hodiny ráno poslední neděli v březnu (začátel letního času)
// a ve 2 hodiny ráno poslední neděli v říjnu (konec letního času)
public class SimpleTimeZone_ {
    public static void main(String[] args) {
        SimpleTimeZone stz = new SimpleTimeZone(
                3600000,//posunutí vůči GMT (v ms)
                "Europe/Prague", //časová zóna
                //údaje o začátku letního času
                Calendar.MARCH, 30, //přesné datum
                0,                  //den v týdnu, 0 = nedůležité
                7200000,        //začíná ve 2 hodiny ráno (v ms)
                SimpleTimeZone.UTC_TIME, //UTC času
                //údaje o konci letního času
                Calendar.OCTOBER, 26,
                0,
                7200000,
                SimpleTimeZone.UTC_TIME,
                3600000 //prodloužení o 1 hodinu (v ms)
        );
        boolean zmena = true;
        GregorianCalendar gc = new GregorianCalendar(2021, Calendar.JANUARY, 1);
        for (int i = 0; i < 366 ; i++) {
            System.out.format("%s ",new SimpleDateFormat("dd.MM.YYYY").format(gc.getTime()));
            for (int j = 0; j < 24; j++) {
                System.out.format("%d %b ",j, stz.inDaylightTime(gc.getTime()));
                gc.add(Calendar.HOUR_OF_DAY,1);
            }
            System.out.println();
        }
    }
}
