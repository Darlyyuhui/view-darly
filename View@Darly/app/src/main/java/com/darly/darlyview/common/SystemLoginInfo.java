package com.darly.darlyview.common;

import android.content.Context;
import android.content.SharedPreferences;

/** 用户登录信息
 * @author Darly/张宇辉/2018/4/8 11:25
 * @version 1.0/com.darly.darlyview.common
 */
public class SystemLoginInfo {

    private static SharedPreferences mysp = null;
    private static final String PREFERENCE_NAME = "viewdarly";

    public static void init(Context context) {
        mysp = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    public static void setParamer(String key,String  value){
        mysp.edit().putString(key, value).commit();
    }

    public static String getParamer(String key){
        return mysp.getString(key, "");
    }
    public static void setParamer(String key,boolean  value){
        mysp.edit().putBoolean(key, value).commit();
    }

    public static boolean getboolean(String key){
        return mysp.getBoolean(key, false);
    }



}
