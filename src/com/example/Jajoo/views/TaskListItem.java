package com.example.Jajoo.views;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import com.example.Jajoo.model.Task;

public class TaskListItem extends LinearLayout{

    private CheckedTextView checkbox;

    private Task task;
    public TaskListItem(Context context) {
        super(context);
    }


    public TaskListItem(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TaskListItem(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        checkbox = (CheckedTextView) findViewById(R.id.text1);
    }

    public Task getTask() {
        return task;
    }


    public void setTask(Task task) {
        this.task = task;
        checkbox.setText(task.getName());
        checkbox.setChecked(task.isComplete());
    }
}
