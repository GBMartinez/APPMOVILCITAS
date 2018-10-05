package pe.edu.unmsm.sistemas.appclinica.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class GsonUtil {
    private static Gson gson;

    public static Gson getGson(){
        if (gson == null){
            gson =  new GsonBuilder().registerTypeAdapter(Calendar.class, new CalendarDeserialize()).registerTypeAdapter(Calendar.class, new CalendarSerialize()).registerTypeAdapter(GregorianCalendar.class, new CalendarDeserialize()).registerTypeAdapter(GregorianCalendar.class, new CalendarSerialize()).create();
        }

        return gson;
    }
}
