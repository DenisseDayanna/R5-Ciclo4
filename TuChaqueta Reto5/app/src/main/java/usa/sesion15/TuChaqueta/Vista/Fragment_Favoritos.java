package usa.sesion15.TuChaqueta.Vista;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import usa.sesion15.TuChaqueta.Modelo.Adaptador;
import usa.sesion15.TuChaqueta.Modelo.BaseDatos.MotorBaseDatosSQLite;
import usa.sesion15.TuChaqueta.Modelo.Entidad;
import usa.sesion15.TuChaqueta.R;


public class Fragment_Favoritos extends Fragment {

    View v;

    String TAG = "Fragment_Favoritos";

    ListView listaFavoritos;
    Adaptador adaptador;

    int [] imagen = {R.drawable.seleccion, R.drawable.seleccion};

    // CONEXION A LA BASE DE DATOS: SQLite
    MotorBaseDatosSQLite conectar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment__favoritos, container, false);
        //-----------------------------------------------------------------------------

        listaFavoritos = (ListView) v.findViewById(R.id.lista_favoritos);
        adaptador = new Adaptador(getTablaFavoritos(), getContext());

        listaFavoritos.setAdapter(adaptador);

        //-----------------------------------------------------------------------------
        return v;
    }

    private ArrayList<Entidad> getTablaFavoritos(){
        ArrayList<Entidad> listaFavoritos = new ArrayList<>();
        conectar = new MotorBaseDatosSQLite(getContext(),"TiendaProductos", null, 1);
        SQLiteDatabase db_leer = conectar.getReadableDatabase();
        Cursor cursor = db_leer.rawQuery("SELECT * FROM favoritos", null);
        Log.v(TAG, "leyendo base de datos");

        while(cursor.moveToNext()){
            Log.v(TAG, "dentro de while");
            listaFavoritos.add(new Entidad(cursor.getString(0), cursor.getString(1), cursor.getString(2)));
            Log.v(TAG, "despues del while");
        }


        return listaFavoritos;
    }

}