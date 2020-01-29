package helloworld.assignment.assignment5and6;


import android.content.ContentValues;
import android.content.Context;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import androidx.annotation.Nullable;


public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME= "Login.db";
    private static final String TABLE_NAME= "contact.db";
    private static final String ID = "id";
    private static final String DATABASE_FNAME= "Fname.db";
    private static final String DATABASE_LNAME= "Lname.db";
    private static final String DATABASE_FMAIL= "Email.db";
    private static final String DATABASE_PASSWORD= "Password.db";
    SQLiteDatabase db;
//    private static final String TABLE_CREATE = "Create table contact (id integer primary key not null, Fname text not null," +
//            "Lname text not null,Email text not null,Password not null );";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
//        db.execSQL("Create table user(email text primary key,password text)");
//        db.execSQL(TABLE_CREATE);
        db.execSQL("CREATE TABLE"+TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT, Fname text,Lname text, Email text, Password text)");
        this.db=db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists"+ TABLE_NAME);
        this.onCreate(db);

//        String query = "DROP TABLE IF EXISTS"+TABLE_NAME;
//        db.execSQL(query);
//        this.onCreate(db);
    }

    public boolean insertion(String FIRSTNAME, String LASTNAME, String EMAIL, String PASSWORD)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DATABASE_FNAME,FIRSTNAME);
        contentValues.put(DATABASE_LNAME,LASTNAME);
        contentValues.put(DATABASE_FMAIL,EMAIL);
        contentValues.put(DATABASE_PASSWORD,PASSWORD);
        long result =db.insert(TABLE_NAME,null,contentValues);
        if(result==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

}
