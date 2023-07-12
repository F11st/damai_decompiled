package com.meizu.cloud.pushsdk.notification.b;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.notification.AbstractC6071a;
import com.meizu.cloud.pushsdk.notification.PushNotificationBuilder;
import com.meizu.cloud.pushsdk.notification.c.C6083c;
import com.meizu.cloud.pushsdk.util.MinSdkChecker;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.notification.b.c */
/* loaded from: classes10.dex */
public class C6079c extends AbstractC6071a {
    public C6079c(Context context, PushNotificationBuilder pushNotificationBuilder) {
        super(context, pushNotificationBuilder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.notification.AbstractC6071a
    public void a(Notification notification, MessageV3 messageV3) {
        if (MinSdkChecker.isSupportNotificationBuild()) {
            RemoteViews remoteViews = new RemoteViews(this.a.getPackageName(), C6083c.a(this.a));
            remoteViews.setTextViewText(C6083c.d(this.a), messageV3.getTitle());
            remoteViews.setTextViewText(C6083c.e(this.a), messageV3.getContent());
            remoteViews.setLong(C6083c.f(this.a), "setTime", System.currentTimeMillis());
            a(remoteViews, messageV3);
            remoteViews.setViewVisibility(C6083c.g(this.a), 8);
            remoteViews.setViewVisibility(C6083c.h(this.a), 8);
            notification.contentView = remoteViews;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(RemoteViews remoteViews, MessageV3 messageV3) {
        Bitmap a;
        if (messageV3.getAppIconSetting() == null || a() || messageV3.getAppIconSetting().isDefaultLargeIcon() || (a = a(messageV3.getAppIconSetting().getLargeIconUrl())) == null) {
            remoteViews.setImageViewBitmap(C6083c.k(this.a), a(this.a, messageV3.getUploadDataPackageName()));
        } else {
            remoteViews.setImageViewBitmap(C6083c.k(this.a), a);
        }
    }
}
