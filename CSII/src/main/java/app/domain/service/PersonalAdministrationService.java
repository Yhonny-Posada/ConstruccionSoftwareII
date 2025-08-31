package app.domain.service;
 
import java.util.List;
import app.domain.model.PersonalAdministration;
import app.domain.repository.PersonalAdministrationRepository;
 
public class PersonalAdministrationService
{
 
    private final PersonalAdministrationRepository repository;
 
    public PersonalAdministrationService(PersonalAdministrationRepository repository)
    {
        this.repository = repository;
    }
 
    public void registerPA(PersonalAdministration pa)
    {
        if (repository.findById(pa.getIdNumber()).isPresent())
        {
            throw new IllegalArgumentException("Ya existe un personal administrativo con este ID.");
        }
        repository.add(pa);
    }
 
    public List<PersonalAdministration> listPA()
    {
        return repository.getAll();
    }
 
    public void updatePA(PersonalAdministration pa)
    {
        repository.update(pa);
    }
 
    public void deletePA(String idNumber)
    {
        repository.delete(idNumber);
    }
}