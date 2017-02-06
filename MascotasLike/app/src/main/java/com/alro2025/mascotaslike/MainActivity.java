package com.alro2025.mascotaslike;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import java.util.ArrayList;

import static com.alro2025.mascotaslike.R.id.rvContactos;
import static com.alro2025.mascotaslike.R.menu.top5;

public class MainActivity extends AppCompatActivity {
    ArrayList <ContactoMascota> contactos;
    private RecyclerView listaContactos;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        contactos = new ArrayList<ContactoMascota>();
        listaContactos = (RecyclerView) findViewById(rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaContactos.setLayoutManager(llm);
        inicializaListaContactos();
        inicializaAdaptador();
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(top5, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){

        switch (item.getItemId()) {
            case R.id.btnStar:
                Intent intent = new Intent(this, ranking.class);
                ArrayList<ContactoMascota> ranking = contactos;
                do {
                    int index = 0;
                    int likes = 0;
                    likes = ranking.get(0).getNumlikes();
                    for (int i = 0; i < ranking.size(); i++) {

                        if (ranking.get(i).getNumlikes() <= likes) {
                            likes = ranking.get(i).getNumlikes();
                            index = i;
                        }
                    }
                    ranking.remove(ranking.get(index));
                } while (ranking.size() > 5);

                int i = 0;
                int[] fotos = new int[5];
                int[] likes = new int[5];
                String[] nombre = new String[5];

                for (ContactoMascota pet : ranking) {
                    fotos[i] = pet.getFoto();
                    nombre[i] = pet.getNombre();
                    likes[i] = pet.getNumlikes();
                    i++;
                }

                intent.putExtra("nombres", nombre);
                intent.putExtra("fotos", fotos);
                intent.putExtra("likes", likes);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected (item);
    }




    public ContactoAdaptador adaptador;
    public void inicializaAdaptador(){
        adaptador = new ContactoAdaptador(contactos, this);
        listaContactos.setAdapter(adaptador);


    }

    public void inicializaListaContactos(){

        contactos.add(new ContactoMascota(R.drawable.burro, "BURRO"));
        contactos.add(new ContactoMascota(R.drawable.dino, "DINO"));
        contactos.add(new ContactoMascota(R.drawable.frank_mib, "FRANK"));
        contactos.add(new ContactoMascota(R.drawable.garfield, "GARFIELD"));
        contactos.add(new ContactoMascota(R.drawable.perry, "PERRY"));
        contactos.add(new ContactoMascota(R.drawable.pluto, "PLUTO"));
        contactos.add(new ContactoMascota(R.drawable.salem, "SALEM"));
        contactos.add(new ContactoMascota(R.drawable.scooby_doo, "SCOOBY DOO"));

    }
}
