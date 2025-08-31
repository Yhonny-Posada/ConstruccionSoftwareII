package app.domain.repository;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import app.domain.model.Patients;
 
public class PatientRepository
{
 
	private List<Patients> patients = new ArrayList<>();
	public void add(Patients patient)
	{
		patients.add(patient);
	}
	public List<Patients> getAll()
	{
		return new ArrayList<>(patients);
	}
	public Optional<Patients> findById(String idNumber)
	{
        if (idNumber == null) return Optional.empty();
        for (Patients p : patients)
        {
            if (idNumber.equals(p.getIdNumber()))
            {
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }
	public void update(Patients updatedPatient)
	{
        findById(updatedPatient.getIdNumber()).ifPresent(p ->
        {
            patients.remove(p);
            patients.add(updatedPatient);
        });
    }
	public void delete(String idNumber)
	{
        patients.removeIf(p -> p.getIdNumber().equals(idNumber));
    }
}