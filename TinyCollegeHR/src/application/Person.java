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
public abstract class Person implements Serializable  {
    private static final long serialVersionUID = 1L;
    
    String firstname, lastname, phoneNumber, email, id;
    
    public abstract String toString(); 
}
