package com.example.hola.tabinicio;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.example.hola.tabinicio.Fragmentos.Fragmento_tab;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //agregamos la barra superior donde está el nombre del activity
        agregarToolbar();

        //creamos un fragmento para contener a los tabs
        Fragment fragmentoGenerico = null;
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentoGenerico = new Fragmento_tab();

        //agregamos al contenedor que están en el xml del activity_main
        //el contenedor es un RelativeLayout
        if (fragmentoGenerico != null) {
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.contenedor_principal, fragmentoGenerico)
                    .commit();
        }
    }


    private void agregarToolbar() {
        //creamos e toolbar que es la barra superior
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //activamos el icono de atrás del activity en la parte superior
        //en este caso esta falso porque no lo necesitamos solo para ejemplo esta
        //actívenlo y vean al icono que me refiero
        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            // Poner ícono del drawer toggle
            ab.setDisplayHomeAsUpEnabled(false);
        }

    }

    //aquí llamamos al método definido por el activity
    //escribimos onCreate luego Crtl+espacio y se mostrara los metodos, buscamos
    //este método
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //con esta línea de código buscamos el menú que creamos en la carpeta
        //res - menu - menu_tab
        //ojo esa carpeta se tiene q crear
        getMenuInflater().inflate(R.menu.menu_tab, menu);
        return true;
    }


}
