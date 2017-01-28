package ayoub;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by ayoub on 25/01/2017.
 */

public class MyDBHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "student6.db";
    public static final String TABLE_STUDENT = "studenttt";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASSWORD = "password";

    public static final String TABLE_POST = "posttt";
    public static final String COLUMN_POST_ID = "id";
    public static final String COLUMN_POST_FK = "fk";
    public static final String COLUMN_POST_LIKES = "likes";
    public static final String COLUMN_POST_SUBJECT = "subject";
    public static final String COLUMN_POST_CONTENT = "content";
    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_STUDENT + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " VARCHAR(20), " +
                COLUMN_EMAIL + " VARCHAR(20), " +
                COLUMN_PASSWORD + " VARCHAR(20) " +
                ");";
        String query1 = "CREATE TABLE " + TABLE_POST + " (" +
                COLUMN_POST_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_POST_FK + " INTEGER, " +
                COLUMN_POST_LIKES + " INTEGER, " +
                COLUMN_POST_SUBJECT + " TEXT, " +
                COLUMN_POST_CONTENT + " TEXT " +
                ");";
        db.execSQL(query);
        db.execSQL(query1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_POST);
        onCreate(db);
    }

    public void addStudent(Student p) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, p.get_name());
        values.put(COLUMN_EMAIL, p.get_email());
        values.put(COLUMN_PASSWORD, p.get_password());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_STUDENT, null, values);
        db.close();
    }
    public void addPost(Post p) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_POST_FK, p.get_fk());
        values.put(COLUMN_POST_SUBJECT, p.get_subject());
        //values.put(COLUMN_POST_LIKES, p.get_likes());
        values.put(COLUMN_POST_CONTENT, p.get_content());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_POST, null, values);
        db.close();
    }

    public String getAuthor(int fk) {
        String s = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_STUDENT + " WHERE " + COLUMN_ID + " = \"" + fk + "\";";
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        if(c.getString(c.getColumnIndex("name")) != null) {
            s += c.getString(c.getColumnIndex("name"));
        }
        return s;
    }
    public int getId(String username) {
        String s = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_STUDENT + " WHERE " + COLUMN_NAME + " = \"" + username + "\";";
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        if(c.getString(c.getColumnIndex("id")) != null) {
            s += c.getString(c.getColumnIndex("id"));
        }
        return Integer.parseInt(s);
    }
    //Deleting user not used!
    public void deleteStudent(String s) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_STUDENT + " WHERE " + COLUMN_NAME + " = \"" + s + "\";");
    }
    public ArrayList<ArrayList<String>> databaseToString() {
        ArrayList<String> dbString = new ArrayList<String>();
        ArrayList<String> dbString1 = new ArrayList<String>();
        ArrayList<String> dbString2 = new ArrayList<String>();
        ArrayList<String> dbString3 = new ArrayList<String>();
        ArrayList<ArrayList<String>> dbTotal = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_POST + " WHERE 1;";

        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        while(!c.isAfterLast()) {
            if(c.getString(c.getColumnIndex("id")) != null) {
                //dbString += c.getString(c.getColumnIndex("name"));
                //dbString += "\n";
                dbString.add(getAuthor(Integer.parseInt(c.getString(c.getColumnIndex("fk")))));
                dbString1.add(c.getString(c.getColumnIndex("subject")));
                dbString2.add(c.getString(c.getColumnIndex("content")));
                dbString3.add(c.getString(c.getColumnIndex("likes")));
            }
            c.moveToNext();
        }
        dbTotal.add(dbString); dbTotal.add(dbString1); dbTotal.add(dbString2); dbTotal.add(dbString3);
        db.close();
        return  dbTotal;
    }
    public boolean CheckIfExists(String username, String password) {
        SQLiteDatabase sqldb = getWritableDatabase();
        String query = "Select * from " + TABLE_STUDENT + " WHERE " + COLUMN_NAME + " = \"" + username + "\"" +
                " AND " + COLUMN_PASSWORD + " = \"" + password + "\";";
        Cursor cursor = sqldb.rawQuery(query, null);
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }
}
