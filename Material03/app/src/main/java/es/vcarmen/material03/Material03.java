package es.vcarmen.material03;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import java.io.Serializable;

public class Material03 extends AppCompatActivity implements View.OnClickListener, Serializable {

    private Animation abrir,cerrar,derecha,izquierda;
    private FloatingActionButton fab1, fab2, fab3;
    boolean abierto     = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material03);

        fab1 = (FloatingActionButton) findViewById(R.id.fabSuperior);
        fab2 = (FloatingActionButton) findViewById(R.id.fabMedio);
        fab3 = (FloatingActionButton) findViewById(R.id.fabInferior);


        abrir     = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.abrir);
        cerrar    = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.cerrar);
        derecha   = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.derecha);
        izquierda = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.izquierda);

        fab1.setOnClickListener(this);
        fab2.setOnClickListener(this);
        fab3.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fabSuperior:
                Toast.makeText(Material03.this, "Fab Superior tocado", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fabMedio:
                Toast.makeText(Material03.this, "Fab Medio tocado", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fabInferior:
                if(abierto){
                    fab1.startAnimation(cerrar);
                    fab2.startAnimation(cerrar);
                    fab3.startAnimation(izquierda);
                    fab2.setClickable(false);
                    fab1.setClickable(false);
                    abierto = false;
                } else {
                    fab1.startAnimation(abrir);
                    fab2.startAnimation(abrir);
                    fab3.startAnimation(derecha);
                    fab2.setClickable(true);
                    fab1.setClickable(true);
                    abierto = true;
                }
                break;
        }
    }
}
