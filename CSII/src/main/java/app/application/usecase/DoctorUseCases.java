package app.application.usecase;

import java.util.HashMap;
import java.util.Map;

import app.domain.model.Patients;
import app.domain.repository.PatientRepository;

public class DoctorUseCases
{

    private final PatientRepository patientRepo;
    private final Map<String, Map<String, String>> clinicalHistory = new HashMap<>();

    public DoctorUseCases(PatientRepository patientRepo)
    {
        this.patientRepo = patientRepo;
    }

    public void registerClinicalHistory(String patientId, String date, String doctorId,
                                        String motivo, String sintomas, String diagnostico)
    {

        Patients patient = patientRepo.findById(patientId)
                .orElseThrow(() -> new IllegalArgumentException("Paciente no encontrado"));

        clinicalHistory
            .computeIfAbsent(patientId, k -> new HashMap<>())
            .put(date, "Doctor: " + doctorId +
                    " | Motivo: " + motivo +
                    " | Síntomas: " + sintomas +
                    " | Diagnóstico: " + diagnostico);

        System.out.println("Historia clínica actualizada para " + patient.getName());
        
    }
    
}
