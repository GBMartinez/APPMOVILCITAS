package pe.edu.unmsm.sistemas.appclinica.reserve.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import pe.edu.unmsm.sistemas.appclinica.R;
import pe.edu.unmsm.sistemas.appclinica.reserve.model.Especialidad;
import pe.edu.unmsm.sistemas.appclinica.reserve.viewHolder.EspecialidadViewHolder;

public class ListaEspecialidadAdapter extends RecyclerView.Adapter<EspecialidadViewHolder>{

    private View viewEsp;
    private List<Especialidad> listaEspecialidad;

    public ListaEspecialidadAdapter(List<Especialidad> listaEspecialidad) {
        this.listaEspecialidad = listaEspecialidad;
    }

    @NonNull
    @Override
    public EspecialidadViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        viewEsp = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_especialidad, parent, false);
        EspecialidadViewHolder especialidadViewHolder = new EspecialidadViewHolder(viewEsp);
        return especialidadViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull EspecialidadViewHolder holder, int position) {
        holder.textViewEspecialidad.setText(listaEspecialidad.get(position).getNombre());
    }

    @Override
    public int getItemCount() {
        return listaEspecialidad.size();
    }
}
