package com.taobao.android.launcher.common;

import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class LauncherParam {
    private static final HashMap<String, Object> PARAMS_BASIC = new HashMap<>(25);

    public static <T> T getParam(String str, T t) {
        T t2 = (T) PARAMS_BASIC.get(str);
        return t2 == null ? t : t2;
    }

    public static HashMap<String, Object> getParams(String str) {
        return PARAMS_BASIC;
    }
}
