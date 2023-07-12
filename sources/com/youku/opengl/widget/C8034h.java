package com.youku.opengl.widget;

import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.SystemClock;
import com.uc.crashsdk.export.LogType;
import com.youku.opengl.a.C8013a;
import com.youku.opengl.a.C8015b;
import com.youku.opengl.a.C8016c;
import com.youku.opengl.a.C8018e;
import com.youku.opengl.filter.C8020b;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: Taobao */
/* renamed from: com.youku.opengl.widget.h */
/* loaded from: classes3.dex */
public class C8034h extends AbstractC8031e {
    public static final float[] e = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    private final FloatBuffer f;
    private final FloatBuffer g;
    private volatile int h;
    private volatile long i;
    private volatile int j;
    private InterfaceC8030d k;
    private C8020b l;
    private final ArrayList<InterfaceC8029c> m;
    private int n;
    private float o;
    private float p;
    private float q;
    private float r;
    private final float[] s;

    public C8034h(InterfaceC8027a interfaceC8027a, InterfaceC8030d interfaceC8030d, C8020b c8020b) {
        super(interfaceC8027a);
        ArrayList<InterfaceC8029c> arrayList = new ArrayList<>();
        this.m = arrayList;
        this.n = 4096;
        float[] fArr = new float[16];
        this.s = fArr;
        if (C8013a.b) {
            C8013a.a("YkGLRenderer", "YkGLRenderer() - renderScheduler:" + interfaceC8027a + " textureHolder:" + interfaceC8030d + " filter:" + c8020b);
        }
        this.k = interfaceC8030d;
        arrayList.add(interfaceC8030d);
        this.l = c8020b;
        float[] fArr2 = e;
        FloatBuffer put = ByteBuffer.allocateDirect(fArr2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(fArr2);
        this.f = put;
        put.position(0);
        float[] fArr3 = C8016c.a;
        FloatBuffer put2 = ByteBuffer.allocateDirect(fArr3.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(fArr3);
        this.g = put2;
        put2.position(0);
        Matrix.setIdentityM(fArr, 0);
    }

    private float a(float f, float f2) {
        return f == 0.0f ? f2 : 1.0f - f2;
    }

    private void h() {
        Iterator<InterfaceC8029c> it = this.m.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    private void i() {
        Iterator<InterfaceC8029c> it = this.m.iterator();
        while (it.hasNext()) {
            int[] iArr = this.b;
            it.next().a(iArr[0], iArr[1]);
        }
    }

    private void j() {
        int[] iArr = this.b;
        float f = iArr[0];
        float f2 = iArr[1];
        int a = C8015b.a(this.n);
        if (a == 90 || a == 270) {
            int[] iArr2 = this.b;
            f = iArr2[1];
            f2 = iArr2[0];
        }
        if (C8013a.b) {
            C8013a.a("YkGLRenderer", "adjustImageScaling() - rotation:" + a + " outputWidth:" + f + " outputHeight:" + f2);
        }
        int[] iArr3 = new int[2];
        this.k.a(iArr3);
        int c = C8015b.c(this.n);
        int i = iArr3[0];
        int i2 = iArr3[1];
        if (c == 65536 || c == 131072) {
            i /= 2;
        }
        if (C8013a.b) {
            C8013a.a("YkGLRenderer", "adjustImageScaling() - imageWidth:" + i + " imageHeight:" + i2);
        }
        float f3 = i;
        float f4 = i2;
        float max = Math.max(f / f3, f2 / f4);
        int round = Math.round(f3 * max);
        int round2 = Math.round(f4 * max);
        if (C8013a.b) {
            C8013a.a("YkGLRenderer", "adjustImageScaling() - imageWidthNew:" + round + " imageHeightNew:" + round2);
        }
        float f5 = round / f;
        float f6 = round2 / f2;
        float[] fArr = e;
        float[] a2 = C8016c.a(this.n, false, false);
        int b = C8015b.b(this.n);
        if (b == 8192) {
            float f7 = (1.0f - (1.0f / f5)) / 2.0f;
            float f8 = (1.0f - (1.0f / f6)) / 2.0f;
            a2 = new float[]{a(a2[0], f7), a(a2[1], f8), a(a2[2], f7), a(a2[3], f8), a(a2[4], f7), a(a2[5], f8), a(a2[6], f7), a(a2[7], f8)};
        } else if (b == 4096) {
            if (C8013a.b) {
                C8013a.a("YkGLRenderer", "adjustImageScaling() - " + C8018e.a("CUBE:", fArr, 2));
            }
            fArr = new float[]{fArr[0] / f6, fArr[1] / f5, fArr[2] / f6, fArr[3] / f5, fArr[4] / f6, fArr[5] / f5, fArr[6] / f6, fArr[7] / f5};
        }
        if (C8013a.b) {
            C8013a.a("YkGLRenderer", "adjustImageScaling() - " + C8018e.a("cube:", fArr, 2));
            C8013a.a("YkGLRenderer", "adjustImageScaling() - " + C8018e.a("textureCords:", a2, 2));
        }
        this.f.clear();
        this.f.put(fArr).position(0);
        this.g.clear();
        this.g.put(a2).position(0);
    }

    public void a(float f, float f2, float f3, float f4) {
        if (C8013a.b) {
            C8013a.a("YkGLRenderer", "setBackgroundColor() - red:" + f + " green:" + f2 + " blue:" + f3 + " alpha:" + f4);
        }
        this.o = f;
        this.p = f2;
        this.q = f3;
        this.r = f4;
    }

    public void a(int i) {
        if (C8013a.b) {
            C8013a.a("YkGLRenderer", "setRenderType() - renderType:" + i);
        }
        this.n = i;
        j();
    }

    public void a(C8020b c8020b) {
        if (C8013a.b) {
            C8013a.a("YkGLRenderer", "setFilter() - filter:" + c8020b);
        }
        C8020b c8020b2 = this.l;
        if (c8020b2 != null) {
            c8020b2.e();
        }
        this.l = c8020b;
        c8020b.a(this);
        this.l.d();
        GLES20.glUseProgram(this.l.l());
        C8018e.a("glUseProgram");
        C8020b c8020b3 = this.l;
        int[] iArr = this.b;
        c8020b3.a(iArr[0], iArr[1]);
    }

    public InterfaceC8030d d() {
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

    @Override // com.youku.opengl.widget.AbstractC8031e, android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        int i;
        super.onDrawFrame(gl10);
        GLES20.glUseProgram(this.l.l());
        C8018e.a("glUseProgram");
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

    @Override // com.youku.opengl.widget.AbstractC8031e, android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        super.onSurfaceChanged(gl10, i, i2);
        if (C8013a.b) {
            C8013a.a("YkGLRenderer", "onSurfaceChanged() - gl:" + gl10 + " width:" + i + " height:" + i2);
        }
        if (this.a) {
            GLES20.glViewport(0, 0, i, i2);
            C8018e.a("glViewport");
            C8013a.a("YkGLRenderer", "onSurfaceChanged() - set view port");
            this.k.b(new int[]{i, i2});
            C8013a.a("YkGLRenderer", "onSurfaceChanged() - reset image size to surface size!!!");
        }
        GLES20.glUseProgram(this.l.l());
        C8018e.a("glUseProgram");
        this.l.a(i, i2);
        j();
        this.k.g();
        i();
    }

    @Override // com.youku.opengl.widget.AbstractC8031e, android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        super.onSurfaceCreated(gl10, eGLConfig);
        if (C8013a.b) {
            C8013a.a("YkGLRenderer", "onSurfaceCreated() - gl:" + gl10 + " config:" + eGLConfig);
        }
        if (this.a) {
            GLES20.glClearColor(this.o, this.p, this.q, this.r);
            C8013a.a("YkGLRenderer", "onSurfaceCreated() - set clear color");
        }
        this.l.d();
        g();
        h();
    }
}
