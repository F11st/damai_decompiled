package com.youku.opengl.widget;

import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.SystemClock;
import com.uc.crashsdk.export.LogType;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class h extends e {
    public static final float[] e = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    private final FloatBuffer f;
    private final FloatBuffer g;
    private volatile int h;
    private volatile long i;
    private volatile int j;
    private d k;
    private com.youku.opengl.filter.b l;
    private final ArrayList<c> m;
    private int n;
    private float o;
    private float p;
    private float q;
    private float r;
    private final float[] s;

    public h(a aVar, d dVar, com.youku.opengl.filter.b bVar) {
        super(aVar);
        ArrayList<c> arrayList = new ArrayList<>();
        this.m = arrayList;
        this.n = 4096;
        float[] fArr = new float[16];
        this.s = fArr;
        if (com.youku.opengl.a.a.b) {
            com.youku.opengl.a.a.a("YkGLRenderer", "YkGLRenderer() - renderScheduler:" + aVar + " textureHolder:" + dVar + " filter:" + bVar);
        }
        this.k = dVar;
        arrayList.add(dVar);
        this.l = bVar;
        float[] fArr2 = e;
        FloatBuffer put = ByteBuffer.allocateDirect(fArr2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(fArr2);
        this.f = put;
        put.position(0);
        float[] fArr3 = com.youku.opengl.a.c.a;
        FloatBuffer put2 = ByteBuffer.allocateDirect(fArr3.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(fArr3);
        this.g = put2;
        put2.position(0);
        Matrix.setIdentityM(fArr, 0);
    }

    private float a(float f, float f2) {
        return f == 0.0f ? f2 : 1.0f - f2;
    }

    private void h() {
        Iterator<c> it = this.m.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    private void i() {
        Iterator<c> it = this.m.iterator();
        while (it.hasNext()) {
            int[] iArr = this.b;
            it.next().a(iArr[0], iArr[1]);
        }
    }

    private void j() {
        int[] iArr = this.b;
        float f = iArr[0];
        float f2 = iArr[1];
        int a = com.youku.opengl.a.b.a(this.n);
        if (a == 90 || a == 270) {
            int[] iArr2 = this.b;
            f = iArr2[1];
            f2 = iArr2[0];
        }
        if (com.youku.opengl.a.a.b) {
            com.youku.opengl.a.a.a("YkGLRenderer", "adjustImageScaling() - rotation:" + a + " outputWidth:" + f + " outputHeight:" + f2);
        }
        int[] iArr3 = new int[2];
        this.k.a(iArr3);
        int c = com.youku.opengl.a.b.c(this.n);
        int i = iArr3[0];
        int i2 = iArr3[1];
        if (c == 65536 || c == 131072) {
            i /= 2;
        }
        if (com.youku.opengl.a.a.b) {
            com.youku.opengl.a.a.a("YkGLRenderer", "adjustImageScaling() - imageWidth:" + i + " imageHeight:" + i2);
        }
        float f3 = i;
        float f4 = i2;
        float max = Math.max(f / f3, f2 / f4);
        int round = Math.round(f3 * max);
        int round2 = Math.round(f4 * max);
        if (com.youku.opengl.a.a.b) {
            com.youku.opengl.a.a.a("YkGLRenderer", "adjustImageScaling() - imageWidthNew:" + round + " imageHeightNew:" + round2);
        }
        float f5 = round / f;
        float f6 = round2 / f2;
        float[] fArr = e;
        float[] a2 = com.youku.opengl.a.c.a(this.n, false, false);
        int b = com.youku.opengl.a.b.b(this.n);
        if (b == 8192) {
            float f7 = (1.0f - (1.0f / f5)) / 2.0f;
            float f8 = (1.0f - (1.0f / f6)) / 2.0f;
            a2 = new float[]{a(a2[0], f7), a(a2[1], f8), a(a2[2], f7), a(a2[3], f8), a(a2[4], f7), a(a2[5], f8), a(a2[6], f7), a(a2[7], f8)};
        } else if (b == 4096) {
            if (com.youku.opengl.a.a.b) {
                com.youku.opengl.a.a.a("YkGLRenderer", "adjustImageScaling() - " + com.youku.opengl.a.e.a("CUBE:", fArr, 2));
            }
            fArr = new float[]{fArr[0] / f6, fArr[1] / f5, fArr[2] / f6, fArr[3] / f5, fArr[4] / f6, fArr[5] / f5, fArr[6] / f6, fArr[7] / f5};
        }
        if (com.youku.opengl.a.a.b) {
            com.youku.opengl.a.a.a("YkGLRenderer", "adjustImageScaling() - " + com.youku.opengl.a.e.a("cube:", fArr, 2));
            com.youku.opengl.a.a.a("YkGLRenderer", "adjustImageScaling() - " + com.youku.opengl.a.e.a("textureCords:", a2, 2));
        }
        this.f.clear();
        this.f.put(fArr).position(0);
        this.g.clear();
        this.g.put(a2).position(0);
    }

    public void a(float f, float f2, float f3, float f4) {
        if (com.youku.opengl.a.a.b) {
            com.youku.opengl.a.a.a("YkGLRenderer", "setBackgroundColor() - red:" + f + " green:" + f2 + " blue:" + f3 + " alpha:" + f4);
        }
        this.o = f;
        this.p = f2;
        this.q = f3;
        this.r = f4;
    }

    public void a(int i) {
        if (com.youku.opengl.a.a.b) {
            com.youku.opengl.a.a.a("YkGLRenderer", "setRenderType() - renderType:" + i);
        }
        this.n = i;
        j();
    }

    public void a(com.youku.opengl.filter.b bVar) {
        if (com.youku.opengl.a.a.b) {
            com.youku.opengl.a.a.a("YkGLRenderer", "setFilter() - filter:" + bVar);
        }
        com.youku.opengl.filter.b bVar2 = this.l;
        if (bVar2 != null) {
            bVar2.e();
        }
        this.l = bVar;
        bVar.a(this);
        this.l.d();
        GLES20.glUseProgram(this.l.l());
        com.youku.opengl.a.e.a("glUseProgram");
        com.youku.opengl.filter.b bVar3 = this.l;
        int[] iArr = this.b;
        bVar3.a(iArr[0], iArr[1]);
    }

    public d d() {
        return this.k;
    }

    public void e() {
        j();
    }

    public int f() {
        return this.j;
    }

    public void g() {
        this.h = 0;
        this.i = 0L;
        this.j = 0;
    }

    @Override // com.youku.opengl.widget.e, android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        int i;
        super.onDrawFrame(gl10);
        GLES20.glUseProgram(this.l.l());
        com.youku.opengl.a.e.a("glUseProgram");
        b();
        if (this.a) {
            i = this.k.f();
            if (this.k.b()) {
                if (this.i == 0) {
                    this.i = SystemClock.elapsedRealtime();
                }
                this.h++;
                long elapsedRealtime = SystemClock.elapsedRealtime() - this.i;
                if (elapsedRealtime > 1000) {
                    this.i = SystemClock.elapsedRealtime();
                    this.j = (int) ((this.h * 1000) / elapsedRealtime);
                    this.h = 0;
                }
                GLES20.glClear(LogType.UNEXP_RESTART);
                i = this.k.c();
                this.k.a(this.s);
                this.l.a(this.s);
            }
        } else {
            i = -1;
            if (this.k.b()) {
                i = this.k.c();
                this.k.a(this.s);
                this.l.a(this.s);
            }
        }
        this.l.a(i, this.f, this.g);
        this.k.e();
        c();
    }

    @Override // com.youku.opengl.widget.e, android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        super.onSurfaceChanged(gl10, i, i2);
        if (com.youku.opengl.a.a.b) {
            com.youku.opengl.a.a.a("YkGLRenderer", "onSurfaceChanged() - gl:" + gl10 + " width:" + i + " height:" + i2);
        }
        if (this.a) {
            GLES20.glViewport(0, 0, i, i2);
            com.youku.opengl.a.e.a("glViewport");
            com.youku.opengl.a.a.a("YkGLRenderer", "onSurfaceChanged() - set view port");
            this.k.b(new int[]{i, i2});
            com.youku.opengl.a.a.a("YkGLRenderer", "onSurfaceChanged() - reset image size to surface size!!!");
        }
        GLES20.glUseProgram(this.l.l());
        com.youku.opengl.a.e.a("glUseProgram");
        this.l.a(i, i2);
        j();
        this.k.g();
        i();
    }

    @Override // com.youku.opengl.widget.e, android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        super.onSurfaceCreated(gl10, eGLConfig);
        if (com.youku.opengl.a.a.b) {
            com.youku.opengl.a.a.a("YkGLRenderer", "onSurfaceCreated() - gl:" + gl10 + " config:" + eGLConfig);
        }
        if (this.a) {
            GLES20.glClearColor(this.o, this.p, this.q, this.r);
            com.youku.opengl.a.a.a("YkGLRenderer", "onSurfaceCreated() - set clear color");
        }
        this.l.d();
        g();
        h();
    }
}
