package app.domain.model;

public class PersonalAdministration extends Employee
{

	    public PersonalAdministration(String idNumber, String name, String lastName, String gender, String birthDate,
	                      			  String phoneNumber, String email, String username, String password)
	    {
	        super(idNumber, name, lastName, gender, birthDate, phoneNumber, email, username, password, "Admin");
	    }

	    @Override
	    public void showData()
	    {
	        System.out.println("Administrative Staff: " + getName() + " " + getLastName());
	    }
	
}
