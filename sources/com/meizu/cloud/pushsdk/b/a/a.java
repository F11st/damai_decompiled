package com.meizu.cloud.pushsdk.b.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.meizu.cloud.pushinternal.DebugLogger;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class a {
    private AlarmManager a;
    private Context b;
    private Runnable c;
    private long d;
    private int e;
    private C0257a f;
    private PendingIntent g;
    private String h;
    private boolean i;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.meizu.cloud.pushsdk.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0257a extends BroadcastReceiver {
        private C0257a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || !intent.getAction().equals("alarm.util")) {
                return;
            }
            DebugLogger.i("AlarmUtils", "on receive delayed task, keyword: " + a.this.h);
            a.this.i = true;
            a.this.c();
            a.this.c.run();
        }
    }

    public a(Context context, Runnable runnable, long j) {
        this(context, runnable, j, true);
    }

    public a(Context context, Runnable runnable, long j, boolean z) {
        Context applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        this.c = runnable;
        this.d = j;
        this.e = !z ? 1 : 0;
        this.a = (AlarmManager) applicationContext.getSystemService(NotificationCompat.CATEGORY_ALARM);
        this.i = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            C0257a c0257a = this.f;
            if (c0257a != null) {
                this.b.unregisterReceiver(c0257a);
                this.f = null;
            }
        } catch (Exception e) {
            DebugLogger.e("AlarmUtils", "clean error, " + e.getMessage());
        }
    }

    public boolean a() {
        if (!this.i) {
            DebugLogger.e("AlarmUtils", "last task not completed");
            return false;
        }
        this.i = false;
        C0257a c0257a = new C0257a();
        this.f = c0257a;
        this.b.registerReceiver(c0257a, new IntentFilter("alarm.util"));
        this.h = String.valueOf(System.currentTimeMillis());
        this.g = PendingIntent.getBroadcast(this.b, 0, new Intent("alarm.util"), 1073741824);
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            this.a.setExactAndAllowWhileIdle(this.e, System.currentTimeMillis() + this.d, this.g);
        } else if (i >= 19) {
            this.a.setExact(this.e, System.currentTimeMillis() + this.d, this.g);
        } else {
            this.a.set(this.e, System.currentTimeMillis() + this.d, this.g);
        }
        DebugLogger.i("AlarmUtils", "start delayed task, keyword: " + this.h);
        return true;
    }

    public void b() {
        if (this.a != null && this.g != null && !this.i) {
            DebugLogger.i("AlarmUtils", "cancel  delayed task, keyword: " + this.h);
            this.a.cancel(this.g);
        }
        c();
    }
}
