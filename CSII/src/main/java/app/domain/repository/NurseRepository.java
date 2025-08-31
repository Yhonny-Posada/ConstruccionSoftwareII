package app.domain.repository;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import app.domain.model.Nurse;
public class NurseRepository
{
 
    private List<Nurse> nurses = new ArrayList<>();
 
    public void add(Nurse nurse)
    {
        nurses.add(nurse);
    }
 
    public List<Nurse> getAll()
    {
        return new ArrayList<>(nurses);
    }
 
    public Optional<Nurse> findById(String idNumber)
    {
        if (idNumber == null) return Optional.empty();
 
        for (Nurse n : nurses)
        {
            if (idNumber.equals(n.getIdNumber()))
            {
                return Optional.of(n);
            }
        }
        return Optional.empty();
    }
 
    public void update(Nurse updatedNurse)
    {
        findById(updatedNurse.getIdNumber()).ifPresent(n ->
        {
            nurses.remove(n);
            nurses.add(updatedNurse);
        });
    }
 
    public void delete(String idNumber)
    {
        nurses.removeIf(n -> n.getIdNumber().equals(idNumber));
    }
}