package com.example.myapplication.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


import com.example.myapplication.R;
import com.example.myapplication.DataBase.SportProgram;

public class SportProgAdapter extends RecyclerView.Adapter<SportProgAdapter.ProgramsViewHolder> {

    private final Context context;
    private final List<SportProgram> programList;

    public SportProgAdapter(Context mCtx, List<SportProgram> programList) {
        this.context = mCtx;
        this.programList = programList;
    }



    @NonNull
    @Override
    public ProgramsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recyclerview, parent, false);
        return new ProgramsViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ProgramsViewHolder holder, int position) {
        SportProgram t = programList.get(position);
        holder.textViewName.setText(t.getName());
        holder.textViewDesc.setText(t.getDesc());

    }

    @Override
    public int getItemCount() {
        return programList.size();
    }

    static class ProgramsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewName, textViewDesc;

        public ProgramsViewHolder(View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.textViewName);
            textViewDesc = itemView.findViewById(R.id.textViewDesc);



            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }


}
