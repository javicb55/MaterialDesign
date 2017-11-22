package es.vcarmen.material06;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Material06 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material06);

        final TabLayout miTabLayout = (TabLayout) findViewById(R.id.tabLayout);

        final LinearLayout mLinearLayout = (LinearLayout) findViewById(R.id.miLayout);

        //Se queda los elementos del tab centrados
        miTabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        miTabLayout.setTabMode(TabLayout.MODE_FIXED);



        //SE queda todo a la Izquierda
        /*
            miTabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
            miTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        */


        //CAMBIOS de color
        miTabLayout.setTabTextColors(Color.RED, Color.WHITE);
        //miTabLayout.setTabTextColors(Color.argb(255,50,50,50), Color.argb(250,0,200,200));
        //miTabLayout.setTabTextColors(Color.rgb(50,50,50), Color.rgb(0,200,200));

        //Cambios de color de la linea del tab
        miTabLayout.setSelectedTabIndicatorColor(Color.GREEN);
        //Altura
        miTabLayout.setSelectedTabIndicatorHeight(12);


        //Crear TABs
        TabLayout.Tab primerTab = miTabLayout.newTab();
        TabLayout.Tab segundoTab = miTabLayout.newTab();
        TabLayout.Tab tercerTab = miTabLayout.newTab();


        primerTab.setText("TAB 01");
        primerTab.setIcon(R.mipmap.ic_launcher);
        miTabLayout.addTab(primerTab);

        segundoTab.setText("TAB 02");
        segundoTab.setIcon(R.drawable.icono1);
        miTabLayout.addTab(segundoTab);

        tercerTab.setText("TAB 03");
        tercerTab.setIcon(R.drawable.ezreal);
        miTabLayout.addTab(tercerTab,1,true);


        //Escuchador del TAB
        miTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int elegida = miTabLayout.getSelectedTabPosition();

                switch(elegida){
                    case 0:
                        Snackbar.make(mLinearLayout, "Posición 1", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Snackbar.make(mLinearLayout, "Posición 2", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Snackbar.make(mLinearLayout, "Posición 3", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Snackbar.make(mLinearLayout, "Posición 4", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Snackbar.make(mLinearLayout, "Posición 5", Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        Snackbar.make(mLinearLayout, "Posición 6", Toast.LENGTH_SHORT).show();
                        break;
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //Listener de los botones

        Button mAniadir = (Button) findViewById(R.id.btnAniadir);
        mAniadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(miTabLayout.getTabCount() < 6) {
                    switch(miTabLayout.getTabCount()){

                        case 1:
                            miTabLayout.addTab(miTabLayout.newTab().setText("TAB 2"));
                            break;
                        case 2:
                            miTabLayout.addTab(miTabLayout.newTab().setText("TAB 3"));
                            break;
                        case 3:
                            miTabLayout.addTab(miTabLayout.newTab().setText("TAB 4"));
                            break;
                        case 4:
                            miTabLayout.addTab(miTabLayout.newTab().setText("TAB 5"));
                            break;
                        case 5:
                            miTabLayout.addTab(miTabLayout.newTab().setText("TAB 6"));
                            break;

                    }


                    Snackbar.make(mLinearLayout, "El número de Tabs son: " + miTabLayout.getTabCount(), Snackbar.LENGTH_SHORT).show();

                } else {
                    Snackbar.make(mLinearLayout, "Ha llegado al número máximo: " + miTabLayout.getTabCount(), Snackbar.LENGTH_SHORT).show();
                }
            }
        });

        Button mEliminar = (Button) findViewById(R.id.btnEliminar);
        mEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(miTabLayout.getTabCount() > 1) {
                    miTabLayout.removeTabAt(1);
                    miTabLayout.clearOnTabSelectedListeners();
                }else{
                    Snackbar.make(mLinearLayout, "No se puede eliminar más", Snackbar.LENGTH_SHORT).show();
                }
            }
        });

    }


}
