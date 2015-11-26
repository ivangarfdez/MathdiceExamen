package com.example.ivan.mathdice3ivangarcia;

/**
 * Created by IvanGarciaFernandez on 18/11/15.
 */

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends Activity implements Fragment_Lista.ListFragmentListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.contenido) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }


            Bundle bundle = getIntent().getExtras();

            //Recogemos los datos.
            String nombre = bundle.getString("nombre");
            String edad = bundle.getString("edad");


            //Hacemos el log y para ver lo que pasa
            Log.i(nombre, "nombre");
            Log.i(edad,"edad");

            //Declaramos un nuevo Fragment para mostrar al lanzar...
            Fragment_Perfil firstFragment = new Fragment_Perfil();

            // Add the fragment to the 'fragment_container' FrameLayout
            getFragmentManager().beginTransaction()
                    .add(R.id.contenido, firstFragment).commit();
        }
    }

    public void onListSelected(int position) {
        // Log.i("FRAGENT", "Llego");

        if (position == 0) {
            Toast.makeText(this, "Perfil", Toast.LENGTH_LONG).show();

            Fragment_Perfil FragmentparaPerfil = new Fragment_Perfil();
            getFragmentManager().beginTransaction().replace(R.id.contenido, FragmentparaPerfil).commit();}

            if (position == 1) {
                Toast.makeText(this, "Juego", Toast.LENGTH_LONG).show();
            }

            if (position == 2) {
                Toast.makeText(this, "Instrucciones", Toast.LENGTH_LONG).show();
            }
            if (position == 3) {
                Toast.makeText(this, "Informacion", Toast.LENGTH_LONG).show();
            }
            if (position == 4) {
                Toast.makeText(this, "¡¡¡WELCOME TO MATHDICE!!!", Toast.LENGTH_LONG).show();
            }


        }
    }

