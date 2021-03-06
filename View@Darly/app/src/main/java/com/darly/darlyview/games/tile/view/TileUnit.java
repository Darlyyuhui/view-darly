package com.darly.darlyview.games.tile.view;

import android.content.Context;
import android.graphics.Rect;

/**
 * @author Darly/张宇辉/2018/4/3 14:55
 * @version 1.0/com.darly.darlyview.games.tile.view
 */
public class TileUnit extends TileImage {

    private int id;
    private static int count = 1;

    public TileUnit(Context context, int drawable) {
        super(context, drawable);
        id = count;
        count++;
    }

    public Rect getRect() {
        Rect rect = new Rect((int) mX, (int) mY, ((int) mX + this.getWidth()), ((int) mY + this.getHeight()));
        return rect;
    }

    public boolean getCollision(int x, int y, int width, int height) {
        Rect rect = new Rect((int) x, (int) y, ((int) x + width), ((int) y + height));
        return (rect.intersects((int) mX, (int) mY, ((int) mX + getWidth()), ((int) mY + getHeight())));
    }

    public boolean getImpact(int x, int y) {
        if ((x >= mX) && (x <= (mX + this.getWidth()))) {
            if ((y >= mY) && (y <= (mY + this.getHeight()))) {
                return true;
            }
        }

        return false;
    }

    public static int getCount() {
        return count;
    }

    public static void resetCount() {
        count = 1;
    }

    public int getId() {
        return id;
    }

}
