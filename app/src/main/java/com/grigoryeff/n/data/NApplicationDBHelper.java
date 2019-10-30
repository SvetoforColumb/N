package com.grigoryeff.n.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static com.grigoryeff.n.data.NApplicationContract.Exams;
import static com.grigoryeff.n.data.NApplicationContract.Questions;


public class NApplicationDBHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = NApplicationDBHelper.class.getSimpleName();


    private static final String DATABASE_NAME = "N.db";

    private static final int DATABASE_VERSION = 1;

    public NApplicationDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // Строка для создания таблицы
        String SQL_CREATE_EXAMS_TABLE = "CREATE TABLE " + Exams.TABLE_NAME + " ("
                + Exams._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Exams.COLUMN_NAME + " TEXT, "
                + Exams.COLUMN_CREATION_DATE + " TEXT);";

        String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " + Questions.TABLE_NAME + " ("
                + Questions._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Questions.COLUMN_NUMBER + " INTEGER, "
                + Questions.COLUMN_NAME + " TEXT, "
                + Questions.COLUMN_TEXT + " TEXT, "
                + Questions.COLUMN_EXAM_ID + "INTEGER, " +
                "FOREIGN KEY(\"exam_id\") REFERENCES \"exams\"(\"_id\") ON DELETE CASCADE);";
        // Запускаем создание таблицы
        db.execSQL(SQL_CREATE_EXAMS_TABLE);
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w("SQLite", "Обновляемся с версии " + oldVersion + " на версию " + newVersion);

        // Удаляем старую таблицу и создаём новую // todo: посмотреть как делаются обновления бд
//        db.execSQL("DROP TABLE IF IT EXISTS " + DATABASE_TABLE);
        // Создаём новую таблицу
        onCreate(db);
    }

    public void createExam(String name, String date){

    }

    public void createQuestion(int exam_id, int number, String name, String text){

    }
}
