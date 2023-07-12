package com.alipay.sdk.m.c;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class e implements com.alipay.sdk.m.b.b {
    public static final String a = "content://cn.nubia.provider.deviceid.dataid/oaid";

    @Override // com.alipay.sdk.m.b.b
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        Cursor query = context.getContentResolver().query(Uri.parse(a), null, null, null, null);
        if (query != null) {
            r0 = query.moveToNext() ? query.getString(query.getColumnIndex("device_ids_grndid")) : null;
            query.close();
        }
        return r0;
    }
}
