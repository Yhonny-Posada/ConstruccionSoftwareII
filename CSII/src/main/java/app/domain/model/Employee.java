package app.domain.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public abstract class Employee extends PersonClass {
    private String username;
    private String password;
    private String jobTitle;

    public Employee(String idNumber, String name, String lastName, String gender, String birthDate,
                    String phoneNumber, String email, String username, String password, String jobTitle)
    {
        super(idNumber, name, lastName, gender, birthDate, phoneNumber, email);
        this.username = username;
        this.password = password;
        this.jobTitle = jobTitle;
    }
    
    public boolean validateUsername()
    {
        return username.matches("[a-zA-Z0-9]{1,15}");
    }

    public boolean validatePassword()
    {
        return password.matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$");
    }

    public boolean validatePhone()
    {
        return getPhoneNumber().matches("\\d{10}");
    }
    
    public boolean validateBirthDate()
    {
    	
        try
        {
        	
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate birth = LocalDate.parse(getBirthDate(), formatter);
            return ChronoUnit.YEARS.between(birth, LocalDate.now()) <= 150;
            
        }
        catch (Exception e)
        {
        	
            return false;
            
        }
        
    }
    
    public boolean accessToPatients()
    {
        return jobTitle.equalsIgnoreCase("Doctor") || jobTitle.equalsIgnoreCase("Nurse") || jobTitle.equalsIgnoreCase("Admin");
    }

    public boolean canManageUsers()
    {
        return jobTitle.equalsIgnoreCase("HR");
    }

    public boolean canUpdateInventory()
    {
        return jobTitle.equalsIgnoreCase("ITSupport") || jobTitle.equalsIgnoreCase("Admin");
    }
    
    public void setUsername(String username)
    {
    	this.username = username;
    }
    
    public void setPassword(String password)
    {
    	this.password = password;
    }
    
    public void setJobTitle(String jobTitle)
    {
    	this.jobTitle = jobTitle;
    }
    
    public String getUsername()
    {
    	return username;
    }

    public String getPassword()
    {
    	return password;
    }
    
    public String getJobTitle()
    {
    	return jobTitle;
    }
    
    public void showData()
    {
        System.out.println("Empleado: " + getName() + " " + getLastName() + ", Cargo: " + getJobTitle());
    }
    
}