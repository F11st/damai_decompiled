package com.alipay.ma.util;

import com.alipay.ma.MaLogger;
import com.autonavi.amap.mapcore.tools.GlMapUtil;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public final class StringEncodeUtils {
    public static final boolean ASSUME_SHIFT_JIS;
    public static final String EUC_JP = "EUC_JP";
    public static final String GB2312 = "GB2312";
    public static final String ISO88591 = "ISO8859_1";
    public static final String SHIFT_JIS = "SJIS";
    public static final String TAG = "StringEncodeUtil";
    public static final String UTF8 = "UTF8";
    private static final String a;

    static {
        String property = System.getProperty("file.encoding");
        a = property;
        ASSUME_SHIFT_JIS = "SJIS".equalsIgnoreCase(property) || EUC_JP.equalsIgnoreCase(property);
    }

    private StringEncodeUtils() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002c, code lost:
        r5 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(byte[] r7) {
        /*
            r0 = 0
            r1 = 0
            r2 = 0
            r3 = 0
        L4:
            int r4 = r7.length
            r5 = 1
            if (r1 >= r4) goto L2d
            r4 = r7[r1]
            r4 = r4 & 255(0xff, float:3.57E-43)
            if (r2 != 0) goto L16
            r6 = r4 & 128(0x80, float:1.8E-43)
            if (r6 != 0) goto L13
            goto L29
        L13:
            r3 = r4
            r2 = 1
            goto L29
        L16:
            r2 = r3 & 255(0xff, float:3.57E-43)
            int r2 = r2 << 8
            r4 = r4 & 255(0xff, float:3.57E-43)
            r2 = r2 | r4
            r4 = 41377(0xa1a1, float:5.7982E-41)
            if (r2 < r4) goto L2c
            r4 = 65278(0xfefe, float:9.1474E-41)
            if (r2 > r4) goto L2c
            r2 = 0
            r3 = 0
        L29:
            int r1 = r1 + 1
            goto L4
        L2c:
            r5 = 0
        L2d:
            if (r3 == 0) goto L30
            goto L31
        L30:
            r0 = r5
        L31:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.ma.util.StringEncodeUtils.a(byte[]):boolean");
    }

    private static boolean b(byte[] bArr) {
        int length = bArr != null ? bArr.length : 0;
        int i = 0;
        boolean z = true;
        while (i < length && z) {
            int i2 = length - i;
            int i3 = bArr[i] & 255;
            int i4 = i2 > 1 ? bArr[i + 1] & 255 : 0;
            int i5 = i2 > 2 ? bArr[i + 2] & 255 : 0;
            int i6 = i2 > 3 ? bArr[i + 3] & 255 : 0;
            if ((i3 & 248) == 240 && (i4 & 192) == 128 && (i5 & 192) == 128 && (i6 & 192) == 128) {
                i += 4;
            } else if ((i3 & GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN) == 224 && (i4 & 192) == 128 && (i5 & 192) == 128) {
                i += 3;
            } else if ((i3 & 224) == 192 && (i4 & 192) == 128) {
                i += 2;
            } else if ((i3 & 128) == 0) {
                i++;
            } else {
                z = false;
            }
        }
        return z;
    }

    public static String getStringEncode(byte[] bArr, boolean z) {
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    return guessEncoding(bArr, z);
                }
                return null;
            } catch (Exception e) {
                MaLogger.e(TAG, e.getMessage());
                return null;
            }
        }
        return null;
    }

    public static String guessEncoding(byte[] bArr, boolean z) {
        int i;
        int length = bArr.length;
        boolean b = b(bArr);
        boolean a2 = !z ? a(bArr) : true;
        boolean z2 = true;
        boolean z3 = true;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < length && ((z && a2) || z2 || z3); i9++) {
            int i10 = bArr[i9] & 255;
            if (z && a2 && i10 > 127 && i10 > 176 && i10 <= 247 && (i = i9 + 1) < length) {
                int i11 = bArr[i] & 255;
                a2 = i11 > 160 && i11 <= 247;
            }
            if (z2) {
                if (i10 > 127 && i10 < 160) {
                    z2 = false;
                } else if (i10 > 159 && (i10 < 192 || i10 == 215 || i10 == 247)) {
                    i6++;
                }
            }
            if (z3) {
                if (i2 > 0) {
                    if (i10 >= 64 && i10 != 127 && i10 <= 252) {
                        i2--;
                    }
                    z3 = false;
                } else {
                    if (i10 != 128 && i10 != 160 && i10 <= 239) {
                        if (i10 <= 160 || i10 >= 224) {
                            if (i10 > 127) {
                                i2++;
                                i7++;
                                if (i7 > i4) {
                                    i4 = i7;
                                }
                            } else {
                                i7 = 0;
                            }
                            i8 = 0;
                        } else {
                            i5++;
                            i8++;
                            if (i8 > i3) {
                                i3 = i8;
                            }
                            i7 = 0;
                        }
                    }
                    z3 = false;
                }
            }
        }
        if (b) {
            return UTF8;
        }
        boolean z4 = (!z3 || i2 <= 0) ? z3 : false;
        return a2 ? "GB2312" : (!z4 || (!ASSUME_SHIFT_JIS && i3 < 3 && i4 < 3)) ? (z2 && z4) ? (!(i3 == 2 && i5 == 2) && i6 * 10 < length) ? ISO88591 : "SJIS" : z2 ? ISO88591 : z4 ? "SJIS" : a : "SJIS";
    }
}
