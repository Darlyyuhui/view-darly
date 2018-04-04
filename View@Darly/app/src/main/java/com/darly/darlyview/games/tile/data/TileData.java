package com.darly.darlyview.games.tile.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;

import static android.provider.BaseColumns._ID;

/**
 * 保存到本地的數據庫
 *
 * @author Darly/张宇辉/2018/4/3 11:45
 * @version 1.0/com.darly.darlyview.games.tile.data
 */
public class TileData extends DataDao {
    public static final String TABLE_NAME = "TileData";

    public static final String NAME = "name";
    public static final String TYPE = "type";
    public static final String DRAWABLE = "drawable";
    public static final String VISIBLE = "visible";

    public static final int FIELD_ID = 0;
    public static final int FIELD_NAME = 1;
    public static final int FIELD_TYPE = 2;
    public static final int FIELD_DRAWABLE = 3;
    public static final int FIELD_VISIBLE = 4;

    public TileData(Context context) {
        super(context);
    }

    /**
     * Gets a map containing definitions for all available game tiles.
     *
     * @return HashMap
     */
    public HashMap<Integer, ArrayList<Integer>> getTilesData() {
        SQLiteDatabase db = this.getReadableDatabase();

        String[] from = {_ID, NAME, TYPE, DRAWABLE, VISIBLE};
        Cursor cursor = db.query(TABLE_NAME, from, null, null, null, null, null);

        HashMap<Integer, ArrayList<Integer>> tiles = new HashMap<Integer, ArrayList<Integer>>();

        if (cursor != null) {
            while (cursor.moveToNext()) {
                ArrayList<Integer> arrayList = new ArrayList<Integer>();

                arrayList.add(cursor.getInt(FIELD_ID));
                arrayList.add(cursor.getInt(FIELD_NAME));
                arrayList.add(cursor.getInt(FIELD_TYPE));
                arrayList.add(cursor.getInt(FIELD_DRAWABLE));
                arrayList.add(cursor.getInt(FIELD_VISIBLE));
                tiles.put(cursor.getInt(FIELD_ID), arrayList);
            }
            cursor.close();
        }

        db.close();

        return tiles;
    }

}
