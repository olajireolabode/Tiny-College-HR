package application;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Olajire
 */
public class Teacher extends Person implements Serializable{
    
    private static final long serialVersionUID = 1L;
    ArrayList<String> speciality;
    String degree;
    String type;
    
    //CONSTRUCTOR
    
    public Teacher() {
        this.id = id;
        this.speciality = speciality;
        this.degree = degree;
        this.type = type;
    }
    

    public Teacher(ArrayList<String> speciality, String degree, String type) {
        this.id = id;
        this.speciality = speciality;
        this.degree = degree;
        this.type = type;
    }    
    
    //GETTERS AND SETTERS
    public ArrayList<String> getSpeciality() {
        return speciality;
    }

    public void setSpeciality(ArrayList<String> speciality) {    
        this.speciality = speciality;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {    
        this.email = email;
    }

    //METHODS
    @Override
    public String toString() {  
        return "Teacher ID: "+super.id+"\nFull name: "+ super.firstname +" "+ super.lastname + "\nPhone number: "+super.phoneNumber+"\nEmail: "+super.email+"\nDegree: "+this.degree +"\nTeacher type: "+this.type;
    }

    
    
    
        
}
