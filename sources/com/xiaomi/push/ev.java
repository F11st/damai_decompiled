package com.xiaomi.push;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.eu;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ev implements eu.InterfaceC7648a {

    /* renamed from: a  reason: collision with other field name */
    protected Context f321a;

    /* renamed from: a  reason: collision with other field name */
    private PendingIntent f320a = null;
    private volatile long a = 0;

    public ev(Context context) {
        this.f321a = null;
        this.f321a = context;
    }

    private void a(AlarmManager alarmManager, long j, PendingIntent pendingIntent) {
        try {
            AlarmManager.class.getMethod("setExact", Integer.TYPE, Long.TYPE, PendingIntent.class).invoke(alarmManager, 2, Long.valueOf(j), pendingIntent);
        } catch (Exception e) {
            AbstractC7535b.d("[Alarm] invoke setExact method meet error. " + e);
        }
    }

    @Override // com.xiaomi.push.eu.InterfaceC7648a
    public void a() {
        if (this.f320a != null) {
            try {
                ((AlarmManager) this.f321a.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(this.f320a);
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.f320a = null;
                AbstractC7535b.c("[Alarm] unregister timer");
                this.a = 0L;
                throw th;
            }
            this.f320a = null;
            AbstractC7535b.c("[Alarm] unregister timer");
            this.a = 0L;
        }
        this.a = 0L;
    }

    public void a(Intent intent, long j) {
        AlarmManager alarmManager = (AlarmManager) this.f321a.getSystemService(NotificationCompat.CATEGORY_ALARM);
        int i = Build.VERSION.SDK_INT;
        this.f320a = i >= 31 ? PendingIntent.getBroadcast(this.f321a, 0, intent, 33554432) : PendingIntent.getBroadcast(this.f321a, 0, intent, 0);
        if (i >= 23) {
            bk.a((Object) alarmManager, "setExactAndAllowWhileIdle", 2, Long.valueOf(j), this.f320a);
        } else {
            a(alarmManager, j, this.f320a);
        }
        AbstractC7535b.c("[Alarm] register timer " + j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0036, code lost:
        if (r8.a < r4) goto L17;
     */
    @Override // com.xiaomi.push.eu.InterfaceC7648a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(boolean r9) {
        /*
            r8 = this;
            android.content.Context r0 = r8.f321a
            com.xiaomi.push.service.o r0 = com.xiaomi.push.service.C7764o.a(r0)
            long r0 = r0.m1221a()
            r2 = 0
            if (r9 != 0) goto L15
            long r4 = r8.a
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 != 0) goto L15
            return
        L15:
            if (r9 == 0) goto L1a
            r8.a()
        L1a:
            long r4 = android.os.SystemClock.elapsedRealtime()
            if (r9 != 0) goto L39
            long r6 = r8.a
            int r9 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r9 != 0) goto L27
            goto L39
        L27:
            long r2 = r8.a
            int r9 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r9 > 0) goto L3f
            long r2 = r8.a
            long r2 = r2 + r0
            r8.a = r2
            long r2 = r8.a
            int r9 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r9 >= 0) goto L3f
            goto L3c
        L39:
            long r2 = r4 % r0
            long r0 = r0 - r2
        L3c:
            long r4 = r4 + r0
            r8.a = r4
        L3f:
            android.content.Intent r9 = new android.content.Intent
            java.lang.String r0 = com.xiaomi.push.service.bk.p
            r9.<init>(r0)
            android.content.Context r0 = r8.f321a
            java.lang.String r0 = r0.getPackageName()
            r9.setPackage(r0)
            long r0 = r8.a
            r8.a(r9, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.ev.a(boolean):void");
    }

    @Override // com.xiaomi.push.eu.InterfaceC7648a
    /* renamed from: a */
    public boolean mo873a() {
        return this.a != 0;
    }
}
