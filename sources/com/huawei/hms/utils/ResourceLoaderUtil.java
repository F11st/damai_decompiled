package com.huawei.hms.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class ResourceLoaderUtil {
    public static Context a;
    public static String b;

    public static int getAnimId(String str) {
        return a.getResources().getIdentifier(str, "anim", b);
    }

    public static int getColorId(String str) {
        return a.getResources().getIdentifier(str, "color", b);
    }

    public static Drawable getDrawable(String str) {
        return a.getResources().getDrawable(getDrawableId(str));
    }

    public static int getDrawableId(String str) {
        return a.getResources().getIdentifier(str, "drawable", b);
    }

    public static int getIdId(String str) {
        return a.getResources().getIdentifier(str, "id", b);
    }

    public static int getLayoutId(String str) {
        return a.getResources().getIdentifier(str, "layout", b);
    }

    public static String getString(String str) {
        return a.getResources().getString(getStringId(str));
    }

    public static int getStringId(String str) {
        return a.getResources().getIdentifier(str, "string", b);
    }

    public static int getStyleId(String str) {
        return a.getResources().getIdentifier(str, "style", b);
    }

    public static Context getmContext() {
        return a;
    }

    public static void setmContext(Context context) {
        a = context;
        b = context.getPackageName();
    }

    public static String getString(String str, Object... objArr) {
        return a.getResources().getString(getStringId(str), objArr);
    }
}
