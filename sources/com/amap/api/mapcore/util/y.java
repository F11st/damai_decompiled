package com.amap.api.mapcore.util;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.amap.api.mapcore.util.de;
import com.amap.api.maps.model.CrossOverlay;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.uc.crashsdk.export.LogType;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class y {
    private final IAMapDelegate c;
    private ExecutorService h;
    private boolean j;
    private volatile EGLContext o;
    private volatile EGLConfig p;
    private de.g t;
    private FloatBuffer u;
    private FloatBuffer v;
    private a w;
    private CrossOverlay.GenerateCrossImageListener x;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private BlockingQueue<Runnable> g = new LinkedBlockingQueue();
    private boolean i = false;
    private int k = 0;
    private int l = 0;
    private int m = 0;
    private boolean n = false;
    private EGLDisplay q = EGL14.EGL_NO_DISPLAY;
    private EGLContext r = EGL14.EGL_NO_CONTEXT;
    private EGLSurface s = EGL14.EGL_NO_SURFACE;
    float[] a = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    float[] b = {-1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, -1.0f, 0.0f, -1.0f, -1.0f, 0.0f};

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface a {
        int getTextureID();
    }

    public y(IAMapDelegate iAMapDelegate) {
        this.h = null;
        this.j = false;
        this.c = iAMapDelegate;
        this.j = false;
        this.h = new ThreadPoolExecutor(1, Runtime.getRuntime().availableProcessors() * 2, 1, TimeUnit.SECONDS, this.g, new ed("AMapPboRenderThread"), new ThreadPoolExecutor.AbortPolicy());
    }

    private void a(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        this.q = eglGetDisplay;
        if (eglGetDisplay == EGL14.EGL_NO_DISPLAY) {
            a("eglGetDisplay failed");
            return;
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
            this.q = null;
            a("eglInitialize failed");
            return;
        }
        EGLContext eglCreateContext = EGL14.eglCreateContext(this.q, this.p, this.o, new int[]{12440, 2, 12344}, 0);
        this.r = eglCreateContext;
        if (eglCreateContext == EGL14.EGL_NO_CONTEXT) {
            a("eglCreateContext failed");
            return;
        }
        EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(this.q, this.p, new int[]{12375, this.e, 12374, this.f, 12344}, 0);
        this.s = eglCreatePbufferSurface;
        if (eglCreatePbufferSurface == EGL14.EGL_NO_SURFACE) {
            a("eglCreatePbufferSurface failed");
        } else if (!EGL14.eglMakeCurrent(this.q, eglCreatePbufferSurface, eglCreatePbufferSurface, this.r)) {
            a("eglMakeCurrent failed");
        } else {
            GLES20.glFlush();
            a("initOpenGL complete");
            this.i = true;
        }
    }

    private void e() {
        IAMapDelegate iAMapDelegate = this.c;
        if (iAMapDelegate != null) {
            this.t = (de.g) iAMapDelegate.getGLShader(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        try {
            if (this.j) {
                return;
            }
            a aVar = this.w;
            if (aVar == null) {
                a("renderTextureAndReadPixel failed textureHelper is null");
                return;
            }
            if (aVar != null) {
                this.d = aVar.getTextureID();
            }
            if (this.d <= 0) {
                a("renderTextureAndReadPixel failed mTextureID is <= 0 mTextureID " + this.d);
                return;
            }
            a("renderTextureAndReadPixel  mTextureID is  mTextureID " + this.d);
            de.g gVar = this.t;
            if (gVar == null || gVar.c()) {
                e();
            }
            if (this.u == null) {
                this.u = eq.a(this.b);
            }
            if (this.v == null) {
                this.v = eq.a(new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f});
            }
            this.t.a();
            GLES20.glDisable(3042);
            GLES20.glBlendFunc(1, 771);
            GLES20.glBlendColor(1.0f, 1.0f, 1.0f, 1.0f);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.d);
            GLES20.glEnableVertexAttribArray(this.t.b);
            GLES20.glVertexAttribPointer(this.t.b, 3, 5126, false, 12, (Buffer) this.u);
            GLES20.glEnableVertexAttribArray(this.t.c);
            GLES20.glVertexAttribPointer(this.t.c, 2, 5126, false, 8, (Buffer) this.v);
            Matrix.setIdentityM(this.a, 0);
            Matrix.scaleM(this.a, 0, 1.0f, 1.0f, 1.0f);
            GLES20.glUniformMatrix4fv(this.t.a, 1, false, this.a, 0);
            GLES20.glDrawArrays(6, 0, 4);
            GLES20.glDisableVertexAttribArray(this.t.b);
            GLES20.glDisableVertexAttribArray(this.t.c);
            GLES20.glBindTexture(3553, 0);
            GLES20.glUseProgram(0);
            GLES20.glDisable(3042);
            dy.a("drawTexure");
            GLES20.glFinish();
            int i = this.k + 1;
            this.k = i;
            if (i == 5) {
                g();
            }
        } catch (Throwable unused) {
            CrossOverlay.GenerateCrossImageListener generateCrossImageListener = this.x;
            if (generateCrossImageListener != null) {
                generateCrossImageListener.onGenerateComplete(null, -1);
            }
        }
    }

    private void g() {
        if (this.x != null) {
            if (this.l == 0) {
                this.l = this.e;
            }
            if (this.m == 0) {
                this.m = this.f;
            }
            int i = this.f;
            int i2 = this.m;
            this.x.onGenerateComplete(eq.a(0, i - i2, this.l, i2), this.i ? 0 : -1);
            this.n = true;
        }
    }

    public void b() {
        this.j = true;
        FloatBuffer floatBuffer = this.v;
        if (floatBuffer != null) {
            floatBuffer.clear();
            this.v = null;
        }
        FloatBuffer floatBuffer2 = this.u;
        if (floatBuffer2 != null) {
            floatBuffer2.clear();
            this.u = null;
        }
        this.w = null;
        this.h.shutdownNow();
    }

    public boolean c() {
        return this.j;
    }

    public void a(int i, int i2) {
        this.e = i;
        this.f = i2;
        this.o = EGL14.eglGetCurrentContext();
        if (this.o == EGL14.EGL_NO_CONTEXT) {
            a("eglGetCurrentContext failed");
            return;
        }
        EGLDisplay eglGetCurrentDisplay = EGL14.eglGetCurrentDisplay();
        if (eglGetCurrentDisplay == EGL14.EGL_NO_DISPLAY) {
            a("sharedEglDisplay failed");
            return;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!EGL14.eglGetConfigs(eglGetCurrentDisplay, eGLConfigArr, 0, 1, new int[1], 0)) {
            a("eglGetConfigs failed");
            return;
        }
        this.p = eGLConfigArr[0];
        ExecutorService executorService = this.h;
        if (executorService == null || executorService.isShutdown()) {
            return;
        }
        this.h.execute(new Runnable() { // from class: com.amap.api.mapcore.util.y.1
            @Override // java.lang.Runnable
            public void run() {
                y.this.d();
            }
        });
    }

    public void b(int i, int i2) {
        this.l = i;
        this.m = i2;
    }

    public void a() {
        ExecutorService executorService = this.h;
        if (executorService == null || executorService.isShutdown()) {
            return;
        }
        this.h.execute(new Runnable() { // from class: com.amap.api.mapcore.util.y.2
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r2v0, types: [android.opengl.EGLContext, android.graphics.Bitmap, android.opengl.EGLDisplay] */
            @Override // java.lang.Runnable
            public void run() {
                try {
                    y.this.n = false;
                    if (y.this.j) {
                        return;
                    }
                    y.this.k = 0;
                    int i = 0;
                    while (!y.this.j && y.this.k < 5 && i < 50) {
                        i++;
                        try {
                            Thread.sleep(16L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (!y.this.i) {
                            if (y.this.x != null) {
                                y.this.x.onGenerateComplete(null, -1);
                            }
                            if (!y.this.n) {
                                y.this.n = true;
                                if (y.this.x != null) {
                                    y.this.x.onGenerateComplete(null, -1);
                                }
                            }
                            if (y.this.r != EGL14.EGL_NO_CONTEXT) {
                                EGL14.eglDestroyContext(y.this.q, y.this.r);
                                EGL14.eglDestroySurface(y.this.q, y.this.s);
                                y.this.r = null;
                            }
                            if (y.this.q != EGL14.EGL_NO_DISPLAY) {
                                EGL14.eglTerminate(y.this.q);
                                y.this.q = null;
                            }
                            y.this.r = EGL14.EGL_NO_CONTEXT;
                            y.this.q = EGL14.EGL_NO_DISPLAY;
                            return;
                        }
                        GLES20.glViewport(0, 0, y.this.e, y.this.f);
                        GLES20.glClear(LogType.UNEXP_RESTART);
                        y.this.f();
                    }
                    if (!y.this.n) {
                        y.this.n = true;
                        if (y.this.x != null) {
                            y.this.x.onGenerateComplete(null, -1);
                        }
                    }
                    if (y.this.r != EGL14.EGL_NO_CONTEXT) {
                        EGL14.eglDestroyContext(y.this.q, y.this.r);
                        EGL14.eglDestroySurface(y.this.q, y.this.s);
                        y.this.r = null;
                    }
                    if (y.this.q != EGL14.EGL_NO_DISPLAY) {
                        EGL14.eglTerminate(y.this.q);
                        y.this.q = null;
                    }
                    y.this.r = EGL14.EGL_NO_CONTEXT;
                    y.this.q = EGL14.EGL_NO_DISPLAY;
                } finally {
                    if (!y.this.n) {
                        y.this.n = true;
                        if (y.this.x != null) {
                            y.this.x.onGenerateComplete(null, -1);
                        }
                    }
                    if (y.this.r != EGL14.EGL_NO_CONTEXT) {
                        EGL14.eglDestroyContext(y.this.q, y.this.r);
                        EGL14.eglDestroySurface(y.this.q, y.this.s);
                        y.this.r = null;
                    }
                    if (y.this.q != EGL14.EGL_NO_DISPLAY) {
                        EGL14.eglTerminate(y.this.q);
                        y.this.q = null;
                    }
                    y.this.r = EGL14.EGL_NO_CONTEXT;
                    y.this.q = EGL14.EGL_NO_DISPLAY;
                }
            }
        });
    }

    public void a(CrossOverlay.GenerateCrossImageListener generateCrossImageListener) {
        this.x = generateCrossImageListener;
    }

    public void a(a aVar) {
        this.w = aVar;
    }
}
