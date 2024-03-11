package application;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Olajire
 */
public class Exceptions {
    
}

class InexistentDepartmentException extends Exception{

    public InexistentDepartmentException() {
        
    }        

    @Override
    public String toString() {
        return "Department does not exist!";
    }
    
}

class AlreadyExistingEmployee extends Exception{

    public AlreadyExistingEmployee() {
    }

    @Override
    public String toString() {
        return "Employee already exists";
    }    
    
}

