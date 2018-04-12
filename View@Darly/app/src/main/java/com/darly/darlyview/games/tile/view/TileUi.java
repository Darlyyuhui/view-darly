package com.darly.darlyview.games.tile.view;

import android.content.Context;

/**
 * @author Darly/张宇辉/2018/4/3 15:13
 * @version 1.0/com.darly.darlyview.games.tile.view
 */
public class TileUi extends TileUnit {
    public static final int STATE_NORMAL = 1;
    public static final int STATE_INACTIVE = 2;
    public static final int STATE_ACTIVE = 3;
    public static final int STATE_READY = 4;

    private int mState = STATE_NORMAL;

    private int mDrawableStateNormal = 0;
    private int mDrawableStateInactive = 0;
    private int mDrawableStateActive = 0;
    private int mDrawableStateReady = 0;
    private boolean mVisible = true;

    private Context mContext = null;

    public TileUi(Context context, int drawable) {
        super(context, drawable);
        this.mContext = context;
        this.mDrawableStateNormal = drawable;
    }

    public void setStateNormal() {
        this.mState = STATE_NORMAL;

        if (this.mDrawableStateNormal > 0) {
            this.setDrawable(this.mContext, this.mDrawableStateNormal);
        }
    }

    public void setStateInactive() {
        this.mState = STATE_INACTIVE;

        if (this.mDrawableStateInactive > 0) {
            this.setDrawable(this.mContext, this.mDrawableStateInactive);
        }
    }

    public void setStateActive() {
        this.mState = STATE_ACTIVE;

        if (this.mDrawableStateActive > 0) {
            this.setDrawable(this.mContext, this.mDrawableStateActive);
        }
    }

    public void setStateReady() {
        this.mState = STATE_READY;

        if (this.mDrawableStateReady > 0) {
            this.setDrawable(this.mContext, this.mDrawableStateReady);
        }
    }

    public int getDrawableStateNormal() {
        return this.mDrawableStateNormal;
    }

    public void setDrawableStateNormal(int mDrawableStateNormal) {
        this.mDrawableStateNormal = mDrawableStateNormal;
    }

    public int getDrawableStateInactive() {
        return this.mDrawableStateInactive;
    }

    public void setDrawableStateInactive(int mDrawableStateInactive) {
        this.mDrawableStateInactive = mDrawableStateInactive;
    }

    public int getDrawableStateActive() {
        return this.mDrawableStateActive;
    }

    public void setDrawableStateActive(int mDrawableStateActive) {
        this.mDrawableStateActive = mDrawableStateActive;
    }

    public int getDrawableStateReady() {
        return this.mDrawableStateReady;
    }

    public void setDrawableStateReady(int mDrawableStateReady) {
        this.mDrawableStateReady = mDrawableStateReady;
    }

    public boolean isStateNormal() {
        return (this.mState == STATE_NORMAL);
    }

    public boolean isStateInactive() {
        return (this.mState == STATE_INACTIVE);
    }

    public boolean isVisible() {
        return this.mVisible;
    }

    public void setVisible(boolean visible) {
        this.mVisible = visible;
    }
}