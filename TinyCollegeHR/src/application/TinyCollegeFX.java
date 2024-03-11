package application;
	
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;


public class TinyCollegeFX extends Application {
	boolean employeeFound = false; 
	
	ArrayList<String>speciality = new ArrayList<>();
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
	
	@Override
	public void start(Stage primaryStage) throws IOException{
	try {
			
			Button newDepartment = new Button("ADD NEW DEPARTMENT");
			newDepartment.setLayoutX(100);
			newDepartment.setLayoutY(20);
			Button newEmployee = new Button("ADD NEW EMPLOYEE");
			newEmployee.setLayoutX(100);
			newEmployee.setLayoutY(60);
			Button assign = new Button("ASSIGN EMPLOYEE TO DEPARTMENT");
			assign.setLayoutX(100);
			assign.setLayoutY(100);
			Button addDean= new Button("ADD DEAN");
			addDean.setLayoutX(100);
			addDean.setLayoutY(140);
			Button showDean = new Button("SHOW DEAN");
			showDean.setLayoutX(100);
			showDean.setLayoutY(180);
			Button showInfo = new Button("SHOW ALL INFORMATION");
			showInfo.setLayoutX(100);
			showInfo.setLayoutY(220);
			Button showDeptInfo = new Button("SHOW INFORMATION BASED ON DEPARTMENT");
			showDeptInfo.setLayoutX(100);
			showDeptInfo.setLayoutY(260);
			Button showEmpInfo = new Button("SHOW INFORMATION BASED ON EMPLOYEE");
			showEmpInfo.setLayoutX(100);
			showEmpInfo.setLayoutY(300);
			Button exit = new Button("EXIT");
			exit.setLayoutX(100);
			exit.setLayoutY(340);
			
			Pane pane = new Pane();
			pane.getChildren().addAll(newDepartment,newEmployee,assign,addDean,showInfo,showDean,showDeptInfo,showEmpInfo,exit);
			
			Scene scene = new Scene(pane,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("Tiny College HR");
			primaryStage.setOnCloseRequest(e -> e.consume());;
			
			
			newDepartment.setOnAction(e -> {
				primaryStage.close();
				
				Pane addDept = new Pane();
				
				Scene sc1 = new Scene(addDept);
				
				Stage stg1 = new Stage();
				stg1.setHeight(400);
				stg1.setWidth(400);
				stg1.setScene(sc1);
				stg1.show();
				stg1.setTitle("Add Department");
				
				Label ldept = new Label("Department ID: ");		
				ldept.setLayoutX(30);
				ldept.setLayoutY(10);
				Label ldeptname = new Label("Department Name: ");
				ldeptname.setLayoutX(30);
				ldeptname.setLayoutY(40);
				
				TextField fdept = new TextField();
				fdept.setLayoutX(150);
				fdept.setLayoutY(10);
				TextField fdeptName = new TextField();
				fdeptName.setLayoutX(150);
				fdeptName.setLayoutY(40);
				
				Button add = new Button("Add");
				add.setLayoutX(150);
				add.setLayoutY(200);
				Button home = new Button("Home");
				home.setLayoutX(200);
				home.setLayoutY(200);
				addDept.getChildren().addAll(ldept, ldeptname, fdept, fdeptName, add, home);
				
				add.setOnAction(addAction ->{
					if (fdept.getText().isEmpty() || fdeptName.getText().isEmpty()) {
						Alert a = new Alert(AlertType.INFORMATION, "Enter all fields", null);
						a.show();
					}
					else {
					String deptId = fdept.getText();
					String deptName = fdeptName.getText();					
					
					Department d = new Department();
					d.setId(deptId);
                    d.setName(deptName);
                    
                    System.out.println("Department created!");
                    listOfDepartments.add(d);
                    
                    try {
						oos = new ObjectOutputStream(new FileOutputStream(departmentFile));
						oos.writeObject(listOfDepartments);
						oos.close();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
                    
                    stg1.close();
					primaryStage.show();
					
					//System.out.println(d);
					}
					
				});
				
				home.setOnAction(homeAction -> {
					stg1.close();
					primaryStage.show();
				});
				 
			});
			
			newEmployee.setOnAction(e ->{
				primaryStage.close();
				
				Pane addEmp = new Pane();
				
				Scene sc1 = new Scene(addEmp);
				
				Stage stg1 = new Stage();
				stg1.setHeight(550);
				stg1.setWidth(400);
				stg1.setScene(sc1);
				stg1.show();
				stg1.setTitle("Add Employee");
				
				Label lempid = new Label("Employee ID: ");		
				lempid.setLayoutX(20);
				lempid.setLayoutY(10);
				Label lempfname = new Label("Employee first name: ");
				lempfname.setLayoutX(20);
				lempfname.setLayoutY(40);
				Label lemplname = new Label("Employee last name: ");
				lemplname.setLayoutX(20);
				lemplname.setLayoutY(70);
				Label lphoneNumber = new Label("Employee phone number: ");
				lphoneNumber.setLayoutX(20);
				lphoneNumber.setLayoutY(100);
				Label lemail = new Label("Employee email: ");
				lemail.setLayoutX(20);
				lemail.setLayoutY(130);
				Label lspeciality = new Label("Enter your speciality(ies): ");
				lspeciality.setLayoutX(20);
				lspeciality.setLayoutY(220);
				Label ldegree = new Label("Enter your degree: ");
				ldegree.setLayoutX(20);
				ldegree.setLayoutY(250);
				Label lhoursworked = new Label("How many hours have you worked: ");
				lhoursworked.setLayoutX(20);
				lhoursworked.setLayoutY(280);
				Label lduty = new Label("Enter your duty: ");
				lduty.setLayoutX(20);
				lduty.setLayoutY(310);
				Label lworkload= new Label("Enter your workload(hours): ");
				lworkload.setLayoutX(20);
				lworkload.setLayoutY(340);
				
				TextField fempid = new TextField();
				fempid.setLayoutX(210);
				fempid.setLayoutY(10);
				TextField fempfname = new TextField();
				fempfname.setLayoutX(210);
				fempfname.setLayoutY(40);
				TextField femplname = new TextField();
				femplname.setLayoutX(210);
				femplname.setLayoutY(70);
				TextField fphoneNumber = new TextField();
				fphoneNumber.setLayoutX(210);
				fphoneNumber.setLayoutY(100);
				TextField femail = new TextField();
				femail.setLayoutX(210);
				femail.setLayoutY(130);
				TextField fspeciality = new TextField();
				fspeciality.setLayoutX(210);
				fspeciality.setLayoutY(220);
				fspeciality.setEditable(false);
				fspeciality.setDisable(true);
				TextField fdegree = new TextField();
				fdegree.setLayoutX(210);
				fdegree.setLayoutY(250);
				fdegree.setEditable(false);
				fdegree.setDisable(true);
				TextField fhoursworked = new TextField();
				fhoursworked.setLayoutX(210);
				fhoursworked.setLayoutY(280);
				fhoursworked.setEditable(false);
				fhoursworked.setDisable(true);
				TextField fduty = new TextField();
				fduty.setLayoutX(210);
				fduty.setLayoutY(310);
				fduty.setEditable(false);
				fduty.setDisable(true);
				TextField fworkload= new TextField();
				fworkload.setLayoutX(210);
				fworkload.setLayoutY(340);
				fworkload.setEditable(false);
				fworkload.setDisable(true);
				
				ToggleGroup emptype = new ToggleGroup();
				ToggleGroup teachertype = new ToggleGroup();
				
				RadioButton fulltimebtn = new RadioButton("Full-Time");
				fulltimebtn.setLayoutX(70);
				fulltimebtn.setLayoutY(190);				
				fulltimebtn.setToggleGroup(teachertype);
				fulltimebtn.setVisible(false);
				
				fulltimebtn.setOnAction(ftaction -> {
					fspeciality.setEditable(true);
					fspeciality.setDisable(false);
					fdegree.setEditable(true);
					fdegree.setDisable(false);
					fhoursworked.setEditable(false);
					fhoursworked.setDisable(true);
					fduty.setEditable(false);
					fduty.setDisable(true);
					fworkload.setEditable(false);
					fworkload.setDisable(true);
				});
				
				RadioButton parttimebtn = new RadioButton("Part-Time");
				parttimebtn.setLayoutX(150);
				parttimebtn.setLayoutY(190);
				parttimebtn.setToggleGroup(teachertype);
				parttimebtn.setVisible(false);
				
				parttimebtn.setOnAction(ptaction -> {
					fspeciality.setEditable(true);
					fspeciality.setDisable(false);
					fdegree.setEditable(true);
					fdegree.setDisable(false);
					fhoursworked.setEditable(true);
					fhoursworked.setDisable(false);
					fduty.setEditable(false);
					fduty.setDisable(true);
					fworkload.setEditable(false);
					fworkload.setDisable(true);
				});
				
				RadioButton teacherbtn = new RadioButton("Teacher");
				teacherbtn.setLayoutX(100);
				teacherbtn.setLayoutY(160);
				teacherbtn.setToggleGroup(emptype);
				
				teacherbtn.setOnAction(taction -> {									
					fulltimebtn.setVisible(true);
					parttimebtn.setVisible(true);
					
					fspeciality.setEditable(false);
					fspeciality.setDisable(true);
					fdegree.setEditable(false);
					fdegree.setDisable(true);
					
					fduty.setEditable(false);
					fduty.setDisable(true);
					fworkload.setEditable(false);
					fworkload.setDisable(true);
				});
				
				RadioButton staffbtn = new RadioButton("Staff");	
				staffbtn.setLayoutX(180);
				staffbtn.setLayoutY(160);
				staffbtn.setToggleGroup(emptype);
				
				staffbtn.setOnAction(saction -> {
					fulltimebtn.setVisible(false);
					parttimebtn.setVisible(false);
					
					fspeciality.setEditable(false);
					fspeciality.setDisable(true);
					fdegree.setEditable(false);
					fdegree.setDisable(true);
					
					fduty.setEditable(true);
					fduty.setDisable(false);
					fworkload.setEditable(true);
					fworkload.setDisable(false);
				});
				
				
				Button add = new Button("Add");
				add.setLayoutX(150);
				add.setLayoutY(420);
				Button home = new Button("Home");
				home.setLayoutX(200);
				home.setLayoutY(420);
				
				addEmp.getChildren().addAll(lempid, lempfname, lemplname,lphoneNumber,lemail, fempid, fempfname, femplname,fphoneNumber,femail,home,add,teacherbtn,staffbtn);
				addEmp.getChildren().addAll(fworkload, fdegree, fhoursworked, fspeciality, lworkload, ldegree, lhoursworked, lspeciality,fduty,lduty,fulltimebtn,parttimebtn);
															
				add.setOnAction(addAction -> {
					//Teacher
					Teacher t = new Teacher();
					
					if (fulltimebtn.isSelected()) {
						//FullTime
						
						FullTime ft = new FullTime();
						ft.setId(fempid.getText());
                        ft.setFirstname(fempfname.getText());
                        ft.setLastname(femplname.getText());
                        ft.setPhoneNumber(fphoneNumber.getText());
                        ft.setEmail(femail.getText());
                        ft.setDegree(fdegree.getText());
                        speciality.add(fspeciality.getText());
                        ft.setSpeciality(speciality);
                        listOfFullTime.add(ft);
                        
                         try {
							oos = new ObjectOutputStream(new FileOutputStream(fulltimeFile));
							 oos.writeObject(listOfFullTime);
							 oos.close();
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						} catch (IOException e1) {
							e1.printStackTrace();
						} 
                        
                        t.setId(fempid.getText());
                        t.setFirstname(fempfname.getText());
                        t.setLastname(femplname.getText());
                        t.setPhoneNumber(fphoneNumber.getText());
                        t.setEmail(femail.getText());
                        t.setDegree(fdegree.getText());
                        speciality.add(fspeciality.getText());
                        t.setSpeciality(speciality);
                        t.setType("Full-Time");
                        
                        
                         try {
							oos = new ObjectOutputStream(new FileOutputStream(teacherFile));
							 oos.writeObject(listOfTeacher);
							 oos.close();
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						} catch (IOException e1) {
							e1.printStackTrace();
						}    
                        
                        System.out.println("Teacher added!");
	                    //System.out.println(t);
					}
					else if(parttimebtn.isSelected()) {
						//PartTime
                        PartTime pt = new PartTime();
						pt.setId(fempid.getText());
                        pt.setFirstname(fempfname.getText());
                        pt.setLastname(femplname.getText());
                        pt.setPhoneNumber(fphoneNumber.getText());
                        pt.setEmail(femail.getText());
                        pt.setDegree(fdegree.getText());
                        speciality.add(fspeciality.getText());
                        pt.setSpeciality(speciality);
                        pt.setHoursWorked(Integer.parseInt(fhoursworked.getText()));                                                                                                                                                 
                        listOfPartTime.add(pt);
                        
                         try {
							oos = new ObjectOutputStream(new FileOutputStream(parttimeFile));
							 oos.writeObject(listOfPartTime);
							 oos.close();
						} catch (FileNotFoundException e2) {
							e2.printStackTrace();
						} catch (IOException e2) {
							e2.printStackTrace();
						} 
                         
                        t.setId(fempid.getText());
                        t.setFirstname(fempfname.getText());
                        t.setLastname(femplname.getText());
                        t.setPhoneNumber(fphoneNumber.getText());
                        t.setEmail(femail.getText());
                        t.setDegree(fdegree.getText());
                        speciality.add(fspeciality.getText());
                        t.setSpeciality(speciality);
                        t.setType("Part-Time");                        
                        listOfTeacher.add(t);
                        
                        
                        try {
							oos = new ObjectOutputStream(new FileOutputStream(teacherFile));
							oos.writeObject(listOfTeacher);
							oos.close();
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						} catch (IOException e1) {
							e1.printStackTrace();
						}    
                        
                        System.out.println("Teacher added!");
	                    //System.out.println(t);
					}
					else if(staffbtn.isSelected()) {
						//Staff						
						Staff s = new Staff();
	                    s.setId(fempid.getText());
	                    s.setFirstname(fempfname.getText());
	                    s.setLastname(femplname.getText());
	                    s.setPhoneNumber(fphoneNumber.getText());
	                    s.setEmail(femail.getText());                              
	                    s.setDuty(fduty.getText());
	                    s.setWorkload(Integer.parseInt(fworkload.getText()));
	                    
	                    listOfStaff.add(s);
	                    System.out.println("Staff added!");
	                    
	                    try {
							oos = new ObjectOutputStream(new FileOutputStream(staffFile));
							oos.writeObject(listOfStaff);
							oos.close();
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
	                    //System.out.println(s);
					}
					
					stg1.close();
					primaryStage.show();
				});
								
				home.setOnAction(homeAction -> {
					stg1.close();
					primaryStage.show();
				});
			});
			
			assign.setOnAction(e -> {
				primaryStage.close();
				
				Pane assignemp = new Pane();
				
				Scene sc1 = new Scene(assignemp);
				
				Stage stg1 = new Stage();
				stg1.setHeight(300);
				stg1.setWidth(400);
				stg1.setScene(sc1);
				stg1.show();
				stg1.setTitle("Assign Employee");
				
				Label ldept = new Label("Department ID: ");		
				ldept.setLayoutX(30);
				ldept.setLayoutY(30);
				Label lemp = new Label("Employee ID: ");
				lemp.setLayoutX(30);
				lemp.setLayoutY(70);
				
				TextField fdept = new TextField();
				fdept.setLayoutX(150);
				fdept.setLayoutY(30);
				TextField femp = new TextField();
				femp.setLayoutX(150);
				femp.setLayoutY(70);
				
				Button assignbtn = new Button("Assign");
				assignbtn.setLayoutX(150);
				assignbtn.setLayoutY(200);
				Button home = new Button("Home");
				home.setLayoutX(200);
				home.setLayoutY(200);
				
				assignemp.getChildren().addAll(ldept, lemp, fdept, femp, assignbtn, home);
				
				assignbtn.setOnAction(assignaction -> {
					boolean deptExists = false;
					
					String deptId = fdept.getText();
					String empId = femp.getText();
					
					try{	                    
	                    
	                    if (listOfDepartments.isEmpty() == true) {
	                    	Alert a = new Alert(AlertType.INFORMATION, "No Departments available", null);
							a.show();
	                        throw new InexistentDepartmentException();	                        
	                    }
	                    
	                    else
	                                                
	                    for (int i = 0; i < listOfDepartments.size(); i++) {
	                        if (listOfDepartments.get(i).getId().equalsIgnoreCase(deptId)) {
	                                deptExists = true;	                                
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
	                                	Alert a = new Alert(AlertType.INFORMATION, "Employee does not exist!", null);
	        							a.show();
	                                    System.out.println("Employee does not exist");
	                                }
	                            }
	                                                
	                    if(deptExists == false) {
	                    		Alert a = new Alert(AlertType.INFORMATION, "Department does not exist!", null);
	                    		a.show();
	                            throw new InexistentDepartmentException();
	                    }
	                    }                           
	                    }                    
	                    catch(Exception err){
	                        System.out.println(err);                        
	                    }
															
				});
				
				home.setOnAction(homeAction -> {
					stg1.close();
					primaryStage.show();
				});
			});
			
			addDean.setOnAction( e -> {
				primaryStage.close();
				
				Pane deanadd = new Pane();
				
				Scene sc1 = new Scene(deanadd);
				
				Stage stg1 = new Stage();
				stg1.setHeight(300);
				stg1.setWidth(400);
				stg1.setScene(sc1);
				stg1.show();
				stg1.setTitle("Add Dean");
				
				Label ldept = new Label("Department ID: ");		
				ldept.setLayoutX(30);
				ldept.setLayoutY(30);
				Label lemp = new Label("Employee ID: ");
				lemp.setLayoutX(30);
				lemp.setLayoutY(70);
				
				TextField fdept = new TextField();
				fdept.setLayoutX(150);
				fdept.setLayoutY(30);
				TextField femp = new TextField();
				femp.setLayoutX(150);
				femp.setLayoutY(70);
				
				Button adddeanbtn = new Button("Assign");
				adddeanbtn.setLayoutX(150);
				adddeanbtn.setLayoutY(200);
				Button home = new Button("Home");
				home.setLayoutX(200);
				home.setLayoutY(200);
				
				deanadd.getChildren().addAll(ldept, lemp, fdept, femp, adddeanbtn, home);
				
				adddeanbtn.setOnAction(addDeanAction -> {
					boolean flag = false;
					String deptId = fdept.getText();
					String empId = femp.getText();
					
					try {
					for (int i = 0; i < listOfDean.size(); i++) {
                        if (listOfDean.get(i).empId.equalsIgnoreCase(empId)) {
                        	Alert a = new Alert(AlertType.INFORMATION, "Teacher is already a dean!", null);
                    		a.show();
                            throw new Exception("Teacher is already a dean!");
                        }                            
                    }
                    
                    for (int i = 0; i < listOfDepartments.size(); i++) {
                        if (listOfDepartments.get(i).id.equalsIgnoreCase(deptId) && listOfDepartments.get(i).getTeacherList().get(i).id.equalsIgnoreCase(empId)) {
                            flag = true;
                            Dean dean = new Dean(empId, deptId);
                            listOfDean.add(dean);
                            System.out.print("Dean assigned!");    
                            
                            oos = new ObjectOutputStream(new FileOutputStream(deanFile));
                            oos.writeObject(listOfDean);
                            oos.close(); 
                        }
                    }
                    
                    for (int i = 0; i < listOfStaff.size(); i++) {
                        if (empId.equalsIgnoreCase(listOfStaff.get(i).id)) {
                        	Alert a = new Alert(AlertType.INFORMATION, "Staff cannot be a dean", null);
                    		a.show();
                            throw new Exception("Staff cannot be a dean");
                        }
                    }
                    
                    if (flag == false) {
                    	Alert a = new Alert(AlertType.INFORMATION, "Teacher cannot be dean in that department!", null);
                		a.show();
                        throw new Exception("Teacher cannot be dean in that department!");
                    }
                    
                } catch (Exception err) {
                    System.out.println(err);
                }
				});
				
				home.setOnAction(homeAction -> {
					stg1.close();
					primaryStage.show();
				});
			});
			
			showDean.setOnAction(e -> {
				
				System.out.println("Deans\n-----------------------");
                for (Dean deans : listOfDean) {
                    System.out.println(deans);
                }
				
				primaryStage.close();
				
				Pane showDeanp = new Pane();
				
				Scene sc1 = new Scene(showDeanp);
				
				Stage stg1 = new Stage();
				stg1.setHeight(300);
				stg1.setWidth(520);
				stg1.setScene(sc1);
				stg1.show();
				stg1.setTitle("Add Dean");
				
				TextArea deanInfo = new TextArea();
				deanInfo.setLayoutX(10);
				deanInfo.setLayoutY(0);
				if (listOfDean.isEmpty()) {
					deanInfo.setText("No Deans to display");
				}
				else {
					deanInfo.setText(listOfDean.toString());
				}		
				
				Button home = new Button("Home");
				home.setLayoutX(220);
				home.setLayoutY(200);
				
				showDeanp.getChildren().addAll(deanInfo,home);
				
				home.setOnAction(homeAction -> {
					stg1.close();
					primaryStage.show();
				});
			});
			
			showInfo.setOnAction(e -> {
				
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
				
				primaryStage.close();
				
				Pane showAllInfo = new Pane();
				
				Scene sc1 = new Scene(showAllInfo);
				
				Stage stg1 = new Stage();
				stg1.setHeight(300);
				stg1.setWidth(520);
				stg1.setScene(sc1);
				stg1.show();
				stg1.setTitle("Show Info");
				
				TextArea allInfo = new TextArea();
				allInfo.setLayoutX(10);
				allInfo.setLayoutY(0);
				if (listOfDepartments.isEmpty()) {
					allInfo.setText("Departments\n------------------\nNo Departments to display");
				}
				if(listOfTeacher.isEmpty()) {
					allInfo.setText("Teachers\n------------------\nNo Teachers to display");
				}
				if(listOfStaff.isEmpty()) {
					allInfo.setText("Staff\n------------------\nNo Staff to display");
				}
				else {
					allInfo.setText("Departments\n------------------\n"+listOfDepartments.toString()+"\n");
					allInfo.setText(listOfDean.toString()+"\n");
					allInfo.setText(listOfDean.toString()+"\n");
				}		
				
				Button home = new Button("Home");
				home.setLayoutX(220);
				home.setLayoutY(200);
				
				showAllInfo.getChildren().addAll(allInfo,home);
				
				home.setOnAction(homeAction -> {
					stg1.close();
					primaryStage.show();
				});
			});
			
			showDeptInfo.setOnAction(e -> {
				primaryStage.close();
				
				Pane showDeptInfop = new Pane();
				
				Scene sc1 = new Scene(showDeptInfop);
				
				Stage stg1 = new Stage();
				stg1.setHeight(350);
				stg1.setWidth(520);
				stg1.setScene(sc1);
				stg1.show();
				stg1.setTitle("Show Department Info");
								
				TextArea deptInfo = new TextArea();
				deptInfo.setLayoutX(10);
				deptInfo.setLayoutY(60);
				
				Label ldept = new Label("Department ID: ");
				ldept.setLayoutX(30);
				ldept.setLayoutY(20);
								
				TextField fdept = new TextField();
				fdept.setLayoutX(150);
				fdept.setLayoutY(20);
				
				Button home = new Button("Home");
				home.setLayoutX(220);
				home.setLayoutY(250);
				Button showDept = new Button("Show");
				showDept.setLayoutX(300);
				showDept.setLayoutY(20);
				showDeptInfop.getChildren().addAll(deptInfo,home,showDept,ldept,fdept);
				
				
				showDept.setOnAction(empAction -> {
					String deptId = fdept.getText();
					
					boolean deptExists2 = false;

                    try{                   
                    
                    if (listOfDepartments.isEmpty()) {
                    	Alert a = new Alert(AlertType.INFORMATION, "There are no departments.", null);
                    	a.show();
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
                        	Alert a = new Alert(AlertType.INFORMATION, "Department does not exist", null);
                        	a.show();
                            throw new InexistentDepartmentException();
                        }                    
                    }
                    }
                    catch(Exception err){
                        System.out.println(err);
                    }
				});
				
				home.setOnAction(homeAction -> {
					stg1.close();
					primaryStage.show();
				});                
			});
			
			
			showEmpInfo.setOnAction(e -> {

				primaryStage.close();
				
				Pane showEmpInfop = new Pane();
				
				Scene sc1 = new Scene(showEmpInfop);
				
				Stage stg1 = new Stage();
				stg1.setHeight(350);
				stg1.setWidth(520);
				stg1.setScene(sc1);
				stg1.show();
				stg1.setTitle("Show Employee Info");
								
				TextArea empInfo = new TextArea();
				empInfo.setLayoutX(10);
				empInfo.setLayoutY(60);
				
				Label lemp = new Label("Employee ID: ");
				lemp.setLayoutX(30);
				lemp.setLayoutY(20);
								
				TextField femp = new TextField();
				femp.setLayoutX(150);
				femp.setLayoutY(20);
				
				Button home = new Button("Home");
				home.setLayoutX(220);
				home.setLayoutY(250);
				Button showEmp = new Button("Show");
				showEmp.setLayoutX(300);
				showEmp.setLayoutY(20);
				showEmpInfop.getChildren().addAll(empInfo,home,showEmp,lemp,femp);
				
				
				showEmp.setOnAction(empAction -> {
					String empId = femp.getText();
					
					if (listOfStaff.isEmpty()&&listOfTeacher.isEmpty()) {
						Alert a = new Alert(AlertType.INFORMATION, "No Employees to Show", null);
                    	a.show();
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
                    	Alert a = new Alert(AlertType.ERROR, "Employee not found", null);
                    	a.show();
                        System.out.println("Employee not found");
                    }
                }
				});
				
				home.setOnAction(homeAction -> {
					stg1.close();
					primaryStage.show();
				});                
			});					
			
			exit.setOnAction( e -> {
				primaryStage.close();
			});
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
