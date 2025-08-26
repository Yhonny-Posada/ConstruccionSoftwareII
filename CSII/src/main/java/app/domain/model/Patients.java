package app.domain.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.criteria.Order;

public class Patients extends PersonClass
{

	    private String address;
	    private String emergencyContact;
	    private String emergencyRelationship;
	    private String emergencyPhone;
	    private Insurance insurance;
	    private List<Order> orders;

	    public Patients(String idNumber, String name, String lastName, String gender, String birthDate,
	                   String phoneNumber, String email, String address, String emergencyContact,
	                   String emergencyRelationship, String emergencyPhone, Insurance insurance)
	    {
	        super(idNumber, name, lastName, gender, birthDate, phoneNumber, email);
	        this.address = address;
	        this.emergencyContact = emergencyContact;
	        this.emergencyRelationship = emergencyRelationship;
	        this.emergencyPhone = emergencyPhone;
	        this.insurance = insurance;
	        this.orders = new ArrayList<>();
	    }

	    public String getAddress()
	    {
	    	return address;
	    }
	    
	    public void setAddress(String address)
	    {
	    	this.address = address;
	    }

	    public String getEmergencyContact()
	    {
	    	return emergencyContact;
	    }
	    
	    public void setEmergencyContact(String emergencyContact)
	    {
	    	this.emergencyContact = emergencyContact;
	    }

	    public String getEmergencyRelationship()
	    {
	    	return emergencyRelationship;
	    }
	    
	    public void setEmergencyRelationship(String emergencyRelationship)
	    {
	    	this.emergencyRelationship = emergencyRelationship;
	    }

	    public String getEmergencyPhone()
	    {
	    	return emergencyPhone;
	    }
	    
	    public void setEmergencyPhone(String emergencyPhone)
	    {
	    	this.emergencyPhone = emergencyPhone;
	    }

	    public Insurance getInsurance()
	    {
	    	return insurance;
	    }
	    
	    public void setInsurance(Insurance insurance)
	    {
	    	this.insurance = insurance;
	    }

	    public List<Order> getOrders()
	    {
	    	return orders;
	    }
	    
	    public void addOrder(Order order)
	    {
	    	orders.add(order);
	    }

	    @Override
	    public void showData()
	    {
	    	
	        System.out.println("Patient: " + getName() + " " + getLastName() + ", ID: " + getIdNumber());
	        System.out.println("Emergency Contact: " + emergencyContact + " (" + emergencyRelationship + ")");
	        System.out.println("Insurance: " + insurance.getCompanyName() + ", Policy: " + insurance.getPolicyNumber());
	        
	    }
	
}
