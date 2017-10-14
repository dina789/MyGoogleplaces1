package hk.ust.cse.comp107x.mygoogleplaces1.models;

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
    http://www.jsonschema2pojo.org/
    public Boolean getOpenNow() {

        return openNow;
    }

    public void setOpenNow(Boolean openNow) {
        this.openNow = openNow;
    }

    public String getFormat() {
        return format;
    }public String getPhotoReference() {
        return photoReference;
    }

    public void setPhotoReference(String photoReference) {
        this.photoReference = photoReference;
    }


}

