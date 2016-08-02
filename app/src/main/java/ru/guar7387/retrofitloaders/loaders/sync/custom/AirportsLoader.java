package ru.guar7387.retrofitloaders.loaders.sync.custom;

import android.content.Context;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import ru.guar7387.retrofitloaders.api.AirportsService;
import ru.guar7387.retrofitloaders.api.ApiFactory;
import ru.guar7387.retrofitloaders.api.response.AirportsResponse;
import ru.guar7387.retrofitloaders.api.response.RequestResult;
import ru.guar7387.retrofitloaders.api.response.Response;
import ru.guar7387.retrofitloaders.content.Airport;

/**
 * @author Artur Vasilov
 */
public class AirportsLoader extends BaseLoader {

    private final String mGps;

    public AirportsLoader(Context context, String gps) {
        super(context);
        mGps = gps;
    }

    @Override
    protected Response apiCall() throws IOException {
        AirportsService service = ApiFactory.getAirportsService();
        Call<List<Airport>> call = service.airports(mGps);
        List<Airport> airports = call.execute().body();
        return new AirportsResponse()
                .setRequestResult(RequestResult.SUCCESS)
                .setAnswer(airports);
    }
}

