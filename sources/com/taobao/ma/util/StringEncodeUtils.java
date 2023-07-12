package com.taobao.ma.util;

import android.text.TextUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class StringEncodeUtils {
    private static final boolean ASSUME_SHIFT_JIS;
    private static final String EUC_JP = "EUC_JP";
    public static final String GB2312 = "GB2312";
    private static final String ISO88591 = "ISO8859_1";
    private static final String PLATFORM_DEFAULT_ENCODING;
    public static final String SHIFT_JIS = "SJIS";
    private static final String UTF8 = "UTF8";

    static {
        String property = System.getProperty("file.encoding");
        PLATFORM_DEFAULT_ENCODING = property;
        ASSUME_SHIFT_JIS = "SJIS".equalsIgnoreCase(property) || "EUC_JP".equalsIgnoreCase(property);
    }

    private StringEncodeUtils() {
    }

    public static String getStringEncode(byte[] bArr) {
        String str = null;
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    str = guessEncoding(bArr);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return TextUtils.isEmpty(str) ? "" : str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x0081, code lost:
        if (r5 <= 127) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0085, code lost:
        if (r5 >= 160) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0087, code lost:
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x008b, code lost:
        if (r5 <= 159) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x008f, code lost:
        if (r5 < 192) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String guessEncoding(byte[] r18) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.ma.util.StringEncodeUtils.guessEncoding(byte[]):java.lang.String");
    }
}
