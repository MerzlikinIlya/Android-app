package com.example.myapplication.Adapter;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.DataBase.Exercise;
import com.example.myapplication.DataBase.SportProgram;
import com.example.myapplication.R;

import java.util.List;

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ProgramsViewHolder> {

    private final Context context;
    private final List<Exercise> exerciseList;
    private final OnNoteListener onClickListener;


    public ExerciseAdapter(Context mCtx, List<Exercise> exerciseList, OnNoteListener onClickListener ) {
        this.context = mCtx;
        this.exerciseList = exerciseList;
        this.onClickListener = onClickListener;

    }



    @NonNull
    @Override
    public ProgramsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_exercise_recycler, parent, false);
        return new ProgramsViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ProgramsViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Exercise t = exerciseList.get(position);
        holder.textViewName.setText(t.getName());



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
        return exerciseList.size();
    }

    static class ProgramsViewHolder extends RecyclerView.ViewHolder  {

        TextView textViewName;

        public ProgramsViewHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
        }


    }
    public interface OnNoteListener{
        void onNoteClick(Exercise exercise,int position);
    }

}
