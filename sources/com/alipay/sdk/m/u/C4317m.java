package com.alipay.sdk.m.u;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.alipay.sdk.app.EnvUtils;
import com.alipay.sdk.m.l.C4230a;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.u.m */
/* loaded from: classes10.dex */
public class C4317m {
    public static final String a = "content://com.alipay.android.app.settings.data.ServerProvider/current_server";

    public static String a(Context context) {
        Cursor query = context.getContentResolver().query(Uri.parse(a), null, null, null, null);
        if (query != null && query.getCount() > 0) {
            r0 = query.moveToFirst() ? query.getString(query.getColumnIndex("url")) : null;
            query.close();
        }
        return r0;
    }

    public static String b(Context context) {
        if (EnvUtils.isSandBox()) {
            return C4230a.b;
        }
        if (context == null) {
            return C4230a.a;
        }
        String str = C4230a.a;
        return TextUtils.isEmpty(str) ? C4230a.a : str;
    }
}
