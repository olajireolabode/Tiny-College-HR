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
public class FullTime extends Teacher implements Payroll,Serializable{
    
    private static final long serialVersionUID = 1L;    
    int degreeRate;
    
    //CONSTRUCTOR
    public FullTime() {
        this.degree = degree;
        this.type = "Full-time";
    }
 
    //GETTERS AND SETTERS
        
    
    //METHOD
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
        double salary = (32 * degreeRate * 2) * 0.85;
        return salary;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSpeciality(ies): " +super.speciality; 
    }

    
    
    
}

/*
if (super.degree.equalsIgnoreCase("phd")) {            
            this.degreeRate = 112;
        }
        else if(super.degree.equalsIgnoreCase("master")){
            this.degreeRate = 82;
        }
        else if(super.degree.equalsIgnoreCase("bachelor")){
            this.degreeRate = 42;
        }
*/