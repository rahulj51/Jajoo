package com.example.Jajoo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.Jajoo.model.Task;

import java.util.List;

public class ViewTasksActivity extends TaskManagerActivity {
    private Button addButton;
    private TextView taskText;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setUpViews();
    }

    @Override
    protected void onResume() {
        super.onResume();
        showTasks();
    }

    private void showTasks() {
        List<Task> tasks = getTaskManagerApplication().getCurrentTasks();
        StringBuffer sb = new StringBuffer("");
        for(Task t : tasks) {
            sb.append("* " + t.toString() + "\n");
        }
        taskText.setText(sb.toString());

    }

    private void setUpViews() {
        addButton = (Button) findViewById(R.id.add_button);
        taskText  = (TextView) findViewById(R.id.task_list_text);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ViewTasksActivity.this, AddTaskActivity.class);
                startActivity(intent);
            }
        });

    }
}
