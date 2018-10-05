package pe.edu.unmsm.sistemas.appclinica.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Retrofit2CustomService {

    public static APIRest getService(){

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIRest.BASE_URL)
                .callbackExecutor(executorService)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create(new ObjectMapper()))
                .build();

        return retrofit.create(APIRest.class);
    }
}
