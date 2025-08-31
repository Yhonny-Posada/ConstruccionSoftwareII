package app.application.usecase;

import app.domain.model.Patients;
import app.domain.repository.PatientRepository;

public class NurseUseCases
{

    private final PatientRepository patientRepo;

    public NurseUseCases(PatientRepository patientRepo)
    {
        this.patientRepo = patientRepo;
    }

    public void registerVitals(String patientId, double temp, double bloodPressure, int pulse, int oxygen)
    {
    	
        Patients patient = patientRepo.findById(patientId)
                .orElseThrow(() -> new IllegalArgumentException("Paciente no encontrado"));

        System.out.println("Signos vitales registrados para " + patient.getName());
        
        System.out.println("Temp: " + temp + " | Presión: " + bloodPressure +
        				   " | Pulso: " + pulse + " | Oxígeno: " + oxygen);
        
    }

    public void registerMedication(String patientId, String medication, String dose)
    {
    	
        Patients patient = patientRepo.findById(patientId)
                .orElseThrow(() -> new IllegalArgumentException("Paciente no encontrado"));

        System.out.println("Medicamento " + medication + " administrado a " +
                patient.getName() + " con dosis " + dose);
        
    }
    
}
