package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.C7575l;
import com.xiaomi.push.bk;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ak {
    public static AbstractPushManager a(Context context, EnumC7568e enumC7568e) {
        return b(context, enumC7568e);
    }

    private static AbstractPushManager b(Context context, EnumC7568e enumC7568e) {
        C7575l.C7576a m655a = C7575l.m655a(enumC7568e);
        if (m655a == null || TextUtils.isEmpty(m655a.a) || TextUtils.isEmpty(m655a.b)) {
            return null;
        }
        return (AbstractPushManager) bk.a(m655a.a, m655a.b, context);
    }
}
