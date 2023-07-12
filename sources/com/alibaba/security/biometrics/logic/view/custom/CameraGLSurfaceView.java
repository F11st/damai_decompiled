package com.alibaba.security.biometrics.logic.view.custom;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class CameraGLSurfaceView extends GLSurfaceView {
    public CameraGLSurfaceView(Context context) {
        super(context);
        setEGLContextClientVersion(2);
    }

    private void a() {
        setEGLContextClientVersion(2);
    }

    public CameraGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setEGLContextClientVersion(2);
    }
}
