package database;

import android.provider.BaseColumns;

/**
 * Created by SHANU on 02-10-2016.
 */
public class RegistrationContact {
    public static final class Schema implements BaseColumns {

        public final static String TABLE_NAME = "student";

        public final static String ID = BaseColumns._ID;


        public final static String COLUMN_ST_NAME ="name";


        public final static String COLUMN_ST_ROLLNO ="rollno";

        public final static String COLUMN_ST_EMAIL = "email";


    }
}
