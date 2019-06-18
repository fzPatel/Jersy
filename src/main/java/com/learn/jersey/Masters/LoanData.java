package com.learn.jersey.Masters;
public class LoanData
{
    private String interestrate;

    private String tenuremonths;

    private String loantype;

    private String id;

    public String getInterestrate ()
    {
        return interestrate;
    }

    public void setInterestrate (String interestrate)
    {
        this.interestrate = interestrate;
    }

    public String getTenuremonths ()
    {
        return tenuremonths;
    }

    public void setTenuremonths (String tenuremonths)
    {
        this.tenuremonths = tenuremonths;
    }

    public String getLoantype ()
    {
        return loantype;
    }

    public void setLoantype (String loantype)
    {
        this.loantype = loantype;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [interestrate = "+interestrate+", tenuremonths = "+tenuremonths+", loantype = "+loantype+", id = "+id+"]";
    }
}
			
		