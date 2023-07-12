package com.alibaba.security.a.a;

import android.content.Context;
import android.opengl.GLES20;
import com.taobao.android.librace.MediaChainEngine;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class a implements com.alibaba.security.common.a.a {
    private static final String a = "BeautyRenderManager";
    private MediaChainEngine b;
    private int c;
    private int d;
    private int e;

    @Override // com.alibaba.security.common.a.a
    public final void a(Context context, int i, int i2, int i3, int i4) {
        try {
            this.c = i;
            this.d = i2;
            this.e = i3;
            MediaChainEngine mediaChainEngine = new MediaChainEngine(context, true);
            this.b = mediaChainEngine;
            mediaChainEngine.setInputTexture(i4, i2, i, true);
            this.b.setScreenViewport(0, 0, i2, i);
            this.b.enableBeautyType(0, true);
            this.b.enableBeautyType(1, true);
            this.b.enableBeautyType(4, true);
            this.b.enableBeautyType(3, true, false);
            this.b.enableBeautyType(2, true, false);
            this.b.setBeautyParam(1, 0.8f);
            this.b.setBeautyParam(3, 0.5f);
            this.b.setBeautyParam(2, 1.0f);
            this.b.setBeautyParam(6, 1.0f);
            this.b.updateFaceShape(0, 0.2f);
            this.b.updateFaceShape(1, 0.8f);
            this.b.updateFaceShape(2, 0.4f);
            this.b.updateFaceShape(3, 0.0f);
            this.b.updateFaceShape(4, 0.4f);
            this.b.updateFaceShape(5, 0.0f);
            this.b.updateFaceShape(6, 0.0f);
            this.b.updateFaceShape(7, 0.0f);
            this.b.updateFaceShape(8, 0.6f);
            this.b.updateFaceShape(9, 0.0f);
            this.b.updateFaceShape(10, 0.0f);
            this.b.updateFaceShape(11, 0.0f);
            this.b.updateFaceShape(12, 0.0f);
            this.b.updateFaceShape(13, 0.0f);
            this.b.updateFaceShape(14, 0.2f);
            this.b.updateFaceShape(15, 0.0f);
            this.b.updateFaceShape(16, 0.0f);
            this.b.updateFaceShape(17, 0.0f);
            this.b.updateFaceShape(18, 0.0f);
            this.b.updateFaceShape(19, 0.0f);
            this.b.updateFaceShape(20, 0.0f);
            this.b.updateFaceShape(21, 0.0f);
        } catch (Throwable unused) {
            com.alibaba.security.common.c.a.c(a, "face engine init fail");
        }
    }

    @Override // com.alibaba.security.common.a.a
    public final void a(int i, int i2) {
        MediaChainEngine mediaChainEngine;
        if (i <= 0 || (mediaChainEngine = this.b) == null) {
            return;
        }
        int i3 = this.c;
        int i4 = this.d;
        mediaChainEngine.setScreenViewport(0, (i2 - ((i * i3) / i4)) / 2, i, (i3 * i) / i4);
    }

    @Override // com.alibaba.security.common.a.a
    public final void a(byte[] bArr, float[] fArr) {
        MediaChainEngine mediaChainEngine = this.b;
        if (mediaChainEngine == null || bArr == null) {
            return;
        }
        try {
            mediaChainEngine.updateInputDataAndRunAlg(bArr, 1, this.c, this.d, 0, this.e, 0, 2);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(16384);
            this.b.renderTexture(fArr);
        } catch (Throwable unused) {
        }
    }

    @Override // com.alibaba.security.common.a.a
    public final void a() {
        try {
            MediaChainEngine mediaChainEngine = this.b;
            if (mediaChainEngine != null) {
                mediaChainEngine.release();
                this.b = null;
            }
        } catch (Throwable unused) {
        }
    }
}
