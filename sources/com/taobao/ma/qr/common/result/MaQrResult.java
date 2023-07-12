package com.taobao.ma.qr.common.result;

import com.taobao.ma.common.result.MaResult;
import com.taobao.ma.common.result.MaType;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MaQrResult extends MaResult {
    public int height;
    public int width;
    public int x;
    public int[] xCorner;
    public int y;
    public int[] yCorner;

    public MaQrResult(MaType maType, String str) {
        super(maType, str);
    }

    public MaQrResult(MaType maType, String str, int[] iArr, int[] iArr2, int i, int i2, int i3, int i4) {
        this(maType, str);
        this.xCorner = iArr;
        this.yCorner = iArr2;
        this.x = i;
        this.y = i2;
        this.width = i3;
        this.height = i4;
    }
}
