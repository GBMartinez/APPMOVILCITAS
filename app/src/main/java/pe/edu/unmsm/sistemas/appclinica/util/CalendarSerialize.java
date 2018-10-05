package pe.edu.unmsm.sistemas.appclinica.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.util.Calendar;

public class CalendarSerialize implements JsonSerializer<Calendar> {

    @Override
    public JsonElement serialize(Calendar arg0, Type arg1, JsonSerializationContext arg2) {
        if(arg0 == null) {
            return null;
        }else {
            return new JsonPrimitive(arg0.getTimeInMillis()/ 1000);
        }
    }

}