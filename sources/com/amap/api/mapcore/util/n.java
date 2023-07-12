package com.amap.api.mapcore.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import com.amap.api.maps.MapsInitializer;
import com.heytap.mcssdk.constant.MessageConstant$CommandId;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: Taobao */
@SuppressLint({"NewApi"})
/* loaded from: classes10.dex */
public class n extends TextureView implements TextureView.SurfaceTextureListener {
    private static final j a = new j();
    private final WeakReference<n> b;
    private i c;
    private GLSurfaceView.Renderer d;
    private boolean e;
    private e f;
    private f g;
    private g h;
    private k i;
    private int j;
    private int k;
    private boolean l;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private abstract class a implements e {
        protected int[] a;

        public a(int[] iArr) {
            this.a = a(iArr);
        }

        private int[] a(int[] iArr) {
            if (n.this.k == 2 || n.this.k == 3) {
                int length = iArr.length;
                int[] iArr2 = new int[length + 2];
                int i = length - 1;
                System.arraycopy(iArr, 0, iArr2, 0, i);
                iArr2[i] = 12352;
                if (n.this.k == 2) {
                    iArr2[length] = 4;
                } else {
                    iArr2[length] = 64;
                }
                iArr2[length + 1] = 12344;
                return iArr2;
            }
            return iArr;
        }

        abstract EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        @Override // com.amap.api.mapcore.util.n.e
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (egl10.eglChooseConfig(eGLDisplay, this.a, null, 0, iArr)) {
                int i = iArr[0];
                if (i > 0) {
                    EGLConfig[] eGLConfigArr = new EGLConfig[i];
                    if (egl10.eglChooseConfig(eGLDisplay, this.a, eGLConfigArr, i, iArr)) {
                        EGLConfig a = a(egl10, eGLDisplay, eGLConfigArr);
                        if (a != null) {
                            return a;
                        }
                        throw new IllegalArgumentException("No config chosen");
                    }
                    throw new IllegalArgumentException("eglChooseConfig#2 failed");
                }
                throw new IllegalArgumentException("No configs match configSpec");
            }
            throw new IllegalArgumentException("eglChooseConfig failed");
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private class c implements f {
        private c() {
        }

        @Override // com.amap.api.mapcore.util.n.f
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {12440, n.this.k, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (n.this.k == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.amap.api.mapcore.util.n.f
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                return;
            }
            Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
            h.a("eglDestroyContex", egl10.eglGetError());
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface e {
        EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface f {
        EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface g {
        EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class i extends Thread {
        private boolean a;
        private boolean b;
        private boolean c;
        private boolean d;
        private boolean e;
        private boolean f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean k;
        private boolean p;
        private h s;
        private WeakReference<n> t;
        private ArrayList<Runnable> q = new ArrayList<>();
        private boolean r = true;
        private int l = 0;
        private int m = 0;
        private boolean o = true;
        private int n = 1;

        i(WeakReference<n> weakReference) {
            this.t = weakReference;
        }

        private void l() {
            if (this.i) {
                this.i = false;
                this.s.e();
            }
        }

        private void m() {
            if (this.h) {
                this.s.f();
                this.h = false;
                n.a.c(this);
            }
        }

        private void n() throws InterruptedException {
            boolean z;
            this.s = new h(this.t);
            this.h = false;
            this.i = false;
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            GL10 gl10 = null;
            boolean z5 = false;
            boolean z6 = false;
            boolean z7 = false;
            boolean z8 = false;
            int i = 0;
            int i2 = 0;
            boolean z9 = false;
            while (true) {
                Runnable runnable = null;
                while (true) {
                    try {
                        synchronized (n.a) {
                            while (!this.a) {
                                if (!this.q.isEmpty()) {
                                    runnable = this.q.remove(0);
                                } else {
                                    boolean z10 = this.d;
                                    boolean z11 = this.c;
                                    if (z10 != z11) {
                                        this.d = z11;
                                        n.a.notifyAll();
                                    } else {
                                        z11 = false;
                                    }
                                    if (this.k) {
                                        l();
                                        m();
                                        this.k = false;
                                        z4 = true;
                                    }
                                    if (z2) {
                                        l();
                                        m();
                                        z2 = false;
                                    }
                                    if (z11 && this.i) {
                                        l();
                                    }
                                    if (z11 && this.h) {
                                        n nVar = this.t.get();
                                        if (!(nVar == null ? false : nVar.l) || n.a.a()) {
                                            m();
                                        }
                                    }
                                    if (z11 && n.a.b()) {
                                        this.s.f();
                                    }
                                    if (!this.e && !this.g) {
                                        if (this.i) {
                                            l();
                                        }
                                        this.g = true;
                                        this.f = false;
                                        n.a.notifyAll();
                                    }
                                    if (this.e && this.g) {
                                        this.g = false;
                                        n.a.notifyAll();
                                    }
                                    if (z3) {
                                        this.p = true;
                                        n.a.notifyAll();
                                        z3 = false;
                                        z9 = false;
                                    }
                                    if (o()) {
                                        if (!this.h) {
                                            if (z4) {
                                                z4 = false;
                                            } else if (n.a.b(this)) {
                                                try {
                                                    this.s.a();
                                                    this.h = true;
                                                    n.a.notifyAll();
                                                    z5 = true;
                                                } catch (RuntimeException e) {
                                                    n.a.c(this);
                                                    throw e;
                                                }
                                            }
                                        }
                                        if (this.h && !this.i) {
                                            this.i = true;
                                            z6 = true;
                                            z7 = true;
                                            z8 = true;
                                        }
                                        if (this.i) {
                                            if (this.r) {
                                                int i3 = this.l;
                                                int i4 = this.m;
                                                this.r = false;
                                                i = i3;
                                                i2 = i4;
                                                z = false;
                                                z6 = true;
                                                z8 = true;
                                                z9 = true;
                                            } else {
                                                z = false;
                                            }
                                            this.o = z;
                                            n.a.notifyAll();
                                        }
                                    }
                                    n.a.wait();
                                }
                            }
                            synchronized (n.a) {
                                l();
                                m();
                            }
                            return;
                        }
                        if (runnable != null) {
                            break;
                        }
                        if (z6) {
                            if (this.s.b()) {
                                synchronized (n.a) {
                                    this.j = true;
                                    n.a.notifyAll();
                                }
                                z6 = false;
                            } else {
                                synchronized (n.a) {
                                    this.j = true;
                                    this.f = true;
                                    n.a.notifyAll();
                                }
                            }
                        }
                        if (z7) {
                            gl10 = (GL10) this.s.c();
                            n.a.a(gl10);
                            z7 = false;
                        }
                        if (z5) {
                            n nVar2 = this.t.get();
                            if (nVar2 != null) {
                                nVar2.d.onSurfaceCreated(gl10, this.s.d);
                            }
                            z5 = false;
                        }
                        if (z8) {
                            n nVar3 = this.t.get();
                            if (nVar3 != null) {
                                nVar3.d.onSurfaceChanged(gl10, i, i2);
                            }
                            z8 = false;
                        }
                        n nVar4 = this.t.get();
                        if (nVar4 != null) {
                            nVar4.d.onDrawFrame(gl10);
                        }
                        int d = this.s.d();
                        if (d != 12288) {
                            if (d != 12302) {
                                h.a("GLThread", "eglSwapBuffers", d);
                                synchronized (n.a) {
                                    this.f = true;
                                    n.a.notifyAll();
                                }
                            } else {
                                z2 = true;
                            }
                        }
                        if (z9) {
                            z3 = true;
                        }
                    } catch (Throwable th) {
                        synchronized (n.a) {
                            l();
                            m();
                            throw th;
                        }
                    }
                }
                runnable.run();
            }
        }

        private boolean o() {
            return !this.d && this.e && !this.f && this.l > 0 && this.m > 0 && (this.o || this.n == 1);
        }

        public int b() {
            int i;
            synchronized (n.a) {
                i = this.n;
            }
            return i;
        }

        public void c() {
            synchronized (n.a) {
                this.o = true;
                n.a.notifyAll();
            }
        }

        public void d() {
            synchronized (n.a) {
                this.e = true;
                this.j = false;
                n.a.notifyAll();
                while (this.g && !this.j && !this.b) {
                    try {
                        n.a.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void e() {
            synchronized (n.a) {
                this.e = false;
                n.a.notifyAll();
                while (!this.g && !this.b) {
                    try {
                        if (MapsInitializer.getTextureViewDestorySync()) {
                            n.a.wait();
                        } else {
                            n.a.wait(2000L);
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void f() {
            synchronized (n.a) {
                this.c = true;
                n.a.notifyAll();
                while (!this.b && !this.d) {
                    try {
                        if (MapsInitializer.getTextureViewDestorySync()) {
                            n.a.wait();
                        } else {
                            n.a.wait(2000L);
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void g() {
            synchronized (n.a) {
                this.c = false;
                this.o = true;
                this.p = false;
                n.a.notifyAll();
                while (!this.b && this.d && !this.p) {
                    try {
                        n.a.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void h() {
            synchronized (n.a) {
                this.a = true;
                n.a.notifyAll();
                while (!this.b) {
                    try {
                        n.a.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void i() {
            this.k = true;
            n.a.notifyAll();
        }

        public int j() {
            int i;
            synchronized (n.a) {
                i = this.l;
            }
            return i;
        }

        public int k() {
            int i;
            synchronized (n.a) {
                i = this.m;
            }
            return i;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                n();
            } catch (InterruptedException unused) {
            } catch (Throwable th) {
                n.a.a(this);
                throw th;
            }
            n.a.a(this);
        }

        public boolean a() {
            return this.h && this.i && o();
        }

        public void a(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (n.a) {
                    this.n = i;
                    n.a.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public void a(int i, int i2) {
            synchronized (n.a) {
                this.l = i;
                this.m = i2;
                this.r = true;
                this.o = true;
                this.p = false;
                n.a.notifyAll();
                while (!this.b && !this.d && !this.p && a()) {
                    try {
                        n.a.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void a(Runnable runnable) {
            if (runnable != null) {
                synchronized (n.a) {
                    this.q.add(runnable);
                    n.a.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("r must not be null");
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface k {
        GL a(GL gl);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class l extends Writer {
        private StringBuilder a = new StringBuilder();

        l() {
        }

        private void a() {
            if (this.a.length() > 0) {
                Log.v("GLSurfaceView", this.a.toString());
                StringBuilder sb = this.a;
                sb.delete(0, sb.length());
            }
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            a();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            a();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                char c = cArr[i + i3];
                if (c == '\n') {
                    a();
                } else {
                    this.a.append(c);
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private class m extends b {
        public m(boolean z) {
            super(8, 8, 8, 0, z ? 16 : 0, 0);
        }
    }

    public n(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new WeakReference<>(this);
        a();
    }

    protected void finalize() throws Throwable {
        try {
            i iVar = this.c;
            if (iVar != null) {
                iVar.h();
            }
        } finally {
            super.finalize();
        }
    }

    public int getRenderMode() {
        return this.c.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.e && this.d != null) {
            i iVar = this.c;
            int b2 = iVar != null ? iVar.b() : 1;
            i iVar2 = new i(this.b);
            this.c = iVar2;
            if (b2 != 1) {
                iVar2.a(b2);
            }
            this.c.start();
        }
        this.e = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDetachedFromWindow() {
        i iVar = this.c;
        if (iVar != null) {
            iVar.h();
        }
        this.e = true;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        onSurfaceTextureSizeChanged(getSurfaceTexture(), i4 - i2, i5 - i3);
        super.onLayout(z, i2, i3, i4, i5);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.c.d();
        if (MapsInitializer.getTextureSizeChangedInvoked()) {
            onSurfaceTextureSizeChanged(surfaceTexture, i2, i3);
        } else if (this.c.j() == i2 && this.c.k() == i3) {
        } else {
            onSurfaceTextureSizeChanged(surfaceTexture, i2, i3);
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.c.e();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.c.a(i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void queueEvent(Runnable runnable) {
        this.c.a(runnable);
    }

    public void requestRender() {
        this.c.c();
    }

    public void setRenderMode(int i2) {
        this.c.a(i2);
    }

    public void setRenderer(GLSurfaceView.Renderer renderer) {
        e();
        if (this.f == null) {
            this.f = new m(true);
        }
        if (this.g == null) {
            this.g = new c();
        }
        if (this.h == null) {
            this.h = new d();
        }
        this.d = renderer;
        i iVar = new i(this.b);
        this.c = iVar;
        iVar.start();
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private static class d implements g {
        private d() {
        }

        @Override // com.amap.api.mapcore.util.n.g
        public EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e) {
                Log.e("GLSurfaceView", "eglCreateWindowSurface", e);
                return null;
            }
        }

        @Override // com.amap.api.mapcore.util.n.g
        public void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    private void a() {
        setSurfaceTextureListener(this);
    }

    private void e() {
        if (this.c != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    public void b() {
        this.c.f();
    }

    public void c() {
        this.c.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class j {
        private static String a = "GLThreadManager";
        private boolean b;
        private int c;
        private boolean d;
        private boolean e;
        private boolean f;
        private i g;

        private j() {
        }

        public synchronized void a(i iVar) {
            iVar.b = true;
            if (this.g == iVar) {
                this.g = null;
            }
            notifyAll();
        }

        public boolean b(i iVar) {
            i iVar2 = this.g;
            if (iVar2 != iVar && iVar2 != null) {
                c();
                if (this.e) {
                    return true;
                }
                i iVar3 = this.g;
                if (iVar3 != null) {
                    iVar3.i();
                    return false;
                }
                return false;
            }
            this.g = iVar;
            notifyAll();
            return true;
        }

        public void c(i iVar) {
            if (this.g == iVar) {
                this.g = null;
            }
            notifyAll();
        }

        private void c() {
            if (this.b) {
                return;
            }
            this.c = 131072;
            this.e = true;
            this.b = true;
        }

        public synchronized boolean a() {
            return this.f;
        }

        public synchronized void a(GL10 gl10) {
            if (!this.d && gl10 != null) {
                c();
                String glGetString = gl10.glGetString(7937);
                if (this.c < 131072) {
                    this.e = !glGetString.startsWith("Q3Dimension MSM7500 ");
                    notifyAll();
                }
                this.f = this.e ? false : true;
                this.d = true;
            }
        }

        public synchronized boolean b() {
            c();
            return !this.e;
        }
    }

    public void a(f fVar) {
        e();
        this.g = fVar;
    }

    public void a(e eVar) {
        e();
        this.f = eVar;
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private class b extends a {
        protected int c;
        protected int d;
        protected int e;
        protected int f;
        protected int g;
        protected int h;
        private int[] j;

        public b(int i, int i2, int i3, int i4, int i5, int i6) {
            super(new int[]{12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12344});
            this.j = new int[1];
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
            this.g = i5;
            this.h = i6;
        }

        @Override // com.amap.api.mapcore.util.n.a
        public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int a = a(egl10, eGLDisplay, eGLConfig, 12325, 0);
                int a2 = a(egl10, eGLDisplay, eGLConfig, 12326, 0);
                if (a >= this.g && a2 >= this.h) {
                    int a3 = a(egl10, eGLDisplay, eGLConfig, 12324, 0);
                    int a4 = a(egl10, eGLDisplay, eGLConfig, 12323, 0);
                    int a5 = a(egl10, eGLDisplay, eGLConfig, 12322, 0);
                    int a6 = a(egl10, eGLDisplay, eGLConfig, 12321, 0);
                    if (a3 == this.c && a4 == this.d && a5 == this.e && a6 == this.f) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }

        private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.j) ? this.j[0] : i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class h {
        EGL10 a;
        EGLDisplay b;
        EGLSurface c;
        EGLConfig d;
        EGLContext e;
        private WeakReference<n> f;

        public h(WeakReference<n> weakReference) {
            this.f = weakReference;
        }

        private void g() {
            EGLSurface eGLSurface;
            EGLSurface eGLSurface2 = this.c;
            if (eGLSurface2 == null || eGLSurface2 == (eGLSurface = EGL10.EGL_NO_SURFACE)) {
                return;
            }
            this.a.eglMakeCurrent(this.b, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            n nVar = this.f.get();
            if (nVar != null) {
                nVar.h.a(this.a, this.b, this.c);
            }
            this.c = null;
        }

        public void a() {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.a = egl10;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.b = eglGetDisplay;
            if (eglGetDisplay != EGL10.EGL_NO_DISPLAY) {
                if (this.a.eglInitialize(eglGetDisplay, new int[2])) {
                    n nVar = this.f.get();
                    if (nVar != null) {
                        this.d = nVar.f.chooseConfig(this.a, this.b);
                        this.e = nVar.g.createContext(this.a, this.b, this.d);
                    } else {
                        this.d = null;
                        this.e = null;
                    }
                    EGLContext eGLContext = this.e;
                    if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
                        this.e = null;
                        a("createContext");
                    }
                    this.c = null;
                    return;
                }
                throw new RuntimeException("eglInitialize failed");
            }
            throw new RuntimeException("eglGetDisplay failed");
        }

        public boolean b() {
            if (this.a != null) {
                if (this.b != null) {
                    if (this.d != null) {
                        g();
                        n nVar = this.f.get();
                        if (nVar != null) {
                            this.c = nVar.h.a(this.a, this.b, this.d, nVar.getSurfaceTexture());
                        } else {
                            this.c = null;
                        }
                        EGLSurface eGLSurface = this.c;
                        if (eGLSurface != null && eGLSurface != EGL10.EGL_NO_SURFACE) {
                            if (this.a.eglMakeCurrent(this.b, eGLSurface, eGLSurface, this.e)) {
                                return true;
                            }
                            a("EGLHelper", "eglMakeCurrent", this.a.eglGetError());
                            return false;
                        }
                        if (this.a.eglGetError() == 12299) {
                            Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                        }
                        return false;
                    }
                    throw new RuntimeException("mEglConfig not initialized");
                }
                throw new RuntimeException("eglDisplay not initialized");
            }
            throw new RuntimeException("egl not initialized");
        }

        GL c() {
            GL gl = this.e.getGL();
            n nVar = this.f.get();
            if (nVar != null) {
                if (nVar.i != null) {
                    gl = nVar.i.a(gl);
                }
                if ((nVar.j & 3) != 0) {
                    return GLDebugHelper.wrap(gl, (nVar.j & 1) != 0 ? 1 : 0, (nVar.j & 2) != 0 ? new l() : null);
                }
                return gl;
            }
            return gl;
        }

        public int d() {
            return !this.a.eglSwapBuffers(this.b, this.c) ? this.a.eglGetError() : MessageConstant$CommandId.COMMAND_BASE;
        }

        public void e() {
            g();
        }

        public void f() {
            if (this.e != null) {
                n nVar = this.f.get();
                if (nVar != null) {
                    nVar.g.destroyContext(this.a, this.b, this.e);
                }
                this.e = null;
            }
            EGLDisplay eGLDisplay = this.b;
            if (eGLDisplay != null) {
                this.a.eglTerminate(eGLDisplay);
                this.b = null;
            }
        }

        private void a(String str) {
            a(str, this.a.eglGetError());
        }

        public static void a(String str, int i) {
            throw new RuntimeException(b(str, i));
        }

        public static void a(String str, String str2, int i) {
            Log.w(str, b(str2, i));
        }

        public static String b(String str, int i) {
            return str + " failed: " + i;
        }
    }
}
