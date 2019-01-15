package prueba.jcp.jorge.fragmentosejerciciociclos;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Clase de Adaptador del list view.
 *
 * @author marta
 */
public class Adaptador extends RecyclerView.Adapter<Adaptador.ClientViewHolder> {
    private ArrayList<CicleFlorida> listadoCiclos;

    /**
     * Método constructor:
     *
     * @param listado
     */
    public Adaptador(ArrayList<CicleFlorida> listado) {
        listadoCiclos = listado;
    }

    /**
     * Inflando el elemento creado:
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public Adaptador.ClientViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_ciclos,
                parent, false);
        return new ClientViewHolder(v);
    }

    /**
     * Aplicando texto correspondiente a textviews.
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(Adaptador.ClientViewHolder holder, int position) {
        holder.tvTitulo.setText(listadoCiclos.get(position).getTitol());
        holder.tvDesc.setText(listadoCiclos.get(position).getDescripcio());
        holder.tvTipo.setText(listadoCiclos.get(position).getTipus());
        holder.tvFam.setText(listadoCiclos.get(position).getFamiliaProfessional());
    }

    /**
     *
     * @return listadoCiclos.size()
     */
    @Override
    public int getItemCount() {
        return listadoCiclos.size();
    }

    /**
     * Clase interna: Hereda de RecyclerView:
     */
    public static class ClientViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitulo, tvDesc, tvTipo, tvFam;
        private ImageButton img;
        private CardView cv;
        private int pos;

        /**
         * Coge los elementos correspondientes.
         * @param itemView
         */
        public ClientViewHolder(View itemView) {
            super(itemView);
            tvTitulo = (TextView) itemView.findViewById(R.id.tvTitulo);
            tvDesc = (TextView) itemView.findViewById(R.id.tvDesc);
            tvTipo = (TextView) itemView.findViewById(R.id.tvTipo);
            tvFam = (TextView) itemView.findViewById(R.id.tvFam);
            // Imágen:
            img = (ImageButton) itemView.findViewById(R.id.cvImagen);
            // Card view:
            cv = (CardView) itemView.findViewById(R.id.card_view);

            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("intent", "Hola");
                }
            });

        }

    }
}
