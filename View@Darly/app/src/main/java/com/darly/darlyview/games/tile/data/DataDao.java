package com.darly.darlyview.games.tile.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.darly.darlyview.R;
import com.darly.darlyview.games.tile.view.TileLevel;

import static android.provider.BaseColumns._ID;

/**
 * @author Darly/张宇辉/2018/4/3 14:26
 * @version 1.0/com.darly.darlyview.games.tile.data
 */
public class DataDao extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "tile.db";
    private static final int DATABASE_VERSION = 1;

    /**
     * TileData 数据库，建立表
     */
    private static final String CREATE_TABLE_GAME_TILES = "CREATE TABLE " + TileData.TABLE_NAME + " ("
            + _ID + " INTEGER PRIMARY KEY, "
            + TileData.NAME + " STRING,"
            + TileData.TYPE + " INTEGER DEFAULT 0,"
            + TileData.DRAWABLE + " INTEGER DEFAULT 0,"
            + TileData.VISIBLE + " INTEGER DEFAULT 1"
            + ");";

    /**
     * 建立关卡表
     */
    private static final String CREATE_TABLE_GAME_LEVEL_TILES = "CREATE TABLE " + LevelTileData.TABLE_NAME + " ("
            + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + LevelTileData.STAGE + " INTEGER DEFAULT 0,"
            + LevelTileData.LEVEL + " INTEGER DEFAULT 0,"
            + LevelTileData.PLAYER_START_TILE_X + " INTEGER DEFAULT 0,"
            + LevelTileData.PLAYER_START_TILE_Y + " INTEGER DEFAULT 0,"
            + LevelTileData.TILE_DATA + " TEXT NOT NULL"
            + ");";


    public DataDao(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
// Create game tables
        Log.d("Tile Game Example", "Creating DB tables");
        db.execSQL(CREATE_TABLE_GAME_TILES);
        db.execSQL(CREATE_TABLE_GAME_LEVEL_TILES);
        // Populate game tables
        Log.d("Tile Game Example", "Populating DB tables");
        for (String query : POPULATE_TABLE_GAME_TILES) {
            db.execSQL(query);
        }
        for (String query : POPULATE_TABLE_GAME_LEVEL_TILES) {
            db.execSQL(query);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TileData.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + LevelTileData.TABLE_NAME);
        onCreate(db);
    }

    //插入TileData数据集合
    private static final String[] POPULATE_TABLE_GAME_TILES = {
            "INSERT INTO " + TileData.TABLE_NAME + " VALUES "
                    + "(1,\"Tile 01\"," + TileLevel.TYPE_OBSTACLE + "," + R.drawable.tile_01 + ",1);",

            "INSERT INTO " + TileData.TABLE_NAME + " VALUES "
                    + "(2,\"Tile 02\"," + TileLevel.TYPE_OBSTACLE + "," + R.drawable.tile_02 + ",1);",

            "INSERT INTO " + TileData.TABLE_NAME + " VALUES "
                    + "(3,\"Tile 03\"," + TileLevel.TYPE_OBSTACLE + "," + R.drawable.tile_03 + ",1);",

            "INSERT INTO " + TileData.TABLE_NAME + " VALUES "
                    + "(4,\"Tile 04\"," + TileLevel.TYPE_OBSTACLE + "," + R.drawable.tile_04 + ",1);",

            "INSERT INTO " + TileData.TABLE_NAME + " VALUES "
                    + "(5,\"Tile 05\"," + TileLevel.TYPE_OBSTACLE + "," + R.drawable.tile_05 + ",1);",

            "INSERT INTO " + TileData.TABLE_NAME + " VALUES "
                    + "(6,\"Tile 06\"," + TileLevel.TYPE_OBSTACLE + "," + R.drawable.tile_06 + ",1);",

            "INSERT INTO " + TileData.TABLE_NAME + " VALUES "
                    + "(7,\"Tile 07\"," + TileLevel.TYPE_OBSTACLE + "," + R.drawable.tile_07 + ",1);",

            "INSERT INTO " + TileData.TABLE_NAME + " VALUES "
                    + "(8,\"Dangerous Tile 01\"," + TileLevel.TYPE_DANGEROUS + "," + R.drawable.tile_danger_01 + ",1);",

            "INSERT INTO " + TileData.TABLE_NAME + " VALUES "
                    + "(9,\"Exit Tile\"," + TileLevel.TYPE_EXIT + "," + R.drawable.tile_exit + ",1);"
    };


    //插入关卡数据集合
    private static final String[] POPULATE_TABLE_GAME_LEVEL_TILES = {
            "INSERT INTO " + LevelTileData.TABLE_NAME + " VALUES "
                    + "(null,1,1,7,3,\""
                    // 1  2  3  4  5  6  7  8  9  10 11 12 13 14 15
                    /* 1  */ + "01,01,01,01,01,01,01,01,01,01,01,01,01,01,01" + LevelTileData.TILE_DATA_LINE_BREAK
                    /* 2  */ + "01,03,03,03,03,03,03,03,03,03,03,03,03,03,01" + LevelTileData.TILE_DATA_LINE_BREAK
                    /* 3  */ + "01,03,00,00,00,00,00,00,00,00,00,00,00,03,01" + LevelTileData.TILE_DATA_LINE_BREAK
                    /* 4  */ + "01,03,00,00,00,00,00,00,00,00,00,07,07,03,01" + LevelTileData.TILE_DATA_LINE_BREAK
                    /* 5  */ + "01,03,07,00,00,00,00,00,00,00,07,07,07,03,01" + LevelTileData.TILE_DATA_LINE_BREAK
                    /* 6  */ + "01,03,05,05,06,05,00,00,00,05,06,05,05,03,01" + LevelTileData.TILE_DATA_LINE_BREAK
                    /* 7  */ + "01,03,03,00,08,00,00,00,00,00,08,00,03,03,01" + LevelTileData.TILE_DATA_LINE_BREAK
                    /* 8  */ + "01,03,00,00,00,00,00,00,00,00,00,00,00,03,01" + LevelTileData.TILE_DATA_LINE_BREAK
                    /* 9  */ + "01,03,00,00,00,00,00,00,00,00,00,00,00,03,01" + LevelTileData.TILE_DATA_LINE_BREAK
                    /* 10 */ + "01,03,00,00,00,00,04,04,04,00,00,00,00,03,01" + LevelTileData.TILE_DATA_LINE_BREAK
                    /* 11 */ + "01,03,00,00,04,04,03,03,03,04,04,00,00,03,01" + LevelTileData.TILE_DATA_LINE_BREAK
                    /* 12 */ + "01,03,00,00,03,00,00,00,00,00,03,00,00,03,01" + LevelTileData.TILE_DATA_LINE_BREAK
                    /* 13 */ + "01,03,00,00,00,00,00,00,00,00,00,00,00,03,01" + LevelTileData.TILE_DATA_LINE_BREAK
                    /* 14 */ + "01,03,00,00,00,00,00,09,00,00,00,00,07,03,01" + LevelTileData.TILE_DATA_LINE_BREAK
                    /* 15 */ + "01,03,03,00,00,00,02,02,02,00,00,00,03,03,01" + LevelTileData.TILE_DATA_LINE_BREAK
                    /* 16 */ + "01,03,03,04,04,04,02,02,02,04,04,04,03,03,01" + LevelTileData.TILE_DATA_LINE_BREAK
                    /* 17 */ + "01,01,01,01,01,01,01,01,01,01,01,01,01,01,01" + LevelTileData.TILE_DATA_LINE_BREAK
                    + "\");"
    };

}
