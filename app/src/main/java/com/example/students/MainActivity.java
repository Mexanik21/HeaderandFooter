package com.example.students;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.students.adapter.RecycleAdapter;
import com.example.students.model.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    Context context;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        context = this;
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));

        ArrayList<Student> students = studentList();
        refreshAdapter(students);
    }

    private void refreshAdapter(ArrayList<Student> students) {
        RecycleAdapter recycleAdapter = new RecycleAdapter(context,students);
        recyclerView.setAdapter(recycleAdapter);

    }

    private  ArrayList <Student> studentList() {
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i <= 30; i++) {
            int a = (int)(Math.random() * 4)+1;
            if (a==4) {
                students.add(new Student("Abdullaziz Yusupov " + i, String.valueOf(a), R.drawable.ic_launcher_background, false));
            } else {
                students.add(new Student("Yusupov Abdullaziz " + i, String.valueOf(a), R.drawable.ic_launcher_background, true));
            }
        }
        return students;
    }


}