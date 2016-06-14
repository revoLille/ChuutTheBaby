package com.projetastonlille.fr.shuutthebaby.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by pierre on 14/06/2016.
 */
public class UsersDataSource {

    // Champs de la base de données
    private SQLiteDatabase database;
    private Database dbHelper;
    private String[] allColumns = { Database.COLUMN_ID,
            Database.COLUMN_LOGIN,
            Database.COLUMN_PASSWORD,
            Database.COLUMN_EMAIL,
            Database.COLUMN_FIRSTNAME,
            Database.COLUMN_LASTNAME};

    public UsersDataSource(Context context) {
        dbHelper = new Database(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    private User cursorToUser(Cursor cursor) {
        User user = new User();
        user.setId(cursor.getInt(0));
        user.setLogin(cursor.getString(1));
        user.setPassword(cursor.getString(2));
        user.setEmail(cursor.getString(3));
        user.setFirst_name(cursor.getString(4));
        user.setLast_name(cursor.getString(5));
        return user;
    }

    public User createUser (String user){

        ContentValues values = new ContentValues();
        values.put (Database.COLUMN_LOGIN, user);
        values.put (Database.COLUMN_PASSWORD, user);
        values.put (Database.COLUMN_EMAIL, user);
        values.put (Database.COLUMN_FIRSTNAME, user);
        values.put (Database.COLUMN_LASTNAME, user);


        int insertId = (int) database.insert(Database.TABLE_COMMENTS_USER, null, values);
        Cursor cursor = database.query(Database.TABLE_COMMENTS_USER, allColumns,
                Database.COLUMN_ID + " = " + insertId, null, null, null, null);
        cursor.moveToFirst();
        User newUser = cursorToUser (cursor);
        cursor.close();
        return newUser;
    }



}
