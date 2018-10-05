package pe.edu.unmsm.sistemas.appclinica.auth.controller.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import pe.edu.unmsm.sistemas.appclinica.R;

public class NextRegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_register);

        instanceWidget();
    }

    private void instanceWidget(){

        Toolbar toolbar = findViewById(R.id.include_toolbar_base);
        ((TextView) findViewById(R.id.text_titulo_toolbar)).setText("Registrar");
        ((TextView) findViewById(R.id.text_titulo_toolbar)).setTextSize(22);
        ((TextView) findViewById(R.id.text_subtitulo_toolbar)).setText("Nuevo paciente");
        toolbar.setElevation(5);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        buttonRegistrar = findViewById(R.id.button_guardar_register);
        buttonRegistrar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.button_guardar_register:
                Toast.makeText(getApplicationContext(),"Paciente creado",Toast.LENGTH_SHORT).show();
                Intent intentRegistro = new Intent(this, LoginActivity.class);
                this.startActivity(intentRegistro);

        }

    }
}
