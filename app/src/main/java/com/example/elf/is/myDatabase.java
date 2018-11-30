package com.example.elf.is;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.Arrays;

import static android.content.Context.*;

public class myDatabase {

    static String number1;
    static String co1;
    static String number2;
    static String co2;
    static String number3;
    static String co3;
    static String number4;
    static String co4;
    static String number[];
    static String co[];
    static  myDbHelper myhelper;

    public myDatabase(Context context) {
        myhelper = new myDbHelper(context);
    }

    public long insertData(String name, String pass){
        SQLiteDatabase database = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.NUMBER,name);
        contentValues.put(myDbHelper.COLOR,pass);
        long id = database.insert(myDbHelper.TABLE_NAME,null,contentValues);
        return id;
    }

    public static void getData(){

        number = new String[4];
        co = new String[4];
        int i=0;

        SQLiteDatabase database = myhelper.getReadableDatabase();
        String columns[] =  {myDbHelper.UID, myDbHelper.NUMBER, myDbHelper.COLOR};
        Cursor cursor = database.query(myDbHelper.TABLE_NAME,columns,null,null,null,null,null);
        StringBuffer stringBuffer = new StringBuffer();
        while (cursor.moveToNext() && i<4){
            int cid = cursor.getInt(cursor.getColumnIndex(myDbHelper.UID));
            String cname = cursor.getString(cursor.getColumnIndex(myDbHelper.NUMBER));
            String cpass = cursor.getString(cursor.getColumnIndex(myDbHelper.COLOR));
            stringBuffer.append(cid+" "+cname+" "+cpass+"\n");
            number[i] = cname;
            co[i] = cpass;
            i++;
        }
    //    return Arrays.toString(number)+ Arrays.toString(co);

    }

    public void delete(){
        SQLiteDatabase database = myhelper.getWritableDatabase();
        database.execSQL("DELETE FROM table1");

    }


    static class myDbHelper extends SQLiteOpenHelper {


        private static final String DATABASE_NAME = "mydatabase9.db";
        private static final String TABLE_NAME= "table1";
        private static final int DATABASE_VERSION = 1;
        private static final String UID = "_id";
        private static final String NUMBER = "number";
        private static final String COLOR = "color";
        private Context context;

        public myDbHelper(Context context) {
            super(context,DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context;

        }

        @Override
        public void onCreate(SQLiteDatabase db) {

        try {
                db.execSQL("CREATE TABLE " + TABLE_NAME + "(" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + NUMBER + " VARCHAR(224) ," + COLOR +" VARCHAR(224) );");


            }catch (Exception e){
                Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
            }

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }


}


