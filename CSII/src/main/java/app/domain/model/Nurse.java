package app.domain.model;

public class Nurse extends Employee 
{
	
    public Nurse(String idNumber, String name, String lastName, String gender, String birthDate,
                 String phoneNumber, String email, String username, String password)
    {
        super(idNumber, name, lastName, gender, birthDate, phoneNumber, email, username, password, "Nurse");
    }

    @Override
    public void showData()
    {
        System.out.println("Nurse: " + getName() + " " + getLastName());
    }

}
