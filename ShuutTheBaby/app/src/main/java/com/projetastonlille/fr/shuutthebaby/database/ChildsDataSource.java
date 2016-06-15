package com.projetastonlille.fr.shuutthebaby.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pierre on 15/06/2016.
 */
public class ChildsDataSource {

    // Champs de la base de données
    private SQLiteDatabase database;
    private Database dbHelper;
    private String[] allColumns = { Database.COLUMN_ID,
            Database.COLUMN_FIRSTNAME_CHILD,
            Database.COLUMN_BIRTHDAY,
            Database.COLUMN_SEX,
            Database.COLUMN_USER_ID,};

    Date c = new Date(System.currentTimeMillis());
    long milliseconds = c.getTime();
    // TODO convert with SimpleDateFormat

    public ChildsDataSource(Context context) {
        dbHelper = new Database(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    private Child cursorToChild(Cursor cursor) {
        Child child = new Child();
        Date c = new Date(cursor.getLong(2));

        child.setId(cursor.getInt(0));
        child.setFirst_name_child(cursor.getString(1));
        child.setBirthday(c);
        child.setSex(cursor.getInt(3));
        child.setUser_id(cursor.getInt(4));
        return child;
    }

    public Child createChild (String child){

        ContentValues values = new ContentValues();
        values.put (Database.COLUMN_FIRSTNAME_CHILD, child);
        values.put (Database.COLUMN_BIRTHDAY, child);
        values.put (Database.COLUMN_SEX, child);
        values.put (Database.COLUMN_USER_ID, child);



        int insertId = (int) database.insert(Database.TABLE_COMMENTS_CHILD, null, values);
        Cursor cursor = database.query(Database.TABLE_COMMENTS_CHILD, allColumns,
                Database.COLUMN_ID + " = " + insertId, null, null, null, null);
        cursor.moveToFirst();
        Child newChild = cursorToChild (cursor);
        cursor.close();
        return newChild;
    }

    public void deleteChild (Child child) {
        int id = child.getId();
        System.out.println("Child deleted with id: " + id);
        database.delete(Database.TABLE_COMMENTS_CHILD, Database.COLUMN_ID
                + " = " + id, null);
    }

    public List<Child> getAllChilds() {
        List<Child> childs = new ArrayList<Child>();
        Cursor cursor = database.query(Database.TABLE_COMMENTS_CHILD, allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Child child = cursorToChild(cursor);
            childs.add(child);
            cursor.moveToNext();
        }
        cursor.close();
        return childs;
    }
}
