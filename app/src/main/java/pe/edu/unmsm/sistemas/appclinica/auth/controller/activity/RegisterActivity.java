package pe.edu.unmsm.sistemas.appclinica.auth.controller.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import pe.edu.unmsm.sistemas.appclinica.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etBirthday;
    Calendar calendario = Calendar.getInstance();
    private RadioButton radioButton;
    private Button buttonSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        instanceWidget();

        boolean estado = radioButton.isChecked();

        etBirthday = findViewById(R.id.text_fecha_register);
        etBirthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(RegisterActivity.this, date, calendario
                        .get(Calendar.YEAR), calendario.get(Calendar.MONTH),
                        calendario.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }


    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            calendario.set(Calendar.YEAR, year);
            calendario.set(Calendar.MONTH, monthOfYear);
            calendario.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            actualizarInput();
        }
    };

    private void instanceWidget(){

        Toolbar toolbar = findViewById(R.id.include_toolbar_base);
        ((TextView) findViewById(R.id.text_titulo_toolbar)).setText("Registrar");
        ((TextView) findViewById(R.id.text_titulo_toolbar)).setTextSize(22);
        ((TextView) findViewById(R.id.text_subtitulo_toolbar)).setText("Nuevo paciente");
        toolbar.setElevation(5);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        radioButton = (RadioButton) findViewById(R.id.radio_masculino);
        buttonSiguiente = findViewById(R.id.button_next_register);
        buttonSiguiente.setOnClickListener(this);

    }

    private void actualizarInput() {
        String formatoDeFecha = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(formatoDeFecha, Locale.US);

        etBirthday.setText(sdf.format(calendario.getTime()));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.button_next_register:
                Intent intentRegistro = new Intent(this, NextRegisterActivity.class);
                this.startActivity(intentRegistro);

        }


    }
}
