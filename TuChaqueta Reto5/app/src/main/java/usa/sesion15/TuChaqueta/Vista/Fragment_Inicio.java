package usa.sesion15.TuChaqueta.Vista;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import usa.sesion15.TuChaqueta.R;


public class Fragment_Inicio extends Fragment {


    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment__inicio, container, false);
        //-----------------------------------------------------------------------------


        //-----------------------------------------------------------------------------
        return v;

    }

}