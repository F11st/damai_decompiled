package com.meizu.cloud.pushsdk.handler.a.a;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.b.a.C5918a;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSettingEx;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.handler.a.a.a */
/* loaded from: classes10.dex */
public class C6035a {
    private Context a;
    private C5918a b;
    private int c;
    private Notification d;

    public C6035a(Context context) {
        this.a = context;
    }

    private void a(int i, Notification notification) {
        this.c = i;
        this.d = notification;
    }

    private void b() {
        this.c = 0;
        this.d = null;
        C5918a c5918a = this.b;
        try {
            if (c5918a != null) {
                try {
                    c5918a.b();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } finally {
            this.b = null;
        }
    }

    private void b(int i) {
        if (i <= 0) {
            return;
        }
        C5918a c5918a = this.b;
        if (c5918a != null) {
            try {
                try {
                    c5918a.b();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } finally {
                this.b = null;
            }
        }
        C5918a c5918a2 = new C5918a(this.a, new Runnable() { // from class: com.meizu.cloud.pushsdk.handler.a.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                DebugLogger.d("AdNotification", "ad priority valid time out");
                C6035a.this.a();
            }
        }, i * 60 * 1000);
        this.b = c5918a2;
        c5918a2.a();
    }

    public void a() {
        if (this.c <= 0 || this.d == null) {
            return;
        }
        try {
            ((NotificationManager) this.a.getSystemService("notification")).notify(this.c, this.d);
            DebugLogger.d("AdNotification", "again show old ad notification, notifyId:" + this.c);
        } catch (Exception e) {
            e.printStackTrace();
            DebugLogger.e("AdNotification", "again show old ad notification error:" + e.getMessage());
        }
        b();
    }

    public void a(int i) {
        int i2;
        if (i <= 0 || (i2 = this.c) <= 0 || i != i2) {
            return;
        }
        b();
        DebugLogger.d("AdNotification", "clean ad notification, notifyId:" + i);
    }

    public void a(int i, Notification notification, int i2) {
        if (i <= 0 || notification == null) {
            return;
        }
        a(i, notification);
        b(i2);
        DebugLogger.d("AdNotification", "save ad notification, notifyId:" + i);
    }

    public void a(MessageV3 messageV3) {
        AdvanceSetting advanceSetting = messageV3.getAdvanceSetting();
        if (advanceSetting != null) {
            advanceSetting.getNotifyType().setSound(false);
            advanceSetting.getNotifyType().setLights(false);
            advanceSetting.getNotifyType().setVibrate(false);
        }
        AdvanceSettingEx advanceSettingEx = messageV3.getAdvanceSettingEx();
        if (advanceSettingEx != null) {
            advanceSettingEx.setSoundTitle(null);
            if (Build.VERSION.SDK_INT < 29 || advanceSetting == null || !advanceSetting.isHeadUpNotification()) {
                advanceSettingEx.setPriorityDisplay(0);
            } else {
                advanceSettingEx.setPriorityDisplay(1);
            }
        }
    }
}
