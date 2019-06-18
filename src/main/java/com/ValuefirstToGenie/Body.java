package com.ValuefirstToGenie;
      
public class Body
{
    private String mode;

    private String raw;

    public String getMode ()
    {
        return mode;
    }

    public void setMode (String mode)
    {
        this.mode = mode;
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
        return "ClassPojo [mode = "+mode+", raw = "+raw+"]";
    }
}