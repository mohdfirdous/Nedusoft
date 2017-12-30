package com.nexusinfo.nedusoft;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.nexusinfo.nedusoft.models.UserModel;

/**
 * Created by firdous on 11/28/2017.
 */

public class LocalDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "LocalDB";

    private static final String TABLE_NAME = "LocalTB";

    private static final String COLUMN_USER_ID = "UserID";
    private static final String COLUMN_FATHER_MOBILE = "FatherMobile";
    private static final String COLUMN_SCHOOL_CODE = "SchoolCode";
    private static final String COLUMN_SCHOOL_DATABASE = "SchoolDatabaseName";
    private static final String COLUMN_SCHOOL_EMAIL = "SchoolEmail";

    private static LocalDatabaseHelper mInstance;

    public static LocalDatabaseHelper getInstance(Context context) {

        if(mInstance == null){
            mInstance = new LocalDatabaseHelper(context);
        }
        return mInstance;
    }


    public LocalDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " ( " + COLUMN_USER_ID + " TEXT PRIMARY KEY, " + COLUMN_SCHOOL_CODE + " TEXT, " + COLUMN_SCHOOL_DATABASE + " TEXT, " + COLUMN_SCHOOL_EMAIL + " TEXT, " + COLUMN_FATHER_MOBILE + " TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(UserModel user){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(COLUMN_USER_ID, user.getUserID());
        cv.put(COLUMN_SCHOOL_CODE, user.getSchoolCode());
        cv.put(COLUMN_SCHOOL_DATABASE, user.getSchoolDBName());
        cv.put(COLUMN_SCHOOL_EMAIL, user.getSchoolEmail());
        cv.put(COLUMN_FATHER_MOBILE, user.getFatherMobile());

        return (db.insert(TABLE_NAME, null, cv) != -1);
    }

    public boolean isDataExist(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        return (cursor.getCount() > 0);
    }

    public UserModel getUser(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        cursor.moveToFirst();

        UserModel user = new UserModel();
        user.setUserID(cursor.getString(0));
        user.setSchoolCode(cursor.getString(1));
        user.setSchoolDBName(cursor.getString(2));
        user.setSchoolEmail(cursor.getString(3));
        user.setFatherMobile(cursor.getString(4));

        return user;
    }

    public boolean deleteData(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME);
        return true;
    }
}
