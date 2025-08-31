package app.domain.repository;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import app.domain.model.Insurance;
 
public class InsuranceRepository
{
 
    private List<Insurance> insurances = new ArrayList<>();
 
    public void add(Insurance insurance)
    {
        insurances.add(insurance);
    }
 
    public List<Insurance> getAll()
    {
        return new ArrayList<>(insurances);
    }
 
    public Optional<Insurance> findById(String policyNumber)
    {
        if (policyNumber == null) return Optional.empty();
 
        return insurances.stream()
                .filter(i -> policyNumber.equals(i.getPolicyNumber()))
                .findFirst();
    }
 
    public void update(Insurance updatedInsurance)
    {
        findById(updatedInsurance.getPolicyNumber()).ifPresent(i ->
        {
            insurances.remove(i);
            insurances.add(updatedInsurance);
        });
    }
 
    public void delete(String policyNumber)
    {
        insurances.removeIf(i -> i.getPolicyNumber().equals(policyNumber));
    }
}