package com.example.myapplication;

import static com.example.myapplication.Fragment.ExerciseFragment.TAG_DIALOG_EXERCISE_SAVE;
import static com.example.myapplication.Fragment.ProgramFrag.TAG_DIALOG_PROGRAM_SAVE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import com.example.myapplication.DataBase.ProgramWithExercise;
import com.example.myapplication.DataBase.SportProgram;
import com.example.myapplication.Fragment.ExerciseFragment;
import com.example.myapplication.Fragment.ProgramFrag;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

import com.example.myapplication.Adapter.ProgramAdapter;
import com.example.myapplication.DataBase.DBClient;


public class MainActivity extends AppCompatActivity  {


    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View view = getLayoutInflater().inflate(R.layout.sport_prog, null);

        recyclerView = findViewById(R.id.recyclerview_program);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab = findViewById(R.id.fab_exercise);
        fab.setOnClickListener(v -> showDialog());

        ProgramAdapter.OnNoteListener stateClickListener = new ProgramAdapter.OnNoteListener() {
            @Override
            public void onNoteClick(SportProgram sportProgram, int position) {
                Intent intent = new Intent(MainActivity.this, ExerciseActivity.class);
                startActivity(intent);
            }



        };
        //Log.d("RRRR","onCreate()");

        Disposable disposable = DBClient
                .getInstance(getApplicationContext())
                .getAppDatabase()
                .SportProgramDao()
                .getAll()
                // ?????????? ???????????????????? UI - ?????????????????? ???? ?????????????????????? Flowable ????????????
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(programs -> {
                    ProgramAdapter adapter = new ProgramAdapter(MainActivity.this, programs,stateClickListener);
                    recyclerView.setAdapter(adapter);
                });
    }
    private void showElseDialog() {
        DialogFragment dialogFragment = new ExerciseFragment();
        dialogFragment.show(getSupportFragmentManager(), TAG_DIALOG_EXERCISE_SAVE);
    }
    private void showDialog() {
        DialogFragment dialogFragment = new ProgramFrag();
        dialogFragment.show(getSupportFragmentManager(), TAG_DIALOG_PROGRAM_SAVE);
    }


}