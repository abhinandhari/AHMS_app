package com.example.amritahostelmanagementsystem;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class StudentAdapter extends ArrayAdapter<Student> { //to add views. This is custom view
    public StudentAdapter(Context context, List<Student> students) { //context check online
        super(context, 0, students);
    }

    @NonNull
    @Override

    public View getView(int pos, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null)
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.listtoshow, parent, false);
        //inflater = making the view
        Student currentStudent = getItem(pos);
        TextView date;
        TextView facultyName;
        TextView name;
        TextView stayback;
        TextView reason;
        TextView studentID;
        TextView time;
        date=listItemView.findViewById(R.id.date);
        facultyName=listItemView.findViewById(R.id.faculty_name);
        name=listItemView.findViewById(R.id.name);
        stayback=listItemView.findViewById(R.id.stayback);
        reason=listItemView.findViewById(R.id.reason);
        studentID=listItemView.findViewById(R.id.studentid);
        time=listItemView.findViewById(R.id.time);
        date.setText(currentStudent.getDate());
        facultyName.setText(currentStudent.getFacultyName());
        name.setText(currentStudent.getFirstName()+currentStudent.getLastName());
        if(currentStudent.getHasStayback().toString().equals("1")) {
            stayback.setText("Has Stayback");
            stayback.setTextColor(0xff22ff22);
        }else{
            stayback.setText("No Stayback");
            stayback.setTextColor(0xffff2222);
        }
        reason.setText(currentStudent.getReason());
        studentID.setText(currentStudent.getStudentId()+"");
        time.setText(currentStudent.getTime());
        return listItemView;
    }
}