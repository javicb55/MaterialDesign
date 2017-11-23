package es.vcarmen.material07;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;


/**
 * Created by matinal on 17/11/17.
 */

public class Adaptador extends FragmentStatePagerAdapter {

    private Fragmento1 primero;
    private Fragmento2 segundo;
    private Fragmento3 tercero;

    private int numTab;

    public Adaptador(FragmentManager fm, int numTab) {
        super(fm);
        this.numTab = numTab;
    }



    @Override
    public Fragment getItem(int index) {

        switch(index){
            case 0:
                primero = new Fragmento1();
                return primero;
            case 1:
                segundo = new Fragmento2();
                return segundo;
            case 2:
                tercero = new Fragmento3();
                return tercero;

        }
        return primero;
    }

    @Override
    public int getCount() {
        return numTab;
    }
}
