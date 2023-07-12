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
/* renamed from: com.amap.api.mapcore.util.n */
/* loaded from: classes10.dex */
public class TextureView$SurfaceTextureListenerC4615n extends TextureView implements TextureView.SurfaceTextureListener {
    private static final C4625j a = new C4625j();
    private final WeakReference<TextureView$SurfaceTextureListenerC4615n> b;
    private C4624i c;
    private GLSurfaceView.Renderer d;
    private boolean e;
    private InterfaceC4620e f;
    private InterfaceC4621f g;
    private InterfaceC4622g h;
    private InterfaceC4626k i;
    private int j;
    private int k;
    private boolean l;

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.n$a */
    /* loaded from: classes10.dex */
    private abstract class AbstractC4616a implements InterfaceC4620e {
        protected int[] a;

        public AbstractC4616a(int[] iArr) {
            this.a = a(iArr);
        }

        private int[] a(int[] iArr) {
            if (TextureView$SurfaceTextureListenerC4615n.this.k == 2 || TextureView$SurfaceTextureListenerC4615n.this.k == 3) {
                int length = iArr.length;
                int[] iArr2 = new int[length + 2];
                int i = length - 1;
                System.arraycopy(iArr, 0, iArr2, 0, i);
                iArr2[i] = 12352;
                if (TextureView$SurfaceTextureListenerC4615n.this.k == 2) {
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

        @Override // com.amap.api.mapcore.util.TextureView$SurfaceTextureListenerC4615n.InterfaceC4620e
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
    /* renamed from: com.amap.api.mapcore.util.n$c */
    /* loaded from: classes10.dex */
    private class C4618c implements InterfaceC4621f {
        private C4618c() {
        }

        @Override // com.amap.api.mapcore.util.TextureView$SurfaceTextureListenerC4615n.InterfaceC4621f
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {12440, TextureView$SurfaceTextureListenerC4615n.this.k, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (TextureView$SurfaceTextureListenerC4615n.this.k == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.amap.api.mapcore.util.TextureView$SurfaceTextureListenerC4615n.InterfaceC4621f
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                return;
            }
            Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
            C4623h.a("eglDestroyContex", egl10.eglGetError());
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.n$e */
    /* loaded from: classes10.dex */
    public interface InterfaceC4620e {
        EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.n$f */
    /* loaded from: classes10.dex */
    public interface InterfaceC4621f {
        EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.n$g */
    /* loaded from: classes10.dex */
    public interface InterfaceC4622g {
        EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.n$i */
    /* loaded from: classes10.dex */
    public static class C4624i extends Thread {
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
        private C4623h s;
        private WeakReference<TextureView$SurfaceTextureListenerC4615n> t;
        private ArrayList<Runnable> q = new ArrayList<>();
        private boolean r = true;
        private int l = 0;
        private int m = 0;
        private boolean o = true;
        private int n = 1;

        C4624i(WeakReference<TextureView$SurfaceTextureListenerC4615n> weakReference) {
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
                TextureView$SurfaceTextureListenerC4615n.a.c(this);
            }
        }

        private void n() throws InterruptedException {
            boolean z;
            this.s = new C4623h(this.t);
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
                        synchronized (TextureView$SurfaceTextureListenerC4615n.a) {
                            while (!this.a) {
                                if (!this.q.isEmpty()) {
                                    runnable = this.q.remove(0);
                                } else {
                                    boolean z10 = this.d;
                                    boolean z11 = this.c;
                                    if (z10 != z11) {
                                        this.d = z11;
                                        TextureView$SurfaceTextureListenerC4615n.a.notifyAll();
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
                                        TextureView$SurfaceTextureListenerC4615n textureView$SurfaceTextureListenerC4615n = this.t.get();
                                        if (!(textureView$SurfaceTextureListenerC4615n == null ? false : textureView$SurfaceTextureListenerC4615n.l) || TextureView$SurfaceTextureListenerC4615n.a.a()) {
                                            m();
                                        }
                                    }
                                    if (z11 && TextureView$SurfaceTextureListenerC4615n.a.b()) {
                                        this.s.f();
                                    }
                                    if (!this.e && !this.g) {
                                        if (this.i) {
                                            l();
                                        }
                                        this.g = true;
                                        this.f = false;
                                        TextureView$SurfaceTextureListenerC4615n.a.notifyAll();
                                    }
                                    if (this.e && this.g) {
                                        this.g = false;
                                        TextureView$SurfaceTextureListenerC4615n.a.notifyAll();
                                    }
                                    if (z3) {
                                        this.p = true;
                                        TextureView$SurfaceTextureListenerC4615n.a.notifyAll();
                                        z3 = false;
                                        z9 = false;
                                    }
                                    if (o()) {
                                        if (!this.h) {
                                            if (z4) {
                                                z4 = false;
                                            } else if (TextureView$SurfaceTextureListenerC4615n.a.b(this)) {
                                                try {
                                                    this.s.a();
                                                    this.h = true;
                                                    TextureView$SurfaceTextureListenerC4615n.a.notifyAll();
                                                    z5 = true;
                                                } catch (RuntimeException e) {
                                                    TextureView$SurfaceTextureListenerC4615n.a.c(this);
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
                                            TextureView$SurfaceTextureListenerC4615n.a.notifyAll();
                                        }
                                    }
                                    TextureView$SurfaceTextureListenerC4615n.a.wait();
                                }
                            }
                            synchronized (TextureView$SurfaceTextureListenerC4615n.a) {
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
                                synchronized (TextureView$SurfaceTextureListenerC4615n.a) {
                                    this.j = true;
                                    TextureView$SurfaceTextureListenerC4615n.a.notifyAll();
                                }
                                z6 = false;
                            } else {
                                synchronized (TextureView$SurfaceTextureListenerC4615n.a) {
                                    this.j = true;
                                    this.f = true;
                                    TextureView$SurfaceTextureListenerC4615n.a.notifyAll();
                                }
                            }
                        }
                        if (z7) {
                            gl10 = (GL10) this.s.c();
                            TextureView$SurfaceTextureListenerC4615n.a.a(gl10);
                            z7 = false;
                        }
                        if (z5) {
                            TextureView$SurfaceTextureListenerC4615n textureView$SurfaceTextureListenerC4615n2 = this.t.get();
                            if (textureView$SurfaceTextureListenerC4615n2 != null) {
                                textureView$SurfaceTextureListenerC4615n2.d.onSurfaceCreated(gl10, this.s.d);
                            }
                            z5 = false;
                        }
                        if (z8) {
                            TextureView$SurfaceTextureListenerC4615n textureView$SurfaceTextureListenerC4615n3 = this.t.get();
                            if (textureView$SurfaceTextureListenerC4615n3 != null) {
                                textureView$SurfaceTextureListenerC4615n3.d.onSurfaceChanged(gl10, i, i2);
                            }
                            z8 = false;
                        }
                        TextureView$SurfaceTextureListenerC4615n textureView$SurfaceTextureListenerC4615n4 = this.t.get();
                        if (textureView$SurfaceTextureListenerC4615n4 != null) {
                            textureView$SurfaceTextureListenerC4615n4.d.onDrawFrame(gl10);
                        }
                        int d = this.s.d();
                        if (d != 12288) {
                            if (d != 12302) {
                                C4623h.a("GLThread", "eglSwapBuffers", d);
                                synchronized (TextureView$SurfaceTextureListenerC4615n.a) {
                                    this.f = true;
                                    TextureView$SurfaceTextureListenerC4615n.a.notifyAll();
                                }
                            } else {
                                z2 = true;
                            }
                        }
                        if (z9) {
                            z3 = true;
                        }
                    } catch (Throwable th) {
                        synchronized (TextureView$SurfaceTextureListenerC4615n.a) {
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
            synchronized (TextureView$SurfaceTextureListenerC4615n.a) {
                i = this.n;
            }
            return i;
        }

        public void c() {
            synchronized (TextureView$SurfaceTextureListenerC4615n.a) {
                this.o = true;
                TextureView$SurfaceTextureListenerC4615n.a.notifyAll();
            }
        }

        public void d() {
            synchronized (TextureView$SurfaceTextureListenerC4615n.a) {
                this.e = true;
                this.j = false;
                TextureView$SurfaceTextureListenerC4615n.a.notifyAll();
                while (this.g && !this.j && !this.b) {
                    try {
                        TextureView$SurfaceTextureListenerC4615n.a.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void e() {
            synchronized (TextureView$SurfaceTextureListenerC4615n.a) {
                this.e = false;
                TextureView$SurfaceTextureListenerC4615n.a.notifyAll();
                while (!this.g && !this.b) {
                    try {
                        if (MapsInitializer.getTextureViewDestorySync()) {
                            TextureView$SurfaceTextureListenerC4615n.a.wait();
                        } else {
                            TextureView$SurfaceTextureListenerC4615n.a.wait(2000L);
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void f() {
            synchronized (TextureView$SurfaceTextureListenerC4615n.a) {
                this.c = true;
                TextureView$SurfaceTextureListenerC4615n.a.notifyAll();
                while (!this.b && !this.d) {
                    try {
                        if (MapsInitializer.getTextureViewDestorySync()) {
                            TextureView$SurfaceTextureListenerC4615n.a.wait();
                        } else {
                            TextureView$SurfaceTextureListenerC4615n.a.wait(2000L);
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void g() {
            synchronized (TextureView$SurfaceTextureListenerC4615n.a) {
                this.c = false;
                this.o = true;
                this.p = false;
                TextureView$SurfaceTextureListenerC4615n.a.notifyAll();
                while (!this.b && this.d && !this.p) {
                    try {
                        TextureView$SurfaceTextureListenerC4615n.a.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void h() {
            synchronized (TextureView$SurfaceTextureListenerC4615n.a) {
                this.a = true;
                TextureView$SurfaceTextureListenerC4615n.a.notifyAll();
                while (!this.b) {
                    try {
                        TextureView$SurfaceTextureListenerC4615n.a.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void i() {
            this.k = true;
            TextureView$SurfaceTextureListenerC4615n.a.notifyAll();
        }

        public int j() {
            int i;
            synchronized (TextureView$SurfaceTextureListenerC4615n.a) {
                i = this.l;
            }
            return i;
        }

        public int k() {
            int i;
            synchronized (TextureView$SurfaceTextureListenerC4615n.a) {
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
                TextureView$SurfaceTextureListenerC4615n.a.a(this);
                throw th;
            }
            TextureView$SurfaceTextureListenerC4615n.a.a(this);
        }

        public boolean a() {
            return this.h && this.i && o();
        }

        public void a(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (TextureView$SurfaceTextureListenerC4615n.a) {
                    this.n = i;
                    TextureView$SurfaceTextureListenerC4615n.a.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public void a(int i, int i2) {
            synchronized (TextureView$SurfaceTextureListenerC4615n.a) {
                this.l = i;
                this.m = i2;
                this.r = true;
                this.o = true;
                this.p = false;
                TextureView$SurfaceTextureListenerC4615n.a.notifyAll();
                while (!this.b && !this.d && !this.p && a()) {
                    try {
                        TextureView$SurfaceTextureListenerC4615n.a.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void a(Runnable runnable) {
            if (runnable != null) {
                synchronized (TextureView$SurfaceTextureListenerC4615n.a) {
                    this.q.add(runnable);
                    TextureView$SurfaceTextureListenerC4615n.a.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("r must not be null");
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.n$k */
    /* loaded from: classes10.dex */
    public interface InterfaceC4626k {
        GL a(GL gl);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.n$l */
    /* loaded from: classes10.dex */
    public static class C4627l extends Writer {
        private StringBuilder a = new StringBuilder();

        C4627l() {
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
    /* renamed from: com.amap.api.mapcore.util.n$m */
    /* loaded from: classes10.dex */
    private class C4628m extends C4617b {
        public C4628m(boolean z) {
            super(8, 8, 8, 0, z ? 16 : 0, 0);
        }
    }

    public TextureView$SurfaceTextureListenerC4615n(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new WeakReference<>(this);
        a();
    }

    protected void finalize() throws Throwable {
        try {
            C4624i c4624i = this.c;
            if (c4624i != null) {
                c4624i.h();
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
            C4624i c4624i = this.c;
            int b = c4624i != null ? c4624i.b() : 1;
            C4624i c4624i2 = new C4624i(this.b);
            this.c = c4624i2;
            if (b != 1) {
                c4624i2.a(b);
            }
            this.c.start();
        }
        this.e = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDetachedFromWindow() {
        C4624i c4624i = this.c;
        if (c4624i != null) {
            c4624i.h();
        }
        this.e = true;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        onSurfaceTextureSizeChanged(getSurfaceTexture(), i3 - i, i4 - i2);
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.c.d();
        if (MapsInitializer.getTextureSizeChangedInvoked()) {
            onSurfaceTextureSizeChanged(surfaceTexture, i, i2);
        } else if (this.c.j() == i && this.c.k() == i2) {
        } else {
            onSurfaceTextureSizeChanged(surfaceTexture, i, i2);
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.c.e();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        this.c.a(i, i2);
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

    public void setRenderMode(int i) {
        this.c.a(i);
    }

    public void setRenderer(GLSurfaceView.Renderer renderer) {
        e();
        if (this.f == null) {
            this.f = new C4628m(true);
        }
        if (this.g == null) {
            this.g = new C4618c();
        }
        if (this.h == null) {
            this.h = new C4619d();
        }
        this.d = renderer;
        C4624i c4624i = new C4624i(this.b);
        this.c = c4624i;
        c4624i.start();
    }

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.n$d */
    /* loaded from: classes10.dex */
    private static class C4619d implements InterfaceC4622g {
        private C4619d() {
        }

        @Override // com.amap.api.mapcore.util.TextureView$SurfaceTextureListenerC4615n.InterfaceC4622g
        public EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e) {
                Log.e("GLSurfaceView", "eglCreateWindowSurface", e);
                return null;
            }
        }

        @Override // com.amap.api.mapcore.util.TextureView$SurfaceTextureListenerC4615n.InterfaceC4622g
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
    /* renamed from: com.amap.api.mapcore.util.n$j */
    /* loaded from: classes10.dex */
    public static class C4625j {
        private static String a = "GLThreadManager";
        private boolean b;
        private int c;
        private boolean d;
        private boolean e;
        private boolean f;
        private C4624i g;

        private C4625j() {
        }

        public synchronized void a(C4624i c4624i) {
            c4624i.b = true;
            if (this.g == c4624i) {
                this.g = null;
            }
            notifyAll();
        }

        public boolean b(C4624i c4624i) {
            C4624i c4624i2 = this.g;
            if (c4624i2 != c4624i && c4624i2 != null) {
                c();
                if (this.e) {
                    return true;
                }
                C4624i c4624i3 = this.g;
                if (c4624i3 != null) {
                    c4624i3.i();
                    return false;
                }
                return false;
            }
            this.g = c4624i;
            notifyAll();
            return true;
        }

        public void c(C4624i c4624i) {
            if (this.g == c4624i) {
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

    public void a(InterfaceC4621f interfaceC4621f) {
        e();
        this.g = interfaceC4621f;
    }

    public void a(InterfaceC4620e interfaceC4620e) {
        e();
        this.f = interfaceC4620e;
    }

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.n$b */
    /* loaded from: classes10.dex */
    private class C4617b extends AbstractC4616a {
        protected int c;
        protected int d;
        protected int e;
        protected int f;
        protected int g;
        protected int h;
        private int[] j;

        public C4617b(int i, int i2, int i3, int i4, int i5, int i6) {
            super(new int[]{12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12344});
            this.j = new int[1];
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
            this.g = i5;
            this.h = i6;
        }

        @Override // com.amap.api.mapcore.util.TextureView$SurfaceTextureListenerC4615n.AbstractC4616a
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
    /* renamed from: com.amap.api.mapcore.util.n$h */
    /* loaded from: classes10.dex */
    public static class C4623h {
        EGL10 a;
        EGLDisplay b;
        EGLSurface c;
        EGLConfig d;
        EGLContext e;
        private WeakReference<TextureView$SurfaceTextureListenerC4615n> f;

        public C4623h(WeakReference<TextureView$SurfaceTextureListenerC4615n> weakReference) {
            this.f = weakReference;
        }

        private void g() {
            EGLSurface eGLSurface;
            EGLSurface eGLSurface2 = this.c;
            if (eGLSurface2 == null || eGLSurface2 == (eGLSurface = EGL10.EGL_NO_SURFACE)) {
                return;
            }
            this.a.eglMakeCurrent(this.b, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            TextureView$SurfaceTextureListenerC4615n textureView$SurfaceTextureListenerC4615n = this.f.get();
            if (textureView$SurfaceTextureListenerC4615n != null) {
                textureView$SurfaceTextureListenerC4615n.h.a(this.a, this.b, this.c);
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
                    TextureView$SurfaceTextureListenerC4615n textureView$SurfaceTextureListenerC4615n = this.f.get();
                    if (textureView$SurfaceTextureListenerC4615n != null) {
                        this.d = textureView$SurfaceTextureListenerC4615n.f.chooseConfig(this.a, this.b);
                        this.e = textureView$SurfaceTextureListenerC4615n.g.createContext(this.a, this.b, this.d);
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
                        TextureView$SurfaceTextureListenerC4615n textureView$SurfaceTextureListenerC4615n = this.f.get();
                        if (textureView$SurfaceTextureListenerC4615n != null) {
                            this.c = textureView$SurfaceTextureListenerC4615n.h.a(this.a, this.b, this.d, textureView$SurfaceTextureListenerC4615n.getSurfaceTexture());
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
            TextureView$SurfaceTextureListenerC4615n textureView$SurfaceTextureListenerC4615n = this.f.get();
            if (textureView$SurfaceTextureListenerC4615n != null) {
                if (textureView$SurfaceTextureListenerC4615n.i != null) {
                    gl = textureView$SurfaceTextureListenerC4615n.i.a(gl);
                }
                if ((textureView$SurfaceTextureListenerC4615n.j & 3) != 0) {
                    return GLDebugHelper.wrap(gl, (textureView$SurfaceTextureListenerC4615n.j & 1) != 0 ? 1 : 0, (textureView$SurfaceTextureListenerC4615n.j & 2) != 0 ? new C4627l() : null);
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
                TextureView$SurfaceTextureListenerC4615n textureView$SurfaceTextureListenerC4615n = this.f.get();
                if (textureView$SurfaceTextureListenerC4615n != null) {
                    textureView$SurfaceTextureListenerC4615n.g.destroyContext(this.a, this.b, this.e);
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
