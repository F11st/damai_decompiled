package com.amap.api.col.s;

import com.amap.api.col.s.bv;
import com.amap.api.services.core.ServiceSettings;

/* compiled from: Taobao */
/* renamed from: com.amap.api.col.s.h */
/* loaded from: classes10.dex */
public final class C4434h {
    public static final String[] a = {"com.amap.api.services", "com.amap.api.search.admic"};

    public static String a() {
        return ServiceSettings.getInstance().getProtocol() == 1 ? "http://restsdk.amap.com/v3" : "https://restsdk.amap.com/v3";
    }

    public static String b() {
        return ServiceSettings.getInstance().getProtocol() == 1 ? "http://restsdk.amap.com/v4" : "https://restsdk.amap.com/v4";
    }

    public static String c() {
        return ServiceSettings.getInstance().getProtocol() == 1 ? "http://restsdk.amap.com/v5" : "https://restsdk.amap.com/v5";
    }

    public static String d() {
        return ServiceSettings.getInstance().getProtocol() == 1 ? "http://yuntuapi.amap.com" : "https://yuntuapi.amap.com";
    }

    public static String e() {
        return ServiceSettings.getInstance().getProtocol() == 1 ? "http://restsdk.amap.com/rest/me/cpoint" : "https://restsdk.amap.com/rest/me/cpoint";
    }

    public static String f() {
        return ServiceSettings.getInstance().getProtocol() == 1 ? "http://m5.amap.com/ws/mapapi/shortaddress/transform" : "https://m5.amap.com/ws/mapapi/shortaddress/transform";
    }

    public static bv a(boolean z) {
        try {
            return new bv.C4400a("sea", "9.2.0", "AMAP SDK Android Search 9.2.0").a(a).a(z).a("9.2.0").a();
        } catch (bj e) {
            C4435i.a(e, "ConfigableConst", "getSDKInfo");
            return null;
        }
    }
}
