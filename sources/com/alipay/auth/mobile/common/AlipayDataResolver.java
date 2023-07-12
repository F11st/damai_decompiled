package com.alipay.auth.mobile.common;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class AlipayDataResolver {
    private ContentResolver a;

    public AlipayDataResolver(Context context) {
        this.a = context.getContentResolver();
    }

    public int getAlipayAuthLoginSupportVersion(int i) {
        try {
            Cursor query = this.a.query(Uri.parse("content://com.alipay.ali.authlogin/auth_login_sdk_version"), null, null, null, null);
            if (query == null) {
                LoggerUtils.d("AlipayDataResolver", "getAlipayAuthLoginSupportVersion cursor == null");
                return i;
            }
            int intValue = query.moveToFirst() ? Integer.valueOf(query.getString(0)).intValue() : i;
            query.close();
            LoggerUtils.d("AlipayDataResolver", "getAlipayAuthLoginSupportVersion result=" + intValue);
            return intValue;
        } catch (Exception e) {
            LoggerUtils.e("AlipayDataResolver", "getAlipayAuthLoginSupportVersion error", e);
            return i;
        }
    }
}
