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
public class Dean extends Teacher implements Serializable{
    String empId;
    String deptId;

    public Dean() {
    }            
    
     public Dean(String empId, String deptId) {
        this.empId = empId;
        this.deptId = deptId;
    }         

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }            
    
    public String toString() {
        return "Employee ID: "+this.empId+"\nDepartment ID: "+this.deptId;
    }
    
}
