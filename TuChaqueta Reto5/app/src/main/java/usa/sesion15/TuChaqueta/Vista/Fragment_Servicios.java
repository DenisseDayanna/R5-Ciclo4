package usa.sesion15.TuChaqueta.Vista;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import usa.sesion15.TuChaqueta.Modelo.Adaptador;
import usa.sesion15.TuChaqueta.Modelo.Entidad;
import usa.sesion15.TuChaqueta.R;


public class Fragment_Servicios extends Fragment {



   // int [] imagen = {R.drawable.se1, R.drawable.se2, R.drawable.se3};

    String TAG = "Fragment_Servicios";

    View v;

    ListView listaServicios;
    Adaptador adaptador;

    TextView prueba;

    // CONEXION A LA BASE DE DATOS: instancia APEX de SQL en Oracle Cloud


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment__servicios, container, false);
        //-----------------------------------------------------------------------------
        listaServicios = (ListView) v.findViewById(R.id.lista_servicios);
        adaptador = new Adaptador(getTablaProductos(), getContext());

        listaServicios.setAdapter(adaptador);

        prueba = (TextView) v.findViewById(R.id.prueba2);
        //-----------------------------------------------------------------------------
        return v;
    }

    private ArrayList<Entidad> getTablaProductos(){
        ArrayList<Entidad> listaServicios = new ArrayList<>();

        /* ================================================================================================== */
        String url = "https://g1f89b7fc4c2d84-tuchaqueta.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/TuChaqueta/servicios";


        RequestQueue requestQueue = Volley.newRequestQueue(getContext());

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //***********************************************************
                try {
                    JSONArray jsonArray = response.getJSONArray("items");
                    for(int i = 0; i < jsonArray.length(); i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        String imagen = jsonObject.getString("imagen");
                        String titulo = jsonObject.getString("titulo");
                        String descripcion = jsonObject.getString("descripcion");

                        listaServicios.add(new Entidad(imagen, titulo, descripcion));
                        prueba.setText(titulo + '\n');

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                //***********************************************************
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestQueue.add(jsonObjectRequest);
        /* ================================================================================================== */

        return listaServicios;
    }

}