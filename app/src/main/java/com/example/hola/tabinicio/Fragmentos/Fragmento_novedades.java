package com.example.hola.tabinicio.Fragmentos;




import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hola.tabinicio.R;


/**
 * Created by hola on 19/09/2016.
 */


public class Fragmento_novedades extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //agregamos el método del RecyclerView para poder usar el recycleview creado el layout
        RecyclerView recyclerView=(RecyclerView) inflater.inflate(R.layout.recycle_view,container,false);

        //agregamos contenido al adaptador
        ContentAdapter adapter = new ContentAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //en este fragmento regresamos el recyclerview
        return recyclerView;
    }

    //clase para poblar el recyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder {

        //método para el contenido y poder usar el evento click
        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.fragmento_novedades, parent, false));
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
        }
    }


     // clase para visualizar el contenido del fragmento_layout creado en una lista
    public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {
        // cantidad a visualizar en la lista
        private static final int LENGTH = 18;

        public ContentAdapter() {
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            // no-op
        }

        @Override
        public int getItemCount() {
            return LENGTH;
        }
    }

}
