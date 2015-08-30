package ru.guar7387.retrofitloaders.ui;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import ru.guar7387.retrofitloaders.R;
import ru.guar7387.retrofitloaders.api.response.Response;
import ru.guar7387.retrofitloaders.content.Airport;
import ru.guar7387.retrofitloaders.loaders.sync.custom.AirportsLoader;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Response> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getLoaderManager().initLoader(R.id.airports_loader, Bundle.EMPTY, this);
    }

    @Override
    public Loader<Response> onCreateLoader(int id, Bundle args) {
        switch (id) {
            case R.id.airports_loader:
                return new AirportsLoader(this, "55.749792,37.6324949");
            default:
                return null;
        }
    }

    @Override
    public void onLoadFinished(Loader<Response> loader, Response data) {
        int id = loader.getId();
        if (id == R.id.airports_loader) {
            List<Airport> airports = data.getTypedAnswer();
            //do something here
        }
        getLoaderManager().destroyLoader(id);
    }

    @Override
    public void onLoaderReset(Loader<Response> loader) {
    }
}
