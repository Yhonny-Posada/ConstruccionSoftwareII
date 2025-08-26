package app.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Order
{
	
    private String orderId;
    private String patientId;
    private String doctorId;
    private String date;
    private List<OrderItem> items;
    
    public Order(String orderId, String patientId, String doctorId, String date)
    {
    	
        this.orderId = orderId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
        this.items = new ArrayList<>();
        
    }
    
    public void addItem(OrderItem item)
    {
    	items.add(item);
    }
    
    public List<OrderItem> getItems()
    {
    	return items;
    }

    public String getOrderId()
    {
    	return orderId;
    }
    
    public String getPatientId()
    {
    	return patientId;
    }
    
    public String getDoctorId()
    {
    	return doctorId;
    }
    
    public String getDate()
    {
    	return date;
    }

}

abstract class OrderItem
{

	private int itemNumber;
    private double cost;

    public OrderItem(int itemNumber, double cost)
    {
    	
        this.itemNumber = itemNumber;
        this.cost = cost;
        
    }

    public int getItemNumber()
    {
    	return itemNumber;
    }
    
    public double getCost()
    {
    	return cost;
    }
    
}

class MedicationItem extends OrderItem
{
	
    private String medicationId;
    private String dosage;
    private int duration;

    public MedicationItem(int itemNumber, double cost, String medicationId, String dosage, int duration)
    {
    	
        super(itemNumber, cost);
        this.medicationId = medicationId;
        this.dosage = dosage;
        this.duration = duration;
        
    }
    
}

class ProcedureItem extends OrderItem
{
	
    private String procedureId;
    private int frequency;
    private boolean requiresSpecialist;
    private String specialistId;

    public ProcedureItem(int itemNumber, double cost, String procedureId, int frequency, boolean requiresSpecialist, String specialistId)
    {
    	
        super(itemNumber, cost);
        this.procedureId = procedureId;
        this.frequency = frequency;
        this.requiresSpecialist = requiresSpecialist;
        this.specialistId = specialistId;
        
    }
    
}

class DiagnosticTestItem extends OrderItem
{
	
    private String testId;
    private int quantity;
    private boolean requiresSpecialist;
    private String specialistId;

    public DiagnosticTestItem(int itemNumber, double cost, String testId, int quantity, boolean requiresSpecialist, String specialistId)
    {
    	
        super(itemNumber, cost);
        this.testId = testId;
        this.quantity = quantity;
        this.requiresSpecialist = requiresSpecialist;
        this.specialistId = specialistId;
        
    }
    
}