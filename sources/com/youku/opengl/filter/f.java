package com.youku.opengl.filter;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.text.TextUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class f extends b {
    private static final float[] d = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    private static final float[] e = com.youku.opengl.a.c.a;
    private int f = -1;
    private Bitmap g;
    private String h;
    private String i;
    private b j;
    private float[] k;
    private FloatBuffer l;
    private final FloatBuffer m;
    private int n;
    private int o;
    private float p;
    private float q;

    public f() {
        float[] fArr = d;
        this.k = fArr;
        this.n = -16776961;
        this.o = 10;
        this.j = new b();
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.l = asFloatBuffer;
        asFloatBuffer.put(fArr).position(0);
        float[] fArr2 = e;
        FloatBuffer asFloatBuffer2 = ByteBuffer.allocateDirect(fArr2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.m = asFloatBuffer2;
        asFloatBuffer2.put(fArr2).position(0);
    }

    private void a(float f, float f2, float f3, float f4) {
        if (com.youku.opengl.a.a.b) {
            String str = this.a;
            com.youku.opengl.a.a.a(str, "setRenderArea() - x:" + f + " y:" + f2 + " width:" + f3 + " height:" + f4);
        }
        this.k = com.youku.opengl.a.e.a(f, f2, f3, f4);
        if (com.youku.opengl.a.a.b) {
            String str2 = this.a;
            com.youku.opengl.a.a.a(str2, "setRenderArea() - new cube:" + com.youku.opengl.a.e.a("cube:", this.k, 2));
        }
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(this.k.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.l = asFloatBuffer;
        asFloatBuffer.put(this.k).position(0);
    }

    private String m() {
        return this.h;
    }

    public void a(float f, float f2) {
        if (com.youku.opengl.a.a.b) {
            String str = this.a;
            com.youku.opengl.a.a.a(str, "setStartPoint() - x:" + f + " y:" + f2);
        }
        this.p = f;
        this.q = f2;
    }

    @Override // com.youku.opengl.filter.b
    public void a(int i, int i2) {
        super.a(i, i2);
        this.j.a(i, i2);
    }

    @Override // com.youku.opengl.filter.b
    public void a(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        super.a(i, floatBuffer, floatBuffer2);
        com.youku.opengl.a.a.a(this.a, "onDraw() - begin");
        String m = m();
        if (TextUtils.isEmpty(m)) {
            com.youku.opengl.a.a.b(this.a, "onDraw() - no text");
            return;
        }
        if (TextUtils.isEmpty(this.i) || !this.i.equals(m)) {
            Bitmap a = com.youku.opengl.a.d.a(this.g, m, this.n, this.o);
            this.g = a;
            this.f = com.youku.opengl.a.e.a(a, this.f, false);
            a(this.p, this.q, this.g.getWidth() / j(), this.g.getHeight() / k());
            this.i = m;
        }
        GLES20.glBlendEquationSeparate(32774, 32774);
        GLES20.glBlendFuncSeparate(1, 771, 1, 1);
        GLES20.glEnable(3042);
        GLES20.glDisable(2929);
        GLES20.glDisable(2884);
        this.j.a(this.f, this.l, this.m);
        GLES20.glDisable(3042);
        com.youku.opengl.a.a.a(this.a, "onDraw() - end");
    }

    public void a(String str) {
        this.h = str;
    }

    public void b(int i) {
        this.o = i;
    }

    @Override // com.youku.opengl.filter.b
    public void c() {
        super.c();
        this.j.d();
    }

    public void c(int i) {
        this.n = i;
    }

    @Override // com.youku.opengl.filter.b
    public void f() {
        super.f();
        this.j.f();
    }
}
