package com.huawei.hms.push;

import android.app.Notification;
import android.text.TextUtils;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.push.m */
/* loaded from: classes10.dex */
public class C5692m {
    public static EnumC5693n a(C5690k c5690k) {
        EnumC5693n enumC5693n = EnumC5693n.STYLE_DEFAULT;
        return (c5690k.w() < 0 || c5690k.w() >= EnumC5693n.values().length) ? enumC5693n : EnumC5693n.values()[c5690k.w()];
    }

    public static void a(Notification.Builder builder, String str, C5690k c5690k) {
        Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle();
        if (!TextUtils.isEmpty(c5690k.h())) {
            bigTextStyle.setBigContentTitle(c5690k.h());
        }
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            bigTextStyle.bigText(str);
        }
        builder.setStyle(bigTextStyle);
    }
}
