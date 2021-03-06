package com.darly.darlyview.common;

import android.content.Context;

import com.darly.darlyview.R;
import com.darly.darlyview.ui.adapter.RecyclerBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Darly/张宇辉/2018/3/6 9:36
 * @version 1.0/com.darly.darlyview.common
 */
public class CacheData {
    public static List<RecyclerBean> getRecyclerBeanData(){
        List<RecyclerBean> data = new ArrayList<RecyclerBean>();
        RecyclerBean slidinguppanel = new RecyclerBean();
        slidinguppanel.setId("0");
        slidinguppanel.setIcon(R.mipmap.ic_slidinguppanel);
        slidinguppanel.setTitle("slidinguppanel（底部展示）");
        slidinguppanel.setDesc("一个能够向上滑动的时候往上飞出一个显示区域的控件，类似于play music中的效果。该控件在主界面中有一个底部触发区域，该区域点击的时候被隐藏在下方的内容将网上漂移到顶部，直到被隐藏的内容完全挡住原来的布局。当被隐藏区域完全显示，这时再次点击触发区域（或者是通过下滑的手势）将恢复到最初的状态。");
        slidinguppanel.setClazz("com.darly.darlyview.ui.pannal.SlidingUpPanelActivity");
        data.add(slidinguppanel);
        RecyclerBean staggeredGrid = new RecyclerBean();
        staggeredGrid.setId("1");
        staggeredGrid.setIcon(R.mipmap.ic_staggeredgrid);
        staggeredGrid.setTitle("staggeredGrid（瀑布流展示）");
        staggeredGrid.setDesc("注意跟StaggeredGridView区别，他的实现原理更类似于PinterestLikeAdapterView。AndroidStaggeredGrid的目的是为了满足Etsy app的需求（估计是作者自己开发的一个app）。有个很不错的特点是，当横竖屏切换时，改控件可以自己定位上次浏览的位置。和ListView一样，支持添加header 和 footer。个人觉得这个才是最好的。");
        staggeredGrid.setClazz("com.darly.darlyview.ui.staggered.StaggeredGridActivity");
        data.add(staggeredGrid);
        RecyclerBean swipecards = new RecyclerBean();
        swipecards.setId("2");
        swipecards.setIcon(R.mipmap.ic_swipecards);
        swipecards.setTitle("swipecards（左右移动纸牌）");
        swipecards.setDesc("一个实现了可滑动卡片风格的开源项目，类似国外很火的交友软件Tinder中的卡片效果，图中的卡片可左右滑动飞出界面，分别表示喜欢和不喜欢。");
        swipecards.setClazz("com.darly.darlyview.ui.swipecards.SwipeCardsActivity");
        data.add(swipecards);
        RecyclerBean waveSwipeRefresh = new RecyclerBean();
        waveSwipeRefresh.setId("3");
        waveSwipeRefresh.setIcon(R.mipmap.ic_wave);
        waveSwipeRefresh.setTitle("waveSwipeRefresh（水滴下拉）");
        waveSwipeRefresh.setDesc("水滴效果的下拉刷新，效果非常不错。");
        waveSwipeRefresh.setClazz("com.darly.darlyview.ui.waveswiperefresh.WaveSwipeRefreshActivity");
        data.add(waveSwipeRefresh);
        RecyclerBean shapeloading = new RecyclerBean();
        shapeloading.setId("4");
        shapeloading.setIcon(R.mipmap.ic_shapeloading);
        shapeloading.setTitle("shapeloading（加载动画）");
        shapeloading.setDesc("跳跃效果的加载动画，类似于58同城的加载效果。");
        shapeloading.setClazz("com.darly.darlyview.ui.shapeloading.ShapeLoadingActivity");
        data.add(shapeloading);
        RecyclerBean pocketsphinx = new RecyclerBean();
        pocketsphinx.setId("5");
        pocketsphinx.setIcon(R.mipmap.ic_pocketsphinx);
        pocketsphinx.setTitle("pocketsphinx（语音识别技术）");
        pocketsphinx.setDesc("This is a demonstration for Pocketsphinx on Android");
        pocketsphinx.setClazz("com.darly.darlyview.ui.pocketsphinx.PocketSphinxActivity");
        data.add(pocketsphinx);
        RecyclerBean grav = new RecyclerBean();
        grav.setId("6");
        grav.setIcon(R.mipmap.ic_grav);
        grav.setTitle("grav（粒子动画效果）");
        grav.setDesc("This is a demonstration for Pocketsphinx on Android");
        grav.setClazz("com.darly.darlyview.ui.grav.GravActivity");
        data.add(grav);
        RecyclerBean rebound = new RecyclerBean();
        rebound.setId("7");
        rebound.setIcon(R.mipmap.ic_rebound);
        rebound.setTitle("rebound（图片图标点击波动效果）");
        rebound.setDesc("Rebound is a java library that models spring dynamics. Rebound spring models can be used to create animations that feel natural by introducing real world physics to your application.\n" +
                "\n" +
                "Rebound is not a general purpose physics library; however, spring dynamics can be used to drive a wide variety of animations. The simplicity of Rebound makes it easy to integrate and use as a building block for creating more complex components like pagers, toggles, and scrollers.\n" +
                "\n" +
                "Rebound uses the same spring constants as Origami making it easy to convert Origami interaction mockups directly into your Android application.");
        rebound.setClazz("com.darly.darlyview.ui.rebound.ReboundActivity");
        data.add(rebound);

        RecyclerBean lottie = new RecyclerBean();
        lottie.setId("8");
        lottie.setIcon(R.mipmap.ic_lottie);
        lottie.setTitle("lottie（各种交互动画）");
        lottie.setDesc("Lottie is a mobile library for Android and iOS that parses Adobe After Effects animations exported as json with Bodymovin and renders them natively on mobile!\n" +
                "\n" +
                "For the first time, designers can create and ship beautiful animations without an engineer painstakingly recreating it by hand. They say a picture is worth 1,000 words so here are 13,000:");
        lottie.setClazz("com.darly.darlyview.ui.lottie.LottieActivity?");
        data.add(lottie);

        RecyclerBean mover = new RecyclerBean();
        mover.setId("9");
        mover.setIcon(R.mipmap.ic_mover);
        mover.setTitle("mover（控件动画）");
        mover.setDesc("控件动画 https://github.com/daimajia/AndroidViewAnimations");
        mover.setClazz("com.darly.darlyview.ui.mover.MoverActivity");
        data.add(mover);
        RecyclerBean magnet = new RecyclerBean();
        magnet.setId("10");
        magnet.setIcon(R.mipmap.ic_mover);
        magnet.setTitle("magnet（磁鐵效果）");
        magnet.setDesc("仿照磁鐵效果的ImageView");
        magnet.setClazz("com.darly.darlyview.ui.magnet.MagnetActivity");
        data.add(magnet);
        return data;
    }


