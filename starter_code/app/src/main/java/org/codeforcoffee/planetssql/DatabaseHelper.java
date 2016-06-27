package org.codeforcoffee.planetssql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by codeforcoffee on 6/22/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "Planets.db";

    public static final String CREATE_TABLE = "create table planets(id int primary key, name text, position int, fact text);";
    public static final String DROP_TABLE = "drop table if exists planets;";

    public DatabaseHelper(Context ctx) {
        super(ctx, DB_NAME, null, DB_VERSION);
        // new SQLiteOpenHelper(ctx, "Planets.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    public void createPlanet(int id, String name, int position, String fact) {
        SQLiteDatabase db = getReadableDatabase();
        ContentValues planet = new ContentValues();
        planet.put("id", id);
        planet.put("name", name);
        planet.put("position", position);
        planet.put("fact", fact);
        db.insert("planets", null, planet);
    }


    public Planets getPlanetById(int id) {

        SQLiteDatabase db = getReadableDatabase();
        String[] projection = new String[]{"id", "name", "position", "fact" };
        String selection = "id =?";
        String[] selectionArguments = new String[]{Integer.toString(id)};

        Cursor c = db.query("planets", projection, selection, selectionArguments, null, null, null, null);
        c.moveToFirst();


        int planetId = Integer.parseInt(c.getString(c.getColumnIndex("id")));
        String planetName = c.getString(c.getColumnIndex("name"));

        Planets planets = new Planets(planetId, planetName, 0, null);


        return planets;
    }


}








