package com.vivo.push.util;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class e {
    public static boolean a(Context context, long j, long j2) {
        p.d("ClientReportUtil", "report message: " + j + ", reportType: " + j2);
        com.vivo.push.b.x xVar = new com.vivo.push.b.x(j2);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("messageID", String.valueOf(j));
        String b = z.b(context, context.getPackageName());
        if (!TextUtils.isEmpty(b)) {
            hashMap.put("remoteAppId", b);
        }
        xVar.a(hashMap);
        com.vivo.push.e.a().a(xVar);
        return true;
    }

    public static boolean a(long j, HashMap<String, String> hashMap) {
        com.vivo.push.b.x xVar = new com.vivo.push.b.x(j);
        xVar.a(hashMap);
        xVar.d();
        com.vivo.push.e.a().a(xVar);
        return true;
    }
}
