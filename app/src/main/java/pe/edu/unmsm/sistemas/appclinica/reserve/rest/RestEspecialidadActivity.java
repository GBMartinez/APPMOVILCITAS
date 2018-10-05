package pe.edu.unmsm.sistemas.appclinica.reserve.rest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import pe.edu.unmsm.sistemas.appclinica.R;
import pe.edu.unmsm.sistemas.appclinica.reserve.controller.ReservaEspecialidadActivity;
import pe.edu.unmsm.sistemas.appclinica.reserve.model.RespuestaEspecialidades;
import pe.edu.unmsm.sistemas.appclinica.util.GsonUtil;
import pe.edu.unmsm.sistemas.appclinica.util.Retrofit2CustomService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestEspecialidadActivity extends AppCompatActivity implements Callback<JsonNode> {

    private Call<JsonNode> callback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);

        callback = Retrofit2CustomService.getService().getEspecialidades();
        System.out.println("request == "+callback.request());
        callback.enqueue(this);

    }

    @Override
    public void onResponse(Call<JsonNode> call, Response<JsonNode> response) {

        if(response.code()==200){

            try {
                ObjectMapper objectMapper = new ObjectMapper();
                RespuestaEspecialidades respuestaEspecialidades = objectMapper.treeToValue(response.body(), RespuestaEspecialidades.class);
                if (respuestaEspecialidades.getData().size()>0){

                    String responseAsString = GsonUtil.getGson().toJson(respuestaEspecialidades);
                    Intent intent = new Intent(this, ReservaEspecialidadActivity.class); // Se dirige a la clase MenuActivity
                    intent.putExtra("responseAsString", responseAsString);
                    startActivity(intent);

                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }else if(response.code() == 404){
            Toast.makeText(this, "Servidor inhabilitado", Toast.LENGTH_SHORT).show();
            finish();
        }else {
            Toast.makeText(this, "Servidor en mantenimiento", Toast.LENGTH_SHORT).show();
            finish();
        }

    }

    @Override
    public void onFailure(Call<JsonNode> call, Throwable t) {
        System.out.println(call.request());
        System.out.println(t.getMessage());
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        callback.cancel();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        finish();
    }
}
