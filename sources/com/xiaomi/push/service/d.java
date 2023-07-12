package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.service.notification.StatusBarNotification;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class d {
    private static List<a> a = new CopyOnWriteArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class a {
        public final int a;

        /* renamed from: a  reason: collision with other field name */
        public final long f968a;

        /* renamed from: a  reason: collision with other field name */
        public final String f969a;

        /* renamed from: a  reason: collision with other field name */
        public final Notification.Action[] f970a;

        a(String str, long j, int i, Notification.Action[] actionArr) {
            this.f969a = str;
            this.f968a = j;
            this.a = i;
            this.f970a = actionArr;
        }
    }

    private static void a() {
        for (int size = a.size() - 1; size >= 0; size--) {
            a aVar = a.get(size);
            if (SystemClock.elapsedRealtime() - aVar.f968a > DanmakuFactory.DEFAULT_DANMAKU_DURATION_V) {
                a.remove(aVar);
            }
        }
        if (a.size() > 10) {
            a.remove(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(Context context, StatusBarNotification statusBarNotification, int i) {
        if (!com.xiaomi.push.m.m1119a(context) || i <= 0 || statusBarNotification == null || Build.VERSION.SDK_INT < 20) {
            return;
        }
        a(new a(statusBarNotification.getKey(), SystemClock.elapsedRealtime(), i, ay.m1192a(statusBarNotification.getNotification())));
    }

    private static void a(a aVar) {
        a.add(aVar);
        a();
    }
}
