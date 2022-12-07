package com.example.myapplication.Adapter;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


import com.example.myapplication.DataBase.ProgramWithExercise;
import com.example.myapplication.R;
import com.example.myapplication.DataBase.SportProgram;

public class ProgramAdapter extends RecyclerView.Adapter<ProgramAdapter.ProgramsViewHolder> {

    private final Context context;
    private final List<SportProgram> programList;
    private final OnNoteListener onClickListener;

   // private final List<State> states;
    public ProgramAdapter(Context mCtx, List<SportProgram> programList, OnNoteListener onClickListener ) {
        this.context = mCtx;
        this.programList = programList;
        this.onClickListener = onClickListener;

    }



    @NonNull
    @Override
    public ProgramsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_program_recycler, parent, false);
        return new ProgramsViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ProgramsViewHolder holder, @SuppressLint("RecyclerView") int position) {
        SportProgram t = programList.get(position);
        holder.textViewName.setText(t.getName());
        holder.textViewDesc.setText(t.getDesc());


        // обработка нажатия
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                // вызываем метод слушателя, передавая ему данные
                onClickListener.onNoteClick(t, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return programList.size();
    }

    static class ProgramsViewHolder extends RecyclerView.ViewHolder  {

        TextView textViewName, textViewDesc;

        public ProgramsViewHolder(View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.textViewName);
            textViewDesc = itemView.findViewById(R.id.textViewDesc);
        }


    }
    public interface OnNoteListener{
        void onNoteClick(SportProgram sportProgram,int position);
    }

}
