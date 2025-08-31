package app.domain.service;
 
import java.util.List;
import app.domain.model.Doctor;
import app.domain.repository.DoctorRepository;
 
public class DoctorService
{
 
    private final DoctorRepository repository;
 
    public DoctorService(DoctorRepository repository)
    {
        this.repository = repository;
    }
 
    public void registerDoctor(Doctor doctors)
    {
        if (repository.findById(doctors.getIdNumber()).isPresent())
        {
            throw new IllegalArgumentException("Ya existe un paciente con este ID.");
        }
        repository.add(doctors);
    }
 
    public List<Doctor> listDoctors()
    {
        return repository.getAll();
    }
 
    public void updateDoctors(Doctor doctors)
    {
        repository.update(doctors);
    }
 
    public void deleteDoctor(String idNumber)
    {
        repository.delete(idNumber);
    }
}
