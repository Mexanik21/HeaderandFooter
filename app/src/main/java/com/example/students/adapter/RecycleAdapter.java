package com.example.students.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.students.R;
import com.example.students.model.Student;

import java.util.ArrayList;


public class RecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_AVAILABLE_YES = 0;
    private static final int TYPE_AVAILABLE_NOT = 1;

    Context context;
    ArrayList<Student> students;

    public RecycleAdapter(Context context, ArrayList<Student> students) {
        this.context = context;
        this.students = students;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == TYPE_AVAILABLE_YES){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student_view_yes,parent,false);
            return new StudentViewHolder(view);
        }


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student_view_not,parent,false);
        return new StudentViewHolder(view);
    }

    @Override
    public int getItemViewType(int position) {
        if(students.get(position).isAvailable())
            return TYPE_AVAILABLE_YES;
        return TYPE_AVAILABLE_NOT;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Student student = students.get(position);
        if(holder instanceof StudentViewHolder){
            ImageView iv_profile = ((StudentViewHolder) holder).iv_profile;
            TextView tv_fullName = ((StudentViewHolder) holder).tv_fullName;
            TextView tv_course = ((StudentViewHolder) holder).tv_course;

            iv_profile.setImageResource(student.getProfile());
            tv_fullName.setText(student.getFullName());
            tv_course.setText(student.getCourse());
        }


    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    private class StudentViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public ImageView iv_profile;
        public TextView tv_fullName;
        public TextView tv_course;
        public StudentViewHolder(View view) {
            super(view);
            this.view = view;
            iv_profile = view.findViewById(R.id.iv_student_image);
            tv_course = view.findViewById(R.id.tv_student_course);
            tv_fullName = view.findViewById(R.id.tv_student_fullName);
        }
    }
}
