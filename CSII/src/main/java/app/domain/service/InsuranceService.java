package app.domain.service;
 
import java.util.List;

import app.domain.model.Insurance;

import app.domain.repository.InsuranceRepository;
 
public class InsuranceService

{
 
    private final InsuranceRepository repository;
 
    public InsuranceService(InsuranceRepository repository)

    {

        this.repository = repository;

    }
 
    public void registerInsurance(Insurance insurance)

    {

        if (repository.findById(insurance.getPolicyNumber()).isPresent())

        {

            throw new IllegalArgumentException("Ya existe un seguro con este número de póliza.");

        }

        repository.add(insurance);

    }
 
    public List<Insurance> listInsurances()

    {

        return repository.getAll();

    }
 
    public void updateInsurance(Insurance insurance)

    {

        repository.update(insurance);

    }
 
    public void deleteInsurance(String policyNumber)

    {

        repository.delete(policyNumber);

    }

}

 
