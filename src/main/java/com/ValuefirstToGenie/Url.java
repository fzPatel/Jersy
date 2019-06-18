package com.ValuefirstToGenie;
      
public class Url
{
    private String[] path;

    private String protocol;

    private String port;

    private Query[] query;

    private String[] host;

    private String raw;

    public String[] getPath ()
    {
        return path;
    }

    public void setPath (String[] path)
    {
        this.path = path;
    }

    public String getProtocol ()
    {
        return protocol;
    }

    public void setProtocol (String protocol)
    {
        this.protocol = protocol;
    }

    public String getPort ()
    {
        return port;
    }

    public void setPort (String port)
    {
        this.port = port;
    }

    public Query[] getQuery ()
    {
        return query;
    }

    public void setQuery (Query[] query)
    {
        this.query = query;
    }

    public String[] getHost ()
    {
        return host;
    }

    public void setHost (String[] host)
    {
        this.host = host;
    }

    public String getRaw ()
    {
        return raw;
    }

    public void setRaw (String raw)
    {
        this.raw = raw;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [path = "+path+", protocol = "+protocol+", port = "+port+", query = "+query+", host = "+host+", raw = "+raw+"]";
    }
}