    public static final int SAMPLE_DATA_ITEM_COUNT = 30;

    public static ArrayList<String> generateSampleData() {
        final ArrayList<String> data = new ArrayList<String>(SAMPLE_DATA_ITEM_COUNT);
        for (int i = 0; i < SAMPLE_DATA_ITEM_COUNT; i++) {
            data.add("SAMPLE #");
        }
        return data;
    }

    static int[] rest = {R.mipmap.ic_stagger_a,R.mipmap.ic_stagger_b,R.mipmap.ic_stagger_c,R.mipmap.ic_stagger_d,R.mipmap.ic_stagger_e,R.mipmap.ic_stagger_f,R.mipmap.ic_stagger_g,R.mipmap.ic_stagger_h};
    public static List<RecyclerBean> getStaggerData(){
        List<RecyclerBean> data = new ArrayList<RecyclerBean>();
        for (int i = 0;i<rest.length;i++){
            RecyclerBean staggera = new RecyclerBean();
            staggera.setIcon(rest[i]);
            staggera.setTitle("图示"+rest[i]);
            staggera.setDesc("假数据");
            data.add(staggera);
        }
        return data;
    }

    public static List<RecyclerBean> getLittleRestData() {
        List<RecyclerBean> data = new ArrayList<RecyclerBean>();
        RecyclerBean tow2048 = new RecyclerBean();
        tow2048.setId("0");
        tow2048.setIcon(R.mipmap.ic_slidinguppanel);
        tow2048.setTitle("2048");
        tow2048.setDesc("数字游戏");
        tow2048.setClazz("com.darly.darlyview.games.nub2048.Game2048Activity");
        data.add(tow2048);
        RecyclerBean tile = new RecyclerBean();
        tile.setId("3");
        tile.setIcon(R.mipmap.ic_slidinguppanel);
        tile.setTitle("tile");
        tile.setDesc("小游戏");
        tile.setClazz("com.darly.darlyview.games.tile.TileActivity");
        data.add(tile);
        RecyclerBean record = new RecyclerBean();
        record.setId("1");
        record.setIcon(R.mipmap.ic_slidinguppanel);
        record.setTitle("Record");
        record.setDesc("上传RTMP流");
        record.setClazz("com.darly.darlyview.video.VideoActivity");
        data.add(record);
        RecyclerBean play = new RecyclerBean();
        play.setId("0");
        play.setIcon(R.mipmap.ic_slidinguppanel);
        play.setTitle("Play");
        play.setDesc("播放RTMP流");
        play.setClazz("com.darly.darlyview.video.PlayActivity");
        data.add(play);
        return data;
    }

}
