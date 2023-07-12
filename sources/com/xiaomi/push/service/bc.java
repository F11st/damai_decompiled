package com.xiaomi.push.service;

import com.xiaomi.push.hp;
import com.xiaomi.push.hq;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
/* synthetic */ class bc {
    static final /* synthetic */ int[] a;
    static final /* synthetic */ int[] b;

    static {
        int[] iArr = new int[hq.values().length];
        b = iArr;
        try {
            iArr[hq.INT.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            b[hq.LONG.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            b[hq.STRING.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            b[hq.BOOLEAN.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        int[] iArr2 = new int[hp.values().length];
        a = iArr2;
        try {
            iArr2[hp.MISC_CONFIG.ordinal()] = 1;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[hp.PLUGIN_CONFIG.ordinal()] = 2;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
