package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.l;
import com.xiaomi.push.bk;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ak {
    public static AbstractPushManager a(Context context, e eVar) {
        return b(context, eVar);
    }

    private static AbstractPushManager b(Context context, e eVar) {
        l.a m655a = l.m655a(eVar);
        if (m655a == null || TextUtils.isEmpty(m655a.a) || TextUtils.isEmpty(m655a.b)) {
            return null;
        }
        return (AbstractPushManager) bk.a(m655a.a, m655a.b, context);
    }
}
