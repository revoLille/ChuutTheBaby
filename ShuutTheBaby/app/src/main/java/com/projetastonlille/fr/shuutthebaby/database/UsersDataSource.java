package com.projetastonlille.fr.shuutthebaby.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

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

    public User createUser (User user){

        ContentValues values = new ContentValues();
        values.put (Database.COLUMN_LOGIN, user.getLogin());
        values.put (Database.COLUMN_PASSWORD, user.getPassword());
        values.put (Database.COLUMN_EMAIL, user.getEmail());
        values.put (Database.COLUMN_FIRSTNAME, user.getFirst_name());
        values.put (Database.COLUMN_LASTNAME, user.getLast_name());


        int insertId = (int) database.insert(Database.TABLE_COMMENTS_USER, null, values);
        Cursor cursor = database.query(Database.TABLE_COMMENTS_USER, allColumns,
                Database.COLUMN_ID + " = " + insertId, null, null, null, null);
        cursor.moveToFirst();
        User newUser = cursorToUser (cursor);
        cursor.close();
        return newUser;
    }

    public void deleteUser (User user) {
        int id = user.getId();
        System.out.println("User deleted with id: " + id);
        database.delete(Database.TABLE_COMMENTS_USER, Database.COLUMN_ID
                + " = " + id, null);
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        Cursor cursor = database.query(Database.TABLE_COMMENTS_USER, allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            User user = cursorToUser(cursor);
            users.add(user);
            cursor.moveToNext();
        }
        cursor.close();
        return users;
    }
}
