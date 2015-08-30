package ru.guar7387.retrofitloaders.content;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * @author Artur Vasilov
 */
public class Airport extends RealmObject {

    @SerializedName("iata")
    private String iata;

    @SerializedName("name")
    private String name;

    @SerializedName("airport_name")
    private String airportName;

    public Airport() {
    }

    public Airport(String iata, String name, String airportName) {
        this.iata = iata;
        this.name = name;
        this.airportName = airportName;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }
}
