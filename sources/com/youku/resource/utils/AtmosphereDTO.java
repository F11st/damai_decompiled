package com.youku.resource.utils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class AtmosphereDTO implements Serializable {
    public String galleryGradientBottomColor;
    public String galleryGradientTopColor;
    public String homeHotWordTextColor;
    public int isForced;
    public String navBgColor;
    public String navBgSubColor;
    public String navColor;
    public String navIconColor;
    public String navIndicatorColor;
    @Deprecated
    public String navLogoColor;
    public String navSubColor;
    public String refreshBgColor;
    public String sceneBgColor;
    public String sceneCardFooterBgColor;
    public String sceneCardFooterTitleColor;
    public String sceneCardHeaderArrowColor;
    public String sceneCardHeaderKeywordColor;
    public String sceneCardHeaderSubTitleColor;
    public String sceneCardHeaderTitleColor;
    public String sceneSubTitleColor;
    public String sceneSubTitleRecommendBgColor;
    public String sceneTitleColor;
    public int statusBarStyle;
    public String navBgImg = "";
    public String navSelectImg = "";

    public HashMap<String, Object> getStyleMap() {
        Field[] fields;
        HashMap<String, Object> hashMap = new HashMap<>();
        for (Field field : getClass().getFields()) {
            field.setAccessible(true);
            try {
                if (field.get(this) != null) {
                    hashMap.put(field.getName(), field.get(this));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return hashMap;
    }

    public AtmosphereDTO setDefaultAtmosphereValue() {
        this.navBgColor = AtmosphereColorConst.navBgColor;
        this.navBgSubColor = AtmosphereColorConst.navBgSubColor;
        String str = AtmosphereColorConst.navIconColor;
        this.navIconColor = str;
        this.navColor = AtmosphereColorConst.navColor;
        this.navSubColor = AtmosphereColorConst.navSubColor;
        this.navLogoColor = str;
        this.navIndicatorColor = AtmosphereColorConst.navIndicatorColor;
        this.statusBarStyle = 0;
        this.isForced = 0;
        this.refreshBgColor = AtmosphereColorConst.refreshBgColor;
        this.navBgImg = AtmosphereColorConst.navBgImg;
        this.navSelectImg = AtmosphereColorConst.navSelectImg;
        this.galleryGradientTopColor = AtmosphereColorConst.galleryGradientTopColor;
        this.galleryGradientBottomColor = AtmosphereColorConst.galleryGradientBottomColor;
        this.homeHotWordTextColor = AtmosphereColorConst.homeHotWordTextColor;
        return this;
    }
}
