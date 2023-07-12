package com.youku.live.dago.widgetlib.interactive.resource.utils;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.upsplayer.util.YKUpsConvert;
import java.security.MessageDigest;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import tb.qb1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class YKLMD5Utils {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final char[] DIGITS_LOWER = {YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final char[] DIGITS_UPPER = {YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, YKUpsConvert.CHAR_A, 'B', 'C', qb1.LEVEL_D, qb1.LEVEL_E, YKUpsConvert.CHAR_F};

    public static char[] encodeHex(byte[] bArr) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-436770933") ? (char[]) ipChange.ipc$dispatch("-436770933", new Object[]{bArr}) : encodeHex(bArr, true);
    }

    public static String md5(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1963109187")) {
            return (String) ipChange.ipc$dispatch("1963109187", new Object[]{str});
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new String(encodeHex(MessageDigest.getInstance(MessageDigestAlgorithms.MD5).digest(str.getBytes("utf-8"))));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static char[] encodeHex(byte[] bArr, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-653584515")) {
            return (char[]) ipChange.ipc$dispatch("-653584515", new Object[]{bArr, Boolean.valueOf(z)});
        }
        return encodeHex(bArr, z ? DIGITS_LOWER : DIGITS_UPPER);
    }

    protected static char[] encodeHex(byte[] bArr, char[] cArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1215367363")) {
            return (char[]) ipChange.ipc$dispatch("1215367363", new Object[]{bArr, cArr});
        }
        int length = bArr.length;
        char[] cArr2 = new char[length << 1];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i + 1;
            cArr2[i] = cArr[(bArr[i2] & 240) >>> 4];
            i = i3 + 1;
            cArr2[i3] = cArr[bArr[i2] & 15];
        }
        return cArr2;
    }
}
