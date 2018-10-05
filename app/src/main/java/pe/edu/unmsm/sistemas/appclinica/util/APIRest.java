package pe.edu.unmsm.sistemas.appclinica.util;

import com.fasterxml.jackson.databind.JsonNode;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APIRest {

    public final static String BASE_URL="http://35.227.84.11:8080";

    @GET("api/especialidades")
    Call<JsonNode> getEspecialidades();

}
