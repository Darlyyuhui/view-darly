package com.darly.darlyview.games.tile.view;

import android.content.Context;

/**
 * @author Darly/张宇辉/2018/4/3 15:09
 * @version 1.0/com.darly.darlyview.games.tile.view
 */
public class TilePlayUnit extends TileImage {
    public static final int SPEED = 3;

    Context mContext;

    private int mUnmodifiedX = 0;
    private int mUnmodifiedY = 0;

    public TilePlayUnit(Context context, int drawable) {
        super(context, drawable);
        this.mContext = context;
    }

    public int getUnmodifiedX() {
        return this.mUnmodifiedX;
    }

    public void setUnmodifiedX(int unmodifiedX) {
        this.mUnmodifiedX = unmodifiedX;
    }

    public int getUnmodifiedY() {
        return this.mUnmodifiedY;
    }

    public void setUnmodifiedY(int unmodifiedY) {
        this.mUnmodifiedY = unmodifiedY;
    }
}
