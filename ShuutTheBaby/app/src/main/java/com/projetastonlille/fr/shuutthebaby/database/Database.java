package com.projetastonlille.fr.shuutthebaby.database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Pierre on 09/06/2016.
 */
public class Database extends SQLiteOpenHelper{

    public static final String TABLE_COMMENTS_USER = "user";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_LOGIN = "login";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_FIRSTNAME = "first_name";
    public static final String COLUMN_LASTNAME = "last_name";

    public static final String TABLE_COMMENTS_CHILD = "child";
    public static final String COLUMN_FIRSTNAME_CHILD = "first_name";
    public static final String COLUMN_BIRTHDAY = "birthday";
    public static final String COLUMN_SEX = "sexe";
    public static final String COLUMN_USER_ID = "user_id";

    public static final String TABLE_COMMENTS_MUSIC = "music";
    public static final String COLUMN_TITLE_MUSIC = "title";
    public static final String COLUMN_CATEGORY_MUSIC = "category";

    public static final String TABLE_COMMENTS_USER_HAS_MUSIC = "user_has_music";
    public static final String COLUMN_MUSIC_ID = "user_id";
    public static final String COLUMN_CREATOR = "creator";



    private static final String DATABASE_NAME = "user.chutTheBabyDbLite";
    private static final int DATABASE_VERSION = 1;


    // Commande sql pour la création de la base de données
    private static final String DATABASE_CREATE = "create table "
            + TABLE_COMMENTS_USER
            + "(" + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_LOGIN + " TEXT not null, "
            + COLUMN_PASSWORD + " TEXT not null, "
            + COLUMN_EMAIL + " TEXT not null, "
            + COLUMN_FIRSTNAME + " TEXT, "
            + COLUMN_LASTNAME + " TEXT "
            + "); "
            + "create table "
            + TABLE_COMMENTS_CHILD
            + "(" + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_FIRSTNAME_CHILD + " TEXT not null, "
            + COLUMN_BIRTHDAY + " DATE, "
            + COLUMN_SEX + " integer, "//TODO verify the enum type :  there is no enum in sqlite only null, integer, real, text, blob http://www.sqlite.org/datatype3.html
            + COLUMN_USER_ID + " integer NOT NULL, "
            + " FOREIGN KEY ("+ COLUMN_USER_ID +") REFERENCES "+TABLE_COMMENTS_USER+" ("+COLUMN_ID+") "
            + "); "
            + "create table "
            + TABLE_COMMENTS_MUSIC
            + "(" + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_TITLE_MUSIC + " TEXT not null, "
            + COLUMN_CATEGORY_MUSIC + " ENUM('song','nursery rhyme', 'lullaby', 'story') " //TODO verify the enum type :  there is no enum in sqlite only null, integer, real, text, blob http://www.sqlite.org/datatype3.html
            + "); "
            + "create table "
            + TABLE_COMMENTS_USER_HAS_MUSIC
            + "(" + COLUMN_USER_ID + " integer not null, "
            + COLUMN_MUSIC_ID + " integer not null, "
            + COLUMN_CREATOR + " TEXT, "
            + " FOREIGN KEY ("+COLUMN_USER_ID+") REFERENCES "+TABLE_COMMENTS_USER+" ("+COLUMN_ID+"), "
            + " FOREIGN KEY ("+COLUMN_MUSIC_ID+") REFERENCES "+TABLE_COMMENTS_MUSIC+" ("+COLUMN_ID+") "
            + "); " ;



    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(Database.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMMENTS_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMMENTS_CHILD);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMMENTS_MUSIC);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMMENTS_USER_HAS_MUSIC);
        onCreate(db);
    }
}
