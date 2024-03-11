package application;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Olajire
 */
public class TinyCollege {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        int option, specialityOption;      
        String deptId, empId;        
        boolean employeeFound = false;                
        
        ArrayList<Department>listOfDepartments = new ArrayList<Department>();  
        ArrayList<FullTime>listOfFullTime = new ArrayList<FullTime>();
        ArrayList<PartTime>listOfPartTime = new ArrayList<PartTime>();
        ArrayList<Staff>listOfStaff = new ArrayList<Staff>();        
        ArrayList<Teacher>listOfTeacher = new ArrayList<Teacher>(); 
        ArrayList<Dean>listOfDean = new ArrayList<Dean>();
        
        File departmentFile = new File("department.txt");
        File teacherFile = new File("teacher.txt");
        File fulltimeFile = new File("fulltime.txt");
        File parttimeFile = new File("parttime.txt");
        File staffFile = new File("staff.txt");     
        File deanFile = new File("dean.txt");
        
        ObjectOutputStream oos = null;            
        ObjectInputStream ois = null;
        
        /*
        if (departmentFile.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(departmentFile));
            listOfDepartments = (ArrayList<Department>) ois.readObject();
            ois.close();
        }
        if (teacherFile.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(teacherFile));
            listOfTeacher = (ArrayList<Teacher>) ois.readObject();
            ois.close();
        }
        if (fulltimeFile.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(fulltimeFile));
            listOfFullTime = (ArrayList<FullTime>) ois.readObject();
            ois.close();
        }
        if (parttimeFile.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(parttimeFile));
            listOfPartTime = (ArrayList<PartTime>) ois.readObject();
            ois.close();
        }
        if (staffFile.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(staffFile));
            listOfStaff = (ArrayList<Staff>) ois.readObject();
            ois.close();
        }
        if (deanFile.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(deanFile));
            listOfDean = (ArrayList<Dean>) ois.readObject();
            ois.close();
        }
        */
        
