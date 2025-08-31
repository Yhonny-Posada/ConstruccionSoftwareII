package app.domain.service;
 
import java.util.List;
import app.domain.model.Nurse;
import app.domain.repository.NurseRepository;
 
public class NurseService
{
 
    private final NurseRepository repository;
 
    public NurseService(NurseRepository repository)
    {
        this.repository = repository;
    }
 
    public void registerNurse(Nurse nurse)
    {
        if (repository.findById(nurse.getIdNumber()).isPresent())
        {
            throw new IllegalArgumentException("Ya existe una enfermera con este ID.");
        }
        repository.add(nurse);
    }
 
    public List<Nurse> listNurses()
    {
        return repository.getAll();
    }
 
    public void updateNurse(Nurse nurse)
    {
        repository.update(nurse);
    }
 
    public void deleteNurse(String idNumber)
    {
        repository.delete(idNumber);
    }
}