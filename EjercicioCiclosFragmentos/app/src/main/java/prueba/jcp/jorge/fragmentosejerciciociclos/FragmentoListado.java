package prueba.jcp.jorge.fragmentosejerciciociclos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the

 * Use the {@link FragmentoListado#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentoListado extends Fragment {
    private static final String LISTADO_FINAL = "listado final";
    private ArrayList<CicleFlorida> listadoRecibidoPorParametros;

    // Atributos empleados en el ejercicio:
    private RecyclerView rv;
    private ImageButton img;

    private Adaptador adap;
    private LinearLayoutManager llm;

    /**
     * Constructor vacío.
     */
    public FragmentoListado() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment FragmentoListado.
     */
    public static FragmentoListado newInstance(ArrayList<CicleFlorida> listadoFinal) {
        FragmentoListado fragment = new FragmentoListado();
        Bundle args = new Bundle();
        args.putParcelableArrayList(LISTADO_FINAL, listadoFinal);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            listadoRecibidoPorParametros = getArguments().getParcelableArrayList(LISTADO_FINAL);
        }

    }

    /**
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return view
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragmento_listado, container, false);

        rv = (RecyclerView) v.findViewById(R.id.recycler);
        img = (ImageButton) v.findViewById(R.id.cvImagenAdd);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), AddGrado.class);
                startActivityForResult(i, 1);
                Log.d("intent", "test");
            }
        });

        llm = new LinearLayoutManager(v.getContext());
        adap = new Adaptador(listadoRecibidoPorParametros);

        rv.setLayoutManager(llm);
        rv.setAdapter(adap);

        return v;
    }

    /**
     *
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    /**
     * Método onDetatch
     */
    @Override
    public void onDetach() {
        super.onDetach();
    }

}
