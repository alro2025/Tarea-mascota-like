package com.alro2025.mascotaslike;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import static com.alro2025.mascotaslike.R.id.rvContactos;

public class ranking extends AppCompatActivity {

    ArrayList<ContactoMascota> contactos;
    private RecyclerView listaContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);


        Bundle parametros = getIntent().getExtras();

        String[] nombres = parametros.getStringArray("nombres");
        int[] fotos = parametros.getIntArray("fotos");
        int[] likes = parametros.getIntArray("likes");

        listaContactos = (RecyclerView) findViewById(rvContactos);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaContactos.setLayoutManager(llm);
        contactos = new ArrayList<ContactoMascota>();
        contactos.add(new ContactoMascota(fotos[0], nombres[0]));
        contactos.add(new ContactoMascota(fotos[1], nombres[1]));
        contactos.add(new ContactoMascota(fotos[2], nombres[2]));
        contactos.add(new ContactoMascota(fotos[3], nombres[3]));
        contactos.add(new ContactoMascota(fotos[4], nombres[4]));

        for (int i=0; i < contactos.size(); i++){
            contactos.get(i).setNumlikes(likes[i]);
        }

        inicializarAdaptador();
    }

    public ContactoAdaptador adaptador;
    public void inicializarAdaptador(){
        adaptador = new ContactoAdaptador(contactos, this);
        listaContactos.setAdapter(adaptador);
    }





}
