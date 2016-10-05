package br.com.carlosmarian.mobile.mylocation.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.com.carlosmarian.mobile.mylocation.domain.LocationObject;

/**
 * Created by des on 05/10/16.
 */

public class DatabaseQuery extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "mylocations_db";

    // Contacts table name
    private static final String TABLE_COORDENADAS = "location";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_TIMESTAMP = "timestamp";
    private static final String KEY_LATITUDE = "latitude";
    private static final String KEY_LONGITUDE = "longitude";

    public DatabaseQuery(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_COORDENADAS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_LATITUDE + " NUMERIC(15,10), "
                + KEY_LONGITUDE + " NUMERIC(15,10), "
                + KEY_TIMESTAMP + " BIGINT"   +")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COORDENADAS);

        // Create tables again
        onCreate(db);
    }

    public long addNewLocationObject(long timestamp, double latitude, double longitude) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_LATITUDE, latitude);
        values.put(KEY_LONGITUDE, longitude);
        values.put(KEY_TIMESTAMP, timestamp);

        // Inserting Row
        long ret = db.insert(TABLE_COORDENADAS, null, values);
        db.close(); // Closing database connection
        return ret;
    }

    public List<LocationObject> getAllLocationObjects() {
        List<LocationObject> locationList = new ArrayList<LocationObject>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_COORDENADAS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                LocationObject location = new LocationObject();
                location.setId(cursor.getLong(cursor.getColumnIndex(KEY_ID)));
                location.setLatitude(cursor.getDouble(cursor.getColumnIndex(KEY_LATITUDE)));
                location.setLongitude(cursor.getDouble(cursor.getColumnIndex(KEY_LONGITUDE)));
                location.setTimeStamp(cursor.getLong(cursor.getColumnIndex(KEY_TIMESTAMP)));
                // Adding contact to list
                locationList.add(location);
            } while (cursor.moveToNext());
        }

        // return contact list
        return locationList;
    }
}
