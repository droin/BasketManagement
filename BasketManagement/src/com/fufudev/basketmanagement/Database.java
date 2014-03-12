package com.fufudev.basketmanagement;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database {

	public static final String TABLE_STATS = "StatsTable";
	public static final String COL_STA_ID = "id";
	public static final String COL_STA_DATE = "match_date";
	public static final String COL_STA_NOM = "match_nom";
	public static final String COL_STA_EQUIPE_DOM = "equipe_dom";
	public static final String COL_STA_EQUIPE_EXT = "equipe_ext";
	public static final String COL_STA_SETPLAY = "setplay";
	public static final String COL_STA_ACTION = "action";
	public static final String COL_STA_NUM_JOUEUR = "joueur_num";
	public static final String COL_STA_NOM_JOUEUR = "joueur_nom";
	public static final String COL_STA_ZONETIR = "zone_tir";
	
	private static final String DATABASE_NAME = "stats.db";
	private static final int DATABASE_VERSION = 1;
	
	private DbHelper ourHelper;
	private final Context ourContext;
	private SQLiteDatabase ourDatabase;
	
	private static boolean debug = false;
	
	private static class DbHelper extends SQLiteOpenHelper {
		public DbHelper (Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}
		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL("create table "); // TODO create table
		}
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			if (newVersion > oldVersion) {
				db.execSQL("drop table if exists " + TABLE_STATS);
				onCreate(db);
			}
		}
	}
	
	public Database(Context c) {
		ourContext = c;
	}
	public Database open() {
		ourHelper = new DbHelper(ourContext);
		ourDatabase = ourHelper.getWritableDatabase();
		return this;
	}
	public void close() {
		ourHelper.close();
	}
	
	
	
}
