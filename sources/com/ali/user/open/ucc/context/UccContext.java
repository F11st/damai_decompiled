package com.ali.user.open.ucc.context;

import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class UccContext {
    private static Map<String, String> bizParams = new HashMap();
    public static long startTrustLoginTime = 0;

    public static Map<String, String> getBizParams() {
        return bizParams;
    }

    public static void setBizParams(Map<String, String> map) {
        bizParams = map;
    }
}
