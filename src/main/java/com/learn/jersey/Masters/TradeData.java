package com.learn.jersey.Masters;
public class TradeData
{
    private String tradename;

    private String id;

    public String getTradename ()
    {
        return tradename;
    }

    public void setTradename (String tradename)
    {
        this.tradename = tradename;
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
        return "ClassPojo [tradename = "+tradename+", id = "+id+"]";
    }
}