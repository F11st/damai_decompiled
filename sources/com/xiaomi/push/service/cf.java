package com.xiaomi.push.service;

import com.xiaomi.push.hj;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
/* synthetic */ class cf {
    static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[hj.values().length];
        a = iArr;
        try {
            iArr[hj.Registration.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[hj.UnRegistration.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[hj.Subscription.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[hj.UnSubscription.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[hj.SendMessage.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[hj.AckMessage.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            a[hj.SetConfig.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            a[hj.ReportFeedback.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            a[hj.Notification.ordinal()] = 9;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            a[hj.Command.ordinal()] = 10;
        } catch (NoSuchFieldError unused10) {
        }
    }
}
