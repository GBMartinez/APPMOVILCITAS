package pe.edu.unmsm.sistemas.appclinica.reserve.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import pe.edu.unmsm.sistemas.appclinica.R;
import pe.edu.unmsm.sistemas.appclinica.reserve.adapter.ListaEspecialidadAdapter;
import pe.edu.unmsm.sistemas.appclinica.reserve.model.RespuestaEspecialidades;
import pe.edu.unmsm.sistemas.appclinica.util.GsonUtil;

public class ReservaEspecialidadActivity extends AppCompatActivity {

    private RecyclerView recyclerLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_especialidad);
        instanceWidget();

        String responseAsString =  getIntent().getStringExtra("responseAsString");
        RespuestaEspecialidades respuestaEspecialidades = GsonUtil.getGson().fromJson(responseAsString,RespuestaEspecialidades.class);
        ListaEspecialidadAdapter listaAdapter = new ListaEspecialidadAdapter(respuestaEspecialidades.getData());
        recyclerLista.setAdapter(listaAdapter);

    }

    private void instanceWidget(){

        Toolbar toolbar = findViewById(R.id.include_toolbar_base);
        ((TextView) findViewById(R.id.text_titulo_toolbar)).setText("Reservar cita");
        ((TextView) findViewById(R.id.text_titulo_toolbar)).setTextSize(22);
        ((TextView) findViewById(R.id.text_subtitulo_toolbar)).setText("Especialidades");
        toolbar.setElevation(5);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerLista = this.findViewById(R.id.recycler_especialidad_reserva);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.ItemAnimator animator = recyclerLista.getItemAnimator();
        if (animator instanceof DefaultItemAnimator) {
            ((DefaultItemAnimator) animator).setSupportsChangeAnimations(false);
        }
        recyclerLista.setLayoutManager(layoutManager);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;

    }

}
