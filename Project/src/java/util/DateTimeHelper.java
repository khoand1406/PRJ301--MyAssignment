/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import helper.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Ngo Tung Son
 */
public class DateTimeHelper {
    public static Date toDate(String datetime, String format) throws ParseException
    {
       return new SimpleDateFormat(format).parse(datetime);
    }
    public static Date removeTime(Date date){
        Calendar c= Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
        
    }
    public static java.util.Date toDateUtil(java.sql.Date date){
        java.util.Date x = new java.util.Date(date.getTime());
        x = removeTime(x);
        return x;
        
    }
    public static java.sql.Date toDateSql(java.util.Date date){
         date= removeTime(date);
        return new java.sql.Date(date.getTime());
    }
    public static int getDayOfWeek(java.util.Date date){
        Calendar c= Calendar.getInstance();
        c.setTime(date);
        int dayofWeek= c.get(Calendar.DAY_OF_WEEK);
        return dayofWeek;
    }
    public static Date addDays(java.util.Date date, int days){
         Calendar cal = Calendar.getInstance(); 
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }
      public static ArrayList<java.sql.Date> 
        getDateList(java.sql.Date from, java.sql.Date to)
    {
        ArrayList<java.sql.Date> dates = new ArrayList<>();
        int days = 0;
        java.util.Date e_from = toDateUtil(from);
        java.util.Date e_to = toDateUtil(to);
        while(true)
        {
            java.util.Date d = DateTimeHelper.addDays(e_from, days);
            dates.add(toDateSql(d));
            days++;
            if(d.compareTo(e_to)>=0)
                break;
        }
        return dates;
    }
    
    public static String getDayNameofWeek(java.sql.Date s) {
        java.util.Date d = toDateUtil(s);
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        switch(dayOfWeek)
        {
            case 1: return "Sun";
            case 2: return "Mon";
            case 3: return "Tue";
            case 4: return "Wed";
            case 5: return "Thu";
            case 6: return "Fri";
            case 7: return "Sat";
        }
        return "Error";
    }
    
    public static int compare(java.sql.Date a, java.sql.Date b)
    {
       
        Date e_a = toDateUtil(a);
        Date e_b = toDateUtil(b);
         System.out.println(a + " " + b +" " +e_a.compareTo(e_b));
        return e_a.compareTo(e_b);
    }
     
    
}
