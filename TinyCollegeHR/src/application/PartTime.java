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
public class PartTime extends Teacher implements Payroll,Serializable{
    
    private static final long serialVersionUID = 1L;    
    private int degreeRate;
    private int hoursWorked;

    
    //CONSTRUCTOR
    public PartTime() {
        this.hoursWorked = hoursWorked;
        this.type = "Part-time";
    }

    public PartTime (int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
    
    //GETTERS AND SETTERS    
    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
    
    //METHODS
    @Override   
    public double ComputePayroll() {   
        if (this.degree.equalsIgnoreCase("phd")) {            
           degreeRate = 112;
        }
        else if(this.degree.equalsIgnoreCase("master")){
            degreeRate = 82;
        }
        else if(this.degree.equalsIgnoreCase("bachelor")){
            degreeRate = 42;
        } 
        double salary = (this.hoursWorked * this.degreeRate *2) * 0.76;
        return salary;
    }

    @Override
    public String toString() {
        return super.toString()+"\nSpeciality(ies): "+super.speciality; 
    }
    
    
}
