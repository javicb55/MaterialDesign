package es.vcarmen.material03;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import java.io.Serializable;


/**
 *  Actividad de FloatingActionButton
 */



public class Material03 extends AppCompatActivity implements View.OnClickListener, Serializable {

    private Animation abrir,cerrar,derecha,izquierda;
    private FloatingActionButton fab1, fab2, fab3, fabUno, fabDos, fabTres;
    boolean abierto         = false;
    boolean abiertoVertical = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material03);

        //FAB verticales
        fab1 = (FloatingActionButton) findViewById(R.id.fabSuperior);
        fab2 = (FloatingActionButton) findViewById(R.id.fabMedio);
        fab3 = (FloatingActionButton) findViewById(R.id.fabInferior);

        //Fab Horizontales
        fabUno = (FloatingActionButton) findViewById(R.id.fabUno);
        fabDos = (FloatingActionButton) findViewById(R.id.fabDos);
        fabTres = (FloatingActionButton) findViewById(R.id.fabTres);


        abrir     = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.abrir);
        cerrar    = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.cerrar);
        derecha   = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.derecha);
        izquierda = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.izquierda);

        fab1.setOnClickListener(this);
        fab2.setOnClickListener(this);
        fab3.setOnClickListener(this);


        fabUno.setOnClickListener(this);
        fabDos.setOnClickListener(this);
        fabTres.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.fabSuperior:
                Toast.makeText(Material03.this, "Fab Superior tocado", Toast.LENGTH_SHORT).show();
                break;

            case R.id.fabUno:
                Toast.makeText(Material03.this, "Fab Uno", Toast.LENGTH_SHORT).show();
                break;

            case R.id.fabDos:
                Toast.makeText(Material03.this, "Fab Dos", Toast.LENGTH_SHORT).show();
                break;

            case R.id.fabTres:
                Toast.makeText(Material03.this, "Fab Dos", Toast.LENGTH_SHORT).show();
                break;

            //QUEDA POR REVISAR
            case R.id.fabMedio:
                if(abiertoVertical){
                    fabUno.startAnimation(cerrar);
                    fabDos.startAnimation(cerrar);
                    fabTres.startAnimation(cerrar);
                    fabTres.setClickable(true);
                    fabDos.setClickable(true);
                    fabUno.setClickable(true);
                    abiertoVertical = false;
                } else{
                    fabUno.startAnimation(abrir);
                    fabDos.startAnimation(abrir);
                    fabTres.startAnimation(abrir);
                    fabTres.setClickable(false);
                    fabDos.setClickable(false);
                    fabUno.setClickable(false);
                    abiertoVertical= true;
                }
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
