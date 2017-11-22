package es.vcarmen.material07;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class Material07 extends AppCompatActivity {

    Fragment fragment;
    ViewPager paginador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material07);


        final TabLayout miTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        final LinearLayout miLinearLayout = (LinearLayout) findViewById(R.id.LinearLayout);

        TabLayout.Tab primerTab = miTabLayout.newTab();
        primerTab.setText("PrimerTab").setIcon(R.drawable.primero);
        miTabLayout.addTab(primerTab);

        TabLayout.Tab segundoTab = miTabLayout.newTab();
        segundoTab.setText("SegundoTab").setIcon(R.drawable.segundo);
        miTabLayout.addTab(segundoTab);

        TabLayout.Tab tercerTab = miTabLayout.newTab();
        tercerTab.setText("TercerTab").setIcon(R.drawable.tercero);
        miTabLayout.addTab(tercerTab);

        paginador = (ViewPager) findViewById(R.id.contenedorViewPager);

        /*
        Adaptador adaptador = new Adaptador(getSupportFragmentManager(), miTabLayout.getTabCount());
        paginador.setAdapter(adaptador);
        paginador.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(miTabLayout));
        */


        miTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                switch (tab.getPosition()){

                    case 0:
                        fragment = new Fragmento1();
                        break;
                    case 1:
                        fragment = new Fragmento2();
                        break;
                    case 2:
                        fragment = new Fragmento3();
                        break;
                }
                //gestor
                FragmentManager FM = getSupportFragmentManager();
                //efecto
                FragmentTransaction FT = FM.beginTransaction();
                FT.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                //movimiento del fragmento
                FT.replace(R.id.contenedor, fragment);
                FT.commit();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
