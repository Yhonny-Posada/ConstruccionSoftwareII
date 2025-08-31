package app.domain.service;
 
import java.util.List;

import app.domain.model.HumanResources;

import app.domain.repository.HumanResourcesRepository;
 
public class HumanResourcesServices

{
 
    private final HumanResourcesRepository repository;
 
    public HumanResourcesServices(HumanResourcesRepository repository)

    {

        this.repository = repository;

    }
 
    public void registerHR(HumanResources hr)

    {

        if (repository.findById(hr.getIdNumber()).isPresent())

        {

            throw new IllegalArgumentException("Ya existe un recurso humano con este ID.");

        }

        repository.add(hr);

    }
 
    public List<HumanResources> listHR()

    {

        return repository.getAll();

    }
 
    public void updateHR(HumanResources hr)

    {

        repository.update(hr);

    }
 
    public void deleteHR(String idNumber)

    {

        repository.delete(idNumber);

    }

}

 
