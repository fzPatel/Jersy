package com.learn.jersey.Masters;
public class ReligionData
{
    private String description;

    private String id;

    private String displayorder;

    private String subcodeid;

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getDisplayorder ()
    {
        return displayorder;
    }

    public void setDisplayorder (String displayorder)
    {
        this.displayorder = displayorder;
    }

    public String getSubcodeid ()
    {
        return subcodeid;
    }

    public void setSubcodeid (String subcodeid)
    {
        this.subcodeid = subcodeid;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [description = "+description+", id = "+id+", displayorder = "+displayorder+", subcodeid = "+subcodeid+"]";
    }
}
			