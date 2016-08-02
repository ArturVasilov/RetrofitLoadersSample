package ru.guar7387.retrofitloaders.loaders;

import android.content.Context;
import android.content.CursorLoader;
import android.net.Uri;

/**
 * @author Artur Vasilov
 */
public class LocalAirportsLoader extends CursorLoader {

    public LocalAirportsLoader(Context context, Uri uri,
                               String[] projection, String selection,
                               String[] selectionArgs, String sortOrder) {
        super(context, uri, projection, selection, selectionArgs, sortOrder);
    }
}


