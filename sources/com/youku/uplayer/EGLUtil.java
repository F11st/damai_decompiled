package com.youku.uplayer;

import android.opengl.GLDebugHelper;
import android.view.SurfaceHolder;
import com.youku.player.util.C8063c;
import java.io.Writer;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import tb.r10;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class EGLUtil {
    private static EGL10 mEGL;
    private static EGLDisplay mEGLDisplay = EGL10.EGL_NO_DISPLAY;
    private static EGLConfig mEGLConfig = null;
    private static EGLSurface mEGLSurface = EGL10.EGL_NO_SURFACE;
    private static EGLContext mEGLContext = EGL10.EGL_NO_CONTEXT;
    private static SurfaceHolder mSHolder = null;
    private static String TAG = "EGLUtil";
    private static boolean inited = false;
    private static int mSurfaceWidth = 0;
    private static int mSurfaceHeight = 0;
    private static int[] mVersions = new int[2];
    private static int EGL_OPENGL_ES2_BIT = 4;
    private static int EGL_CONTEXT_CLIENT_VERSION = 12440;

    public static boolean InitEGL() {
        String str;
        String str2;
        EGL10 egl10 = (EGL10) GLDebugHelper.wrap(EGLContext.getEGL(), 3, (Writer) null);
        mEGL = egl10;
        if (egl10 == null) {
            str = TAG;
            str2 = "EGLContext.getEGL failed";
        } else {
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            mEGLDisplay = eglGetDisplay;
            if (EGL10.EGL_NO_DISPLAY == eglGetDisplay) {
                str = TAG;
                str2 = "mEGL.eglGetDisplay failed";
            } else if (mEGL.eglInitialize(eglGetDisplay, mVersions)) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                if (!mEGL.eglChooseConfig(mEGLDisplay, new int[]{12352, EGL_OPENGL_ES2_BIT, 12339, 4, 12344}, eGLConfigArr, 1, new int[1])) {
                    return false;
                }
                mEGLConfig = eGLConfigArr[0];
                SurfaceHolder surfaceHolder = mSHolder;
                if (surfaceHolder == null || !surfaceHolder.getSurface().isValid()) {
                    str = TAG;
                    str2 = "mSHolder == null";
                } else {
                    try {
                        mEGLSurface = mEGL.eglCreateWindowSurface(mEGLDisplay, mEGLConfig, mSHolder, null);
                    } catch (Exception e) {
                        C8063c.a(TAG, e);
                    }
                    EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
                    EGLSurface eGLSurface2 = mEGLSurface;
                    if (eGLSurface == eGLSurface2) {
                        str = TAG;
                        str2 = "mEGL.eglCreateWindowSurface failed";
                    } else {
                        int[] iArr = new int[1];
                        int[] iArr2 = new int[1];
                        if (mEGL.eglQuerySurface(mEGLDisplay, eGLSurface2, 12375, iArr) && mEGL.eglQuerySurface(mEGLDisplay, mEGLSurface, 12374, iArr2)) {
                            int i = iArr[0];
                            mSurfaceWidth = i;
                            int i2 = iArr2[0];
                            mSurfaceHeight = i2;
                            if (i == 0 || i2 == 0) {
                                str = TAG;
                                str2 = "0 == mSurfaceWidth || 0 == mSurfaceHeight";
                            } else {
                                String str3 = TAG;
                                C8063c.a(str3, "mSurfaceWidth=" + Integer.toString(mSurfaceWidth) + ",mSurfaceHeight=" + Integer.toString(mSurfaceHeight));
                                EGLContext eglCreateContext = mEGL.eglCreateContext(mEGLDisplay, mEGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{EGL_CONTEXT_CLIENT_VERSION, 2, 12344});
                                mEGLContext = eglCreateContext;
                                if (EGL10.EGL_NO_CONTEXT == eglCreateContext) {
                                    str = TAG;
                                    str2 = "mEGL.eglCreateContext failed";
                                } else {
                                    EGL10 egl102 = mEGL;
                                    EGLDisplay eGLDisplay = mEGLDisplay;
                                    EGLSurface eGLSurface3 = mEGLSurface;
                                    if (egl102.eglMakeCurrent(eGLDisplay, eGLSurface3, eGLSurface3, eglCreateContext)) {
                                        inited = true;
                                        return true;
                                    }
                                    str = TAG;
                                    str2 = "mEGL.eglMakeCurrent failed";
                                }
                            }
                        } else {
                            str = TAG;
                            str2 = "mEGL.eglQuerySurface failed";
                        }
                    }
                }
            } else {
                str = TAG;
                str2 = "mEGL.eglInitialize failed";
            }
        }
        C8063c.a(str, str2);
        return false;
    }

    public static void ReleaseEGL() {
        EGLDisplay eGLDisplay = mEGLDisplay;
        if (eGLDisplay != EGL10.EGL_NO_DISPLAY) {
            EGL10 egl10 = mEGL;
            EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
            egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            EGLContext eGLContext = mEGLContext;
            if (eGLContext != EGL10.EGL_NO_CONTEXT) {
                mEGL.eglDestroyContext(mEGLDisplay, eGLContext);
            }
            EGLSurface eGLSurface2 = mEGLSurface;
            if (eGLSurface2 != EGL10.EGL_NO_SURFACE) {
                mEGL.eglDestroySurface(mEGLDisplay, eGLSurface2);
            }
            mEGL.eglTerminate(mEGLDisplay);
        }
        mEGLDisplay = EGL10.EGL_NO_DISPLAY;
        mEGLContext = EGL10.EGL_NO_CONTEXT;
        mEGLSurface = EGL10.EGL_NO_SURFACE;
        mEGL = null;
    }

    public static void UpdateSize(int[] iArr) {
        if (inited) {
            int[] iArr2 = new int[1];
            int[] iArr3 = new int[1];
            if (!mEGL.eglQuerySurface(mEGLDisplay, mEGLSurface, 12375, iArr2) || !mEGL.eglQuerySurface(mEGLDisplay, mEGLSurface, 12374, iArr3)) {
                C8063c.a(TAG, "mEGL.eglQuerySurface failed");
                return;
            }
            int i = iArr2[0];
            mSurfaceWidth = i;
            iArr[0] = i;
            int i2 = iArr3[0];
            mSurfaceHeight = i2;
            iArr[1] = i2;
        }
    }

    public static void UpdateSurface() {
        if (inited) {
            mEGL.eglSwapBuffers(mEGLDisplay, mEGLSurface);
        }
    }

    public static int eglGetError() {
        if (inited) {
            return mEGL.eglGetError();
        }
        return 0;
    }

    public static String getClassPath() {
        return EGLUtil.class.getName().replace('.', r10.DIR);
    }

    public static void setSurfaceHolder(SurfaceHolder surfaceHolder) {
    }
}
