package pe.edu.unmsm.sistemas.appclinica.util;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarDeserialize implements JsonDeserializer<Calendar> {

    @Override
    public Calendar deserialize(JsonElement arg0, Type arg1, JsonDeserializationContext arg2)
            throws JsonParseException {
        if(arg0 == null) {
            return null;
        }else {
            Calendar c = GregorianCalendar.getInstance();
            c.setTimeInMillis(arg0.getAsLong()*1000);
            return c;
        }
    }

}