package database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by SHANU on 02-10-2016.
 */
public class RegDbHelper  extends SQLiteOpenHelper {
    public static final String LOG_TAG = RegDbHelper.class.getSimpleName();

    /** Name of the database file */
    private static final String DATABASE_NAME = "mydata.db";

    private static final int DATABASE_VERSION = 2;


    public RegDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * This is called when the database ishe first time. created for t
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_TABLE =  "CREATE TABLE " + RegistrationContact.Schema.TABLE_NAME + " ("
                + RegistrationContact.Schema.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + RegistrationContact.Schema.COLUMN_ST_NAME + " TEXT NOT NULL, "
                +  RegistrationContact.Schema.COLUMN_ST_ROLLNO  + " TEXT  ) ";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String SQL_DELETE_TABLE;
        SQL_DELETE_TABLE = "DROP TABLE IF EXISTS " + RegistrationContact.Schema.TABLE_NAME;
        db.execSQL(SQL_DELETE_TABLE);
        onCreate(db);


    }


}
