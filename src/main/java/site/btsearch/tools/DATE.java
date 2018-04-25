package site.btsearch.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DATE {


    private DATE (){};



    public static String getYMD(){
        return getDateString("YYYY-MM-DD");
    }

    public static String getDateString(String pattern){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

}
