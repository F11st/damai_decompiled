package com.taobao.ma.ar;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ARInputParam {
    public final byte[] imageData;
    public final int imageHeight;
    public final int imageWidth;
    public final int interestP1_X;
    public final int interestP1_Y;
    public final int interestP2_X;
    public final int interestP2_Y;
    public final int preDim;
    public final int preInCount;
    public final int[] preXCoords;
    public final int[] preYCoords;

    public ARInputParam(byte[] bArr, int i, int i2, int[] iArr, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.imageData = bArr;
        this.imageWidth = i;
        this.imageHeight = i2;
        this.preXCoords = iArr;
        this.preYCoords = iArr2;
        this.interestP1_X = i3;
        this.interestP1_Y = i4;
        this.interestP2_X = i5;
        this.interestP2_Y = i6;
        this.preInCount = i7;
        this.preDim = i8;
    }
}
