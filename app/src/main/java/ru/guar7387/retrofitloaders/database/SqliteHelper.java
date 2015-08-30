package ru.guar7387.retrofitloaders.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

import ru.guar7387.retrofitloaders.database.tables.AirportsTable;

/**
 * @author Artur Vasilov
 */
public class SqliteHelper extends SQLiteOpenHelper {

    public static final String CONTENT_AUTHORITY = "ru.sample.retrofit.loaders";

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    private static final String DATABASE_NAME = "ru.sample.database.db";

    private static final int DATABASE_VERSION = 1;

    public SqliteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(AirportsTable.Requests.CREATION_REQUEST);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(AirportsTable.Requests.DROP_REQUEST);
        onCreate(db);
    }
}
