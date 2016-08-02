package ru.guar7387.retrofitloaders.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.guar7387.retrofitloaders.content.Airport;

/**
 * @author Artur Vasilov
 */
public interface AirportsService {

    @GET("/places/coords_to_places_ru.json")
    Call<List<Airport>> airports(@Query("coords") String gps);

}
