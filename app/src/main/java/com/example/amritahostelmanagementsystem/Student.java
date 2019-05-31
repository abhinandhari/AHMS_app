
package com.example.amritahostelmanagementsystem;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Student {

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("faculty_name")
    @Expose
    private String facultyName;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("has_stayback")
    @Expose
    private Integer hasStayback;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("reason")
    @Expose
    private String reason;
    @SerializedName("student_id")
    @Expose
    private Integer studentId;
    @SerializedName("time")
    @Expose
    private String time;

    /**
     * No args constructor for use in serialization
     *
     */
    public Student() {
    }

    /**
     *
     * @param facultyName
     * @param lastName
     * @param time
     * @param studentId
     * @param reason
     * @param firstName
     * @param date
     * @param hasStayback
     */
    public Student(String date, String facultyName, String firstName, Integer hasStayback, String lastName, String reason, Integer studentId, String time) {
        super();
        this.date = date;
        this.facultyName = facultyName;
        this.firstName = firstName;
        this.hasStayback = hasStayback;
        this.lastName = lastName;
        this.reason = reason;
        this.studentId = studentId;
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getHasStayback() {
        return hasStayback;
    }

    public void setHasStayback(Integer hasStayback) {
        this.hasStayback = hasStayback;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


}