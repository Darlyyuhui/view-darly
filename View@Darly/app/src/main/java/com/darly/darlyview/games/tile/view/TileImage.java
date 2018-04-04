package com.darly.darlyview.games.tile.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/** 英雄角色
 * @author Darly/张宇辉/2018/4/3 14:46
 * @version 1.0/com.darly.darlyview.games.tile.view
 */
public class TileImage {

    protected Bitmap mImg = null;
    protected int mX = 0;
    protected int mY = 0;
    protected int mWidth = 0;
    protected int mHeight = 0;


    public TileImage(Context context)
    {
    }

    public TileImage(Context context, int drawable)
    {
        this.setDrawable(context, drawable);
    }


    public void setDrawable(Context context, int drawable)
    {
        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inJustDecodeBounds = true;
        this.mImg = BitmapFactory.decodeResource(context.getResources(), drawable);

        mWidth = this.mImg.getWidth();
        mHeight = this.mImg.getHeight();
    }
    public void setBitmap(Bitmap bitmap)
    {
        if (bitmap != null)
        {
            this.mImg = bitmap;
            this.mWidth = bitmap.getWidth();
            this.mHeight = bitmap.getHeight();
        }
    }

    public Bitmap getBitmap() {
        return mImg;
    }

    public int getX() {
        return mX;
    }

    public void setX(int mX) {
        this.mX = mX;
    }

    public int getY() {
        return mY;
    }

    public void setY(int mY) {
        this.mY = mY;
    }

    public int getWidth() {
        return mWidth;
    }

    public void setWidth(int mWidth) {
        this.mWidth = mWidth;
    }

    public int getHeight() {
        return mHeight;
    }

    public void setHeight(int mHeight) {
        this.mHeight = mHeight;
    }

    public void setCenterX(int centerX)
    {
        this.mX = (centerX - (this.getWidth() / 2));
    }

    public int getCenterX()
    {
        return (mX + (this.getWidth() / 2));
    }

    public void setCenterY(int centerY)
    {
        this.mY = (centerY - (this.getHeight() / 2));
    }

    public int getCenterY()
    {
        return (mY + (this.getHeight() / 2));
    }

}
