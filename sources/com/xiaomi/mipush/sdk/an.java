package com.xiaomi.mipush.sdk;

import com.xiaomi.push.hj;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
/* synthetic */ class an {
    static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[hj.values().length];
        a = iArr;
        try {
            iArr[hj.SendMessage.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[hj.Registration.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[hj.UnRegistration.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[hj.Subscription.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[hj.UnSubscription.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[hj.Command.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            a[hj.Notification.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
    }
}
