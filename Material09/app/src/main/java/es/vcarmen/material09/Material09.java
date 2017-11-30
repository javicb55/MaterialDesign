package es.vcarmen.material09;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

public class Material09 extends AppCompatActivity {

    private Toolbar mtoolbar;
    private static final int DURATICION = 250;
    ImageView icono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material09);

        icono = (ImageView) findViewById(R.id.imagen2);


        mtoolbar = (Toolbar) findViewById(R.id.toolbar1);

        mtoolbar.setTitle("El huargo de Jon Snow");
        mtoolbar.setSubtitle("Juego de Tronos");
        //para que lo escuche
        mtoolbar.inflateMenu(R.menu.menu);
        //para que escuche el hacer click
        mtoolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.opcion1:
                        Toast.makeText(Material09.this, "Pulsado Opción 1", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.opcion2:
                        Toast.makeText(Material09.this, "Pulsado Opción 2", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.opcion3:
                        Toast.makeText(Material09.this, "Pulsado Opción 3", Toast.LENGTH_SHORT).show();
                        break;
                }

                return true;
            }
        });

    }

    private void rotatar(float angulo){
        Animation animacion = new RotateAnimation(0.0f, angulo, Animation.RELATIVE_TO_SELF,
                0.5f,Animation.RELATIVE_TO_SELF,0.5f);

        animacion.setFillAfter(true);
        animacion.setDuration(DURATICION);
        icono.startAnimation(animacion);
    }


}
