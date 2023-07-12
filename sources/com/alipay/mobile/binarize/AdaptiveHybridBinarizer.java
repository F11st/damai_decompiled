package com.alipay.mobile.binarize;

import android.content.Context;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.Type;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.mobile.binarize.rs.ScriptC_adaptiveHybridBinarizer;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class AdaptiveHybridBinarizer extends Binarizer {
    private boolean b = true;
    private boolean c = false;
    private Allocation d;
    private Allocation e;
    private Allocation f;
    private Allocation g;
    private byte[] h;
    private byte[] i;
    private Allocation j;
    private Allocation k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int[] p;
    private ScriptC_adaptiveHybridBinarizer q;
    private RenderScript r;

    public AdaptiveHybridBinarizer(Context context) {
        this.r = RenderScript.create(context);
        this.q = new ScriptC_adaptiveHybridBinarizer(this.r);
    }

    private void a() {
        Allocation allocation = this.f;
        if (allocation != null) {
            allocation.destroy();
            this.f.getType().destroy();
        }
        Allocation allocation2 = this.g;
        if (allocation2 != null) {
            allocation2.destroy();
            this.g.getType().destroy();
        }
        Allocation allocation3 = this.e;
        if (allocation3 != null) {
            allocation3.destroy();
            this.e.getType().destroy();
        }
        Allocation allocation4 = this.k;
        if (allocation4 != null) {
            allocation4.destroy();
            this.k.getType().destroy();
        }
        Allocation allocation5 = this.j;
        if (allocation5 != null) {
            allocation5.destroy();
            this.j.getType().destroy();
        }
        Allocation allocation6 = this.d;
        if (allocation6 != null) {
            allocation6.destroy();
            this.d.getType().destroy();
        }
    }

    @Override // com.alipay.mobile.binarize.Binarizer
    public void destroy() {
        a();
        ScriptC_adaptiveHybridBinarizer scriptC_adaptiveHybridBinarizer = this.q;
        if (scriptC_adaptiveHybridBinarizer != null) {
            scriptC_adaptiveHybridBinarizer.destroy();
        }
        RenderScript renderScript = this.r;
        if (renderScript != null) {
            renderScript.destroy();
        }
    }

    @Override // com.alipay.mobile.binarize.Binarizer
    public BinarizeResult getBinarizedData(byte[] bArr) {
        this.j.copyFrom(bArr);
        if (this.c) {
            this.q.forEach_deNoiseByAverage(this.j, this.k);
            this.k.copyTo(this.h);
            this.j.copyFrom(this.h);
            this.r.finish();
            this.q.forEach_calAverage(this.e);
        } else {
            this.q.set_gCurrentFrame(this.j);
            this.q.forEach_calAverage(this.e);
        }
        this.r.finish();
        this.d.copyTo(this.p);
        this.r.finish();
        for (int i = 0; i < this.o; i++) {
            int i2 = 0;
            while (true) {
                int i3 = this.n;
                if (i2 < i3) {
                    int i4 = ((i * i3) + i2) * 4;
                    int[] iArr = this.p;
                    int i5 = iArr[i4 + 1];
                    int i6 = iArr[i4 + 2] - i5;
                    if (i6 <= 24) {
                        int i7 = this.b ? i5 >> 1 : (i6 >> 1) + i5;
                        if (i > 0 && i2 > 0) {
                            int i8 = (((i - 1) * i3) + i2) - 1;
                            int i9 = ((iArr[(i8 + 1) * 4] + (iArr[(i3 + i8) * 4] << 1)) + iArr[i8 * 4]) >> 2;
                            if (i5 < i9) {
                                i7 = i9;
                            }
                        }
                        iArr[i4] = i7;
                    }
                    i2++;
                }
            }
        }
        this.d.copyFrom(this.p);
        this.q.forEach_calThreshold(this.d);
        this.r.finish();
        this.q.forEach_setBlack(this.f, this.g);
        this.g.copyTo(this.i);
        this.r.finish();
        BinarizeResult binarizeResult = new BinarizeResult();
        binarizeResult.bitMatrixData = this.i;
        binarizeResult.width = this.l;
        binarizeResult.height = this.m;
        return binarizeResult;
    }

    @Override // com.alipay.mobile.binarize.Binarizer
    public void initialize(int i, int i2) {
        if (this.l == i && this.m == i2) {
            return;
        }
        a();
        this.l = i;
        this.m = i2;
        int ceil = (int) Math.ceil(i / 32.0f);
        this.i = new byte[ceil * i2 * 4];
        RenderScript renderScript = this.r;
        Type.Builder y = new Type.Builder(renderScript, Element.U8(renderScript)).setX(ceil * 4).setY(i2);
        this.f = Allocation.createTyped(this.r, y.create(), SecExceptionCode.SEC_ERROR_INIT_INDEX_ERROR);
        this.g = Allocation.createTyped(this.r, y.create(), SecExceptionCode.SEC_ERROR_INIT_INDEX_ERROR);
        this.h = new byte[i * i2];
        RenderScript renderScript2 = this.r;
        Type.Builder y2 = new Type.Builder(renderScript2, Element.U8(renderScript2)).setX(i).setY(i2);
        this.j = Allocation.createTyped(this.r, y2.create(), SecExceptionCode.SEC_ERROR_INIT_INDEX_ERROR);
        this.k = Allocation.createTyped(this.r, y2.create(), SecExceptionCode.SEC_ERROR_INIT_INDEX_ERROR);
        this.n = ((i + 8) - 1) / 8;
        this.o = ((i2 + 8) - 1) / 8;
        RenderScript renderScript3 = this.r;
        this.d = Allocation.createTyped(this.r, new Type.Builder(renderScript3, Element.I32_3(renderScript3)).setX(this.n).setY(this.o).create());
        RenderScript renderScript4 = this.r;
        this.e = Allocation.createTyped(this.r, new Type.Builder(renderScript4, Element.U8(renderScript4)).setX(this.n).setY(this.o).create());
        this.q.invoke_initSize(i, i2, 8, 24);
        this.q.set_gCurrentFrame(this.j);
        this.q.set_gTempAverageFrame(this.d);
        this.q.set_gAverageFrame(this.e);
        this.p = new int[this.n * this.o * 4];
    }

    public void setDeNoiseByAvg(boolean z) {
        this.c = z;
    }

    public void setPreferWhite(boolean z) {
        this.b = z;
    }
}
