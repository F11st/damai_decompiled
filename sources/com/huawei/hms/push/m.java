package com.huawei.hms.push;

import android.app.Notification;
import android.text.TextUtils;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class m {
    public static n a(k kVar) {
        n nVar = n.STYLE_DEFAULT;
        return (kVar.w() < 0 || kVar.w() >= n.values().length) ? nVar : n.values()[kVar.w()];
    }

    public static void a(Notification.Builder builder, String str, k kVar) {
        Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle();
        if (!TextUtils.isEmpty(kVar.h())) {
            bigTextStyle.setBigContentTitle(kVar.h());
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
