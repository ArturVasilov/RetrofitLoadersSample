package ru.guar7387.retrofitloaders.loaders.async.cursor;

import android.content.Context;
import android.database.Cursor;

import java.util.List;

import retrofit.Call;
import retrofit.Response;
import ru.guar7387.retrofitloaders.api.AirportsService;
import ru.guar7387.retrofitloaders.api.ApiFactory;
import ru.guar7387.retrofitloaders.api.RetrofitCallback;
import ru.guar7387.retrofitloaders.content.Airport;
import ru.guar7387.retrofitloaders.database.tables.AirportsTable;

/**
 * @author Artur Vasilov
 */
public class AirportsLoader extends BaseLoader {

    private final String mGps;

    private final AirportsService mAirportsService;

    public AirportsLoader(Context context, String gps) {
        super(context);
        mGps = gps;
        mAirportsService = ApiFactory.getAirportsService();
    }

    @Override
    protected void onForceLoad() {
        Call<List<Airport>> call = mAirportsService.airports(mGps);
        call.enqueue(new RetrofitCallback<List<Airport>>() {
            @Override
            public void onResponse(Response<List<Airport>> response) {
                if (response.isSuccess()) {
                    AirportsTable.clear(getContext());
                    AirportsTable.save(getContext(), response.body());
                    Cursor cursor = getContext().getContentResolver().query(AirportsTable.URI,
                            null, null, null, null);
                    deliverResult(cursor);
                } else {
                    deliverResult(null);
                }
            }
        });
    }
}