        do{            
            System.out.println("Please enter the number with your desired operation\n1. Create new Department\n2. Add new Employee\n3. Add Employee to Department.\n4. Assign Dean to Department\n5. Show Dean\n6. Show Info based on Department\n7. Show Full Information\n8. Show Employee based on iD\n0. Exit");
            option = sc.nextInt();
            
            switch(option) {
                
                case 1:
                    //new AddNewDepartment().setVisible(true);                                        
                    
                    System.out.println("Enter department ID: ");
                    deptId = sc.next();
                    
                    for (int i = 0; i < listOfDepartments.size(); i++) {
                        if ( listOfDepartments.get(i).getId().equalsIgnoreCase(deptId)) {
                                    
                            do {                                        
                                System.out.println("Department already exists. Enter new iD: ");
                                deptId = sc.next();
                                } while (listOfDepartments.get(i).getId().equalsIgnoreCase(deptId));
                        }
                        }                    
                    
                    System.out.println("Enter the department name: ");
                    String departmentName = sc.next();
                                        
                    Department d = new Department();
                    
                    d.setId(deptId);
                    d.setName(departmentName);
                    
                    System.out.println("Department created!");
                    listOfDepartments.add(d);
                    
                    oos = new ObjectOutputStream(new FileOutputStream(departmentFile));
                    oos.writeObject(listOfDepartments);
                    oos.close();
                    break;
                    
                    
                case 2:
                    try{
                    System.out.println("Enter your Employee ID: ");
                    empId = sc.next();                                                              
                    
                    do{
                    for (int i = 0; i < listOfTeacher.size(); i++) {
                        if ( listOfTeacher.get(i).getId().equalsIgnoreCase(empId)) { 
                            employeeFound = true;
                            
                                do {                                        
                                System.out.println("Employee already exists. Enter new iD: ");
                                empId = sc.next();
                                } while (listOfTeacher.get(i).getId().equalsIgnoreCase(empId));
                        }
                        else employeeFound = false;                            
                    }
                        
                    for (int j = 0; j < listOfStaff.size(); j++) {
                    if ( listOfStaff.get(j).getId().equalsIgnoreCase(empId)) { 
                        employeeFound = true;
                            do {                                        
                                System.out.println("Employee already exists. Enter new iD: ");
                                empId = sc.next();
                                } while (listOfStaff.get(j).getId().equalsIgnoreCase(empId));
                    }
                    else employeeFound = false;
                    }
                    }
                    while(employeeFound == true);
                    
                    System.out.println("Enter your first name: ");
                    String fname = sc.next();
                    System.out.println("Enter your last name: ");
                    String lname = sc.next();
                    System.out.println("Enter your phone number: ");
                    String phoneNumber = sc.next();
                    System.out.println("Enter you email: ");
                    String email = sc.next();
                                       
                    System.out.println("Are you a Teacher or Staff\nEnter 1 for Teacher\nEnter 2 for Staff");
                    option = sc.nextInt();
                    
                        switch (option) {
                            
                            case 1:
                                ArrayList <String> specialityList = new ArrayList<String>();
                                                                
                                do {         
                                    System.out.println("Press 1 to enter speciality\nPress 0 to stop.");
                                    specialityOption = sc.nextInt();
                                    switch (specialityOption) {
                                            case 1:
                                            System.out.println("Enter your speciality: ");
                                            String speciality = sc.next();
                                            specialityList.add(speciality);
                                            break;                              
                                      }
                                    } while (specialityOption!=0);                                
                                
                                System.out.println("Enter your degree: ");
                                String degree = sc.next();
                                
                                Teacher t = new Teacher();                                
                                t.setId(empId);
                                t.setFirstname(fname);
                                t.setLastname(lname);
                                t.setPhoneNumber(phoneNumber);
                                t.setEmail(email);
                                t.setDegree(degree);
                                t.setSpeciality(specialityList);
                                
                                System.out.println("Are you FullTime or PartTime?\nEnter: \n1 for FullTime\n2 for Partime");
                                int teacherTypeChoice = sc.nextInt();
                                
                                
                                switch (teacherTypeChoice) {
                                    case 1:
                                        FullTime ft = new FullTime();
                                        
                                        ft.setId(empId);
                                        ft.setFirstname(fname);
                                        ft.setLastname(lname);
                                        ft.setPhoneNumber(phoneNumber);
                                        ft.setEmail(email);
                                        ft.setDegree(degree);
                                        ft.setSpeciality(specialityList);

                                        listOfFullTime.add(ft);                                                                                  
                                        oos = new ObjectOutputStream(new FileOutputStream(fulltimeFile));
                                        oos.writeObject(listOfFullTime);
                                        oos.close();  
                                        
                                        t.setId(empId);
                                        t.setFirstname(fname);
                                        t.setLastname(lname);
                                        t.setPhoneNumber(phoneNumber);
                                        t.setEmail(email);
                                        t.setDegree(degree);
                                        t.setSpeciality(specialityList);
                                        t.setType("Full-time");
                                        
                                        listOfTeacher.add(t);                                           
                                        oos = new ObjectOutputStream(new FileOutputStream(teacherFile));
                                        oos.writeObject(listOfTeacher);
                                        oos.close();                                                                                      
                                        break;
                                        
                                    case 2:
                                        System.out.println("How many hours do you work: ");
                                        int hoursWorked = sc.nextInt();
                                        PartTime pt = new PartTime();
                                        pt.setId(empId);
                                        pt.setFirstname(fname);
                                        pt.setLastname(lname);
                                        pt.setPhoneNumber(phoneNumber);
                                        pt.setEmail(email);
                                        pt.setDegree(degree);
                                        pt.setSpeciality(specialityList);
                                        pt.setHoursWorked(hoursWorked);
                                                                                                                        
                                        listOfPartTime.add(pt);                                            
                                        oos = new ObjectOutputStream(new FileOutputStream(parttimeFile));
                                        oos.writeObject(listOfPartTime);
                                        oos.close();
                                        
                                        t.setId(empId);
                                        t.setFirstname(fname);
                                        t.setLastname(lname);
                                        t.setPhoneNumber(phoneNumber);
                                        t.setEmail(email);
                                        t.setDegree(degree);
                                        t.setSpeciality(specialityList);
                                        t.setType("Part-time");
                                        
                                        listOfTeacher.add(t);                                        
                                        oos = new ObjectOutputStream(new FileOutputStream(teacherFile));
                                        oos.writeObject(listOfTeacher);
                                        oos.close();                                        
                                        break;                                              
                                }
                            break;
                                
                            case 2:
                                System.out.println("Enter your duty: ");
                                String duty = sc.next();
                                System.out.println("Please enter your workload (hours worked): ");
                                int workload = sc.nextInt();
                                
                                Staff s = new Staff();
                                s.setId(empId);
                                s.setFirstname(fname);
                                s.setLastname(lname);
                                s.setPhoneNumber(phoneNumber);
                                s.setEmail(email);                              
                                s.setDuty(duty);
                                s.setWorkload(workload);

                                listOfStaff.add(s);                                 
                                oos = new ObjectOutputStream(new FileOutputStream(staffFile));
                                oos.writeObject(listOfStaff);
                                oos.close();
                                break;
                                
                        }
                    }
                    catch(Exception e){
                        System.out.println(e);
                    }
                    System.out.println("Employee added!");
                    break;
                    
                case 3:
                    boolean deptExists = false;
                    
                    try{
                    System.out.println("Enter the Department iD: ");
                    deptId = sc.next();
                    
                    if (listOfDepartments.isEmpty() == true) {
                        throw new InexistentDepartmentException();
                    }
                    
                    else
                                                
                    for (int i = 0; i < listOfDepartments.size(); i++) {
                        if (listOfDepartments.get(i).getId().equalsIgnoreCase(deptId)) {
                                deptExists = true;
                                System.out.println("Enter the Employee's id you wish to add: ");
                                empId = sc.next();
                                employeeFound = false;
                               
                                    for (int j = 0; j < listOfStaff.size(); j++) {
                                        if (listOfStaff.get(j).id.equalsIgnoreCase(empId)) {
                                            employeeFound = true;      
                                            listOfDepartments.get(i).addStaff(listOfStaff.get(j));                                                                                                                               
                                        }
                                }                                                               
                                
                                    for (int j = 0; j < listOfTeacher.size(); j++) {
                                        if (listOfTeacher.get(j).getId().equalsIgnoreCase(empId)) {
                                            employeeFound = true;                                                
                                            listOfDepartments.get(i).addTeacher(listOfTeacher.get(j));
                                        }
                                }                                                                    
                                                                                            
                                if (employeeFound==false) {
                                    System.out.println("Employee does not exist");
                                }
                            }
                                                
                    if(deptExists == false) {
                            throw new InexistentDepartmentException();
                    }
                    }                           
                    }                    
                    catch(Exception e){
                        System.out.println(e);                        
                    }
                    break;
                    
                
                case 4:
                    boolean flag = false;
                    try {
                        System.out.println("Enter Employee ID: ");
                        empId = sc.next();
                        System.out.println("Enter Department ID: ");
                        deptId = sc.next();
                        
                        for (int i = 0; i < listOfDean.size(); i++) {
                            if (listOfDean.get(i).empId.equalsIgnoreCase(empId)) {
                                throw new Exception("Teacher is already a dean!");
                            }                            
                        }
                        
                        for (int i = 0; i < listOfDepartments.size(); i++) {
                            if (listOfDepartments.get(i).id.equalsIgnoreCase(deptId) && listOfDepartments.get(i).getTeacherList().get(i).id.equalsIgnoreCase(empId)) {
                                flag = true;
                                Dean dean = new Dean(empId, deptId);
                                listOfDean.add(dean);
                                                                
                                oos = new ObjectOutputStream(new FileOutputStream(deanFile));
                                oos.writeObject(listOfDean);
                                oos.close();                                
                            }
                        }
                        
                        for (int i = 0; i < listOfStaff.size(); i++) {
                            if (empId.equalsIgnoreCase(listOfStaff.get(i).id)) {
                                throw new Exception("Staff cannot be a dean");
                            }
                        }
                        
                        if (flag == false) {
                            throw new Exception("Teacher cannot be dean in that department!");
                        }
                        
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                    
                case 5:
                    System.out.println("Deans\n-----------------------");
                    for (Dean deans : listOfDean) {
                        System.out.println(deans);
                    }
                    break;
                    
                case 6:    
                    boolean deptExists2 = false;

                    try{
                    System.out.println("Enter the department iD: ");
                    deptId = sc.next();
                    
                    if (listOfDepartments.isEmpty()) {
                        System.out.println("There are no departments.");
                    }
                    else
                    for (int i = 0; i < listOfDepartments.size(); i++) {
                        if (listOfDepartments.get(i).getId().equalsIgnoreCase(deptId)) {
                            deptExists2 = true;
                            System.out.println(listOfDepartments.get(i));
                            
                            listOfDepartments.get(i).listTeachers();
                            listOfDepartments.get(i).listStaff();
                        }
                        if(deptExists2 == false){
                            throw new InexistentDepartmentException();
                        }                    
                    }
                    }
                    catch(Exception e){
                        System.out.println(e);
                    }
                    break;
                    
                case 7:
                    System.out.println("Departments\n---------------");
                    for (int i = 0; i < listOfDepartments.size(); i++) {
                        System.out.println(listOfDepartments.get(i));                        
                    }
                    System.out.println("Employees\n---------------");
                    
                    for (int i = 0; i < listOfTeacher.size(); i++) {
                        System.out.println(listOfTeacher.get(i));
                    }
                    
                    for (int i = 0; i < listOfStaff.size(); i++) {
                        System.out.println(listOfStaff.get(i));
                    }                    
                                        
                    break;                            
                    
                case 8:
                    System.out.println("Enter the employee id: ");
                    empId = sc.next();
                    if (listOfStaff.isEmpty()&&listOfTeacher.isEmpty()) {
                        System.out.println("No Employees to Show");
                    }                                        
                    else{                
                    do{
                        for (int j = 0; j < listOfStaff.size(); j++) {
                            if (listOfStaff.get(j).id.equalsIgnoreCase(empId)) {
                                employeeFound = true;                                            
                                System.out.println(listOfStaff.get(j));
                                System.out.println("Salary: "+listOfStaff.get(j).ComputePayroll()+" CAD");
                            }
                        }

                        for (int j = 0; j < listOfFullTime.size(); j++) {
                            if (listOfFullTime.get(j).getId().equalsIgnoreCase(empId)) {
                                employeeFound = true;                                            
                                System.out.println(listOfFullTime.get(j));
                                System.out.println("Salary: "+listOfFullTime.get(j).ComputePayroll()+" CAD");
                            }
                        }

                        for (int j = 0; j < listOfPartTime.size(); j++) {
                           if (listOfPartTime.get(j).getId().equalsIgnoreCase(empId)) {
                                employeeFound = true;                                            
                                System.out.println(listOfPartTime.get(j));
                                System.out.println("Salary: "+listOfPartTime.get(j).ComputePayroll()+" CAD");                                            
                            }
                        } 
                    
                    }
                    while (employeeFound == false);                        
                                           
                    if(employeeFound == false){
                        System.out.println("Employee not found");
                    }
                }
                    break;                                      
            }
                                            
        }
        while(option!=0);                    
    }            
}
