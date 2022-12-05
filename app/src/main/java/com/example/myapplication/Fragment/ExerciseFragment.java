package com.example.myapplication.Fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;


import com.example.myapplication.DataBase.Exercise;
import com.example.myapplication.R;
import com.example.myapplication.DataBase.SportProgram;
import com.example.myapplication.DataBase.DBClient;


public class ExerciseFragment extends DialogFragment {

    private Context context;
    public static final String TAG_DIALOG_EXERCISE_SAVE = "exercise_save";

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        View view = getActivity().getLayoutInflater().inflate(R.layout.add_exercise, null);
        final EditText nameEx = view.findViewById(R.id.Name);
        final EditText time = view.findViewById(R.id.Time);
        final EditText desc = view.findViewById(R.id.Descriptions);

        alertDialogBuilder.setView(view)
                .setTitle(getString(R.string.addtasktitle))
                .setPositiveButton(R.string.save, (dialog, which) -> saveExercise(nameEx.getText().toString(),
                                                                                  time.getText().toString(),
                                                                                  desc.getText().toString()))
                .setNegativeButton(R.string.cancel, (dialog, which) -> dialog.cancel());

        return alertDialogBuilder.create();
    }

    private void saveExercise(String nameEx, String time, String desc  ) {
        if (TextUtils.isEmpty(nameEx) || TextUtils.isEmpty(time)|| TextUtils.isEmpty(desc) ) {
            return;
        }

        new Thread(() -> {DBClient.getInstance(context).getAppDatabase()
                .ExersiceDAO()
                .insert(new Exercise(nameEx,desc,Integer.valueOf(time)));
        }).start();


    }

}