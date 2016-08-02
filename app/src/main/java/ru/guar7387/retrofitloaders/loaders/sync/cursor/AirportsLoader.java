package ru.guar7387.retrofitloaders.loaders.sync.cursor;

import android.content.Context;
import android.database.Cursor;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import ru.guar7387.retrofitloaders.api.AirportsService;
import ru.guar7387.retrofitloaders.api.ApiFactory;
import ru.guar7387.retrofitloaders.content.Airport;
import ru.guar7387.retrofitloaders.database.tables.AirportsTable;

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
    protected Cursor apiCall() throws IOException {
        AirportsService service = ApiFactory.getAirportsService();
        Call<List<Airport>> call = service.airports(mGps);
        List<Airport> airports = call.execute().body();
        AirportsTable.save(getContext(), airports);
        return getContext().getContentResolver().query(AirportsTable.URI,
                null, null, null, null);
    }
}


