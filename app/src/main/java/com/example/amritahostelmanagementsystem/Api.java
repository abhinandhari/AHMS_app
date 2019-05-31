package com.example.amritahostelmanagementsystem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    String BASE_URL = "https://mock-ahms.herokuapp.com/v1/resources/";
    @GET("ahms")
    Call<List<Student>> getStudentList();
}
