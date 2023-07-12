package com.alipay.mobile.binarize;

import android.content.Context;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.Type;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.ma.MaLogger;
import com.alipay.mobile.binarize.rs.ScriptC_hybridStdBinarizer;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class HybridStdBinarizer extends Binarizer {
    private RenderScript b;
    private ScriptC_hybridStdBinarizer c;
    private Allocation d;
    private Allocation e;
    private Allocation f;
    private Allocation g;
    private byte[] h;
    private byte[] i;
    private int j;
    private int k;

    public HybridStdBinarizer(Context context) {
        this.b = RenderScript.create(context);
        this.c = new ScriptC_hybridStdBinarizer(this.b);
    }

    private void a() {
        Allocation allocation = this.g;
        if (allocation != null) {
            allocation.destroy();
            this.g.getType().destroy();
        }
        Allocation allocation2 = this.d;
        if (allocation2 != null) {
            allocation2.destroy();
            this.d.getType().destroy();
        }
        Allocation allocation3 = this.e;
        if (allocation3 != null) {
            allocation3.destroy();
            this.e.getType().destroy();
        }
        Allocation allocation4 = this.f;
        if (allocation4 != null) {
            allocation4.destroy();
            this.f.getType().destroy();
        }
    }

    @Override // com.alipay.mobile.binarize.Binarizer
    public void destroy() {
        a();
        ScriptC_hybridStdBinarizer scriptC_hybridStdBinarizer = this.c;
        if (scriptC_hybridStdBinarizer != null) {
            scriptC_hybridStdBinarizer.destroy();
        }
        RenderScript renderScript = this.b;
        if (renderScript != null) {
            renderScript.destroy();
        }
    }

    @Override // com.alipay.mobile.binarize.Binarizer
    public BinarizeResult getBinarizedData(byte[] bArr) {
        this.f.copyFrom(bArr);
        this.c.forEach_calAverage(this.d);
        this.b.finish();
        this.d.copyTo(this.h);
        this.c.set_avgSum(this.c.reduce_produceAverage(this.h).get());
        this.b.finish();
        this.c.forEach_setBlack(this.d);
        this.g.copyTo(this.i);
        this.b.finish();
        BinarizeResult binarizeResult = new BinarizeResult();
        binarizeResult.bitMatrixData = this.i;
        binarizeResult.width = this.j;
        binarizeResult.height = this.k;
        return binarizeResult;
    }

    @Override // com.alipay.mobile.binarize.Binarizer
    public void initialize(int i, int i2) {
        if (this.j == i && this.k == i2) {
            return;
        }
        a();
        this.j = i;
        this.k = i2;
        int ceil = (int) Math.ceil(i / 32.0f);
        int i3 = ceil * i2 * 4;
        MaLogger.d("HybridStdBinarizer", "bitMatrixLength is " + i3);
        this.i = new byte[i3];
        RenderScript renderScript = this.b;
        int i4 = ceil * 4;
        this.g = Allocation.createTyped(this.b, new Type.Builder(renderScript, Element.U8(renderScript)).setX(i4).setY(i2).create(), SecExceptionCode.SEC_ERROR_INIT_INDEX_ERROR);
        int i5 = (i >> 3) * (i2 >> 3);
        this.h = new byte[i5];
        RenderScript renderScript2 = this.b;
        Type.Builder x = new Type.Builder(renderScript2, Element.U8(renderScript2)).setX(i5);
        this.d = Allocation.createTyped(this.b, x.create());
        this.e = Allocation.createTyped(this.b, x.create());
        RenderScript renderScript3 = this.b;
        Allocation createTyped = Allocation.createTyped(this.b, new Type.Builder(renderScript3, Element.U8(renderScript3)).setX(i * i2).create(), SecExceptionCode.SEC_ERROR_INIT_INDEX_ERROR);
        this.f = createTyped;
        this.c.set_gCurrentFrame(createTyped);
        this.c.set_gAverageBlockAllocation(this.d);
        this.c.set_gTypeAllocation(this.e);
        this.c.set_gBitMatrixAllocation(this.g);
        this.c.invoke_initBinarizer(i, i2, 25, 3, i4);
    }
}
