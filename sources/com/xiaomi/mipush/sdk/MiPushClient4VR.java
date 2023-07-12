package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.hj;
import com.xiaomi.push.ht;
import com.xiaomi.push.hw;
import com.xiaomi.push.ii;
import com.xiaomi.push.service.bd;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MiPushClient4VR {
    public static void uploadData(Context context, String str) {
        ii iiVar = new ii();
        iiVar.c(ht.VRUpload.f497a);
        iiVar.b(b.m629a(context).m630a());
        iiVar.d(context.getPackageName());
        iiVar.a("data", str);
        iiVar.a(bd.a());
        ao.a(context).a((ao) iiVar, hj.Notification, (hw) null);
    }
}
