/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.mavenproject1;

/**
 *
 * @author ROG
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime; 
import java.time.LocalDate; 


public class Staff {
    
    String employee_name;
    String employee_id;
    String employee_phoneno;
    String employee_type;
    
    Staff(){
        
    }
       public static void main(String args[]) {
        
       
         Staff m3 = new Staff();  // Create object of Staff class
	System.out.println("######################################################################################################################\n\n\n");
	System.out.println("EMPLOYEE PAYROlL SYSTEM");
	m3.method();
        
    
    }
    
        public void method(){
            
        Staff m1 = new Staff();  // Create object of Staff class
        Employee ty = new Employee();  // Create object of Employee class
	
	int choice = 0;
	
	

	LocalDate dat = LocalDate.now();
        LocalTime tim = LocalTime.now();   // Create a date object
        
        Scanner enter = new Scanner(System.in);
        for(int u=0; u<10; u++){
            System.out.println("\n\n");
        }
        
        m1.display();  // call the display function in Staff class
        System.out.println(dat); // Display the current date
	System.out.println(tim); // Display the current time
        while(choice < 8) {
            
            Scanner input = new Scanner(System.in);
	    System.out.print("\nPlease Enter Your Choice (1-7): ");
            choice = input.nextInt();
            
            switch(choice){
                
                case 1:
	        {
                    Staff add = new Staff();   // Create object of Staff class
                    add.createFile();
		    m1.display();     
		    break;
		}
				
		case 2:
		{	
		    System.out.print("\nView Employee Details- \n");
		    String dt = input.nextLine();
				
		    Staff view = new Staff();
				
		    try {
                        view.viewFile(dt);
                    }
		    catch(Exception e){
                        System.out.println("\nError! Employee not exists.");
                    }
		    m1.display();
		    break;
		}
			
		case 3:
		{
                    System.out.print("\nEnter Employee ID : ");
                    String id = input.nextLine();
		
                    Staff view = new Staff();
			
                    try{
                        view.viewFile(id);
                    }
		    catch(Exception e){
                        System.out.println("\nError! Employee not exists.");
                    }
                    
                    System.out.print("\nEnter the Employee's Detail that you want to edit (Exp: jason) ");
		    System.out.print("\nEnter Old Details: ");
		    String ot = input.nextLine();
		
		    System.out.print("\nEnter New Details: ");
		    String nt = input.nextLine();
				
		    Staff edit = new Staff();
		
                    try{
			edit.updateFile(id,ot,nt);
                        edit.display();
			break;
			}
			catch(IOException e){
                            System.out.println("\nError! Employee not exists.");
                        }
		}
				
		case 4:
		{	
                    Staff dlt = new Staff();
		    dlt.removeFile();
		    dlt.display();
		    break;
		}
				
		case 5:
		{
                    System.out.print("\nSelect type of employee\n 1: Salaried Employee \n 2: Hourly Employee \n 3: Commission Employee \n 4: Base-Salaried Commission Employee: \n\nInsert number(1-4): ");
		    int employeeType = input.nextInt();
                    
                    if(employeeType==1){
                        Sala_emp cl = new Sala_emp();  // Create object of Sala_emp class
                        cl.salaryemp();
		    }
                    else if(employeeType==2){
                        Hour_emp hr = new Hour_emp();  // Create object of Hour_emp class
                        hr.houremp();
		    }
                    else if(employeeType==3){
			Commi_emp ce = new Commi_emp();  // Create object of Commi_emp class
			ce.commisionemp();
		    }
                    else if(employeeType==4){
			Basesal_com_emp bs = new  Basesal_com_emp();  // Create object of Basesal_com_emp class
			bs.basesalcomemp(); 
                    }
                    
		    Staff emp = new Staff();  // Create object of Staff class
                    emp.display();   // call the display function in Staff class
		    break;
		}
		
	        case 6:
		{
                    System.out.print("\nSelect type of Leave: \n1 : Annual Leave\n2 : Unpaid Leave \n\nInsert number(1-2): ");
                    int leavetype = input.nextInt();
                    
                    if(leavetype==1){
                        Employee an = new Employee();  // Create object of Employee class
                        an.annualLeave();
                    }
                    else if(leavetype==2){
                        Employee un = new Employee();
                        un.unpaidLeave();
                    }
                    
                    Staff mn = new Staff();  
                    mn.display();
		    break;
		}
                
                case 7:
		{
                    Staff qt = new Staff();
                    qt.logout();    
		}
                
                default:
                {
                    System.out.println("\nInvalid choice! Please Try Again");
                }
            }
	}
    }

    public void display() { 
        
        System.out.println("\n\n--------------------------------------");
	System.out.println("\n\nMenu:-");
	System.out.println("1 : Add Employee");
	System.out.println("2 : View Employee Details ");
	System.out.println("3 : Edit/Update Employee Details");
	System.out.println("4 : Delete Employee");
        System.out.println("5 : Calculate Employee Salary");
	System.out.println("6 : Check Employee Leave Status");
        System.out.println("7 : Quit\n\n");
    }
    
    public void createFile(){
        
        Scanner input = new Scanner(System.in);
		
        System.out.print("\nEnter Employee Name: ");
        employee_name = input.nextLine();
		
        System.out.print("Enter Employee ID: ");
        employee_id = input.nextLine();
		
	System.out.print("\nEmployee Types:- \n SE: Salaried Employee \n HE: Hourly Employee \n CE: Commission Employee \n BSE: Base-Salaried Commission Employee");
        System.out.print("\n\nEnter Employee Type: ");
        employee_type = input.nextLine();
		
	System.out.print("Enter Employee Phone No.: ");
        employee_phoneno = input.nextLine();
		
	System.out.println("\nEmployee Name: " +employee_name);
	System.out.println("Employee ID: " +employee_id);
	System.out.println("Employee Type: " +employee_type); 
	System.out.println("Employee Phone No.: " +employee_phoneno);
	
        try{
			
            File txt = new File("" +employee_id +".txt");
			
            if(txt.createNewFile()){  // creates the file
                
                FileWriter file = new FileWriter("" +employee_id +".txt");  // creates a FileWriter Object
		    // Writes the content to the file
                file.write("\nEmployee Details:- \nEmployee Name: " +employee_name +"\n" +"Employee ID: " +employee_id +"\n" +"Employee Type: " +employee_type +"\n" +"Phone No.: " +employee_phoneno);
                file.close();
				
                System.out.println("\nEmployee Info Added Successfully!");
	    }
            else {
                System.out.println("\nError! Employee ID already exists!  ");
            }		
        }
        catch(Exception e){
            System.out.println("\nError! Employee did not exists!");
        }
    }
    
    public void logout(){
        System.out.println("\n--------------------------------------");
        System.out.println("\n     LogOut Successfully!\n");
	System.exit(0);
    }
    
    public void viewFile(String dt) throws Exception {
		
		String id;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter Employee ID : ");
		id = sc.nextLine();
		
		File txt = new File("" +id +".txt");
		Scanner input = new Scanner(txt);
		
		while (input.hasNextLine()) {  //Reading the lines of the file
		
		    System.out.println(input.nextLine());
		}
    }
    
    public void updateFile(String id,String ot,String nt) throws IOException {
		
	Scanner in = new Scanner(System.in);
	System.out.print("\nEnter the Employee ID to confirm: ");
	id = in.nextLine();
	
	File txt = new File("" +id +".txt");
	if(txt.exists()){
            
            Scanner input = new Scanner(txt);
	    String fileContent = "";  //Instantiating the File class
            
            while (input.hasNextLine()) {  //Reading lines of the file
                fileContent = fileContent +"\n" +input.nextLine();
	    }
            
            FileWriter word = new FileWriter("" +id +".txt");
            fileContent = fileContent.replaceAll(ot, nt);  // ot - oldtext, nt - newtext & replace the old text with new text
	    word.write(fileContent);   //instantiating the FileWriter class
	    word.close();
		  
	    System.out.println("\nEmployee Detail has updated. ");
		
	}else{
            System.out.println("\nError! Employee did not exists! ");
	}
    }
    
    public void removeFile() {
		
	String id;
		
	Scanner input = new Scanner(System.in);
	System.out.print("\nEnter Employee ID : ");
	id = input.nextLine();
		
	File txt = new File("" +id +".txt");
	if(txt.exists()){
            if(txt.delete()) {
                System.out.println(txt.getName() + " has been deleted. ");
	        System.out.println("\nEmployee has been deleted. ");
            }
	}
	else{ 
            System.out.println("\nError! Employee did not exists! ");
	}
    }
}


class Employee {
    
    Employee(){
    
    }
    
    public void annualLeave() {
        
        int cash;
        int grosspay;
        int leave;
        
        Scanner in = new Scanner(System.in);
        System.out.println("\nAnnual Leave is Selected.");
        System.out.print("\nEnter Employee Salary: ");
        cash = in.nextInt();
                
        System.out.println("\nDay of leave: ");
        leave = in.nextInt();
                
        System.out.println("\nDay of leave: "+ leave);
        int al = 14;  //14 days is the default annual leave for 1 year
        
        double finalal = al - leave;
        grosspay = cash - 0;  // deduct 0 because annualLeave no need to deduct employee's salary
        
        System.out.println("Salary earned: "+ grosspay);
        System.out.println("AL :"+ finalal + " Days"); 
    }
    
    public void unpaidLeave() {
        
     
        
        Scanner in = new Scanner(System.in);
        
        System.out.println("\nUnpaid Leave is Selected.");
        
                
        System.out.print("\nDay of leave: ");
        int leave = in.nextInt();
        System.out.print("\nEnter Employee Salary: RM");
        double cash = in.nextInt();
		double cal= (cash -(leave*((cash/30))));
        double grosspay = (cash - cal);
                    
        System.out.println("Salary earned: RM"+ grosspay);
    }
}

class Sala_emp extends Employee{
    
    int week;
    int id;
    String sn;
    
    Scanner in = new Scanner(System.in);
    
    public void salaryemp(){
        
        System.out.println("\nEnter Salaried Employee Name : ");
        sn = in.nextLine();
	
	System.out.println("Enter Employee ID: ");
	id = in.nextInt();
	
	System.out.println("Enter week of the employee work: ");
	week = in.nextInt();
        
        System.out.print("\nTotal Salary is RM " +(week*750));
        
        System.out.println("\n\nDo you want to print the payment slip(1=Yes || 2=No): ");  
	int choices = in.nextInt();
                        
        if(choices==1){
            display();
        }else{
            System.out.println("Process End! ");
             }
    }
    
    public void display(){
        
        System.out.print("\n\n****RESULT****\n");
	System.out.print("\nEmployee ID: " +id);
	System.out.print("\nSalaried Employee Name : " +sn);
	System.out.print("\nWeekly Salary is RM 750");
        System.out.print("\nThe total weeks that employee have worked: "+ week +" weeks");
	System.out.print("\nCalculation: " +week +" * " +" RM750");
	System.out.print("\nTotal Salary is RM " +(week*750));
    }
}

class Hour_emp extends Employee{
    
    int hour, ot;
    int id;
    String hn;
    double salary;
    
    public void houremp(){
        
        Scanner in = new Scanner(System.in);
        System.out.println("\nEnter Hourly Employee Name: ");
        hn = in.nextLine();

        System.out.println("Enter Employee ID: ");
        id = in.nextInt();

        System.out.println("Enter the number of the hours worked: ");
        hour = in.nextInt();
        
        if(hour>40){
            salary = (hour-40)*10+320;
	    System.out.print("\nTotal salary is RM " +salary); 
        }
        else {
            System.out.print("\nTotal Salary is RM" +(hour*8));
	}
        
        System.out.println("\n\nDo you want to print the payment slip(1=Yes || 2=No): ");  
	int choices = in.nextInt();
                        
        if(choices==1){
            display();
        }else{
            System.out.println("Process End! ");
             }
    }
    
    public void display(){
        
        if(hour>40){
            
            System.out.print("\n\n****RESULT****\n");
	    System.out.print("Employee ID: " +id);
	    System.out.print("\nHourly Employee Name : " +hn);
            System.out.print("\nHourly Wages is RM 8");
            System.out.print("\nThe total hour work that employee worked: " +hour +" hours");
	    System.out.print("\nThe overtime work = " +(hour-40) +" hour");
            System.out.print("\nOvertime Paid is RM 10 per hour");
            salary = (hour-40)*10+320;  //RM10 -overtime pay per hour, RM320 -salary of 40 hours 
            System.out.print("\nCalculation: " +hour +" - 40 * 10 + RM320");
	    System.out.print("\nTotal salary is RM " +salary); 
        }
        else {
            
            System.out.println("\n\n****RESULT****\n");
	    System.out.print("Employee ID: " +id);
	    System.out.print("\nHourly Employee Name : " +hn);
            System.out.print("\nHourly Wages is RM 8");
	    System.out.print("\nThe total hour work that employee worked: " +hour +" hours");
            System.out.print("\nCalculation: " +hour +" * RM8");
            System.out.print("\nTotal Salary is RM" +(hour*8));
	}
    }
}

class Commi_emp extends Employee{
    
    double sale;
    int id;
    String cn;
    
    public void commisionemp(){
        
        Scanner in = new Scanner(System.in);
        System.out.println("\nEnter Commission Employee Name: ");
        cn = in.nextLine();

        System.out.println("Enter Employee ID: ");
        id = in.nextInt();
 
        System.out.print("Enter the Gross Sales :RM ");
        sale = in.nextDouble();
        
        System.out.print("\nTotal salary is RM" +(sale*0.10));
        
        System.out.println("\n\nDo you want to print the payment slip(1=Yes || 2=No): ");  
	int choices = in.nextInt();
                        
        if(choices==1){
            display();
        }else{
            System.out.println("Process End! ");
             }
    }
    
    public void display(){
   
        System.out.print("\n\n****RESULT****\n");
	System.out.print("Employee ID: " +id);
	System.out.print("\nCommission Employee Name: " +cn);
        System.out.print("\nGross sale of the employee: RM " +sale);
        System.out.print("\nThe commision rate earn of the employee is 10% when reached over RM 1000 sales ");
        System.out.print("\nCalculation: " +sale +" * " +10 +"%");
        System.out.print("\nTotal salary is RM" +(sale*0.10));  // 0.10 = 10% 
    }	
}

class Basesal_com_emp extends Commi_emp{
    
    int id;
    String bsn;
    double g,s, salary;
    
    public void basesalcomemp(){
        
        Scanner in = new Scanner(System.in);
        System.out.println("\nEnter Base-Salaried Commision Employee Name : ");
        bsn = in.nextLine();

        System.out.println("Enter Employee ID: ");
        id = in.nextInt();

        System.out.print("Enter the Gross Sales :RM ");
        g = in.nextDouble();
        
        salary = (g*0.10); 
        System.out.println("\nTotal Salary is RM " +(salary+750));  
        
        System.out.println("\n\nDo you want to print the payment slip(1=Yes || 2=No): ");  
	int choices = in.nextInt();
                        
        if(choices==1){
            display();
        }else{
            System.out.println("Process End! ");
             }
    }
    
    public void display(){
    
        System.out.println("\n\n****RESULT****\n");
	System.out.println("Employee ID: " +id);
	System.out.println("\nBase-Salaried Commision Employee Name : " +bsn);
        System.out.println("\nThe base salary of the employee : RM 750");
	System.out.print("\nGross sale of the employee is RM " +g);
	System.out.println("\nThe commision rate earn of the employee is 10% when reached over RM 1000 sales ");
	salary = (g*0.10);  // 0.10 = 10% 
        System.out.print("\nCalculation: " +g +" * " +10 +"%" +" + RM750");
        System.out.println("\nTotal Salary is RM " +(salary+750));  
    }
}
