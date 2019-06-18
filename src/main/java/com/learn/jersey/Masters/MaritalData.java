package com.learn.jersey.Masters;
public class MaritalData
{
    private String maritalstatus;

    private String id;

    public String getMaritalstatus ()
    {
        return maritalstatus;
    }

    public void setMaritalstatus (String maritalstatus)
    {
        this.maritalstatus = maritalstatus;
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
        return "ClassPojo [maritalstatus = "+maritalstatus+", id = "+id+"]";
    }
}