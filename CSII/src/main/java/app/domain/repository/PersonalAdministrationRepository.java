package app.domain.repository;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import app.domain.model.PersonalAdministration;
 
public class PersonalAdministrationRepository
{
 
    private List<PersonalAdministration> personalAdmins = new ArrayList<>();
 
    public void add(PersonalAdministration pa)
    {
        personalAdmins.add(pa);
    }
 
    public List<PersonalAdministration> getAll()
    {
        return new ArrayList<>(personalAdmins);
    }
 
    public Optional<PersonalAdministration> findById(String idNumber)
    {
        if (idNumber == null) return Optional.empty();
 
        return personalAdmins.stream()
                .filter(pa -> idNumber.equals(pa.getIdNumber()))
                .findFirst();
    }
 
    public void update(PersonalAdministration updatedPA)
    {
        findById(updatedPA.getIdNumber()).ifPresent(pa ->
        {
            personalAdmins.remove(pa);
            personalAdmins.add(updatedPA);
        });
    }
 
    public void delete(String idNumber)
    {
        personalAdmins.removeIf(pa -> pa.getIdNumber().equals(idNumber));
    }
}