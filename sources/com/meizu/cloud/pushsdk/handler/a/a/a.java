package com.meizu.cloud.pushsdk.handler.a.a;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSettingEx;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class a {
    private Context a;
    private com.meizu.cloud.pushsdk.b.a.a b;
    private int c;
    private Notification d;

    public a(Context context) {
        this.a = context;
    }

    private void a(int i, Notification notification) {
        this.c = i;
        this.d = notification;
    }

    private void b() {
        this.c = 0;
        this.d = null;
        com.meizu.cloud.pushsdk.b.a.a aVar = this.b;
        try {
            if (aVar != null) {
                try {
                    aVar.b();
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
        com.meizu.cloud.pushsdk.b.a.a aVar = this.b;
        if (aVar != null) {
            try {
                try {
                    aVar.b();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } finally {
                this.b = null;
            }
        }
        com.meizu.cloud.pushsdk.b.a.a aVar2 = new com.meizu.cloud.pushsdk.b.a.a(this.a, new Runnable() { // from class: com.meizu.cloud.pushsdk.handler.a.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                DebugLogger.d("AdNotification", "ad priority valid time out");
                a.this.a();
            }
        }, i * 60 * 1000);
        this.b = aVar2;
        aVar2.a();
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
