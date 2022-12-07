package com.example.myapplication;

import static com.example.myapplication.Fragment.ExerciseFragment.TAG_DIALOG_EXERCISE_SAVE;
import static com.example.myapplication.Fragment.ProgramFrag.TAG_DIALOG_PROGRAM_SAVE;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter.ExerciseAdapter;
import com.example.myapplication.DataBase.DBClient;
import com.example.myapplication.DataBase.Exercise;
import com.example.myapplication.Fragment.ExerciseFragment;
import com.example.myapplication.Fragment.ProgramFrag;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;


public class ExerciseActivity extends MainActivity
{


    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise);

        recyclerView = findViewById(R.id.recyclerview_program);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab = findViewById(R.id.fab_exercise);
        fab.setOnClickListener(v -> showElseDialog());

        ExerciseAdapter.OnNoteListener stateClickListener = new ExerciseAdapter.OnNoteListener() {
            @Override
            public void onNoteClick(Exercise exercise, int position) {
                DialogFragment dialogFragment = new ProgramFrag();
                dialogFragment.show(getSupportFragmentManager(), TAG_DIALOG_PROGRAM_SAVE);

            }

        };
        //Log.d("RRRR","onCreate()");

        Disposable disposable = DBClient
                .getInstance(getApplicationContext())
                .getAppDatabase()
                .ExersiceDAO()
                .getExercise()
                // поток интерфейса UI - наблюдает за изменениями Flowable данных
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(exercises -> {
                    ExerciseAdapter adapter = new ExerciseAdapter(ExerciseActivity.this, exercises,stateClickListener);
                    recyclerView.setAdapter(adapter);
                });
    }
    private void showElseDialog() {
        DialogFragment dialogFragment = new ExerciseFragment();
        dialogFragment.show(getSupportFragmentManager(), TAG_DIALOG_EXERCISE_SAVE);
    }



}