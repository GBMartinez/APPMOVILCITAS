package pe.edu.unmsm.sistemas.appclinica.home.controller.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import pe.edu.unmsm.sistemas.appclinica.R;
import pe.edu.unmsm.sistemas.appclinica.reserve.controller.ReservaDoctorActivity;
import pe.edu.unmsm.sistemas.appclinica.reserve.rest.RestEspecialidadActivity;

public class InicioActivity extends AppCompatActivity implements View.OnClickListener{

    private CardView cardViewReservaEsp;
    private CardView cardViewReservaMed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        instanceWidget();
    }

    private void instanceWidget(){

        Toolbar toolbar = findViewById(R.id.include_toolbar_base);
        ((TextView) findViewById(R.id.text_titulo_toolbar)).setText("Reserva de Citas");
        ((TextView) findViewById(R.id.text_titulo_toolbar)).setTextSize(22);
        ((TextView) findViewById(R.id.text_subtitulo_toolbar)).setText("Clínica universitaria - UNMSM");
        toolbar.setElevation(5);
        setSupportActionBar(toolbar);

        cardViewReservaEsp = findViewById(R.id.card_reserca_esp_inicio);
        cardViewReservaMed = findViewById(R.id.card_reserca_med_inicio);
        cardViewReservaMed.setOnClickListener(this);
        cardViewReservaEsp.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.card_reserca_esp_inicio:
                Intent intentRegistroEsp = new Intent(this, RestEspecialidadActivity.class);
                this.startActivity(intentRegistroEsp);
                break;

            case R.id.card_reserca_med_inicio:
                Intent intentRegistroMed = new Intent(this, ReservaDoctorActivity.class);
                this.startActivity(intentRegistroMed);
                break;

        }



    }
}
