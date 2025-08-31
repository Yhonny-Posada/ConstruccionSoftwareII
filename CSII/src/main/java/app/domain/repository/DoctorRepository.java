package app.domain.repository;

import java.util.ArrayList;

import java.util.List;

import java.util.Optional;

import app.domain.model.Doctor;
 
public class DoctorRepository

{
 
	private List<Doctor> doctors = new ArrayList<>();

	public void add(Doctor doctor)

	{

		doctors.add(doctor);

	}

	public List<Doctor> getAll()

	{

		return new ArrayList<>(doctors);

	}

	public Optional<Doctor> findById(String idNumber)

	{

        if (idNumber == null) return Optional.empty();

        for (Doctor p : doctors)

        {

            if (idNumber.equals(p.getIdNumber()))

            {

                return Optional.of(p);

            }

        }

        return Optional.empty();

    }
 
	public void update(Doctor updatedDoctors)

	{

        findById(updatedDoctors.getIdNumber()).ifPresent(d ->

        {

            doctors.remove(d);

            doctors.add(updatedDoctors);

        });

    }

	public void delete(String idNumber)

	{

        doctors.removeIf(d -> d.getIdNumber().equals(idNumber));

    }

}

 