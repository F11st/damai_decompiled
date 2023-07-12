package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.service.notification.StatusBarNotification;
import com.xiaomi.push.C7688m;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
/* renamed from: com.xiaomi.push.service.d */
/* loaded from: classes11.dex */
public class C7750d {
    private static List<C7751a> a = new CopyOnWriteArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.service.d$a */
    /* loaded from: classes11.dex */
    public static class C7751a {
        public final int a;

        /* renamed from: a  reason: collision with other field name */
        public final long f968a;

        /* renamed from: a  reason: collision with other field name */
        public final String f969a;

        /* renamed from: a  reason: collision with other field name */
        public final Notification.Action[] f970a;

        C7751a(String str, long j, int i, Notification.Action[] actionArr) {
            this.f969a = str;
            this.f968a = j;
            this.a = i;
            this.f970a = actionArr;
        }
    }

    private static void a() {
        for (int size = a.size() - 1; size >= 0; size--) {
            C7751a c7751a = a.get(size);
            if (SystemClock.elapsedRealtime() - c7751a.f968a > DanmakuFactory.DEFAULT_DANMAKU_DURATION_V) {
                a.remove(c7751a);
            }
        }
        if (a.size() > 10) {
            a.remove(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(Context context, StatusBarNotification statusBarNotification, int i) {
        if (!C7688m.m1119a(context) || i <= 0 || statusBarNotification == null || Build.VERSION.SDK_INT < 20) {
            return;
        }
        a(new C7751a(statusBarNotification.getKey(), SystemClock.elapsedRealtime(), i, ay.m1192a(statusBarNotification.getNotification())));
    }

    private static void a(C7751a c7751a) {
        a.add(c7751a);
        a();
    }
}
