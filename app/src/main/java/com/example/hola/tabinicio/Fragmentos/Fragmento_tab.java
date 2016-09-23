package com.example.hola.tabinicio.Fragmentos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hola.tabinicio.R;

import java.util.ArrayList;
import java.util.List;
import android.support.v4.app.Fragment;
/**
 * Created by hola on 19/09/2016.
 */
public class Fragmento_tab extends Fragment {

    //llamamos a viewpager que se creó en layout
    private ViewPager viewPager;
    //llamamos al TabLayout que esta implementado en el layout activity_main
    private TabLayout pestanas;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //llamamos al método view para poder usar los componentes del layout en un fragmento
        //dibujamos el layout en este fragmento con R.layout.fragmento_tab_viewpage
        View view = inflater.inflate(R.layout.fragmento_tab_viewpage, container, false);
        if (savedInstanceState == null) {

            // Setear adaptador al viewpager.
            viewPager = (ViewPager) view.findViewById(R.id.pagina);

            //poblamos el ViewPager
            poblarViewPager(viewPager);

            //insertamos los Tabs
            insertarTabs(container);


            pestanas.setupWithViewPager(viewPager);

            //agregamos los iconos en el los tabs
            pestanas.getTabAt(0).setIcon(R.drawable.ic_novedades);
            pestanas.getTabAt(1).setIcon(R.drawable.ic_speaker);
            pestanas.getTabAt(2).setIcon(R.drawable.ic_conferencia);
            pestanas.getTabAt(3).setIcon(R.drawable.ic_codelab);
            pestanas.getTabAt(4).setIcon(R.drawable.ic_feria);
        }

        //devolvemos el view para visualizar el layotu dibujado en este fragmento
        return view;
    }
    private void insertarTabs(ViewGroup container) {
        //abrimos un view para poder llamar al tabs
        View padre = (View) container.getParent();
        pestanas = (TabLayout)padre.findViewById(R.id.tabs);
    }
    private void poblarViewPager(ViewPager viewPager) {
        //aquí agregamos los fragmentos a un adaptador
        AdaptadorSecciones adapter = new AdaptadorSecciones(getFragmentManager());
        adapter.addFragment(new Fragmento_novedades());
        adapter.addFragment(new Fragmento_novedades());
        adapter.addFragment(new Fragmento_novedades());
        adapter.addFragment(new Fragmento_novedades());
        adapter.addFragment(new Fragmento_novedades());

        //seteamos el adaptador donde cargamos los fragmentos
        //en la clase de abajo es donde cargamos y mostramos los fragmentos
        //que se mostrara en cada tab
        viewPager.setAdapter(adapter);
    }

    //creamos una clase para extender los métodos de FragmentStatePagerAdapter
    //así poder usar estos métodos para mostrar los contenidos de los framentos
    public class AdaptadorSecciones extends FragmentStatePagerAdapter {

        //lista para cada fragmento cargado y para mostrar
        private final List<android.support.v4.app.Fragment> fragmentos = new ArrayList<>();

        //método para cada sección de los fragmentos
        public AdaptadorSecciones(FragmentManager fm) {
            super(fm);
        }

        //buscamos los fragmentos en cada posición
        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            return fragmentos.get(position);
        }

        //contamos los fragmentos
        @Override
        public int getCount() {
            return fragmentos.size();
        }

        //agregamos los fragmentos
        public void addFragment(android.support.v4.app.Fragment fragment) {
            fragmentos.add(fragment);
        }


    }
}
