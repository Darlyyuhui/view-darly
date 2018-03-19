package com.darly.darlyview.base;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.multidex.MultiDexApplication;
import android.telephony.TelephonyManager;

import com.darly.common.Common;
import com.darly.darlyview.BuildConfig;
import com.darly.dview.DView;

/**项目启动加载初始化类
 * @author Darly/张宇辉/2018/3/5 8:47
 * @version 1.0/com.darly.darlyview.base
 */
public class BaseApplication  extends MultiDexApplication {

    private static BaseApplication instance;
    @Override
    public void onCreate() {
        instance = this;
        super.onCreate();
        DView.init().notifyInit(BuildConfig.DEBUG, this);//初始化自定义控件集合
        Common.init().init(this, "darlyview_share");//初始化工具类中的缓存集合
        Common.init().initDlog(BuildConfig.DEBUG, "View");//初始化工具类中的日志
    }


    public static BaseApplication getInstance() {
        return instance;
    }

    /*
        获取项目的版本号
     */
    public int getVersionCode() {
        int version = 0;
        try {
            PackageInfo info = this.getPackageManager().getPackageInfo(this.getPackageName(), 0);
            version = info.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return version;
    }

    public String getDevId() {
        TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        return tm.getDeviceId();
    }

}