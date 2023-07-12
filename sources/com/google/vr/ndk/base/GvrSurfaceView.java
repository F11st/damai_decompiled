package com.google.vr.ndk.base;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.GLDebugHelper;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.google.vr.cardboard.EglReadyListener;
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
import tb.sd0;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class GvrSurfaceView extends SurfaceView implements SurfaceHolder.Callback2 {
    public static final int DEBUG_CHECK_GL_ERROR = 1;
    public static final int DEBUG_LOG_GL_CALLS = 2;
    private static final int GL_CONTEXT_FLAG_NO_ERROR_BIT_KHR = 8;
    private static final boolean LOG_ATTACH_DETACH = false;
    private static final boolean LOG_EGL = false;
    private static final boolean LOG_PAUSE_RESUME = false;
    private static final boolean LOG_RENDERER = false;
    private static final boolean LOG_RENDERER_DRAW_FRAME = false;
    private static final boolean LOG_SURFACE = false;
    private static final boolean LOG_THREADS = false;
    public static final int RENDERMODE_CONTINUOUSLY = 1;
    public static final int RENDERMODE_WHEN_DIRTY = 0;
    public static final int SWAPMODE_MANUAL = 2;
    public static final int SWAPMODE_QUEUED = 0;
    public static final int SWAPMODE_SINGLE = 1;
    private static final String TAG = "GvrSurfaceView";
    private EglReadyListener mAppContextListener;
    private int mDebugFlags;
    private boolean mDetached;
    private GLSurfaceView.EGLConfigChooser mEGLConfigChooser;
    private int mEGLContextClientVersion;
    private GLSurfaceView.EGLContextFactory mEGLContextFactory;
    private GLSurfaceView.EGLWindowSurfaceFactory mEGLWindowSurfaceFactory;
    private GLThread mGLThread;
    private GLWrapper mGLWrapper;
    private boolean mPreserveEGLContextOnPause;
    private boolean mPreserveGlThreadOnDetachedFromWindow;
    private GLSurfaceView.Renderer mRenderer;
    private final WeakReference<GvrSurfaceView> mThisWeakRef;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    abstract class BaseConfigChooser implements GLSurfaceView.EGLConfigChooser {
        protected int[] mConfigSpec;

        public BaseConfigChooser(int[] iArr) {
            this.mConfigSpec = filterConfigSpec(iArr);
        }

        private int[] filterConfigSpec(int[] iArr) {
            if (GvrSurfaceView.this.mEGLContextClientVersion == 2 || GvrSurfaceView.this.mEGLContextClientVersion == 3) {
                int length = iArr.length;
                int[] iArr2 = new int[length + 2];
                int i = length - 1;
                System.arraycopy(iArr, 0, iArr2, 0, i);
                iArr2[i] = 12352;
                if (GvrSurfaceView.this.mEGLContextClientVersion == 2) {
                    iArr2[length] = 4;
                } else {
                    iArr2[length] = 64;
                }
                iArr2[length + 1] = 12344;
                return iArr2;
            }
            return iArr;
        }

        @Override // android.opengl.GLSurfaceView.EGLConfigChooser
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int i = 1;
            int[] iArr = new int[1];
            if (egl10.eglChooseConfig(eGLDisplay, this.mConfigSpec, null, 0, iArr)) {
                int i2 = iArr[0];
                if (i2 > 0) {
                    EGLConfig[] eGLConfigArr = new EGLConfig[i2];
                    if (egl10.eglChooseConfig(eGLDisplay, this.mConfigSpec, eGLConfigArr, i2, iArr)) {
                        EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
                        if (chooseConfig != null) {
                            return chooseConfig;
                        }
                        throw new IllegalArgumentException("No config chosen");
                    }
                    throw new IllegalArgumentException("eglChooseConfig#2 failed");
                }
                throw new IllegalArgumentException("No configs match configSpec");
            }
            while (true) {
                int[] iArr2 = this.mConfigSpec;
                if (i < iArr2.length) {
                    if (iArr2[i - 1] == 12352 && iArr2[i] == 64) {
                        Log.w(GvrSurfaceView.TAG, "Failed to choose GLES 3 config, will try 2.");
                        this.mConfigSpec[i] = 4;
                        return chooseConfig(egl10, eGLDisplay);
                    }
                    i++;
                } else {
                    throw new IllegalArgumentException("eglChooseConfig failed");
                }
            }
        }

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    class ComponentSizeChooser extends BaseConfigChooser {
        protected int mAlphaSize;
        protected int mBlueSize;
        protected int mDepthSize;
        protected int mGreenSize;
        protected int mRedSize;
        protected int mStencilSize;
        private int[] mValue;

        public ComponentSizeChooser(GvrSurfaceView gvrSurfaceView, int i, int i2, int i3, int i4, int i5, int i6) {
            super(new int[]{12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12344});
            this.mValue = new int[1];
            this.mRedSize = i;
            this.mGreenSize = i2;
            this.mBlueSize = i3;
            this.mAlphaSize = i4;
            this.mDepthSize = i5;
            this.mStencilSize = i6;
        }

        private int findConfigAttrib(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.mValue) ? this.mValue[0] : i2;
        }

        @Override // com.google.vr.ndk.base.GvrSurfaceView.BaseConfigChooser
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int findConfigAttrib = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12325, 0);
                int findConfigAttrib2 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12326, 0);
                if (findConfigAttrib >= this.mDepthSize && findConfigAttrib2 >= this.mStencilSize) {
                    int findConfigAttrib3 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12324, 0);
                    int findConfigAttrib4 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12323, 0);
                    int findConfigAttrib5 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12322, 0);
                    int findConfigAttrib6 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12321, 0);
                    if (findConfigAttrib3 == this.mRedSize && findConfigAttrib4 == this.mGreenSize && findConfigAttrib5 == this.mBlueSize && findConfigAttrib6 == this.mAlphaSize) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    class DefaultContextFactory implements GLSurfaceView.EGLContextFactory {
        private DefaultContextFactory() {
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {12440, GvrSurfaceView.this.mEGLContextClientVersion, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (GvrSurfaceView.this.mEGLContextClientVersion == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                return;
            }
            String valueOf = String.valueOf(eGLDisplay);
            String valueOf2 = String.valueOf(eGLContext);
            StringBuilder sb = new StringBuilder(valueOf.length() + 18 + valueOf2.length());
            sb.append("display:");
            sb.append(valueOf);
            sb.append(" context: ");
            sb.append(valueOf2);
            Log.e("DefaultContextFactory", sb.toString());
            EglHelper.throwEglException("eglDestroyContext", egl10.eglGetError());
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class DefaultWindowSurfaceFactory implements GLSurfaceView.EGLWindowSurfaceFactory {
        private DefaultWindowSurfaceFactory() {
        }

        @Override // android.opengl.GLSurfaceView.EGLWindowSurfaceFactory
        public EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e) {
                Log.e(GvrSurfaceView.TAG, "eglCreateWindowSurface", e);
                return null;
            }
        }

        @Override // android.opengl.GLSurfaceView.EGLWindowSurfaceFactory
        public void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class EglHelper {
        public static final int EGL_FRONT_BUFFER_AUTO_REFRESH = 12620;
        EGL10 mEgl;
        EGLConfig mEglConfig;
        EGLContext mEglContext;
        EGLDisplay mEglDisplay;
        EGLSurface mEglSurface;
        private WeakReference<GvrSurfaceView> mGvrSurfaceViewWeakRef;
        EGLContext mPendingEglContext;
        EGLDisplay mPendingEglDisplay;

        public EglHelper(WeakReference<GvrSurfaceView> weakReference) {
            this.mGvrSurfaceViewWeakRef = weakReference;
        }

        private void createPendingEglContext() {
            EGLContext createContext;
            EGLDisplay eglGetDisplay = this.mEgl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.mPendingEglDisplay = eglGetDisplay;
            if (eglGetDisplay == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (this.mEgl.eglInitialize(eglGetDisplay, new int[2])) {
                GvrSurfaceView gvrSurfaceView = this.mGvrSurfaceViewWeakRef.get();
                EGLContext eGLContext = null;
                if (gvrSurfaceView != null) {
                    if (gvrSurfaceView.mAppContextListener != null) {
                        EGLContext b = gvrSurfaceView.mAppContextListener.b();
                        if (b != null && b != EGL10.EGL_NO_CONTEXT) {
                            sd0 sd0Var = (sd0) gvrSurfaceView.mEGLContextFactory;
                            int c = gvrSurfaceView.mAppContextListener.c();
                            sd0Var.c(b);
                            sd0Var.b((c & 8) == 0);
                            sd0Var.a(gvrSurfaceView.mAppContextListener.d());
                        } else {
                            throwEglException("Unable to obtain application's OpenGL context.");
                        }
                    }
                    this.mEglConfig = gvrSurfaceView.mEGLConfigChooser.chooseConfig(this.mEgl, this.mPendingEglDisplay);
                    createContext = gvrSurfaceView.mEGLContextFactory.createContext(this.mEgl, this.mPendingEglDisplay, this.mEglConfig);
                } else {
                    this.mEglConfig = null;
                    createContext = null;
                }
                if (createContext == null || createContext == EGL10.EGL_NO_CONTEXT) {
                    int eglGetError = this.mEgl.eglGetError();
                    if (eglGetError == 12294) {
                        Log.e("EglHelper", "Stashed EGL context has become invalid and can no longer be used for sharing.");
                        this.mPendingEglContext = null;
                        this.mPendingEglDisplay = null;
                        this.mEglConfig = null;
                        if (gvrSurfaceView.mAppContextListener != null) {
                            gvrSurfaceView.mAppContextListener.a();
                            return;
                        }
                        return;
                    }
                    throwEglException("createPendingEglContext", eglGetError);
                } else {
                    eGLContext = createContext;
                }
                this.mPendingEglContext = eGLContext;
                return;
            }
            throw new RuntimeException("eglInitialize failed");
        }

        private void destroySurfaceImp() {
            EGLSurface eGLSurface;
            EGLSurface eGLSurface2 = this.mEglSurface;
            if (eGLSurface2 == null || eGLSurface2 == (eGLSurface = EGL10.EGL_NO_SURFACE)) {
                return;
            }
            this.mEgl.eglMakeCurrent(this.mEglDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            GvrSurfaceView gvrSurfaceView = this.mGvrSurfaceViewWeakRef.get();
            if (gvrSurfaceView != null) {
                gvrSurfaceView.mEGLWindowSurfaceFactory.destroySurface(this.mEgl, this.mEglDisplay, this.mEglSurface);
            }
            this.mEglSurface = null;
        }

        public static String formatEglError(String str, int i) {
            String errorString = getErrorString(i);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 9 + String.valueOf(errorString).length());
            sb.append(str);
            sb.append(" failed: ");
            sb.append(errorString);
            return sb.toString();
        }

        private static String getErrorString(int i) {
            switch (i) {
                case MessageConstant$CommandId.COMMAND_BASE /* 12288 */:
                    return "EGL_SUCCESS";
                case MessageConstant$CommandId.COMMAND_REGISTER /* 12289 */:
                    return "EGL_NOT_INITIALIZED";
                case MessageConstant$CommandId.COMMAND_UNREGISTER /* 12290 */:
                    return "EGL_BAD_ACCESS";
                case MessageConstant$CommandId.COMMAND_STATISTIC /* 12291 */:
                    return "EGL_BAD_ALLOC";
                case MessageConstant$CommandId.COMMAND_SET_ALIAS /* 12292 */:
                    return "EGL_BAD_ATTRIBUTE";
                case 12293:
                    return "EGL_BAD_CONFIG";
                case 12294:
                    return "EGL_BAD_CONTEXT";
                case 12295:
                    return "EGL_BAD_CURRENT_SURFACE";
                case 12296:
                    return "EGL_BAD_DISPLAY";
                case 12297:
                    return "EGL_BAD_MATCH";
                case MessageConstant$CommandId.COMMAND_SET_PUSH_TIME /* 12298 */:
                    return "EGL_BAD_NATIVE_PIXMAP";
                case MessageConstant$CommandId.COMMAND_PAUSE_PUSH /* 12299 */:
                    return "EGL_BAD_NATIVE_WINDOW";
                case MessageConstant$CommandId.COMMAND_RESUME_PUSH /* 12300 */:
                    return "EGL_BAD_PARAMETER";
                case 12301:
                    return "EGL_BAD_SURFACE";
                case 12302:
                    return "EGL_CONTEXT_LOST";
                default:
                    return getHex(i);
            }
        }

        private static String getHex(int i) {
            String valueOf = String.valueOf(Integer.toHexString(i));
            return valueOf.length() != 0 ? "0x".concat(valueOf) : new String("0x");
        }

        private void initialize() {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.mEgl = egl10;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.mEglDisplay = eglGetDisplay;
            if (eglGetDisplay != EGL10.EGL_NO_DISPLAY) {
                if (this.mEgl.eglInitialize(eglGetDisplay, new int[2])) {
                    this.mEglSurface = null;
                    return;
                }
                throw new RuntimeException("eglInitialize failed");
            }
            throw new RuntimeException("eglGetDisplay failed");
        }

        public static void logEglErrorAsWarning(String str, String str2, int i) {
            Log.w(str, formatEglError(str2, i));
        }

        private void throwEglException(String str) {
            throwEglException(str, this.mEgl.eglGetError());
        }

        GL createGL() {
            GL gl = this.mEglContext.getGL();
            GvrSurfaceView gvrSurfaceView = this.mGvrSurfaceViewWeakRef.get();
            if (gvrSurfaceView != null) {
                if (gvrSurfaceView.mGLWrapper != null) {
                    gl = gvrSurfaceView.mGLWrapper.wrap(gl);
                }
                if ((gvrSurfaceView.mDebugFlags & 3) != 0) {
                    return GLDebugHelper.wrap(gl, (gvrSurfaceView.mDebugFlags & 1) != 0 ? 1 : 0, (gvrSurfaceView.mDebugFlags & 2) != 0 ? new LogWriter() : null);
                }
                return gl;
            }
            return gl;
        }

        public boolean createSurface() {
            if (this.mEgl != null) {
                if (this.mEglDisplay != null) {
                    if (this.mEglConfig != null) {
                        destroySurfaceImp();
                        GvrSurfaceView gvrSurfaceView = this.mGvrSurfaceViewWeakRef.get();
                        if (gvrSurfaceView != null) {
                            this.mEglSurface = gvrSurfaceView.mEGLWindowSurfaceFactory.createWindowSurface(this.mEgl, this.mEglDisplay, this.mEglConfig, gvrSurfaceView.getHolder());
                        } else {
                            this.mEglSurface = null;
                        }
                        EGLSurface eGLSurface = this.mEglSurface;
                        if (eGLSurface != null && eGLSurface != EGL10.EGL_NO_SURFACE) {
                            if (this.mEgl.eglMakeCurrent(this.mEglDisplay, eGLSurface, eGLSurface, this.mEglContext)) {
                                return true;
                            }
                            logEglErrorAsWarning("EGLHelper", "eglMakeCurrent", this.mEgl.eglGetError());
                            return false;
                        }
                        if (this.mEgl.eglGetError() == 12299) {
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

        public void destroySurface() {
            destroySurfaceImp();
        }

        public void finish() {
            if (this.mEglContext != null) {
                GvrSurfaceView gvrSurfaceView = this.mGvrSurfaceViewWeakRef.get();
                if (gvrSurfaceView != null) {
                    gvrSurfaceView.mEGLContextFactory.destroyContext(this.mEgl, this.mEglDisplay, this.mEglContext);
                }
                this.mEglContext = null;
            }
            EGLDisplay eGLDisplay = this.mEglDisplay;
            if (eGLDisplay != null) {
                this.mEgl.eglTerminate(eGLDisplay);
                this.mEglDisplay = null;
            }
        }

        public void renewPendingEglContext() {
            if (this.mEgl == null) {
                initialize();
            }
            EGLContext eGLContext = this.mPendingEglContext;
            if (eGLContext != null) {
                this.mEgl.eglDestroyContext(this.mEglDisplay, eGLContext);
            }
            createPendingEglContext();
        }

        public void setEglSurfaceAttrib(int i, int i2) {
            if (Build.VERSION.SDK_INT < 17) {
                Log.e("EglHelper", "Cannot call eglSurfaceAttrib. API version is too low.");
            } else if (EGL14.eglSurfaceAttrib(EGL14.eglGetCurrentDisplay(), EGL14.eglGetCurrentSurface(12377), i, i2)) {
            } else {
                StringBuilder sb = new StringBuilder(66);
                sb.append("eglSurfaceAttrib() failed. attribute=");
                sb.append(i);
                sb.append(" value=");
                sb.append(i2);
                Log.e("EglHelper", sb.toString());
            }
        }

        public void start() {
            if (this.mEgl == null) {
                initialize();
            }
            EGLContext eGLContext = this.mEglContext;
            if (eGLContext != null) {
                this.mEgl.eglDestroyContext(this.mEglDisplay, eGLContext);
                this.mEglContext = null;
            }
            if (this.mPendingEglContext == null) {
                createPendingEglContext();
            }
            this.mEglContext = this.mPendingEglContext;
            this.mEglDisplay = this.mPendingEglDisplay;
            this.mPendingEglContext = null;
            this.mPendingEglDisplay = null;
        }

        public int swap() {
            return !this.mEgl.eglSwapBuffers(this.mEglDisplay, this.mEglSurface) ? this.mEgl.eglGetError() : MessageConstant$CommandId.COMMAND_BASE;
        }

        public static void throwEglException(String str, int i) {
            throw new RuntimeException(formatEglError(str, i));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class GLThread extends Thread implements EglReadyListener.EventListener {
        private EglHelper mEglHelper;
        private boolean mExited;
        private boolean mFinishedCreatingEglSurface;
        private WeakReference<GvrSurfaceView> mGvrSurfaceViewWeakRef;
        private boolean mHasSurface;
        private boolean mHaveEglContext;
        private boolean mHaveEglSurface;
        private boolean mPaused;
        private boolean mRenderComplete;
        private boolean mRequestPaused;
        private boolean mShouldExit;
        private boolean mShouldReleaseEglContext;
        private boolean mSurfaceIsBad;
        private boolean mWaitingForSurface;
        private ArrayList<Runnable> mEventQueue = new ArrayList<>();
        private boolean mSizeChanged = true;
        private final GLThreadManager mGLThreadManager = new GLThreadManager();
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean mRequestRender = true;
        private int mRenderMode = 1;
        private int mRequestedSwapMode = 0;
        private boolean mWantRenderNotification = false;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public static class GLThreadManager {
            private GLThreadManager() {
            }

            public void releaseEglContextLocked(GLThread gLThread) {
                notifyAll();
            }

            public synchronized void threadExiting(GLThread gLThread) {
                gLThread.mExited = true;
                notifyAll();
            }
        }

        GLThread(WeakReference<GvrSurfaceView> weakReference) {
            this.mGvrSurfaceViewWeakRef = weakReference;
            GvrSurfaceView gvrSurfaceView = weakReference.get();
            if (gvrSurfaceView == null || gvrSurfaceView.mAppContextListener == null) {
                return;
            }
            gvrSurfaceView.mAppContextListener.g(this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:176:0x0249  */
        /* JADX WARN: Removed duplicated region for block: B:202:0x0245 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:205:0x0022 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:208:0x010e A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void guardedRun() throws java.lang.InterruptedException {
            /*
                Method dump skipped, instructions count: 615
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.vr.ndk.base.GvrSurfaceView.GLThread.guardedRun():void");
        }

        private boolean readyToDraw() {
            GvrSurfaceView gvrSurfaceView = this.mGvrSurfaceViewWeakRef.get();
            EglReadyListener eglReadyListener = gvrSurfaceView == null ? null : gvrSurfaceView.mAppContextListener;
            return !this.mPaused && (eglReadyListener == null || eglReadyListener.b() != null) && this.mHasSurface && !this.mSurfaceIsBad && this.mWidth > 0 && this.mHeight > 0 && (this.mRequestRender || this.mRenderMode == 1);
        }

        private void stopEglContextLocked() {
            if (this.mHaveEglContext) {
                this.mEglHelper.finish();
                this.mHaveEglContext = false;
                this.mGLThreadManager.releaseEglContextLocked(this);
            }
        }

        private void stopEglSurfaceLocked() {
            if (this.mHaveEglSurface) {
                this.mHaveEglSurface = false;
                this.mEglHelper.destroySurface();
            }
        }

        public boolean ableToDraw() {
            return this.mHaveEglContext && this.mHaveEglSurface && readyToDraw();
        }

        public int getRenderMode() {
            int i;
            synchronized (this.mGLThreadManager) {
                i = this.mRenderMode;
            }
            return i;
        }

        public int getSwapMode() {
            int i;
            synchronized (this.mGLThreadManager) {
                i = this.mRequestedSwapMode;
            }
            return i;
        }

        @Override // com.google.vr.cardboard.EglReadyListener.EventListener
        public void onEglReady() {
            synchronized (this.mGLThreadManager) {
                this.mEglHelper.renewPendingEglContext();
                this.mGLThreadManager.notifyAll();
            }
        }

        public void onPause() {
            synchronized (this.mGLThreadManager) {
                this.mRequestPaused = true;
                this.mGLThreadManager.notifyAll();
                while (!this.mExited && !this.mPaused) {
                    try {
                        this.mGLThreadManager.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (this.mGLThreadManager) {
                this.mRequestPaused = false;
                this.mRequestRender = true;
                this.mRenderComplete = false;
                this.mGLThreadManager.notifyAll();
                while (!this.mExited && this.mPaused && !this.mRenderComplete) {
                    try {
                        this.mGLThreadManager.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onWindowResize(int i, int i2) {
            synchronized (this.mGLThreadManager) {
                this.mWidth = i;
                this.mHeight = i2;
                this.mSizeChanged = true;
                this.mRequestRender = true;
                this.mRenderComplete = false;
                if (Thread.currentThread() == this) {
                    return;
                }
                this.mGLThreadManager.notifyAll();
                while (!this.mExited && !this.mPaused && !this.mRenderComplete && ableToDraw()) {
                    try {
                        this.mGLThreadManager.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void queueEvent(Runnable runnable) {
            if (runnable != null) {
                synchronized (this.mGLThreadManager) {
                    this.mEventQueue.add(runnable);
                    this.mGLThreadManager.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("r must not be null");
        }

        public void requestExitAndWait() {
            synchronized (this.mGLThreadManager) {
                this.mShouldExit = true;
                this.mGLThreadManager.notifyAll();
                while (!this.mExited) {
                    try {
                        this.mGLThreadManager.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
                GvrSurfaceView gvrSurfaceView = this.mGvrSurfaceViewWeakRef.get();
                if (gvrSurfaceView != null && gvrSurfaceView.mAppContextListener != null) {
                    gvrSurfaceView.mAppContextListener.f();
                }
            }
        }

        public void requestReleaseEglContextLocked() {
            this.mShouldReleaseEglContext = true;
            this.mGLThreadManager.notifyAll();
        }

        public void requestRender() {
            synchronized (this.mGLThreadManager) {
                this.mRequestRender = true;
                this.mGLThreadManager.notifyAll();
            }
        }

        public void requestRenderAndWait() {
            synchronized (this.mGLThreadManager) {
                if (Thread.currentThread() == this) {
                    return;
                }
                this.mWantRenderNotification = true;
                this.mRequestRender = true;
                this.mRenderComplete = false;
                this.mGLThreadManager.notifyAll();
                while (!this.mExited && !this.mPaused && !this.mRenderComplete && ableToDraw()) {
                    try {
                        this.mGLThreadManager.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            long id = getId();
            StringBuilder sb = new StringBuilder(29);
            sb.append("GLThread ");
            sb.append(id);
            setName(sb.toString());
            try {
                guardedRun();
            } catch (InterruptedException unused) {
            } catch (Throwable th) {
                this.mGLThreadManager.threadExiting(this);
                throw th;
            }
            this.mGLThreadManager.threadExiting(this);
        }

        public void setRenderMode(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (this.mGLThreadManager) {
                    this.mRenderMode = i;
                    this.mGLThreadManager.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public void setSwapMode(int i) {
            if (i >= 0 && i <= 2) {
                synchronized (this.mGLThreadManager) {
                    this.mRequestedSwapMode = i;
                    this.mGLThreadManager.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("swapMode");
        }

        public void surfaceCreated() {
            synchronized (this.mGLThreadManager) {
                this.mHasSurface = true;
                this.mFinishedCreatingEglSurface = false;
                this.mGLThreadManager.notifyAll();
                while (this.mWaitingForSurface && !this.mFinishedCreatingEglSurface && !this.mExited) {
                    try {
                        this.mGLThreadManager.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (this.mGLThreadManager) {
                this.mHasSurface = false;
                this.mGLThreadManager.notifyAll();
                while (!this.mWaitingForSurface && !this.mExited) {
                    try {
                        this.mGLThreadManager.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface GLWrapper {
        GL wrap(GL gl);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class LogWriter extends Writer {
        private StringBuilder mBuilder = new StringBuilder();

        LogWriter() {
        }

        private void flushBuilder() {
            if (this.mBuilder.length() > 0) {
                Log.v(GvrSurfaceView.TAG, this.mBuilder.toString());
                StringBuilder sb = this.mBuilder;
                sb.delete(0, sb.length());
            }
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            flushBuilder();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            flushBuilder();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                char c = cArr[i + i3];
                if (c == '\n') {
                    flushBuilder();
                } else {
                    this.mBuilder.append(c);
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    class SimpleEGLConfigChooser extends ComponentSizeChooser {
        public SimpleEGLConfigChooser(GvrSurfaceView gvrSurfaceView, boolean z) {
            super(gvrSurfaceView, 8, 8, 8, 0, z ? 16 : 0, 0);
        }
    }

    public GvrSurfaceView(Context context) {
        super(context);
        this.mThisWeakRef = new WeakReference<>(this);
        init();
    }

    private void checkRenderThreadState() {
        if (this.mGLThread != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    private void init() {
        getHolder().addCallback(this);
    }

    protected void finalize() throws Throwable {
        try {
            GLThread gLThread = this.mGLThread;
            if (gLThread != null) {
                gLThread.requestExitAndWait();
            }
        } finally {
            super.finalize();
        }
    }

    public int getDebugFlags() {
        return this.mDebugFlags;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.mPreserveEGLContextOnPause;
    }

    public int getRenderMode() {
        return this.mGLThread.getRenderMode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isDetachedFromWindow() {
        return this.mDetached;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.SurfaceView, android.view.View
    public void onAttachedToWindow() {
        int i;
        int i2;
        super.onAttachedToWindow();
        if (this.mDetached && this.mRenderer != null && !this.mPreserveGlThreadOnDetachedFromWindow) {
            GLThread gLThread = this.mGLThread;
            if (gLThread != null) {
                i = gLThread.getRenderMode();
                i2 = this.mGLThread.getSwapMode();
            } else {
                i = 1;
                i2 = 0;
            }
            GLThread gLThread2 = new GLThread(this.mThisWeakRef);
            this.mGLThread = gLThread2;
            if (i != 1) {
                gLThread2.setRenderMode(i);
            }
            if (i2 != 0) {
                this.mGLThread.setSwapMode(i2);
            }
            this.mGLThread.start();
        }
        this.mDetached = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        if (this.mGLThread != null && !this.mPreserveGlThreadOnDetachedFromWindow) {
            requestExitAndWait();
        }
        this.mDetached = true;
        super.onDetachedFromWindow();
    }

    public void onPause() {
        this.mGLThread.onPause();
    }

    public void onResume() {
        this.mGLThread.onResume();
    }

    public void queueEvent(Runnable runnable) {
        this.mGLThread.queueEvent(runnable);
    }

    public void requestExitAndWait() {
        this.mGLThread.requestExitAndWait();
    }

    public void requestRender() {
        this.mGLThread.requestRender();
    }

    public void setDebugFlags(int i) {
        this.mDebugFlags = i;
    }

    public void setEGLConfigChooser(GLSurfaceView.EGLConfigChooser eGLConfigChooser) {
        checkRenderThreadState();
        this.mEGLConfigChooser = eGLConfigChooser;
    }

    public void setEGLContextClientVersion(int i) {
        checkRenderThreadState();
        this.mEGLContextClientVersion = i;
    }

    public void setEGLContextFactory(GLSurfaceView.EGLContextFactory eGLContextFactory) {
        checkRenderThreadState();
        this.mEGLContextFactory = eGLContextFactory;
    }

    public void setEGLWindowSurfaceFactory(GLSurfaceView.EGLWindowSurfaceFactory eGLWindowSurfaceFactory) {
        checkRenderThreadState();
        this.mEGLWindowSurfaceFactory = eGLWindowSurfaceFactory;
    }

    public void setEglReadyListener(EglReadyListener eglReadyListener) {
        this.mAppContextListener = eglReadyListener;
    }

    public void setGLWrapper(GLWrapper gLWrapper) {
        this.mGLWrapper = gLWrapper;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.mPreserveEGLContextOnPause = z;
    }

    public void setPreserveGlThreadOnDetachedFromWindow(boolean z) {
        checkRenderThreadState();
        this.mPreserveGlThreadOnDetachedFromWindow = z;
    }

    public void setRenderMode(int i) {
        this.mGLThread.setRenderMode(i);
    }

    public void setRenderer(GLSurfaceView.Renderer renderer) {
        checkRenderThreadState();
        if (this.mEGLConfigChooser == null) {
            this.mEGLConfigChooser = new SimpleEGLConfigChooser(this, true);
        }
        if (this.mEGLContextFactory == null) {
            this.mEGLContextFactory = new DefaultContextFactory();
        }
        if (this.mEGLWindowSurfaceFactory == null) {
            this.mEGLWindowSurfaceFactory = new DefaultWindowSurfaceFactory();
        }
        this.mRenderer = renderer;
        GLThread gLThread = new GLThread(this.mThisWeakRef);
        this.mGLThread = gLThread;
        gLThread.start();
    }

    public void setSwapMode(int i) {
        if (i == 1 && Build.VERSION.SDK_INT < 17) {
            Log.e(TAG, "setSwapMode(SWAPMODE_SINGLE) requires Jellybean MR1 (EGL14 dependency)");
        } else {
            this.mGLThread.setSwapMode(i);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.mGLThread.onWindowResize(i2, i3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.mGLThread.surfaceCreated();
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.mGLThread.surfaceDestroyed();
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        this.mGLThread.requestRenderAndWait();
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new SimpleEGLConfigChooser(this, z));
    }

    public GvrSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mThisWeakRef = new WeakReference<>(this);
        init();
    }

    public void setEGLConfigChooser(int i, int i2, int i3, int i4, int i5, int i6) {
        setEGLConfigChooser(new ComponentSizeChooser(this, i, i2, i3, i4, i5, i6));
    }
}
