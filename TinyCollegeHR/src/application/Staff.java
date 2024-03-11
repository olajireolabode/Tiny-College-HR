package application;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.Serializable;

/**
 *
 * @author Olajire
 */
public class Staff extends Person implements Payroll, Serializable{
    
    private static final long serialVersionUID = 1L;    
    String duty;
    int workload;
    
    //CONSTRUCTORS
    public Staff() {
        this.id = id;         
        this.duty = duty;
        this.workload = workload;
    }

    public Staff(String duty, int workload) {
        this.id = id;         
        this.duty = duty;
        this.workload = workload;
    }


    //GETTERS AND SETTERS

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public int getWorkload() {
        return workload;
    }

    public void setWorkload(int workload) {
        this.workload = workload;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return "Staff ID: "+super.id+"\nFull name:  "+ super.firstname +" "+ super.lastname + "\nPhone number: "+super.phoneNumber+"\nEmail: "+super.email;
    }

    @Override
    public double ComputePayroll() {
        double salary = (this.workload * 32 * 2) * 0.75;
        return salary;
    }
    
    
}
