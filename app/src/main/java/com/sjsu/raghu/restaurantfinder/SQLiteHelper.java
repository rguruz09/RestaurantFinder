package com.sjsu.raghu.restaurantfinder;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Raghu on 3/15/2016.
 */
public class SQLiteHelper extends SQLiteOpenHelper {

    private static String DBTAG = "Database ";
    private static final String DB_NAME = "FAV_RESTAURANT.DB";
    private static final int VERSION = 1;

    private static final String CREATE_TABLE_QUERY = "" +
            "CREATE TABLE "+FavRestaurant.TABLE_NAME+
            " ( "+FavRestaurant.REF_ID +" TEXT, " +
            FavRestaurant.NAME +" TEXT ," +
            FavRestaurant.SNIPPET_TEXT +" TEXT ," +
            FavRestaurant.DISPLAY_PHONE +" TEXT ," +
            FavRestaurant.ADDRESS +" TEXT ," +
            FavRestaurant.RATING +" REAL ," +
            FavRestaurant.LATITUDE +" INTEGER ," +
            FavRestaurant.LONGITUDE +" INTEGER ," +
            FavRestaurant.COUNT_REVIEW +" INTEGER ," +
            FavRestaurant.IMAGE_URL +" TEXT ," +
            ")";

    public SQLiteHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
        Log.d(DBTAG,"DB created/opened");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_QUERY);
        Log.d(DBTAG, "Table Created..");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addFav(String ref, String name, String snippet, String phone, String addr, String ratings, double lat, double longi, int ct, String url, SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(FavRestaurant.REF_ID, ref);
        contentValues.put(FavRestaurant.NAME, name);
        contentValues.put(FavRestaurant.SNIPPET_TEXT, snippet);
        contentValues.put(FavRestaurant.DISPLAY_PHONE, phone);
        contentValues.put(FavRestaurant.ADDRESS, addr);
        contentValues.put(FavRestaurant.RATING, ratings);
        contentValues.put(FavRestaurant.LATITUDE, lat);
        contentValues.put(FavRestaurant.LONGITUDE, longi);
        contentValues.put(FavRestaurant.COUNT_REVIEW, ct);
        contentValues.put(FavRestaurant.IMAGE_URL, url);

        db.insert(FavRestaurant.TABLE_NAME, null, contentValues);
        Log.d(DBTAG,"Row inserted");

    }

}
