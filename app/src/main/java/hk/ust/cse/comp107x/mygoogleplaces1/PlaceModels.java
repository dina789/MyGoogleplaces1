package hk.ust.cse.comp107x.mygoogleplaces1;

import java.io.Serializable;

public class PlaceModels implements Serializable {

    String name="";
    private String number="";
    private String address="";
    private String format;


    public void setName(String name)
    {
        this.name = name;
    }

    public void setNumber(String number)

    {
        this.number = number;
    }

    public void setAddress(String address)

    {
        this.address = address;
    }

    public String getName()

    {
        return name;
    }

    public String getNumber()
    {
        return number;
    }

    public String getAddress()

    {
        return address;
    }


}

