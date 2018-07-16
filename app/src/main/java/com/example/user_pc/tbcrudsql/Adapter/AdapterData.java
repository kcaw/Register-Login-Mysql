package com.example.user_pc.tbcrudsql.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user_pc.tbcrudsql.InsertData;
import com.example.user_pc.tbcrudsql.Model.ModelData;
import com.example.user_pc.tbcrudsql.R;

import java.util.List;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {
    private List<ModelData> mItems;
    private Context context;

    public AdapterData (Context context, List<ModelData> items)
    {
        this.mItems = items;
        this.context = context;
    }

    @Override
    public HolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_row,parent,false);
        HolderData holderData = new HolderData(layout);
        return holderData;

    }

    @Override
    public void onBindViewHolder(HolderData holder, int position) {
        ModelData md = mItems.get(position);
        holder.tvnama.setText(md.getNama());
        holder.tvnpm.setText(md.getNpm());

        holder.md = md;


    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class HolderData extends RecyclerView.ViewHolder
    {
        TextView tvnama,tvnpm;
        ModelData md;

        public HolderData (View view)
        {
            super(view);

            tvnama = (TextView) view.findViewById(R.id.nama);
            tvnpm = (TextView) view.findViewById(R.id.npm);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent update = new Intent(context, InsertData.class);
                    update.putExtra("update",1);
                    update.putExtra("npm", md.getNpm());
                    update.putExtra("nama", md.getNama());
                    update.putExtra("prodi", md.getProdi());
                    update.putExtra("fakultas", md.getFakultas());

                    context.startActivity(update);
                }
            });
        }
    }
}
