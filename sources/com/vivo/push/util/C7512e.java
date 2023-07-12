package com.vivo.push.util;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.C7481e;
import com.vivo.push.b.C7436x;
import java.util.HashMap;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.util.e */
/* loaded from: classes11.dex */
public final class C7512e {
    public static boolean a(Context context, long j, long j2) {
        C7523p.d("ClientReportUtil", "report message: " + j + ", reportType: " + j2);
        C7436x c7436x = new C7436x(j2);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("messageID", String.valueOf(j));
        String b = C7533z.b(context, context.getPackageName());
        if (!TextUtils.isEmpty(b)) {
            hashMap.put("remoteAppId", b);
        }
        c7436x.a(hashMap);
        C7481e.a().a(c7436x);
        return true;
    }

    public static boolean a(long j, HashMap<String, String> hashMap) {
        C7436x c7436x = new C7436x(j);
        c7436x.a(hashMap);
        c7436x.d();
        C7481e.a().a(c7436x);
        return true;
    }
}
