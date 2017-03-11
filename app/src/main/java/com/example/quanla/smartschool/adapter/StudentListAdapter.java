package com.example.quanla.smartschool.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quanla.smartschool.R;
import com.example.quanla.smartschool.activities.StudentActivity;
import com.example.quanla.smartschool.adapter.viewhodler.ClassListHodler;
import com.example.quanla.smartschool.adapter.viewhodler.StudentListHolder;
import com.example.quanla.smartschool.database.DbStudentContext;
import com.example.quanla.smartschool.database.model.Student;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by tranh on 3/11/2017.
 */

public class StudentListAdapter extends RecyclerView.Adapter<StudentListHolder> {
    private Context context;

    public StudentListAdapter(Context context) {
        this.context = context;

    }


    @Override
    public StudentListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.student_item, parent, false);
        //2: create ViewHolder
        return new StudentListHolder(itemView);
    }


    @Override
    public void onBindViewHolder(StudentListHolder holder, final int position) {
        final Student student=DbStudentContext.instance.getStudents().get(position);
        holder.bind(student);
        holder.itemView.findViewById(R.id.iv_student_img).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, StudentActivity.class);
                context.startActivity(intent);
                StudentActivity.student = (student);

            }
        });
    }

    @Override
    public int getItemCount() {
       return DbStudentContext.instance.getStudents().size();
    }
}
