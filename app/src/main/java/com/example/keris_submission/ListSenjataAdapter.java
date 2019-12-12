package com.example.keris_submission;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.keris_submission.model.Senjata;

import java.util.ArrayList;

public class ListSenjataAdapter extends RecyclerView.Adapter<ListSenjataAdapter.ListViewHolder> {

    private ArrayList<Senjata> listsenjata;

    public ListSenjataAdapter(ArrayList<Senjata> list) {
        this.listsenjata = list;
    }

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public ListSenjataAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.keris_activity, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Senjata senjata = listsenjata.get(position);
        Glide.with(holder.itemView.getContext())
                .load(senjata.getFoto())
                .apply(new RequestOptions())
                .into(holder.imgfoto);
        holder.tvnama.setText(senjata.getNama());
        holder.tvdetail.setText(senjata.getDetail());
        holder.tvtempat.setText(senjata.getAsal());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listsenjata.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
         return listsenjata.size();
    }



    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgfoto;
        TextView tvnama, tvdetail, tvasal, tvtempat;


        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgfoto = itemView.findViewById(R.id.foto_keris);
            tvnama = itemView.findViewById(R.id.nama_senjata);
            tvdetail = itemView.findViewById(R.id.detail_senjata);
            tvasal = itemView.findViewById(R.id.senjata);
            tvtempat = itemView.findViewById(R.id.asal_senjata);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Senjata data);
    }


}
