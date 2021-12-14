package com.example.memorygame;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {

    public static final String SCORE_TABLE = "SCORE_TABLE";
    public static final String PLAYER_NAME = "PLAYER_NAME";
    public static final String PLAYER_SCORE = "PLAYER_SCORE";


    /**
     * Create a helper object to create, open, and/or manage a database.
     * This method always returns very quickly.  The database is not actually
     * created or opened until one of {@link #getWritableDatabase} or
     * {@link #getReadableDatabase} is called.
     *
     * @param context to use for locating paths to the the database
     * @param name    of the database file, or null for an in-memory database
     * @param factory to use for creating cursor objects, or null for the default
     * @param version number of the database (starting at 1); if the database is older,
     *                {@link #onUpgrade} will be used to upgrade the database; if the database is
     *                newer, {@link #onDowngrade} will be used to downgrade the database
     */
    public DbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * Called when the database is created for the first time. This is where the
     * creation of tables and the initial population of the tables should happen.
     *
     * @param db The database.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + SCORE_TABLE + " (" + getId() + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                EnterNameFragment.getPlayerName() + " TEXT, " + EasyGame.getPlayerScore() + " INTEGER)";
        db.execSQL(createTableStatement);
    }

    @NonNull
    private String getId() {
        return "ID";
    }

    @NonNull
    private String getScore() {
        return PLAYER_SCORE;
    }

    @NonNull
    private String getName() {
        return PLAYER_NAME;
    }

    @NonNull
    private String getScores() {
        return "SCORES";
    }

    /**
     * Called when the database needs to be upgraded. The implementation
     * should use this method to drop tables, add tables, or do anything else it
     * needs to upgrade to the new schema version.
     *
     * <p>
     * The SQLite ALTER TABLE documentation can be found
     * <a href="http://sqlite.org/lang_altertable.html">here</a>. If you add new columns
     * you can use ALTER TABLE to insert them into a live table. If you rename or remove columns
     * you can use ALTER TABLE to rename the old table, then create the new table and then
     * populate the new table with the contents of the old table.
     * </p><p>
     * This method executes within a transaction.  If an exception is thrown, all changes
     * will automatically be rolled back.
     * </p>
     *
     * @param db         The database.
     * @param oldVersion The old database version.
     * @param newVersion The new database version.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addScore(Score score) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        if (GameHomeScreen.EASY == true) {

            cv.put(EnterNameFragment.getPlayerName(), EasyGame.getPlayerScore());
            db.insert(SCORE_TABLE, null, cv);
        }
        else if (GameHomeScreen.NORMAL == true) {
            cv.put(EnterNameFragment.getPlayerName(), NormalGame.getPlayerScore());
            db.insert(SCORE_TABLE, null, cv);
        }
    }

    public List<Score> getAllScores() {
        List<Score> scoreList = new ArrayList<>();

        String queryString = "SELECT * FROM SCORES";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            do {
                int scoreId = cursor.getInt(0);
                String scorePlayerName = cursor.getString(1);
                int totalScore = cursor.getInt(2);
                Score newScore = new Score(scoreId, scorePlayerName, totalScore);
                scoreList.add(newScore);
            } while (cursor.moveToNext());
        }
        else {
            cursor.close();
            db.close();
            return scoreList;
        }
        return scoreList;
    }
}
