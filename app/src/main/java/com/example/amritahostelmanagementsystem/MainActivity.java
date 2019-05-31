package com.example.amritahostelmanagementsystem;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ImageView amrita;
    Button staybackbutton;
    Button idgen;
    TextView date;
    TextView facultyName;
    TextView name;
    TextView stayback;
    TextView reason;
    TextView studentID;
    TextView time;
    ListView studentlistview;
    EditText edit;
    Button search;
    LinearLayout linearLayout1;
    List<Student> studentList;
    Context context;
    public void runner(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);
        Call<List<Student>> call = api.getStudentList();
        call.enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {
                Log.v("Api : ", call.request().url().toString());
                Log.v("Api : ", response.body().toString());
                studentList = response.body();
                StudentAdapter students = new StudentAdapter(context,studentList);
                studentlistview = findViewById(R.id.lister);
                studentlistview.setAdapter(students);
            }

            @Override
            public void onFailure(Call<List<Student>> call, Throwable t) {

                Log.v("Api :","Failed...");
            }
        });
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        studentList = new ArrayList<>();
        idgen = findViewById(R.id.id);
        amrita = findViewById(R.id.logo);
        amrita.setImageResource(R.drawable.amrita);
        staybackbutton = findViewById(R.id.stay);
        date = findViewById(R.id.date);
        facultyName = findViewById(R.id.faculty_name);
        name = findViewById(R.id.name);
        stayback = findViewById(R.id.stayback);
        reason = findViewById(R.id.reason);
        studentID = findViewById(R.id.studentid);
        time = findViewById(R.id.time);
        linearLayout1 = findViewById(R.id.search);
        edit = findViewById(R.id.edit_text);
        search = findViewById(R.id.searchbutton);
        linearLayout1.setVisibility(View.GONE);
        runner();
    }
    public void idgen(View v){
        linearLayout1.setVisibility(View.VISIBLE);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i;
                List<Student> temp = new ArrayList<>();
                String id = edit.getText().toString();
                int l=id.length();
                if(l>4&&l<17)
                    id=id.substring(l-5,l);
                for(i=0;i<studentList.size();i++){
                    if(id.equals(studentList.get(i).getStudentId().toString())){
                        temp.add(studentList.get(i));
                        break;
                    }
                }
                if(i==studentList.size()){
                    temp.add(new Student("-","-","-",0,"-","-",0,"-"));
                }
                StudentAdapter students = new StudentAdapter(context,temp);
                studentlistview = findViewById(R.id.lister);
                studentlistview.setAdapter(students);
            }
        });
    }
    public void refreshes(View v){
        linearLayout1.setVisibility(View.GONE);
        runner();
    }
    public void staybacker(View v){
        linearLayout1.setVisibility(View.INVISIBLE);
        int i;
        List<Student> temp = new ArrayList<>();
        for(i=0;i<studentList.size();i++){
            if(studentList.get(i).getHasStayback()==1){
                temp.add(studentList.get(i));
            }
        }
        StudentAdapter students = new StudentAdapter(context,temp);
        studentlistview = findViewById(R.id.lister);
        studentlistview.setAdapter(students);
    }
}
