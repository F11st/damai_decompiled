package com.alipay.share.sdk.openapi.channel;

import com.alipay.share.sdk.Constant;
import com.alipay.share.sdk.openapi.algorithm.MD5;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class MMessageUtil {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] a(String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        if (str != null) {
            stringBuffer.append(str);
        }
        stringBuffer.append(Constant.SDK_VERSION);
        stringBuffer.append(str2);
        stringBuffer.append("alipay");
        return MD5.getMessageDigest(stringBuffer.toString().substring(1, 9).getBytes()).getBytes();
    }
}
