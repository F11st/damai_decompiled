package com.alipay.sdk.m.c;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.alipay.sdk.m.b.InterfaceC4143b;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.c.e */
/* loaded from: classes10.dex */
public class C4158e implements InterfaceC4143b {
    public static final String a = "content://cn.nubia.provider.deviceid.dataid/oaid";

    @Override // com.alipay.sdk.m.b.InterfaceC4143b
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
