package com.learn.jersey.Masters;

public class LdGrid
{
    private String emi;

    private String cli;

    private String loan_amt;

    private String proc_fee;

    private String disb_amt;

    public String getEmi ()
    {
        return emi;
    }

    public void setEmi (String emi)
    {
        this.emi = emi;
    }

    public String getCli ()
    {
        return cli;
    }

    public void setCli (String cli)
    {
        this.cli = cli;
    }

    public String getLoan_amt ()
    {
        return loan_amt;
    }

    public void setLoan_amt (String loan_amt)
    {
        this.loan_amt = loan_amt;
    }

    public String getProc_fee ()
    {
        return proc_fee;
    }

    public void setProc_fee (String proc_fee)
    {
        this.proc_fee = proc_fee;
    }

    public String getDisb_amt ()
    {
        return disb_amt;
    }

    public void setDisb_amt (String disb_amt)
    {
        this.disb_amt = disb_amt;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [emi = "+emi+", cli = "+cli+", loan_amt = "+loan_amt+", proc_fee = "+proc_fee+", disb_amt = "+disb_amt+"]";
    }
}
			
		