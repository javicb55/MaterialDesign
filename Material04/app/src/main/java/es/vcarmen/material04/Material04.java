package es.vcarmen.material04;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Material04 extends AppCompatActivity implements View.OnClickListener {


    private CoordinatorLayout coordinatorLayout;
    private Button simple, interactivo, personalizado;
    private FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material04);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinadorLayout);
        simple            = (Button) findViewById(R.id.btnSimple);
        interactivo       = (Button) findViewById(R.id.btnInteractivo);
        personalizado     = (Button) findViewById(R.id.btnPersonalizado);
        fab               = (FloatingActionButton) findViewById(R.id.fab);

        simple.setOnClickListener(this);
        interactivo.setOnClickListener(this);
        personalizado.setOnClickListener(this);
        fab.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            //snackbar SOLO
            case R.id.btnSimple:
                Snackbar.make(coordinatorLayout, "Primer Snacbar", Snackbar.LENGTH_LONG).show();
                break;

            //Snackbar Anidado
            case R.id.btnInteractivo:
                Snackbar.make(coordinatorLayout,"Mensaje borrado", Snackbar.LENGTH_LONG)
                        .setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Snackbar.make(coordinatorLayout, "Mensaje Restaurado", Snackbar.LENGTH_SHORT).show();
                            }
                        }).show();
                break;

            //Tercer Snackbar Personalizando color.

            case R.id.btnPersonalizado:
                Snackbar snackbar3 = Snackbar.make(coordinatorLayout,"No hay internet", Snackbar.LENGTH_SHORT)
                        .setActionTextColor(Color.GREEN)
                        .setAction("RETRY", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        });
                View sbView = snackbar3.getView();
                TextView texto = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                texto.setTextColor(Color.GRAY);
                snackbar3.show();
                break;

            case R.id.fab:
                Snackbar snackbarFab = Snackbar.make(coordinatorLayout, "Francisco Javier Collado Barrachina", 5000);
                snackbarFab.show();
        }
    }
}
