package com.example.Jajoo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.Jajoo.model.Task;


public class AddTaskActivity extends TaskManagerActivity {
    private EditText editText;
    private Button add_task_button;
    private Button cancel_button;
    private boolean textChanged;
    private AlertDialog textChangedDialog;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_task);
        setUpViews();
        
    }

    private void setUpViews() {
        editText = (EditText) findViewById(R.id.edit_text);
        add_task_button = (Button) findViewById(R.id.add_task_button);
        cancel_button = (Button) findViewById(R.id.cancel_task_button);

        add_task_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTask();
            }
        });

        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
            }
        });

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textChanged = true;
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });


    }

    private void cancel() {

        if (textChanged) {

            textChangedDialog = new AlertDialog.Builder(this)
                    .setTitle(R.string.unsaved_title)
                    .setMessage(R.string.unsaved_message)
                    .setPositiveButton(R.string.add_task, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            addTask();
                        }
                    })

                    .setNeutralButton(R.string.discard, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })

                    .setNegativeButton(R.string.cancel_task, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            textChangedDialog.cancel();
                        }
                    }).create();

            textChangedDialog.show();

        } else {
            finish();
        }
    }

    private void addTask() {

        String taskString = editText.getText().toString();
        if (taskString != null && taskString.length() > 0){
            Task task = new Task(taskString);
            getTaskManagerApplication().addTask(task);
            finish();
        }
    }

}