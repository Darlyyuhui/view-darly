package com.darly.darlyview.games.tile.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import static android.provider.BaseColumns._ID;

/**
 * @author Darly/张宇辉/2018/4/3 13:40
 * @version 1.0/com.darly.darlyview.games.tile.data
 */
public class LevelTileData extends DataDao {
    public static final String TABLE_NAME = "LevelTileData";

    public static final String STAGE = "stage";
    public static final String LEVEL = "level";
    public static final String PLAYER_START_TILE_X = "playerStartTileX";
    public static final String PLAYER_START_TILE_Y = "playerStartTileY";
    public static final String TILE_DATA = "tileData";

    public static final int FIELD_ID = 0;
    public static final int FIELD_STAGE = 1;
    public static final int FIELD_LEVEL = 2;
    public static final int FIELD_PLAYER_START_TILE_X = 3;
    public static final int FIELD_PLAYER_START_TILE_Y = 4;
    public static final int FIELD_TILE_DATA = 5;

    public static final String TILE_DATA_LINE_BREAK = "//";

    public LevelTileData(Context context) {
        super(context);
    }


    public ArrayList<String> getGameLevelData(int stage, int level) {
        SQLiteDatabase db = this.getReadableDatabase();

        String[] from = {_ID, STAGE, LEVEL, PLAYER_START_TILE_X, PLAYER_START_TILE_Y, TILE_DATA};
        String where = STAGE + " = " + stage + " AND " + LEVEL + " = " + level;

        Cursor cursor = db.query(TABLE_NAME, from, where, null, null, null, null);

        ArrayList<String> levelData = new ArrayList<String>();

        if (cursor != null) {
            while (cursor.moveToNext()) {
                levelData.add(cursor.getString(FIELD_ID));
                levelData.add(cursor.getString(FIELD_STAGE));
                levelData.add(cursor.getString(FIELD_LEVEL));
                levelData.add(cursor.getString(FIELD_PLAYER_START_TILE_X));
                levelData.add(cursor.getString(FIELD_PLAYER_START_TILE_Y));
                levelData.add(cursor.getString(FIELD_TILE_DATA));
            }
            cursor.close();
        }

        db.close();
        return levelData;
    }
}
