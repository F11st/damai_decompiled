package com.meizu.cloud.pushsdk.notification.a;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.notification.PushNotificationBuilder;
import com.meizu.cloud.pushsdk.util.MinSdkChecker;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class a extends c {
    public a(Context context, PushNotificationBuilder pushNotificationBuilder) {
        super(context, pushNotificationBuilder);
    }

    @Override // com.meizu.cloud.pushsdk.notification.a
    protected void a(Notification.Builder builder, MessageV3 messageV3) {
        Bitmap a;
        if (MinSdkChecker.isSupportNotificationBuild()) {
            Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle();
            if (messageV3.getNotificationStyle() == null || a() || TextUtils.isEmpty(messageV3.getNotificationStyle().getExpandableImageUrl()) || (a = a(messageV3.getNotificationStyle().getExpandableImageUrl())) == null) {
                return;
            }
            bigPictureStyle.setBigContentTitle(messageV3.getTitle());
            bigPictureStyle.bigPicture(a);
            builder.setStyle(bigPictureStyle);
        }
    }
}
