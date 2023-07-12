package com.taobao.tao.log;

import androidx.annotation.Keep;

/* compiled from: Taobao */
@Keep
@Deprecated
/* loaded from: classes11.dex */
public class TSceneLog {
    public static final int PAGE_EVENT_TYPE_APPEAR = 2;
    public static final int PAGE_EVENT_TYPE_DISAPPEAR = 3;
    public static final int PAGE_EVENT_TYPE_ENTER = 1;
    public static final int PAGE_EVENT_TYPE_LEAVE = 4;
    public static final int PAGE_EVENT_TYPE_UNKNOWN = 0;
    public static final int PAGE_TYPE_ACTIVITY = 1;
    public static final int PAGE_TYPE_ALERT = 3;
    public static final int PAGE_TYPE_DIALOG = 4;
    public static final int PAGE_TYPE_FRAGMENT = 2;
    public static final int PAGE_TYPE_UNKNOWN = 0;
    public static final int SCENE_TYPE_LAUNCH = 1;
    public static final int SCENE_TYPE_PAGE = 2;
    public static final int SCENE_TYPE_UNKNOWN = 0;
    private static final String TAG = "TSceneLog";
    private static String globalSceneID = "";

    private static void event(LogLevel logLevel, String str, String str2, String str3, int i, String str4, String str5, String str6) {
    }

    public static void event(String str, String str2, String str3, int i, String str4, String str5, String str6) {
        event(LogLevel.I, str, str2, str3, i, str4, str5, str6);
    }

    public static String getGlobalSceneID() {
        return globalSceneID;
    }

    public static void launchEvent(String str, String str2, String str3, String str4, String str5, String str6) {
        event(str, str2, str3, 1, str4, str5, str6);
    }

    public static void pageEvent(String str, String str2, String str3, String str4, String str5, int i, int i2, String str6, String str7) {
        event(str, str2, str3, 2, str4, str5, String.format("%s|%d|%d|%s", str6, Integer.valueOf(i2), Integer.valueOf(i), str7));
    }

    public static void setGlobalSceneID(String str) {
        globalSceneID = str;
    }
}
