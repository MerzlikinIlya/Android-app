package com.example.myapplication;

import static com.example.myapplication.Fragment.ProgramFrag.TAG_DIALOG_PROGRAM_SAVE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;


import com.example.myapplication.DataBase.SportProgram;
import com.example.myapplication.Fragment.ProgramFrag;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

import com.example.myapplication.Adapter.ProgramAdapter;
import com.example.myapplication.DataBase.DBClient;


public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerview_program);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(v -> showDialog());

        ProgramAdapter.OnNoteListener stateClickListener = new ProgramAdapter.OnNoteListener() {
            @Override
            public void onNoteClick(SportProgram sportProgram, int position) {

                DialogFragment dialogFragment = new ProgramFrag();
                dialogFragment.show(getSupportFragmentManager(), TAG_DIALOG_PROGRAM_SAVE);
            }
        };
        //Log.d("RRRR","onCreate()");

        Disposable disposable = DBClient
                .getInstance(getApplicationContext())
                .getAppDatabase()
                .taskDao()
                .getAll()
                // поток интерфейса UI - наблюдает за изменениями Flowable данных
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(programs -> {
                    ProgramAdapter adapter = new ProgramAdapter(MainActivity.this, programs,stateClickListener);
                    recyclerView.setAdapter(adapter);
                });
    }

    private void showDialog() {
        DialogFragment dialogFragment = new ProgramFrag();
        dialogFragment.show(getSupportFragmentManager(), TAG_DIALOG_PROGRAM_SAVE);
    }


}