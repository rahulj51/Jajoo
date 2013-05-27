package com.example.Jajoo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.example.Jajoo.R;
import com.example.Jajoo.model.Task;
import com.example.Jajoo.views.TaskListItem;

import java.util.List;

public class TaskListAdapter extends BaseAdapter {


    private List<Task> tasks;
    private Context context;


    public TaskListAdapter(List<Task> tasks, Context context) {
        this.tasks = tasks;
        this.context = context;
    }

    @Override
    public int getCount() {
        return tasks.size();
    }

    @Override
    public Task getItem(int position) {
        return tasks == null ? null : tasks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TaskListItem tli;
        if (null == convertView) {
            tli = (TaskListItem)View.inflate(context, R.layout.task_list_item, null);
        } else {
            tli = (TaskListItem) convertView;
        }

        tli.setTask(getItem(position));

        return tli;
    }

    public void forceReload() {
        notifyDataSetChanged();
    }
}
