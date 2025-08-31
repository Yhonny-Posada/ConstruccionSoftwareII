package app.application.usecase;

import app.domain.model.HumanResources;
import app.domain.repository.HumanResourcesRepository;

public class HumanResourcesUseCases {

    private final HumanResourcesRepository repository;

    public HumanResourcesUseCases(HumanResourcesRepository repository)
    {
        this.repository = repository;
    }

    public void createUser(HumanResources hrMember)
    {
    	
        if (repository.findById(hrMember.getIdNumber()).isPresent())
        {
            throw new IllegalArgumentException("Ya existe un usuario con esta cédula.");
        }
        
        repository.add(hrMember);
        
    }
    
    public void deleteUser(String idNumber)
    {
        repository.delete(idNumber);
    }

    
    public void updateUser(HumanResources hrMember)
    {
        repository.update(hrMember);
    }

    public HumanResources getUser(String idNumber)
    {
    	
        return repository.findById(idNumber).orElseThrow(() ->
        				 new IllegalArgumentException("Usuario no encontrado"));
        
    }
    
}
