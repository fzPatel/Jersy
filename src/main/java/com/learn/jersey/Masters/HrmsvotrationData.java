package com.learn.jersey.Masters;
public class HrmsvotrationData
{
    private String mccode;

    private String voter_card;

    private String ration_card;

    public String getMccode ()
    {
        return mccode;
    }

    public void setMccode (String mccode)
    {
        this.mccode = mccode;
    }

    public String getVoter_card ()
    {
        return voter_card;
    }

    public void setVoter_card (String voter_card)
    {
        this.voter_card = voter_card;
    }

    public String getRation_card ()
    {
        return ration_card;
    }

    public void setRation_card (String ration_card)
    {
        this.ration_card = ration_card;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [mccode = "+mccode+", voter_card = "+voter_card+", ration_card = "+ration_card+"]";
    }
}