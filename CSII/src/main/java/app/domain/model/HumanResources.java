package app.domain.model;

public class HumanResources extends Employee
{

	public HumanResources(String idNumber, String name, String lastName, String gender, String birthDate,
						  String phoneNumber, String email, String username, String password)
	{
		super(idNumber, name, lastName, gender, birthDate, phoneNumber, email, username, password, "HR");
	}
	
	@Override
    public void showData()
	{
        System.out.println("HR: " + getName() + " " + getLastName());
    }
	
}
