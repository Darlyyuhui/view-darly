package com.darly.darlyview.games.tile;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Window;

import com.darly.darlyview.games.tile.view.TileBaseView;

/** The Play activity creates a new GameView instance and starts the game.
 * @author Darly/张宇辉/2018/4/3 11:34
 * @version 1.0/com.darly.darlyview.games.tile
 */
public class TileActivity extends Activity {

    private TileBaseView baseView = null;
    private DisplayMetrics mMetrics = new DisplayMetrics();
    private float mScreenDensity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context mContext = getApplicationContext();
        /**
         * Get the screen density that all pixel values will be based on.
         * This allows scaling of pixel values over different screen sizes.
         *
         * See: http://developer.android.com/reference/android/util/DisplayMetrics.html
         */
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
        mScreenDensity = mMetrics.density;

        /**
         * There is only one stage / level in this example.
         * In a real game, the user's chosen stage / level should be
         * passed to this activity.
         */
        int stage = 1;
        int level = 1;

        Log.d("Tile Game Example", "Starting game at stage: " + stage + ", level: " + level);
        baseView = new TileBaseView(mContext, this, stage, level, mScreenDensity);
        setContentView(baseView);

    }

    @Override
    protected void onPause(){
        super.onPause();
        if (baseView!=null) {
            baseView.getThread().setState(TileBaseView.STATE_PAUSED); // pause game when Activity pauses
        }
    }
}
