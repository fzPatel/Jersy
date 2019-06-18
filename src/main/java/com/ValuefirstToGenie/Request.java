package com.ValuefirstToGenie;
               
public class Request
{
    private String method;

    private String[] header;

    private Body body;

    private Url url;

    public String getMethod ()
    {
        return method;
    }

    public void setMethod (String method)
    {
        this.method = method;
    }

    public String[] getHeader ()
    {
        return header;
    }

    public void setHeader (String[] header)
    {
        this.header = header;
    }

    public Body getBody ()
    {
        return body;
    }

    public void setBody (Body body)
    {
        this.body = body;
    }

    public Url getUrl ()
    {
        return url;
    }

    public void setUrl (Url url)
    {
        this.url = url;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [method = "+method+", header = "+header+", body = "+body+", url = "+url+"]";
    }
}