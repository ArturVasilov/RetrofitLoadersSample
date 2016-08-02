package ru.guar7387.retrofitloaders.api.response;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.List;

import io.realm.Realm;
import ru.guar7387.retrofitloaders.content.Airport;
import ru.guar7387.retrofitloaders.database.realm.AirportsHelper;

/**
 * @author Artur Vasilov
 */
public class AirportsResponse extends Response {

    @Override
    public void save(@NonNull Context context) {
        List<Airport> airports = getTypedAnswer();
        if (airports != null) {
            AirportsHelper.save(Realm.getDefaultInstance(), airports);
        }
    }

    /*
    @Override
    public void save(Context context) {
        List<Airport> airports = getTypedAnswer();
        if (airports != null) {
            AirportsTable.save(context, airports);
        }
    }*/
}
