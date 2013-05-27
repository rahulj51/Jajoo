package com.example.Jajoo;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.Jajoo.adapter.TaskListAdapter;

public class ViewTasksActivity extends ListActivity {
    private Button addButton;
    private TaskManagerApplication app;
    private TaskListAdapter adapter;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setUpViews();

        app = (TaskManagerApplication) getApplication();
        adapter = new TaskListAdapter(app.getCurrentTasks(), app);
        setListAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.forceReload();
    }

    private void setUpViews() {
        addButton = (Button) findViewById(R.id.add_button);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ViewTasksActivity.this, AddTaskActivity.class);
                startActivity(intent);
            }
        });

    }
}
