package es.vcarmen.material07;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by matinal on 17/11/17.
 */

public class Fragmento3 extends Fragment {


    WebView Wv;
    String url = "https://www.google.es";
    Activity act;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mVista = inflater.inflate(R.layout.primero,container,false);

        Wv = (WebView) mVista.findViewById(R.id.webView1);
        Wv.loadUrl(url);

        return mVista;
    }
}
