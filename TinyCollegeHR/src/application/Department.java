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
public class Department implements Serializable{
    
    private static final long serialVersionUID = 1L;
     String name;
     String id;
     ArrayList<Staff> staffList;
     ArrayList<Teacher> teacherList;
     Teacher dean;
    
    
    //CONSTRUCTOR
    public Department() {
        this.name = name;
        this.id = id;
        this.staffList = new ArrayList<Staff>();
        this.teacherList = new ArrayList<Teacher>();
    }

    public Department(String name, String id, ArrayList<Staff> staffList, ArrayList<Teacher> teacherList) {
        this.name = name;
        this.id = id;
        this.staffList = new ArrayList<Staff>();
        this.teacherList = new ArrayList<Teacher>();
    }
    
    //GETTERS AND SETTERS

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(ArrayList<Staff> staffList) {
        this.staffList = staffList;
    }

    public ArrayList<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(ArrayList<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public Teacher getDean() {
        return dean;
    }

    public void setDean(Teacher dean) {
        this.dean = dean;
    }        
    
    //METHODS
    public boolean contains(Teacher t) {
        for (Teacher teacher : teacherList) {
            if (teacher.getId()== t.getId()) {
                return true;
            }
        }
        return false;
    }
    
    public boolean contains(Staff s) {
        for (Staff staff : staffList) {
            if (staff.getId()== s.getId()) {
                return true;
            }
        }
        return false;
    }
    
    public Teacher getTeacher(String id){
        for (Teacher teacher : teacherList) {
            if (teacher.id.equals(id)) {
                return teacher;
            }
        }
        return null;
    }
    
    public Staff getStaff(String id){
        
        for (Staff staff : staffList) {
            if (id.equals(staff.id)) {
                return staff;
            }
            else{
                return getStaff(id);
            }
        }
        return null;
    }
    
    public void listTeachers(){
        for (Teacher teacher : teacherList) {
            System.out.println(teacher);
        }
    }
    
    public void listStaff(){
        for (Staff staff : staffList) {
            System.out.println(staff);
        }
    }
    
    public void addTeacher(Teacher t) throws Exception{
        if (contains(t)) {
            throw new AlreadyExistingEmployee();
        }
        this.teacherList.add(t);
        System.out.println("Teacher Added");
    }
    
    public void addStaff(Staff s) throws Exception{
        if (contains(s)) {
            throw new AlreadyExistingEmployee();
        }
        this.staffList.add(s);
        System.out.println("Staff Added");
    }
    
    @Override
    public String toString() {
        return "Department ID: " +this.id + "\nDepartment name: "+this.name;
    }
    
    

}
