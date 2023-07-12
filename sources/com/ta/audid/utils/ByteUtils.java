package com.ta.audid.utils;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ByteUtils {
    public static long getLongByByte4(byte[] bArr) {
        return ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (255 & bArr[3]);
    }
}
