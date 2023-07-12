package com.meizu.cloud.pushsdk.b;

import com.youku.upsplayer.util.YKUpsConvert;
import org.apache.commons.lang3.CharUtils;
import tb.jn1;
import tb.qb1;
import tb.r10;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.b.d */
/* loaded from: classes10.dex */
class C5935d {
    private static final char[] a = {YKUpsConvert.CHAR_A, 'B', 'C', qb1.LEVEL_D, qb1.LEVEL_E, YKUpsConvert.CHAR_F, 'G', 'H', qb1.LEVEL_I, 'J', 'K', qb1.LEVEL_L, 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', qb1.LEVEL_V, qb1.LEVEL_W, 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, '+', r10.DIR};
    private static final char b = (char) Integer.parseInt("00000011", 2);
    private static final char c = (char) Integer.parseInt("00001111", 2);
    private static final char d = (char) Integer.parseInt("00111111", 2);
    private final String e;
    private char[] f;
    private int g = 0;

    public C5935d(String str) {
        this.e = str;
        a();
    }

    private void a() {
        char[] cArr = new char[a.length];
        int i = 0;
        this.g = this.e.charAt(0) % CharUtils.CR;
        while (true) {
            char[] cArr2 = a;
            if (i >= cArr2.length) {
                this.f = cArr;
                return;
            } else {
                cArr[i] = cArr2[(this.g + i) % cArr2.length];
                i++;
            }
        }
    }

    public String a(byte[] bArr) {
        String str;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder(((bArr.length + 2) / 3) * 4);
        int i = 0;
        int length = bArr.length;
        while (i < length) {
            int i2 = i + 1;
            int i3 = bArr[i] & 255;
            if (i2 == length) {
                sb.append(this.f[i3 >>> 2]);
                sb.append(this.f[(i3 & b) << 4]);
                str = jn1.EQUAL2;
            } else {
                int i4 = i2 + 1;
                int i5 = bArr[i2] & 255;
                if (i4 == length) {
                    sb.append(this.f[i3 >>> 2]);
                    sb.append(this.f[((i3 & b) << 4) | (i5 >>> 4)]);
                    sb.append(this.f[(c & i5) << 2]);
                    str = "=";
                } else {
                    int i6 = i4 + 1;
                    int i7 = bArr[i4] & 255;
                    sb.append(this.f[i3 >>> 2]);
                    sb.append(this.f[((i3 & b) << 4) | (i5 >>> 4)]);
                    sb.append(this.f[((i5 & c) << 2) | (i7 >>> 6)]);
                    sb.append(this.f[d & i7]);
                    i = i6;
                }
            }
            sb.append(str);
            break;
        }
        return sb.toString();
    }
}
