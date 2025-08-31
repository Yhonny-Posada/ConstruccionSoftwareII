package app.application.usecase;

import app.domain.model.Patients;
import app.domain.model.Insurance;
import app.domain.repository.PatientRepository;
import app.domain.repository.InsuranceRepository;

public class PersonalAdministrationUseCases
{

    private final PatientRepository patientRepo;
    private final InsuranceRepository insuranceRepo;

    public PersonalAdministrationUseCases(PatientRepository patientRepo, InsuranceRepository insuranceRepo)
    {
        this.patientRepo = patientRepo;
        this.insuranceRepo = insuranceRepo;
    }

    public void registerPatient(Patients patient)
    {
        
    	if (patientRepo.findById(patient.getIdNumber()).isPresent())
        {
            throw new IllegalArgumentException("Ya existe un paciente con esta cédula.");
        }
    	
        patientRepo.add(patient);
        
    }

    public void scheduleAppointment(String patientId, String date)
    {
    
    	Patients patient = patientRepo.findById(patientId)
                .orElseThrow(() -> new IllegalArgumentException("Paciente no encontrado"));
    	
        System.out.println("Cita programada para " + patient.getName() + " el día " + date);
        
    }

    public void registerInsurance(Insurance insurance)
    {
        insuranceRepo.add(insurance);
    }

    public void generateInvoice(String patientId)
    {
    	
        Patients patient = patientRepo.findById(patientId)
                .orElseThrow(() -> new IllegalArgumentException("Paciente no encontrado"));

        System.out.println("Factura generada para el paciente: " + patient.getName());
        
    }
    
}
