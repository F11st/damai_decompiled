package com.uc.webview.export.utility;

import android.opengl.GLES10;
import cn.damai.common.util.ACache;
import com.uc.webview.export.annotations.Interface;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.IGlobalSettings;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.utility.Log;
import java.util.Formatter;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* compiled from: Taobao */
@Interface
/* loaded from: classes11.dex */
public class Utils {
    private static ThreadLocal<Formatter> a = new a();

    private Utils() {
    }

    public static boolean checkSupportSamplerExternalOES() {
        String glGetString;
        try {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            if (egl10.eglGetCurrentContext() == EGL10.EGL_NO_CONTEXT) {
                EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
                egl10.eglInitialize(eglGetDisplay, null);
                int[] iArr = new int[1];
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                egl10.eglChooseConfig(eglGetDisplay, new int[]{12339, 1, 12352, 4, 12344}, eGLConfigArr, 1, iArr);
                if (iArr[0] != 1) {
                    Log.e(com.youku.playerservice.axp.utils.Utils.TAG, "eglChooseConfig failed");
                    return false;
                }
                EGLSurface eglCreatePbufferSurface = egl10.eglCreatePbufferSurface(eglGetDisplay, eGLConfigArr[0], new int[]{12375, 1, 12374, 1, 12344});
                if (EGL10.EGL_NO_SURFACE == eglCreatePbufferSurface) {
                    Log.e(com.youku.playerservice.axp.utils.Utils.TAG, "eglCreatePbufferSurface failed");
                    return false;
                }
                EGLContext eglCreateContext = egl10.eglCreateContext(eglGetDisplay, eGLConfigArr[0], EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
                egl10.eglMakeCurrent(eglGetDisplay, eglCreatePbufferSurface, eglCreatePbufferSurface, eglCreateContext);
                glGetString = GLES10.glGetString(7939);
                String glGetString2 = GLES10.glGetString(7936);
                String glGetString3 = GLES10.glGetString(7937);
                if (glGetString2 != null && glGetString2.toLowerCase().contains("google") && glGetString3 != null && glGetString3.toLowerCase().contains("emulator")) {
                    return true;
                }
                EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
                egl10.eglMakeCurrent(eglGetDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
                egl10.eglDestroyContext(eglGetDisplay, eglCreateContext);
                egl10.eglDestroySurface(eglGetDisplay, eglCreatePbufferSurface);
                egl10.eglTerminate(eglGetDisplay);
            } else {
                glGetString = GLES10.glGetString(7939);
            }
            if (glGetString == null || !glGetString.contains("GL_OES_EGL_image_external")) {
                Log.i(com.youku.playerservice.axp.utils.Utils.TAG, "don't support GL_OES_EGL_image_external");
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    protected static void setCoreType(int i) {
        SDKFactory.f(i);
    }

    protected static void setProxyAddress(String str) {
        IGlobalSettings f = SDKFactory.f();
        if (f != null) {
            f.setStringValue("FoxyServerAddr", str);
            f.setStringValue("WifiFoxyServerAddr", str);
        }
    }

    public static void setWaPrintLogEnable(boolean z) {
        IWaStat.WaStat.setPrintLogEnable(z);
    }

    public static void setWaUploadInterval(int i) {
        IWaStat.WaStat.setUploadInterval(i);
    }

    public static String timeFormat(int i) {
        int i2 = i / 1000;
        int i3 = i2 % 60;
        int i4 = (i2 / 60) % 60;
        int i5 = i2 / ACache.TIME_HOUR;
        Formatter formatter = a.get();
        if (i5 != 0) {
            formatter.format("%d:%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i3));
        } else {
            formatter.format("%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3));
        }
        return formatter.toString();
    }
}
