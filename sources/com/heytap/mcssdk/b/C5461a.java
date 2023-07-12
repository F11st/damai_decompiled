package com.heytap.mcssdk.b;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.pushsdk.R$string;
import tb.o73;
import tb.u63;

/* compiled from: Taobao */
/* renamed from: com.heytap.mcssdk.b.a */
/* loaded from: classes10.dex */
public class C5461a {
    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(26)
    public boolean b(Context context, String str, String str2, int i) {
        NotificationManager notificationManager;
        if (context == null || (notificationManager = (NotificationManager) context.getSystemService("notification")) == null) {
            return false;
        }
        notificationManager.createNotificationChannel(new NotificationChannel(str, str2, i));
        return true;
    }

    public void a(final Context context) {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        o73.a(new Runnable() { // from class: com.heytap.mcssdk.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (u63.f().c()) {
                    return;
                }
                String string = context.getString(R$string.system_default_channel);
                if (TextUtils.isEmpty(string)) {
                    string = "System Default Channel";
                }
                u63.f().b(C5461a.this.b(context, "Heytap PUSH", string, 3));
            }
        });
    }
}
