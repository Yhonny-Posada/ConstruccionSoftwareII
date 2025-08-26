package app.domain.model;

public abstract class PersonClass
{

	private String idNumber;
    private String name;
    private String lastName;
    private String gender;
    private String birthDate;
    private String phoneNumber;
    private String email;
    
    public PersonClass(String idNumber, String name, String lastName, String gender, String birthDate, String phoneNumber, String email) {
        this.idNumber = idNumber;
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public void setName(String name)
    {
    	this.name = name;
    }
    
    public void setLastName(String lastName)
    {
    	this.lastName = lastName;
    }
    
    public void setGender(String gender)
    {
    	this.gender = gender;
    }
    
    public void setBirthDate(String birthDate)
    {
    	this.birthDate = birthDate;
    }
    
    public void setPhoneNumber(String phoneNumber)
    {
    	this.phoneNumber = phoneNumber;
    }
    
    public void setEmail(String email)
    {
    	this.email = email;
    }
    
    public String getIdNumber()
    {
    	return idNumber;
    }
    
    public String getName()
    {
    	return name;
    }
    
    public String getLastName()
    {
    	return lastName;
    }
    
    public String getGender()
    {
    	return gender;
    }
    
    public String getBirthDate()
    {
    	return birthDate;
    }
    public String getPhoneNumber()
    {
    	return phoneNumber;
    }
    public String getEmail()
    {
    	return email;
    }
    
    public abstract void showData();
    
}
