package tb;

import android.opengl.GLSurfaceView;
import android.os.Build;
import android.util.Log;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class sd0 implements GLSurfaceView.EGLContextFactory, GLSurfaceView.EGLWindowSurfaceFactory {
    private boolean a = false;
    private boolean b = false;
    private boolean c = true;
    private int d = 2;
    private EGLContext e = EGL10.EGL_NO_CONTEXT;

    private boolean f(EGL10 egl10, EGLDisplay eGLDisplay) {
        return egl10.eglQueryString(eGLDisplay, 12373).contains("EGL_EXT_protected_content");
    }

    public void a(int i) {
        this.d = i;
    }

    public void b(boolean z) {
        this.c = z;
    }

    public void c(EGLContext eGLContext) {
        this.e = eGLContext;
    }

    @Override // android.opengl.GLSurfaceView.EGLContextFactory
    public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
        int i;
        IntBuffer allocate = IntBuffer.allocate(8);
        allocate.put(12440);
        allocate.put(this.d);
        if (this.a) {
            allocate.put(12544);
            allocate.put(12545);
        }
        if (this.b && f(egl10, eGLDisplay)) {
            allocate.put(12992);
            allocate.put(1);
        }
        if (!this.c && egl10.eglQueryString(eGLDisplay, 12373).contains("EGL_KHR_create_context_no_error")) {
            allocate.put(12723);
            allocate.put(1);
        }
        while (allocate.hasRemaining()) {
            allocate.put(12344);
        }
        EGLContext eglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, this.e, allocate.array());
        if ((eglCreateContext == null || eglCreateContext == EGL10.EGL_NO_CONTEXT) && (i = this.d) > 2) {
            StringBuilder sb = new StringBuilder(75);
            sb.append("Failed to create EGL context with version ");
            sb.append(i);
            sb.append(", will try 2");
            Log.w("GvrEglFactory", sb.toString());
            allocate.array()[1] = 2;
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, this.e, allocate.array());
        }
        return eglCreateContext;
    }

    @Override // android.opengl.GLSurfaceView.EGLWindowSurfaceFactory
    public EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
        try {
            return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, (this.b && f(egl10, eGLDisplay)) ? new int[]{12992, 1, 12344} : null);
        } catch (IllegalArgumentException e) {
            Log.e("GvrEglFactory", "eglCreateWindowSurface", e);
            return null;
        }
    }

    public void d(boolean z) {
        this.a = z;
    }

    @Override // android.opengl.GLSurfaceView.EGLContextFactory
    public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
        egl10.eglDestroyContext(eGLDisplay, eGLContext);
    }

    @Override // android.opengl.GLSurfaceView.EGLWindowSurfaceFactory
    public void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        egl10.eglDestroySurface(eGLDisplay, eGLSurface);
    }

    public void e(boolean z) {
        if (z && Build.VERSION.SDK_INT < 17) {
            throw new RuntimeException("Protected buffer support requires EGL 1.4, available only on Jelly Bean MR1 and later.");
        }
        this.b = z;
    }
}
