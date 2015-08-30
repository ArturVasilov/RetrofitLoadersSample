package ru.guar7387.retrofitloaders.database.realm;

import android.support.annotation.NonNull;

import java.util.List;

import io.realm.Realm;
import ru.guar7387.retrofitloaders.content.Airport;

/**
 * @author Artur Vasilov
 */
public class AirportsHelper {

    public static void save(@NonNull Realm realm, List<Airport> airports) {
        realm.beginTransaction();
        realm.clear(Airport.class);
        realm.copyToRealm(airports);
        realm.commitTransaction();
    }

    @NonNull
    public static List<Airport> getAirports(@NonNull Realm realm) {
        return realm.allObjects(Airport.class);
    }
}
