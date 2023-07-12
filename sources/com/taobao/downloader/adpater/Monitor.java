package com.taobao.downloader.adpater;

import tb.nh1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface Monitor {
    public static final String POINT_ADD = "add";
    public static final String POINT_ALL_CALLBACK = "allcallback";
    public static final String POINT_URL = "url";

    void monitorCount(String str, String str2, String str3, int i);

    void monitorFail(String str, String str2, String str3, String str4, String str5);

    void monitorSuccess(String str, String str2, String str3);

    void stat(nh1.C9474a c9474a, String str);
}
