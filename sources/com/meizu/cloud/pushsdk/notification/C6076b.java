package com.meizu.cloud.pushsdk.notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.notification.b.C6079c;
import com.meizu.cloud.pushsdk.notification.c.C6083c;
import com.meizu.cloud.pushsdk.notification.model.styleenum.InnerStyleLayout;
import com.meizu.cloud.pushsdk.util.MinSdkChecker;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.notification.b */
/* loaded from: classes10.dex */
public class C6076b extends C6079c {
    public C6076b(Context context, PushNotificationBuilder pushNotificationBuilder) {
        super(context, pushNotificationBuilder);
    }

    @Override // com.meizu.cloud.pushsdk.notification.AbstractC6071a
    protected void a(Notification notification, MessageV3 messageV3, PendingIntent pendingIntent) {
        if (MinSdkChecker.isSupportNotificationBuild()) {
            Bitmap a = a(messageV3.getNotificationStyle().getBannerImageUrl());
            if (a() || a == null) {
                return;
            }
            RemoteViews remoteViews = new RemoteViews(this.a.getPackageName(), C6083c.c(this.a));
            remoteViews.setImageViewBitmap(C6083c.i(this.a), a);
            remoteViews.setViewVisibility(C6083c.j(this.a), 8);
            remoteViews.setViewVisibility(C6083c.i(this.a), 0);
            notification.contentView = remoteViews;
            if (messageV3.getNotificationStyle().getInnerStyle() == InnerStyleLayout.EXPANDABLE_PIC.getCode()) {
                Bitmap a2 = a(messageV3.getNotificationStyle().getExpandableImageUrl());
                if (a() || a2 == null) {
                    return;
                }
                RemoteViews remoteViews2 = new RemoteViews(this.a.getPackageName(), C6083c.c(this.a));
                remoteViews2.setImageViewBitmap(C6083c.j(this.a), a2);
                remoteViews2.setViewVisibility(C6083c.j(this.a), 0);
                remoteViews2.setViewVisibility(C6083c.i(this.a), 8);
                notification.bigContentView = remoteViews2;
                if (messageV3.getAdvertisementOption() == null || TextUtils.isEmpty(messageV3.getAdvertisementOption().getAdInstallPackage())) {
                    return;
                }
                remoteViews2.setViewVisibility(C6083c.m(this.a), 0);
                remoteViews2.setOnClickPendingIntent(C6083c.m(this.a), pendingIntent);
            }
        }
    }
}