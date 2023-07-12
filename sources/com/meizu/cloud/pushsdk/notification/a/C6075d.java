package com.meizu.cloud.pushsdk.notification.a;

import android.app.Notification;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import com.alibaba.security.realidentity.jsbridge.AbstractC3893a;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.c.C5943a;
import com.meizu.cloud.pushsdk.d.b.a.C6005b;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.handler.MessageV4;
import com.meizu.cloud.pushsdk.notification.PushNotificationBuilder;
import com.meizu.cloud.pushsdk.notification.c.C6081a;
import com.meizu.cloud.pushsdk.notification.c.C6085e;
import com.meizu.cloud.pushsdk.util.C6101a;
import com.meizu.cloud.pushsdk.util.MinSdkChecker;
import java.io.File;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.notification.a.d */
/* loaded from: classes10.dex */
public class C6075d extends C6074c {
    public C6075d(Context context, PushNotificationBuilder pushNotificationBuilder) {
        super(context, pushNotificationBuilder);
    }

    @Override // com.meizu.cloud.pushsdk.notification.AbstractC6071a
    protected void a(Notification.Builder builder, MessageV3 messageV3) {
        if (MinSdkChecker.isSupportNotificationBuild()) {
            Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle();
            bigTextStyle.setBigContentTitle(messageV3.getTitle());
            bigTextStyle.bigText(messageV3.getNotificationStyle().getExpandableText());
            builder.setStyle(bigTextStyle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.notification.AbstractC6071a
    public void a(Notification notification, MessageV3 messageV3) {
        super.a(notification, messageV3);
        MessageV4 parse = MessageV4.parse(messageV3);
        if (parse.getActVideoSetting() == null) {
            DebugLogger.e("AbstractPushNotification", "only wifi can download act");
        } else if (parse.getActVideoSetting().isWifiDisplay() && !C6101a.b(this.a)) {
            DebugLogger.e("AbstractPushNotification", "only wifi can download act");
        } else {
            final String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/pushSdkAct/" + messageV3.getUploadDataPackageName();
            String valueOf = String.valueOf(System.currentTimeMillis());
            String actUrl = parse.getActVideoSetting().getActUrl();
            if (!TextUtils.isEmpty(actUrl) && C5943a.a(actUrl, str, valueOf).a().c().b()) {
                DebugLogger.i("AbstractPushNotification", "down load " + actUrl + " success");
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                String str2 = File.separator;
                sb.append(str2);
                sb.append("ACT-");
                sb.append(valueOf);
                String sb2 = sb.toString();
                boolean a = new C6085e(str + str2 + valueOf, sb2).a();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("zip file ");
                sb3.append(a);
                DebugLogger.i("AbstractPushNotification", sb3.toString());
                if (a) {
                    Bundle bundle = new Bundle();
                    bundle.putString(AbstractC3893a.V, sb2);
                    Bundle bundle2 = new Bundle();
                    bundle2.putBundle("big", bundle);
                    if (MinSdkChecker.isSupportVideoNotification()) {
                        notification.extras.putBundle("flyme.active", bundle2);
                    }
                }
            }
            C6005b.a(new Runnable() { // from class: com.meizu.cloud.pushsdk.notification.a.d.1
                @Override // java.lang.Runnable
                public void run() {
                    File[] b;
                    for (File file : C6081a.b(str, String.valueOf(System.currentTimeMillis() - 86400000))) {
                        C6081a.b(file.getPath());
                        DebugLogger.i("AbstractPushNotification", "Delete file directory " + file.getName() + StringUtils.LF);
                    }
                }
            });
        }
    }
}
