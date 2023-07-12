package com.taobao.ma.decode;

import java.io.Serializable;
import java.util.Arrays;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DecodeResult implements Serializable {
    private static final long serialVersionUID = -1127433175886611037L;
    public byte[] bytes;
    public byte[] decodeBytes;
    public int height;
    public String hiddenData;
    public String strCode;
    public int subType;
    public int type;
    public int width;
    public int x;
    public int[] xCorner;
    public int y;
    public int[] yCorner;

    public DecodeResult(int i, int i2, String str) {
        this.type = i;
        this.subType = i2;
        this.strCode = str;
    }

    public String toString() {
        return "DecodeResult [type=" + this.type + ", subType=" + this.subType + ", strCode=" + this.strCode + ", bytes=" + Arrays.toString(this.bytes) + ", x=" + this.x + ", y=" + this.y + ", width=" + this.width + ", height=" + this.height + ", decodeBytes=" + Arrays.toString(this.decodeBytes) + ", hiddenData=" + this.hiddenData + jn1.ARRAY_END_STR;
    }

    public DecodeResult(int i, int i2, byte[] bArr, int i3, int i4, int i5, int i6) {
        this.type = i;
        this.subType = i2;
        this.bytes = bArr;
        this.x = i3;
        this.y = i4;
        this.width = i5;
        this.height = i6;
    }

    public DecodeResult(int i, int i2, byte[] bArr, int i3, int i4, int i5, int i6, byte[] bArr2) {
        this.type = i;
        this.subType = i2;
        this.bytes = bArr;
        this.x = i3;
        this.y = i4;
        this.width = i5;
        this.height = i6;
        this.decodeBytes = bArr2;
    }

    public DecodeResult(int i, int i2, byte[] bArr, int i3, int i4, int i5, int i6, byte[] bArr2, String str) {
        this.type = i;
        this.subType = i2;
        this.bytes = bArr;
        this.x = i3;
        this.y = i4;
        this.width = i5;
        this.height = i6;
        this.decodeBytes = bArr2;
        this.hiddenData = str;
        this.xCorner = new int[4];
        this.yCorner = new int[4];
    }

    public DecodeResult(int i, int i2, byte[] bArr) {
        this.type = i;
        this.subType = i2;
        this.bytes = bArr;
    }

    public DecodeResult(int i, int i2, byte[] bArr, byte[] bArr2) {
        this.type = i;
        this.subType = i2;
        this.bytes = bArr;
        this.decodeBytes = bArr2;
    }
}
