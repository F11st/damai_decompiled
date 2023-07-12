package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.text.SimpleDateFormat;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class co {
    private static String a;

    /* renamed from: a  reason: collision with other field name */
    private static SimpleDateFormat f169a;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        f169a = simpleDateFormat;
        a = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    }

    public static C7672hn a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C7672hn c7672hn = new C7672hn();
        c7672hn.d("category_push_stat");
        c7672hn.a("push_sdk_stat_channel");
        c7672hn.a(1L);
        c7672hn.b(str);
        c7672hn.a(true);
        c7672hn.b(System.currentTimeMillis());
        c7672hn.g(bx.a(context).m714a());
        c7672hn.e("com.xiaomi.xmsf");
        c7672hn.f("");
        c7672hn.c("push_stat");
        return c7672hn;
    }
}
