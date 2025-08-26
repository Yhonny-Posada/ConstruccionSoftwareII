package app.domain.model;

public class Insurance
{

	private String companyName;
    private String policyNumber;
    private boolean active;
    private String endDate;
    
    public Insurance(String companyName, String policyNumber, boolean active, String endDate)
    {
    	
        this.companyName = companyName;
        this.policyNumber = policyNumber;
        this.active = active;
        this.endDate = endDate;
        
    }

    public void setCompanyName(String companyName)
    {
    	this.companyName = companyName;
    }
    
    public void setPolicyNumber(String policyNumber)
    {
    	this.policyNumber = policyNumber;
    }
    
    public void setActive(boolean active)
    {
    	this.active = active;
    }
    
    public void setEndDate(String endDate)
    {
    	this.endDate = endDate;
    }
    
    public String getCompanyName()
    {
    	return companyName;
    }
    
    public String getPolicyNumber()
    {
    	return policyNumber;
    }
    
    public boolean isActive()
    {
    	return active;
    }
    
    public String getEndDate()
    {
    	return endDate;
    }
	
}
