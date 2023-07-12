package com.vivo.push.d;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.vivo.push.sdk.PushMessageCallback;
import com.vivo.push.util.NotifyAdapterUtil;
import java.security.PublicKey;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class z extends com.vivo.push.l {
    protected PushMessageCallback b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(com.vivo.push.o oVar) {
        super(oVar);
    }

    public final void a(PushMessageCallback pushMessageCallback) {
        this.b = pushMessageCallback;
    }

    public final int b() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            NotificationManager notificationManager = (NotificationManager) this.a.getSystemService("notification");
            if (notificationManager == null || notificationManager.areNotificationsEnabled()) {
                if (i < 26 || notificationManager == null) {
                    return 0;
                }
                try {
                    NotificationChannel notificationChannel = notificationManager.getNotificationChannel(NotifyAdapterUtil.PRIMARY_CHANNEL);
                    if (notificationChannel != null) {
                        return notificationChannel.getImportance() == 0 ? 2121 : 0;
                    }
                    return 0;
                } catch (Exception unused) {
                    com.vivo.push.util.p.b("OnVerifyCallBackCommand", "判断通知通道出现系统错误");
                    return 0;
                }
            }
            return 2104;
        }
        return 0;
    }

    public final boolean a(PublicKey publicKey, String str, String str2) {
        if (!com.vivo.push.e.a().d()) {
            com.vivo.push.util.p.d("OnVerifyCallBackCommand", "vertify is not support , vertify is ignore");
            return true;
        } else if (publicKey == null) {
            com.vivo.push.util.p.d("OnVerifyCallBackCommand", "vertify key is null");
            return false;
        } else if (TextUtils.isEmpty(str)) {
            com.vivo.push.util.p.d("OnVerifyCallBackCommand", "contentTag is null");
            return false;
        } else if (!TextUtils.isEmpty(str2)) {
            try {
                com.vivo.push.util.p.d("OnVerifyCallBackCommand", str.hashCode() + " = " + str2);
                if (com.vivo.push.util.u.a(str.getBytes("UTF-8"), publicKey, Base64.decode(str2, 2))) {
                    com.vivo.push.util.p.d("OnVerifyCallBackCommand", "vertify id is success");
                    return true;
                }
                com.vivo.push.util.p.d("OnVerifyCallBackCommand", "vertify fail srcDigest is ".concat(str));
                com.vivo.push.util.p.c(this.a, "vertify fail srcDigest is ".concat(str));
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                com.vivo.push.util.p.d("OnVerifyCallBackCommand", "vertify exception");
                return false;
            }
        } else {
            com.vivo.push.util.p.d("OnVerifyCallBackCommand", "vertify id is null");
            return false;
        }
    }
}
