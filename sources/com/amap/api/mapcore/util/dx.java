package com.amap.api.mapcore.util;

import android.opengl.GLSurfaceView;
import com.amap.api.mapcore.util.TextureView$SurfaceTextureListenerC4615n;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class dx implements GLSurfaceView.EGLContextFactory, TextureView$SurfaceTextureListenerC4615n.InterfaceC4621f {
    @Override // android.opengl.GLSurfaceView.EGLContextFactory, com.amap.api.mapcore.util.TextureView$SurfaceTextureListenerC4615n.InterfaceC4621f
    public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
        return null;
    }

    @Override // android.opengl.GLSurfaceView.EGLContextFactory, com.amap.api.mapcore.util.TextureView$SurfaceTextureListenerC4615n.InterfaceC4621f
    public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
    }
}
