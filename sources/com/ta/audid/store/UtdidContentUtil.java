package com.ta.audid.store;

import android.text.TextUtils;
import com.ta.audid.utils.RC4;
import com.ta.audid.utils.UtdidLogger;
import com.ta.utdid2.android.utils.Base64;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class UtdidContentUtil {
    public static String getEncodedContent(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new String(Base64.encode(RC4.rc4(str.getBytes()), 2), "UTF-8");
        } catch (Exception e) {
            UtdidLogger.e("", e, new Object[0]);
            return "";
        }
    }
}
