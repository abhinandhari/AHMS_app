package com.example.amritahostelmanagementsystem;

import android.util.Log;



import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api2 {
    String BASE_URL = "https://mock-ahms.herokuapp.com/v1/resources/";

    @GET("ahms")
    Call<List<Student>>getStudent(@Query("student_id") String para);
}
