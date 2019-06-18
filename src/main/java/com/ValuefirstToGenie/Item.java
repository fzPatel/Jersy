package com.ValuefirstToGenie;
     
public class Item
{
    private Request request;

    private String[] response;

    private String name;

    public Request getRequest ()
    {
        return request;
    }

    public void setRequest (Request request)
    {
        this.request = request;
    }

    public String[] getResponse ()
    {
        return response;
    }

    public void setResponse (String[] response)
    {
        this.response = response;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [request = "+request+", response = "+response+", name = "+name+"]";
    }
}
			