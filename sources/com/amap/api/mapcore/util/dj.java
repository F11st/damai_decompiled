package com.amap.api.mapcore.util;

import android.text.TextUtils;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class dj {
    int a;
    int[] b;
    int c;
    int d;
    String e;
    String f;
    String g;

    public dj(int i, int[] iArr, String str, String str2, String str3) {
        this.a = i;
        this.b = iArr;
        this.e = str;
        this.f = str2;
        this.g = str3;
        str = TextUtils.isEmpty(str) ? str2 : str;
        this.c = -1000;
        if ("regions".equals(str)) {
            this.c = 1001;
        } else if ("water".equals(str)) {
            this.c = 1002;
        } else if ("buildings".equals(str)) {
            this.c = 1003;
        } else if ("roads".equals(str)) {
            this.c = 1004;
        } else if ("labels".equals(str)) {
            this.c = 1005;
        } else if ("borders".equals(str)) {
            this.c = 1006;
        }
        this.d = (i * 1000) + iArr.hashCode();
    }
}
