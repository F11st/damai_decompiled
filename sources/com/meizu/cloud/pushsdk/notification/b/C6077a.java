package com.meizu.cloud.pushsdk.notification.b;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.notification.PushNotificationBuilder;
import com.meizu.cloud.pushsdk.notification.c.C6083c;
import com.meizu.cloud.pushsdk.util.MinSdkChecker;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.notification.b.a */
/* loaded from: classes10.dex */
public class C6077a extends C6079c {
    public C6077a(Context context, PushNotificationBuilder pushNotificationBuilder) {
        super(context, pushNotificationBuilder);
    }

    private void b(RemoteViews remoteViews, MessageV3 messageV3) {
        Bitmap a;
        if (messageV3.getNotificationStyle() == null || a()) {
            return;
        }
        if (TextUtils.isEmpty(messageV3.getNotificationStyle().getExpandableImageUrl()) || (a = a(messageV3.getNotificationStyle().getExpandableImageUrl())) == null) {
            remoteViews.setViewVisibility(C6083c.g(this.a), 8);
            return;
        }
        remoteViews.setViewVisibility(C6083c.g(this.a), 0);
        remoteViews.setImageViewBitmap(C6083c.g(this.a), a);
    }

    @Override // com.meizu.cloud.pushsdk.notification.AbstractC6071a
    protected void a(Notification notification, MessageV3 messageV3, PendingIntent pendingIntent) {
        if (MinSdkChecker.isSupportNotificationBuild()) {
            RemoteViews remoteViews = new RemoteViews(this.a.getPackageName(), C6083c.a(this.a));
            remoteViews.setTextViewText(C6083c.d(this.a), messageV3.getTitle());
            remoteViews.setTextViewText(C6083c.e(this.a), messageV3.getContent());
            remoteViews.setLong(C6083c.f(this.a), "setTime", System.currentTimeMillis());
            a(remoteViews, messageV3);
            b(remoteViews, messageV3);
            notification.bigContentView = remoteViews;
        }
    }
}
