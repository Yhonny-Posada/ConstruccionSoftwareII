package app.domain.model;

public class Doctor extends Employee
{

	private String professionalLicense;
	
	public Doctor(String idNumber, String name, String lastName, String gender, String birthDate,
            	  String phoneNumber, String email, String username, String password, String professionalLicense)
	{
		
		super(idNumber, name, lastName, gender, birthDate, phoneNumber, email, username, password, "Doctor");
		this.professionalLicense = professionalLicense;
		
	}
	
	public void setProfessionalLicense(String professionalLicense)
	{
		this.professionalLicense = professionalLicense;
	}
	
	public String getProfessionalLicense()
	{
		return professionalLicense;
	}
	
	@Override
    public void showData()
	{
        System.out.println("Doctor: " + getName() + " " + getLastName() + ", Licencia: " + professionalLicense);
    }
	
}
