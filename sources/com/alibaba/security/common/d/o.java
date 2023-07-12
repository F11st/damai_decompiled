package com.alibaba.security.common.d;

import android.util.Base64;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.taobao.weex.common.Constants;
import com.taobao.weex.ui.component.WXComponent;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class o {
    public static String a = "";
    private static final String[] b = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", com.huawei.hms.opendevice.c.a, "d", "e", "f", "g", "h", "i", "j", "k", NotifyType.LIGHTS, WXComponent.PROP_FS_MATCH_PARENT, "n", "o", "p", "q", UploadQueueMgr.MSGTYPE_REALTIME, "s", "t", IRequestConst.U, "v", WXComponent.PROP_FS_WRAP_CONTENT, Constants.Name.X, Constants.Name.Y, "z"};

    public static byte[] a(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        String upperCase = str.toUpperCase();
        int length = upperCase.length() / 2;
        char[] charArray = upperCase.toCharArray();
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (((byte) "0123456789abcdef".indexOf(charArray[i2 + 1])) | (((byte) "0123456789abcdef".indexOf(charArray[i2])) << 4));
        }
        return bArr;
    }

    private static String b(byte[] bArr) {
        if (bArr == 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i : bArr) {
            if (i < 0) {
                i += 256;
            }
            String[] strArr = b;
            stringBuffer.append(strArr[i / 16]);
            stringBuffer.append(strArr[i % 16]);
        }
        return stringBuffer.toString();
    }

    private static byte a(char c) {
        return (byte) "0123456789abcdef".indexOf(c);
    }

    public static String a(byte[] bArr) {
        return bArr == null ? "" : Base64.encodeToString(bArr, 2);
    }
}
