package com.youku.playerservice.axp.utils;

import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class SessionUtil {
    private static int sIndex;

    public static String create(String str) {
        String str2 = str + jn1.PLUS + sIndex + jn1.PLUS + System.currentTimeMillis();
        sIndex++;
        return str2;
    }
}
