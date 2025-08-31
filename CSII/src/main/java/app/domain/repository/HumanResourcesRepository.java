package app.domain.repository;

import java.util.ArrayList;

import java.util.List;

import java.util.Optional;

import app.domain.model.HumanResources;
 
public class HumanResourcesRepository {
 
    private List<HumanResources> humanResources = new ArrayList<>();
 
    public void add(HumanResources hr) {

        humanResources.add(hr);

    }
 
    public List<HumanResources> getAll() {

        return new ArrayList<>(humanResources);

    }
 
    public Optional<HumanResources> findById(String idNumber) {

        if (idNumber == null) return Optional.empty();
 
        return humanResources.stream()

                .filter(hr -> idNumber.equals(hr.getIdNumber()))

                .findFirst();

    }
 
    public void update(HumanResources updatedHR) {

        findById(updatedHR.getIdNumber()).ifPresent(hr -> {

            humanResources.remove(hr);

            humanResources.add(updatedHR);

        });

    }
 
    public void delete(String idNumber) {

        humanResources.removeIf(hr -> hr.getIdNumber().equals(idNumber));

    }

}

 