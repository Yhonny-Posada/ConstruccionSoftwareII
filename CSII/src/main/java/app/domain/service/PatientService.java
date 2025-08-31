package app.domain.service;
 
import java.util.List;
import app.domain.model.Patients;
import app.domain.repository.PatientRepository;
 
public class PatientService
{
    private final PatientRepository repository;
 
    public PatientService(PatientRepository repository)
    {
        this.repository = repository;
    }
 
    public void registerPatient(Patients patient)
    {
        if (repository.findById(patient.getIdNumber()).isPresent())
        {
            throw new IllegalArgumentException("Ya existe un paciente con este ID.");
        }
        repository.add(patient);
    }
 
    public List<Patients> listPatients()
    {
        return repository.getAll();
    }
 
    public void updatePatient(Patients patient)
    {
        repository.update(patient);
    }
 
    public void deletePatient(String idNumber)
    {
        repository.delete(idNumber);
    }
}