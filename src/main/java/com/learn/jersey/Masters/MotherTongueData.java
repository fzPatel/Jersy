package com.learn.jersey.Masters;
public class MotherTongueData
{
    private String subCodeId;

    private String description;

    private String id;

    private String displayorder;

    public String getSubCodeId ()
    {
        return subCodeId;
    }

    public void setSubCodeId (String subCodeId)
    {
        this.subCodeId = subCodeId;
    }

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

    @Override
    public String toString()
    {
        return "ClassPojo [subCodeId = "+subCodeId+", description = "+description+", id = "+id+", displayorder = "+displayorder+"]";
    }
}