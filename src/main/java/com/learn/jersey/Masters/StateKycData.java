package com.learn.jersey.Masters;
public class StateKycData
{
    private String mc_id;

    private String id;

    private String state_id;

    public String getMc_id ()
    {
        return mc_id;
    }

    public void setMc_id (String mc_id)
    {
        this.mc_id = mc_id;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getState_id ()
    {
        return state_id;
    }

    public void setState_id (String state_id)
    {
        this.state_id = state_id;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [mc_id = "+mc_id+", id = "+id+", state_id = "+state_id+"]";
    }
}