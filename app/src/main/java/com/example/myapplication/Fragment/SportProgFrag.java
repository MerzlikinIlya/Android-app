package com.example.myapplication.Fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;


import com.example.myapplication.R;
import com.example.myapplication.DataBase.SportProgram;
import com.example.myapplication.DataBase.SportProgramDAO;
import com.example.myapplication.DataBase.DB;
import com.example.myapplication.DataBase.DBClient;




public class SportProgFrag extends DialogFragment {

    private Context context;
    public static final String TAG_DIALOG_PROGRAM_SAVE = "program_save";

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
        View view = getActivity().getLayoutInflater().inflate(R.layout.sport_prog, null);
        final EditText name = view.findViewById(R.id.Name);
        final EditText desc = view.findViewById(R.id.Desc);

        alertDialogBuilder.setView(view)
                .setTitle(getString(R.string.addtasktitle))
                .setPositiveButton(R.string.save, (dialog, which) -> saveSportprog(name.getText().toString(),desc.getText().toString()))
                .setNegativeButton(R.string.cancel, (dialog, which) -> dialog.cancel());

        return alertDialogBuilder.create();
    }

    private void saveSportprog(String name, String desc) {
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(desc)) {
            return;
        }

        new Thread(() -> {DBClient.getInstance(context).getAppDatabase()
                .taskDao()
                .insert(new SportProgram(name, desc));
        }).start();

    }
}
