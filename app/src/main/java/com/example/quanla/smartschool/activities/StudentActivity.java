package com.example.quanla.smartschool.activities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.quanla.smartschool.R;
import com.example.quanla.smartschool.database.model.Student;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StudentActivity extends AppCompatActivity  {

    @BindView(R.id.iv_Students)
    ImageView ivStudent;
    @BindView(R.id.ib_Rotation_left)
    ImageButton ibRotationLeft;
    @BindView(R.id.ib_Rotation_right)
    ImageButton ibRotationRight;

    Context context;




    public static Student student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        setupUI();

    }



    private  int count =0;

    private void setupUI() {
        ButterKnife.bind(this);
        context =this;

        //olbStudent.setScrollViewCallbacks(this);
        Picasso.with(this)
                .load(student.getUrl())
                .into(ivStudent);
        ibRotationLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count -=90;
                Picasso.with(context)
                        .load(student.getUrl())
                        .rotate(count)
                        .into(ivStudent);

            }
        });
        ibRotationRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count +=90;
                Picasso.with(context)
                        .load(student.getUrl())
                        .rotate(count)
                        .into(ivStudent);
            }
        });



//        ArrayList<String> items = new ArrayList<String>();
//        for (int i = 1; i <= 100; i++) {
//            items.add("Item " + i);
//        }
//        olbStudent.setAdapter(new ArrayAdapter<String>(
//                this, android.R.layout.simple_list_item_1, items));
    }


}
