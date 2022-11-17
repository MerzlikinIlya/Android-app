package com.example.myapplication;

import static com.example.myapplication.Fragment.SportProgFrag.TAG_DIALOG_PROGRAM_SAVE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import com.example.myapplication.Adapter.SportProgAdapter;
import com.example.myapplication.DataBase.DBClient;
import com.example.myapplication.DataBase.SportProgram;
import com.example.myapplication.Fragment.SportProgFrag;

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
        //Log.d("RRRR","onCreate()");
        Disposable disposable = DBClient
                .getInstance(getApplicationContext())
                .getAppDatabase()
                .taskDao()
                .getAll()
                // поток интерфейса UI - наблюдает за изменениями Flowable данных
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(tasks -> {
                    SportProgAdapter adapter = new SportProgAdapter(MainActivity.this, tasks);
                    recyclerView.setAdapter(adapter);
                });
    }
    private void showDialog() {
        DialogFragment dialogFragment = new SportProgFrag();
        dialogFragment.show(getSupportFragmentManager(), TAG_DIALOG_PROGRAM_SAVE);
    }
}