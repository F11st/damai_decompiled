package com.xiaomi.mipush.sdk;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
/* synthetic */ class k {
    static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[e.values().length];
        a = iArr;
        try {
            iArr[e.ASSEMBLE_PUSH_HUAWEI.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[e.ASSEMBLE_PUSH_FCM.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[e.ASSEMBLE_PUSH_COS.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[e.ASSEMBLE_PUSH_FTOS.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
