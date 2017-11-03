package es.vcarmen.material01;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class Material01 extends AppCompatActivity {

    private TextInputLayout controlNombre;
    private TextInputLayout controlCorreo;
    private TextInputLayout controlNumero;

    private EditText campoNombre;
    private EditText campoCorreo;
    private EditText campoNumero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material01);

        //FindViews
        controlNombre = (TextInputLayout) findViewById(R.id.controlNombre);
        controlCorreo = (TextInputLayout) findViewById(R.id.controlCorreo);
        controlNumero = (TextInputLayout) findViewById(R.id.controlTelefono);
        campoNombre   = (EditText) findViewById(R.id.campoNombre);
        campoCorreo   = (EditText) findViewById(R.id.campoCorreo);
        campoNumero   = (EditText) findViewById(R.id.campoTelefono);

        Button btnAceptar = (Button) findViewById(R.id.btnAceptarXML);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarDatos();
            }
        });


        //Watcher para el campo de Nombre
        campoNombre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                controlNombre.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //Watcher para el campo de Correo
        campoCorreo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                controlCorreo.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        //Watcher para el telefono
        campoNumero.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                controlNumero.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }



    //Metodos de validación
    private boolean esNombreValido(String nombre){
        Pattern patron = Pattern.compile("^[a-zA-Z ]+$");

        if(!patron.matcher(nombre).matches() || nombre.length() > 30){
            controlNombre.setError("Error en el nombre");
            return false;
        }else{
            controlNombre.setError(null);
        }

        return true;
    }


    private boolean esCorreoValido(String correo){
        if(!Patterns.EMAIL_ADDRESS.matcher(correo).matches()){
            controlCorreo.setError("Error en correo");
            return false;
        } else {
            controlCorreo.setError(null);
        }
        return true;
    }


    private boolean esTelefonoValido(String telefono){
        if(!Patterns.PHONE.matcher(telefono).matches()){
            controlNumero.setError("Error número");
            return false;
        } else{
            controlNumero.setError(null);
        }
        return true;
    }

    private void validarDatos(){
        String nombre   = controlNombre.getEditText().getText().toString();
        String correo   = controlCorreo.getEditText().getText().toString();
        String telefono = controlNumero.getEditText().getText().toString();

        boolean a = esNombreValido(nombre);
        boolean b = esCorreoValido(correo);
        boolean c = esTelefonoValido(telefono);

        if(a && b && c){
            Toast.makeText(this,"Registro correcto", Toast.LENGTH_LONG).show();
        }
    }



}
