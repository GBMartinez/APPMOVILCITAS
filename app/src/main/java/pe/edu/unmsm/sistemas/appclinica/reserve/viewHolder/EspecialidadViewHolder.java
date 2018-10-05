package pe.edu.unmsm.sistemas.appclinica.reserve.viewHolder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import pe.edu.unmsm.sistemas.appclinica.R;

public class EspecialidadViewHolder extends RecyclerView.ViewHolder {

    public TextView textViewEspecialidad;
    public CardView cardViewEspecialidad;
    public ImageView imageViewEspecialidad;

    public EspecialidadViewHolder(View itemView) {
        super(itemView);

        textViewEspecialidad = itemView.findViewById(R.id.text_especialidad_item);
        cardViewEspecialidad = itemView.findViewById(R.id.card_especialidad_item);
        imageViewEspecialidad =  itemView.findViewById(R.id.image_especialidad_item);
    }
}
