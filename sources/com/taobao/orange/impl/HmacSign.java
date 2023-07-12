package com.taobao.orange.impl;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.orange.inner.ISign;
import com.taobao.orange.util.OLog;
import com.youku.upsplayer.util.YKUpsConvert;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class HmacSign implements ISign {
    private static final char[] DIGITS = {YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final String HMAC_SHA1 = "HmacSHA1";
    private static final String TAG = "HmacSign";

    private char[] encodeHex(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length << 1];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i + 1;
            char[] cArr2 = DIGITS;
            cArr[i] = cArr2[(bArr[i2] & 240) >>> 4];
            i = i3 + 1;
            cArr[i3] = cArr2[bArr[i2] & 15];
        }
        return cArr;
    }

    private String hmacSha1(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                Mac mac = Mac.getInstance(HMAC_SHA1);
                mac.init(new SecretKeySpec(str2.getBytes("utf-8"), HMAC_SHA1));
                char[] encodeHex = encodeHex(mac.doFinal(str.getBytes("utf-8")));
                if (encodeHex != null) {
                    return new String(encodeHex);
                }
                return null;
            } catch (Exception e) {
                OLog.e(TAG, "hmacSha1", e, new Object[0]);
            }
        }
        return null;
    }

    @Override // com.taobao.orange.inner.ISign
    public String sign(Context context, String str, String str2, String str3, String str4) {
        return hmacSha1(str3, str2);
    }
}
