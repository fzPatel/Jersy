package com.ValuefirstToGenie;
           
public class Info
{
    private String schema;

    private String name;

    private String _postman_id;

    public String getSchema ()
    {
        return schema;
    }

    public void setSchema (String schema)
    {
        this.schema = schema;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String get_postman_id ()
    {
        return _postman_id;
    }

    public void set_postman_id (String _postman_id)
    {
        this._postman_id = _postman_id;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [schema = "+schema+", name = "+name+", _postman_id = "+_postman_id+"]";
    }
}