package prueba.jcp.jorge.fragmentosejerciciociclos;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Botones:
 */
public class fragmentoBotones extends Fragment implements View.OnClickListener {

    private Button btnDeporte;
    private Button btnEmpresa;
    private Button btnInformatica;
    private ComunicacionFragmentoBotones comunicador;

     /* --------------------------------------->
    NO SON NECESARIOS LOS PARAMETROS
     <----------------------------------------- */

    /* -------------------------------------------------------------->
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    <------------------------------------------------------------------- */




    public fragmentoBotones() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_fragmento_botones, container, false);
        /* &------------------------------------------------>

        Asignar objetos Java a los elementos del XML.

         <------------------------------------------------& */

        btnDeporte = v.findViewById(R.id.btnDeporte);
        btnEmpresa = v.findViewById(R.id.btnEmpresa);
        btnInformatica = v.findViewById(R.id.btnInformatica);

        /* -------------------------------------------->
        ASIGNAMOS UN LISTENER A CADA BOTON
         <---------------------------------------------- */

        btnInformatica.setOnClickListener(this);
        btnEmpresa.setOnClickListener(this);
        btnDeporte.setOnClickListener(this);

        return  v;
    }

    /*
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.ComunicacionFragmentoBotones();
        }
    }

    */

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ComunicacionFragmentoBotones) {
            comunicador = (ComunicacionFragmentoBotones) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement comunicacionConActivity");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        comunicador = null;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnDeporte) {
            comunicador.mostrarCicloDeportes();
        }
        if(view.getId() == R.id.btnEmpresa){
            comunicador.mostrarCicloEmpresa();
        }
        if(view.getId() == R.id.btnInformatica){
            comunicador.mostrarCicloInformatica();
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface ComunicacionFragmentoBotones {
        // TODO: Update argument type and name
        void mostrarCicloDeportes();
        void mostrarCicloEmpresa();
        void mostrarCicloInformatica();
    }
}
