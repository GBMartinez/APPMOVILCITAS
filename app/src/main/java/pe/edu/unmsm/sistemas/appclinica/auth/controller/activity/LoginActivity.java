package pe.edu.unmsm.sistemas.appclinica.auth.controller.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import pe.edu.unmsm.sistemas.appclinica.R;
import pe.edu.unmsm.sistemas.appclinica.auth.service.LoginService;
import pe.edu.unmsm.sistemas.appclinica.home.controller.activity.InicioActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextUsuario;
    private TextInputEditText editTextContrasena;
    private Button buttonIngresar;
    private CheckBox checkBoxRecordar;
    private TextView textViewCrearCuenta;

    private boolean boolRecordar;

    private SharedPreferences mSharedPreferences;
    public static final String PREFERENCE = "preference";
    public static final String PREF_USER = "user";
    public static final String PREF_PASS = "pass";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        instanceWidgets();

        mSharedPreferences = this.getSharedPreferences(PREFERENCE, MODE_PRIVATE);

        if (mSharedPreferences.contains(PREF_USER) && mSharedPreferences.contains(PREF_PASS)) {
            editTextUsuario.setText(leerValor(this,PREF_USER));
            editTextContrasena.setText(leerValor(this,PREF_PASS));
            checkBoxRecordar.setChecked(true);
            boolRecordar=true;
        }
    }

    private void instanceWidgets(){

        editTextUsuario = findViewById(R.id.edittext_usuario_login);
        editTextContrasena = findViewById(R.id.edittext_password_login);
        checkBoxRecordar = findViewById(R.id.checkbox_login);
        textViewCrearCuenta = findViewById(R.id.text_cuenta_login);
        textViewCrearCuenta.setOnClickListener(this);
        buttonIngresar = findViewById(R.id.button_ingresar_login);
        buttonIngresar.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.button_ingresar_login:

             /*   if(editTextContrasena.getText().toString().isEmpty() || editTextUsuario.getText().toString().isEmpty()){
                    Toast.makeText(this, "Ingrese datos solicitados", Toast.LENGTH_SHORT).show();
                }else{

                    validarUsuario();
                }*/
                validarUsuario();
                break;

            case R.id.checkbox_login:
                boolRecordar = ((CheckBox) v).isChecked();
                break;

            case R.id.text_cuenta_login:
                Intent intentRegistro = new Intent(this, RegisterActivity.class);
                this.startActivity(intentRegistro);

        }
    }

    private void validarUsuario(){
/*
        usuario = new Usuario();
        usuario.setId(etUsuario.getText().toString().trim().toLowerCase());
        usuario.setPass(etContrasenia.getText().toString());
        String parametro = GsonUtil.getGson().toJson(usuario);
*/

        String recordar = "verdad";
        if(!boolRecordar){
            recordar = "falso";
        }

        Intent intentCarga = new Intent(this, InicioActivity.class);
        //intentCarga.putExtra("recordar",recordar);
        this.startActivity(intentCarga);
    }


    public static String leerValor(Context context, String keyPref) {
        SharedPreferences preferences = context.getSharedPreferences(PREFERENCE, MODE_PRIVATE);
        return  preferences.getString(keyPref, "");
    }
}
