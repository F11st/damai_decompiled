package com.alipay.sdk.m.l0;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class c {
    public static byte[] a(int i) {
        byte[] bArr = {(byte) ((r3 >> 8) % 256), (byte) (r3 % 256), (byte) (r3 % 256), (byte) (i % 256)};
        int i2 = i >> 8;
        int i3 = i2 >> 8;
        return bArr;
    }
}
