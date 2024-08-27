package biplap.com.FirstApp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME ="mycontacts";
    private static final int DATABASE_VERSION=1;


    public MyDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE ContactList (Id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL,address TEXT,phone TEXT, email TEXT)";
        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        String upGradeQuery = "DROP TABLE IF EXISTS ContactList";
        sqLiteDatabase.execSQL(upGradeQuery);

    }
    public void addContacts(String name, String email, String address, String phone){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("email",email);
        contentValues.put("phone",phone);
        contentValues.put("address",address);

        sqLiteDatabase.insert("ContactList",null,contentValues);
    }

    public Cursor selectData(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String selectQuery="SELECT * FROM ContactList";
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery,null);
        return cursor;
    }

    public void updateData(int id ,String name, String email, String address, String phone){
    SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
    ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("email",email);
        contentValues.put("phone",phone);
        contentValues.put("address",address);
        sqLiteDatabase.update("Contactlist", contentValues,"id=?",new String[]{String.valueOf(id)});
    }
    public void deleteData(int id){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        sqLiteDatabase.delete("ContactList", "id=?",new String[]{String.valueOf(id)});
}
}
