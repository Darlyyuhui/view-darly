package com.darly.darlyview.ui.adapter;

import java.io.Serializable;

/**首頁展示模型
 * @author Darly/张宇辉/2018/3/6 8:59
 * @version 1.0/com.darly.darlyview.ui.adapter
 */
public class RecyclerBean implements Serializable{

    private String id;
    private String clazz;
    private int icon;
    private String title;
    private String desc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
